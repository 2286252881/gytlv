package com.gytlv.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gytlv.base.baseEntity.TUser;

public interface ICustomUserMapper {
	/**
	 * 检测用户是否存在
	 * 
	 * @param username
	 * @return
	 */
	TUser getUserByUsername(@Param("username")String username);
	
	/**
	 * 用户登录
	 */
	TUser getUserByUser(@Param("user")TUser user);
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	List<TUser> getAllUser();
}
