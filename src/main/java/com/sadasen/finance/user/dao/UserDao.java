package com.sadasen.finance.user.dao;

import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.mapper.BaseMapper;

import com.sadasen.finance.user.dto.UserDto;
import com.sadasen.finance.user.entity.User;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface UserDao extends BaseMapper<User> {
	
	public User findToLogin(UserDto userDto);
	
	public User selectByUserName(@Param("userName") String userName);

}
