package com.gytlv.controller.backstage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commons.utils.IpUtil;
import com.gytlv.base.baseEntity.TUser;
import com.gytlv.service.IUserService;
import com.process.context.Config;
import com.process.result.ResultInfo;
import com.process.result.ResultUtil;

@Controller
@RequestMapping("/backstageUser")
public class BackstageUserAction {

	@Autowired
	private IUserService userService;

	@RequestMapping("/tologin")
	public String tologin() {
		return "/public/login";
	}

	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public @ResponseBody ResultInfo dologin(HttpServletRequest request, TUser user) throws Exception {
		TUser loginUser = new TUser();
		loginUser = userService.findUser(user);
		if (loginUser != null) {
			request.getSession().setAttribute("loginUser", loginUser);
			return ResultUtil.createSuccess(Config.MESSAGE, 107, new Object[] { loginUser.getUsername() });
		} else {
			return ResultUtil.createFail(Config.MESSAGE, 101, null);
		}
	}

	@RequestMapping("/toReg")
	public String toReg() {
		return "/public/reg";
	}

	@RequestMapping(value = "/doReg", method = RequestMethod.POST)
	public @ResponseBody ResultInfo doReg(HttpServletRequest request, TUser user, String password_) throws Exception {
		TUser regUser = userService.getUserByUsername(user.getUsername());
		if (null != regUser) {
			return ResultUtil.createFail(Config.MESSAGE, 403, new Object[] { user.getUsername() });
		}
		if (!user.getPassword().equals(password_)) {
			return ResultUtil.createFail(Config.MESSAGE, 402, null);
		}
		user.setId(IpUtil.getClientIp(request));
		userService.addUser(user);
		return ResultUtil.createSuccess(Config.MESSAGE, 401, null);
	}

	@RequestMapping("/dopublicMain")
	public String dobackstageMain(HttpServletRequest request) {
		return "/public/login";
	}

	@RequestMapping("/dobackstageMain")
	public String dopubackstageMain(HttpServletRequest request) {
		return "/backstage/backstageHome";
	}
}
