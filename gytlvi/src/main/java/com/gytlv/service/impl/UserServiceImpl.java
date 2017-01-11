package com.gytlv.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.commons.utils.UUIDBuild;
import com.gytlv.base.baseEntity.TUser;
import com.gytlv.base.mapper.ICustomUserMapper;
import com.gytlv.base.mapper.TUserMapper;
import com.gytlv.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Autowired
	private TUserMapper userMapper;
	
	
	@Autowired
	private ICustomUserMapper customUserMapper;

	@Override
	public void addUser(TUser user) throws Exception {
		user.setId(UUIDBuild.getUUID());
		user.setCreatedate(new Date());
		userMapper.insertSelective(user);
	}

	@Override
	public TUser getUserByUsername(String username) throws Exception {
		TUser user=customUserMapper.getUserByUsername(username);
		return user;
	}

	@Override
	public TUser findUser(TUser user) throws Exception {
		TUser loginUser=customUserMapper.getUserByUser(user);
		return loginUser;
	}
}
