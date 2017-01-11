package com.gytlv.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.commons.utils.DateUtil;
import com.commons.utils.UUIDBuild;
import com.gytlv.base.baseEntity.TArticle;
import com.gytlv.base.baseEntity.TArticletype;
import com.gytlv.base.baseEntity.TArticletypeExample;
import com.gytlv.base.baseEntity.TArticlevisitor;
import com.gytlv.base.baseEntity.TArticlevisitorExample;
import com.gytlv.base.baseEntity.TUser;
import com.gytlv.base.mapper.ICustomArticleMapper;
import com.gytlv.base.mapper.ICustomUserMapper;
import com.gytlv.base.mapper.TArticleMapper;
import com.gytlv.base.mapper.TArticletypeMapper;
import com.gytlv.base.mapper.TArticlevisitorMapper;
import com.gytlv.extendEntity.CustomArticle;
import com.gytlv.service.IArticleService;
import com.process.result.LayPageResultInfo;

public class ArticleServiceImpl implements IArticleService {

	@Value("#{configProperties['uploadImage']}")
	private String uploadImage;

	@Autowired
	private ICustomUserMapper custUserMapper;

	@Autowired
	private TArticleMapper articleMapper;

	@Autowired
	private ICustomArticleMapper custArticleMapper;

	@Autowired
	private ICustomUserMapper customUserMapper;

	@Autowired
	private TArticletypeMapper articletypeMapper;

	@Autowired
	private TArticlevisitorMapper articlevisitorMapper;

	@Override
	public void addArticle(TArticle article, String userId) throws Exception {
		article.setId(UUIDBuild.getUUID());
		article.setUserid(userId);
		article.setArticletime(new Date());
		articleMapper.insertSelective(article);
	}

	@Override
	public List<TArticle> getAllArticle(TArticle article) throws Exception {
		article.setPage((article.getPage() - 1) * article.getPageSize());
		return custArticleMapper.finAllArticle(article);
	}

	@Override
	public Integer finAllArticleCount(TArticle article) throws Exception {
		
		return custArticleMapper.finAllArticleCount(article);
	}

	@Override
	public TArticle getArticleById(String id) throws Exception {
		return custArticleMapper.getArticleById(id);
	}

	@Override
	public void doEditArticle(TArticle article) throws Exception {
		article.setArticletime(new Date());
		custArticleMapper.doEditArticle(article);
	}

	@Override
	public int delArticle(TArticle article) throws Exception {
		 int result=articleMapper.deleteByPrimaryKey(article.getId());
		return result;
	}

	@Override
	public List<CustomArticle> getSupportTopTen() throws Exception {

		List<CustomArticle> articles = custArticleMapper.getSupportTopTen();
		// 获取所有用户
		List<TUser> users = customUserMapper.getAllUser();

		// 获取所有文章类型
		TArticletypeExample articletypeExample = new TArticletypeExample();
		TArticletypeExample.Criteria criteria = articletypeExample.createCriteria();
		criteria.andIdNotEqualTo("");
		List<TArticletype> articletypes = articletypeMapper.selectByExample(articletypeExample);
		// 取消a标签和img标签
		for (CustomArticle article : articles) {
			/**
			 * 取消标签之前先把图片保存
			 */
			Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(article.getArticlecontent());
			while (m.find()) {
				article.getImgs().add(m.group(1));
				break;
			}
			if (article.getImgs().size() == 0) {
				Random random = new Random();
				int s = random.nextInt(4) % 4 + 1;
				article.getImgs().add("/upload/public/" + s + ".jpg");
			}
			article.setArticlecontent(article.getArticlecontent().replaceAll("<a href[^>]*>", ""));
			article.setArticlecontent(article.getArticlecontent().replaceAll("</a>", ""));
			article.setArticlecontent(article.getArticlecontent().replaceAll("<img[^>]*>", ""));
			if (article.getArticlecontent().length() > 200) {
				article.setArticlecontent(article.getArticlecontent().substring(0, 200));
			}
			for (TUser user : users) {
				if (user.getId().equals(article.getUserid())) {
					article.setUsername(user.getUsername());
				}
			}
			for (TArticletype articletype : articletypes) {
				if (articletype.getId().equals(article.getArticletype())) {
					article.setArticleTypename(articletype.getArticletypename());
				}
			}
		}
		return articles;
	}

	@Override
	public CustomArticle getArticleByuserIdandArticleIdandArticletypeId(String userid, String articleid, String articletypeid) throws Exception {
		return custArticleMapper.getArticleByuserIdandArticleIdandArticletypeId(userid, articleid, articletypeid);
	}

	@Override
	public int editArticleClickBy(TArticlevisitor articlevisitor) throws Exception {
		int flag = 0;
		TArticlevisitorExample articlevisitorExample = new TArticlevisitorExample();
		TArticlevisitorExample.Criteria criteria = articlevisitorExample.createCriteria();
		criteria.andVisitoripEqualTo(articlevisitor.getVisitorip());
		List<Date> dates = new ArrayList<Date>();
		dates.add(DateUtil.parseDate((DateUtil.formatDateByFormat(new Date(), DateUtil.DATE_FORMAT))));
		criteria.andVisitortimeEqualTo(dates.get(0));
		criteria.andVisitorarticleidEqualTo(articlevisitor.getVisitorarticleid());
		List<TArticlevisitor> articlevisitors = articlevisitorMapper.selectByExample(articlevisitorExample);
		TArticlevisitor visitor = this.getVisitor(articlevisitors);
		if (null != visitor) {
			if (!"".equals(articlevisitor.getUserid()) || null != articlevisitor.getUserid()) {
				visitor.setUserid(articlevisitor.getUserid());
				visitor.setVisitorname(articlevisitor.getVisitorname());
			}
			flag = articlevisitorMapper.updateByPrimaryKey(visitor);
		} else {
			flag = articlevisitorMapper.insert(articlevisitor);
			TArticle article = articleMapper.selectByPrimaryKey(articlevisitor.getVisitorarticleid());
			// 将文章的点击量加1
			if ("".equals(article.getArticleclick()) || null == article.getArticleclick()) {
				article.setArticleclick(0);
			}
			article.setArticleclick(article.getArticleclick() + 1);
			System.out.println("获取总点击量:" + article.getArticleclick());
			flag = articleMapper.updateByPrimaryKey(article);
		}
		return flag;
	}

	public TArticlevisitor getVisitor(List<TArticlevisitor> articlevisitors) {
		if (articlevisitors.size() > 0) {
			return articlevisitors.get(0);
		} else {
			return null;
		}
	}

	@Override
	public LayPageResultInfo<CustomArticle> getPublicAllArticleByArticle(TArticle article) throws Exception {

		// 查询用户信息
		TUser searchUser = new TUser();
		searchUser.setId(article.getUserid());
		;
		TUser u = custUserMapper.getUserByUser(searchUser);

		List<TArticle> articles = custArticleMapper.finAllArticle(article);
		int count = custArticleMapper.finAllArticleCount(article);
		List<CustomArticle> customArticles = new ArrayList<CustomArticle>();

		CustomArticle customArticle = null;
		if (null != customArticles) {
			for (TArticle a : articles) {
				customArticle = new CustomArticle();
				BeanUtils.copyProperties(a, customArticle);
				customArticle.setUsername(u.getUsername());
				customArticles.add(customArticle);
			}
		}
		// 取消a标签和img标签
		for (CustomArticle a : customArticles) {
			/**
			 * 取消标签之前先把图片保存
			 */
			Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(a.getArticlecontent());
			while (m.find()) {
				a.getImgs().add(m.group(1));
				break;
			}
			if (a.getImgs().size() == 0) {
				Random random = new Random();
				int s = random.nextInt(4) % 4 + 1;
				a.getImgs().add("/upload/public/" + s + ".jpg");
			}
			a.setArticlecontent(a.getArticlecontent().replaceAll("<a href[^>]*>", ""));
			a.setArticlecontent(a.getArticlecontent().replaceAll("</a>", ""));
			a.setArticlecontent(a.getArticlecontent().replaceAll("<img[^>]*>", ""));
			if (a.getArticlecontent().length() > 200) {
				a.setArticlecontent(a.getArticlecontent().substring(0, 300));
			}
		}

		LayPageResultInfo<CustomArticle> obj = new LayPageResultInfo<CustomArticle>();
		if (count % article.getPageSize() == 0) {
			count = count / article.getPageSize();
		} else {
			count = count / article.getPageSize() + 1;
		}
		obj.setCount(count);
		obj.setObj(customArticles);
		return obj;
	}
	
	@Override
	public List<CustomArticle> getNewsTopTen() throws Exception {
		List<CustomArticle> list= custArticleMapper.getNewsTopTen();
		return list;
	}

	@Override
	public List<CustomArticle> getClicksTopTen() throws Exception {
		List<CustomArticle> list= custArticleMapper.getClicksTopTen();
		return list;
	};
}
