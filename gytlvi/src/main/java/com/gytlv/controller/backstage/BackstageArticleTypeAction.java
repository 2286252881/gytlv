package com.gytlv.controller.backstage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.commons.utils.UUIDBuild;
import com.gytlv.base.baseEntity.TArticletype;
import com.gytlv.base.baseEntity.TUser;
import com.gytlv.extendEntity.Custarticletype;
import com.gytlv.service.IArticleTypeService;
import com.process.context.Config;
import com.process.result.ResultInfo;
import com.process.result.ResultUtil;

@Controller
@RequestMapping("/backstageArticleType")
public class BackstageArticleTypeAction {
	@Autowired
	private IArticleTypeService articleTypeService;

	@RequestMapping(value = "/addArticleType", method = RequestMethod.POST)
	public @ResponseBody ResultInfo toaddArticleType(HttpServletRequest request, String articletypename) throws Exception {
		TUser loginUser = (TUser) request.getSession().getAttribute("loginUser");
		TArticletype articletype = new TArticletype();
		articletype.setUserid(loginUser.getId());
		articletype.setId(UUIDBuild.getUUID());
		articletype.setArticletypename(articletypename);
		if (null == articleTypeService.getArticleType(articletypename, loginUser.getId())) {
			articleTypeService.addArticleType(articletype);
		} else {
			return ResultUtil.createFail(Config.MESSAGE, 301, null);
		}
		return ResultUtil.createSuccess(Config.MESSAGE, 300, null);
	}

	/**
	 * @throws Exception
	 * 
	 */
	@RequestMapping("/toArticleType")
	public ModelAndView toArticleType(HttpServletRequest request) throws Exception {
		TUser loginUser = (TUser) request.getSession().getAttribute("loginUser");
		ModelAndView mv = new ModelAndView();
		List<Custarticletype> articletypes = articleTypeService.getAllArticleTypesByuserId(loginUser.getId());
		mv.addObject("articletypes", articletypes);
		mv.setViewName("/backstage/articletypeList");
		return mv;
	}

	/**
	 * 修改文章分类
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/editArticleType")
	public @ResponseBody ResultInfo editArticleType(HttpServletRequest request, String articletypename, String id) throws Exception {
		TUser loginUser = (TUser) request.getSession().getAttribute("loginUser");
		TArticletype articletype = articleTypeService.getArticleType(articletypename, loginUser.getId());
		if (null != articletype) {
			return ResultUtil.createWarning(Config.MESSAGE, 304, new Object[] { articletypename });
		} else {
			TArticletype articletype_ = articleTypeService.getAllArticleTypesById(id);
			articletype_.setArticletypename(articletypename);
			articleTypeService.editArticleType(articletype_);
			return ResultUtil.createSuccess(Config.MESSAGE, 305, null);
		}
	}

	@RequestMapping("/delArticleType")
	public @ResponseBody ResultInfo delArticleType(HttpServletRequest request, String id) throws Exception {
		TUser loginUser = (TUser) request.getSession().getAttribute("loginUser");
		articleTypeService.delArticleType(id, loginUser.getUsername());
		return ResultUtil.createSuccess(Config.MESSAGE, 305, null);
	}
}
