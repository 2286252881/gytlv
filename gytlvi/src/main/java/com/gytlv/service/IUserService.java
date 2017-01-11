package com.gytlv.service;

import com.gytlv.base.baseEntity.TUser;

public interface IUserService {
	
	//添加新用户
	public void addUser(TUser user)throws Exception;
	
	//检测用户是否存在
	public TUser getUserByUsername(String name)throws Exception;
	
	//后台用户登录
	public TUser findUser(TUser user)throws Exception;
}
