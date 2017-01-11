package com.gytlv.controller.open;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gytlv.extendEntity.CustomArticle;
import com.gytlv.service.IArticleService;

@Controller
@RequestMapping("/public")
public class IndexAction {
	@Autowired
	private IArticleService articleService;

	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<CustomArticle> articles = articleService.getSupportTopTen();
		mv.addObject("articles", articles);
		mv.setViewName("/public/home");
		return mv;
	}

	@RequestMapping("/getNewsTopTen")
	public @ResponseBody List<CustomArticle> getNewsTopTen(HttpServletRequest request) throws Exception {
		List<CustomArticle> newsArticles = articleService.getNewsTopTen();
		return newsArticles;
	}
	@RequestMapping("/getClicksTopTen")
	public @ResponseBody List<CustomArticle> getClicksTopTen(HttpServletRequest request) throws Exception {
		List<CustomArticle> clicksArticles = articleService.getClicksTopTen();
		return clicksArticles;
	}
	

	@RequestMapping("/doQuit")
	public String doQuit(HttpServletRequest request) {
		request.getSession().removeAttribute("loginUser");
		return "redirect:/public/index.html";
	}
}
