package com.gytlv.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commons.utils.UUIDBuild;
import com.gytlv.base.baseEntity.TUser;
import com.gytlv.service.IUserService;
import com.process.context.Config;
import com.process.result.ResultInfo;
import com.process.result.ResultUtil;

@Controller
@RequestMapping("/user")
public class UserAction {

	@Autowired
	private IUserService userService;

	@RequestMapping("/add")
	public String addUser() throws Exception {
		TUser user = new TUser();
		user.setId(UUIDBuild.getUUID());
		user.setUsername("admin");
		userService.addUser(user);
		return null;
	}
	
	@RequestMapping("/checkUsername")
	public @ResponseBody ResultInfo checkUsername(String username) throws Exception{
		TUser user=userService.getUserByUsername(username);
		if(user!=null){
			return ResultUtil.createFail(Config.MESSAGE, 200, new Object[]{username});
		}
		return ResultUtil.createSuccess(Config.MESSAGE, 201, new Object[]{username});
	}
}
