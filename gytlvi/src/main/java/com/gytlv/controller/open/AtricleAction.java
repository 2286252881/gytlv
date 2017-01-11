package com.gytlv.controller.open;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.commons.utils.DateUtil;
import com.commons.utils.IpUtil;
import com.commons.utils.UUIDBuild;
import com.gytlv.base.baseEntity.TArticle;
import com.gytlv.base.baseEntity.TArticlevisitor;
import com.gytlv.base.baseEntity.TUser;
import com.gytlv.extendEntity.Custarticletype;
import com.gytlv.extendEntity.CustomAboutArticle;
import com.gytlv.extendEntity.CustomArticle;
import com.gytlv.service.IArticleService;
import com.gytlv.service.IArticleTypeService;
import com.process.result.LayPageResultInfo;

@Controller
@RequestMapping("/publicArticle")
public class AtricleAction {
	@Autowired
	private IArticleService articleService;
	@Autowired
	private IArticleTypeService articleTypeService;

	@RequestMapping(value = "toReadArticle/{userid}/{articleid}/{articletypeid}", method = RequestMethod.GET)
	public ModelAndView toReadArticle(@PathVariable("userid") String userid,@PathVariable("articleid") String articleid,@PathVariable("articletypeid") String articletypeid ) throws Exception {
		ModelAndView mv = new ModelAndView();
		CustomAboutArticle aboutArticle=new CustomAboutArticle();
		aboutArticle.setUserid(userid);
		aboutArticle.setArticleid(articleid);
		aboutArticle.setArticletypeid(articletypeid);
		if (("".equals(aboutArticle.getUserid()) || "".equals(aboutArticle.getArticleid()) || "".equals(aboutArticle.getArticletypeid())) || (null == aboutArticle.getUserid() || null == aboutArticle.getArticleid() || null == aboutArticle.getArticletypeid())) {
			mv.setViewName("redirect:/public/index.html");
		} else {
			CustomArticle article = articleService.getArticleByuserIdandArticleIdandArticletypeId(aboutArticle.getUserid(), aboutArticle.getArticleid(), aboutArticle.getArticletypeid());
			mv.addObject("article", article);
			mv.setViewName("/public/readArticle");
		}
		return mv;
	}

	@RequestMapping(value = "clickCount", method = RequestMethod.POST)
	public @ResponseBody void clickCount(HttpServletRequest request, CustomAboutArticle aboutArticle) throws Exception {
		TUser user = (TUser) request.getSession().getAttribute("loginUser");
		String visitorIpAddress = IpUtil.getClientIp(request);// 这个ip是访问文章的ip
		TArticlevisitor visitor = new TArticlevisitor();
		visitor.setVisitorip(visitorIpAddress);// 访问人的ip
		visitor.setId(UUIDBuild.getUUID());
		visitor.setVisitortime(DateUtil.parseDate((DateUtil.formatDateByFormat(new Date(), DateUtil.DATE_FORMAT))));
		visitor.setVisitoruserid(aboutArticle.getUserid());// 被访人的用户id
		visitor.setVisitorarticleid(aboutArticle.getArticleid());// 被访问人的文章id
		visitor.setVisitorarticletypeid(aboutArticle.getArticletypeid());// 被访问人的文章类型id
		if (null == user) {
			// 业务查寻当天该访客是否访问了该文章。
			// 1：没有，则保存。并更新文章字段的articleClick
			// 2：有，不做处理。
			articleService.editArticleClickBy(visitor);
		} else {
			visitor.setUserid(user.getId());
			visitor.setVisitorname(user.getUsername());
			articleService.editArticleClickBy(visitor);
		}
	}

	@RequestMapping(value = "toReadArticleType/{useridT}/{articletypeidT}", method = RequestMethod.GET)
	public ModelAndView toReadArticleType(@PathVariable("useridT")String useridT,@PathVariable("articletypeidT")String articletypeidT) throws Exception {
		ModelAndView mv = new ModelAndView();
		CustomAboutArticle aboutArticle=new CustomAboutArticle();
		aboutArticle.setUserid(useridT);
		aboutArticle.setArticletypeid(articletypeidT);
		if (("".equals(aboutArticle.getUserid()) || "".equals(aboutArticle.getArticletypeid())) || (null == aboutArticle.getUserid() || null == aboutArticle.getArticletypeid())) {
			mv.setViewName("redirect:/public/index.html");
		} else {
			Custarticletype articletype=articleTypeService.getArticleTypeArticleByIdandUserId(aboutArticle);
			mv.addObject("articletype", articletype);
			mv.setViewName("/public/readArticleType");
		}
		return mv;
	}
	
	@RequestMapping(value = "/getPublicAllArticle")
	public @ResponseBody LayPageResultInfo<CustomArticle> getPublicAllArticleByArticle(String actiletypeid,String userid,int page) throws Exception{
		TArticle article=new TArticle();
		article.setArticletype(actiletypeid);
		article.setUserid(userid);
		article.setPage((page-1)*article.getPageSize());
		LayPageResultInfo<CustomArticle> articles= articleService.getPublicAllArticleByArticle(article);
		return articles;
	}
}
