package com.sadasen.finance.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sadasen.core.common.Consts;
import com.sadasen.core.common.JsonResult;
import com.sadasen.finance.base.BaseController;
import com.sadasen.finance.user.dto.UserDto;
import com.sadasen.finance.user.entity.User;
import com.sadasen.finance.user.service.UserService;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class UserController extends BaseController {
	
	private static final long serialVersionUID = 5851995341518049077L;
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/register")
	public JsonResult register(UserDto dto) {
		User user = new User();
		user.setUserName(dto.getUserName());
		user.setPassword(dto.getPassword());
		user = userService.save(user);
		if(null!=user) {
			return new JsonResult(user);
		}
		return new JsonResult("error to register!", 500);
	}
	
	@PostMapping("/login")
	public JsonResult login(UserDto userDto) {
		User user = userService.findToLogin(userDto);
		if(null!=user) {
			getRequest().getSession().setAttribute(Consts.LOGIN_USER, user);
			return new JsonResult(user);
		}
		return new JsonResult("error to register!", 500);
	}
	
	@GetMapping("/user/{id}")
	public JsonResult userInfo(@PathVariable("id") long id) {
		User user = userService.findById(id);
		if(null!=user) {
			return new JsonResult(user);
		}
		return new JsonResult("error to get info!", 500);
	}
	
	@GetMapping("/info/{id}")
	public JsonResult info(@PathVariable("id") long id) {
		User user = userService.getById(id);
		if(null!=user) {
			return new JsonResult(user);
		}
		return new JsonResult("error to get info!", 500);
	}

}
