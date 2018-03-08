package com.sadasen.finance.user.service;

import com.sadasen.finance.user.dto.UserDto;
import com.sadasen.finance.user.entity.User;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public interface UserService {
	
	public User save(User user);
	
	public User findToLogin(UserDto userDto);
	
	public User findById(long id);
	
	public User getById(long id);

}