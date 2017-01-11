package com.gytlv.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gytlv.base.baseEntity.TArticle;
import com.gytlv.base.baseEntity.TArticletype;
import com.gytlv.base.baseEntity.TArticletypeExample;
import com.gytlv.base.mapper.ICustomArticleMapper;
import com.gytlv.base.mapper.ICustomArticleTypeMapper;
import com.gytlv.base.mapper.TArticletypeMapper;
import com.gytlv.extendEntity.Custarticletype;
import com.gytlv.extendEntity.CustomAboutArticle;
import com.gytlv.service.IArticleTypeService;

public class ArticleTypeServiceImpl implements IArticleTypeService {

	@Autowired
	private ICustomArticleTypeMapper articleTypeMapper;

	@Autowired
	private TArticletypeMapper baseArticleTypeMapper;

	@Autowired
	private ICustomArticleMapper customArticleMapper;

	@Override
	public TArticletype getArticleType(String articletypename, String userid) throws Exception {
		TArticletype articletype = new TArticletype();
		articletype = articleTypeMapper.getArticleType(articletypename, userid);
		return articletype;
	}

	@Override
	public void addArticleType(TArticletype articletype) throws Exception {
		articleTypeMapper.addArticleType(articletype);
	}

	@Override
	public List<TArticletype> getAllArticleTypeByuserId(String userid) throws Exception {
		return articleTypeMapper.getAllArticleTypeByuserId(userid);
	}

	@Override
	public List<Custarticletype> getAllArticleTypesByuserId(String id) throws Exception {

		return articleTypeMapper.getAllArticleTypesByuserId(id);
	}

	@Override
	public TArticletype getAllArticleTypesByArticlename(String articlename) throws Exception {
		TArticletypeExample articletypeExample = new TArticletypeExample();
		TArticletypeExample.Criteria criteria = articletypeExample.createCriteria();
		criteria.andArticletypenameEqualTo(articlename);
		List<TArticletype> articletypes = baseArticleTypeMapper.selectByExample(articletypeExample);
		if (articletypes.size() > 0) {
			return articletypes.get(0);
		} else {
			return null;
		}
	}

	@Override
	public TArticletype getAllArticleTypesById(String id) throws Exception {
		TArticletypeExample articletypeExample = new TArticletypeExample();
		TArticletypeExample.Criteria criteria = articletypeExample.createCriteria();
		criteria.andIdEqualTo(id);
		List<TArticletype> articletypes = baseArticleTypeMapper.selectByExample(articletypeExample);
		return articletypes.get(0);
	}

	@Override
	public int editArticleType(TArticletype articletype_) throws Exception {
		return baseArticleTypeMapper.updateByPrimaryKey(articletype_);
	}

	@Override
	public void delArticleType(String id, String username) throws Exception {
		/**
		 * 判断该文章类型下是否有文章
		 */
		List<TArticle> articles = customArticleMapper.findArticlesByArticleType(id);
		if (articles.size() > 0) {
			/**
			 * 判断是否存在文章分类id为“用户名”的(作用--用来保存删除的文章分类下的文章) 这里的用户名作为id
			 */
			TArticletype articletype_0 = null;
			TArticletypeExample articletypeExample = new TArticletypeExample();
			TArticletypeExample.Criteria criteria = articletypeExample.createCriteria();
			criteria.andIdEqualTo(username);

			if (baseArticleTypeMapper.selectByExample(articletypeExample).size() > 0) {
				articletype_0 = baseArticleTypeMapper.selectByExample(articletypeExample).get(0);
			} else {
				articletype_0 = new TArticletype();
				articletype_0.setId(username);
				articletype_0.setArticletypename("未分类");
				articletype_0.setUserid(articles.get(0).getUserid());
				articleTypeMapper.addArticleType(articletype_0);
			}
			/**
			 * 如果该分类下面有文章，则把文章放到未分类下面
			 */
			for (TArticle article : articles) {
				article.setArticletype(username);
				customArticleMapper.doEditArticle(article);
			}
		}
		baseArticleTypeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Custarticletype getArticleTypeArticleByIdandUserId(CustomAboutArticle aboutArticle) throws Exception {
		TArticletypeExample articletypeExample = new TArticletypeExample();
		TArticletypeExample.Criteria criteria = articletypeExample.createCriteria();
		criteria.andIdEqualTo(aboutArticle.getArticletypeid());
		criteria.andUseridEqualTo(aboutArticle.getUserid());
		TArticletype articletype = baseArticleTypeMapper.selectByExample(articletypeExample).get(0);
		Custarticletype customArticle = new Custarticletype();
		BeanUtils.copyProperties(articletype, customArticle);
		return customArticle;
	}

}
