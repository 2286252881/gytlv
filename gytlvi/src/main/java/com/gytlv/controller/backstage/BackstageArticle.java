package com.gytlv.controller.backstage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.commons.utils.IpUtil;
import com.gytlv.base.baseEntity.TArticle;
import com.gytlv.base.baseEntity.TArticletype;
import com.gytlv.base.baseEntity.TUser;
import com.gytlv.service.IArticleService;
import com.gytlv.service.IArticleTypeService;
import com.process.result.LayPageResultInfo;

@Controller
@RequestMapping("/backstageArticle")
public class BackstageArticle {

	@Value("#{configProperties['uploadImage']}")
	private String uploadImage;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private IArticleTypeService articleTypeService;

	/**
	 * 到达后台文章列表公共方法
	 * 
	 * @return
	 */
	@RequestMapping("/toAllArticle")
	public String toAllArticle(HttpServletRequest request) {
		return "/backstage/articleList";
	}

	/**
	 * 添加文章控制器
	 * 
	 * @param article
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	public String addArticle(TArticle article, HttpServletRequest request) throws Exception {
		article.setArticleip(IpUtil.getClientIp(request));
		TUser loginUser = (TUser) request.getSession().getAttribute("loginUser");
		articleService.addArticle(article, loginUser.getId());
		return "/backstage/articleList";
	}

	/**
	 * 到达后台编写文章页面
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toPreAddArticle")
	public ModelAndView toPreAddArticle(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		TUser loginUser = (TUser) request.getSession().getAttribute("loginUser");
		List<TArticletype> articletypes = articleTypeService.getAllArticleTypeByuserId(loginUser.getId());
		mv.addObject("articletypes", articletypes);
		mv.setViewName("/backstage/writeArticle");
		return mv;
	}

	/**
	 * 后台用户根据用户id获取该用户的所有文章
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAllArticle")
	public @ResponseBody LayPageResultInfo<TArticle> getAllArticle(HttpServletRequest request, int page) throws Exception {
		TUser loginUser = (TUser) request.getSession().getAttribute("loginUser");
		List<TArticletype> articletypes = articleTypeService.getAllArticleTypeByuserId(loginUser.getId());
		TArticle searchAeticle = new TArticle();
		searchAeticle.setUserid(loginUser.getId());
		searchAeticle.setPage(page);
		List<TArticle> articles = articleService.getAllArticle(searchAeticle);
		for (TArticle article : articles) {
			for (TArticletype articleType : articletypes) {
				if (articleType.getId().equals(article.getArticletype())) {
					article.setArticletype(articleType.getArticletypename());
				}
			}
			if ("1".equals(article.getArticlemodle())) {
				article.setArticlemodle("公开");
			} else {
				article.setArticlemodle("私有");
			}
			if ("1".equals(article.getArticlesupport())) {
				article.setArticlesupport("是");
			} else {
				article.setArticlesupport("否");
			}
		}
		int count = articleService.finAllArticleCount(searchAeticle);
		if (count % searchAeticle.getPageSize() == 0) {
			count = count / searchAeticle.getPageSize();
		} else {
			count = count / searchAeticle.getPageSize() + 1;
		}
		LayPageResultInfo<TArticle> obj = new LayPageResultInfo<TArticle>(articles, count);
		return obj;
	}

	/**
	 * 编辑文章页面
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/toEditArticle")
	public ModelAndView toEditArticle(HttpServletRequest request, String id) throws Exception {
		TUser loginUser = (TUser) request.getSession().getAttribute("loginUser");
		ModelAndView mv = new ModelAndView();
		if ("".equals(id)) {
			mv.setViewName("/backstage/articleList");
		} else {
			TArticle article = articleService.getArticleById(id);
			List<TArticletype> articletypes = articleTypeService.getAllArticleTypeByuserId(loginUser.getId());
			mv.addObject("article", article);
			mv.addObject("articletypes", articletypes);
			mv.setViewName("/backstage/editArticle");
		}
		return mv;
	}

	@RequestMapping("/doEditArticle")
	public ModelAndView doEditArticle(HttpServletRequest request, TArticle article, String ck) throws Exception {
		ModelAndView mv = new ModelAndView();
		article.setArticlesupport(ck);
		article.setArticleip(IpUtil.getClientIp(request));
		articleService.doEditArticle(article);
		mv.setViewName("/backstage/articleList");
		return mv;
	}

	@RequestMapping(value = "/delArticle")
	public ModelAndView delArticle(HttpServletRequest request, String id) throws Exception {
		ModelAndView mv = new ModelAndView();
		TArticle article = articleService.getArticleById(id);
		Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(article.getArticlecontent());
		List<String> imgSrc = new ArrayList<String>();
		while (m.find()) {
			imgSrc.add(uploadImage + m.group(1));
		}
		File file = null;
		for (String img : imgSrc) {
			file = new File(img);
			if (file.exists()) {
				file.delete();
			}
		}
		articleService.delArticle(article);
		mv.setViewName("/backstage/articleList");
		return mv;
	}
}
