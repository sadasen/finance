package com.sadasen.finance.modules.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sadasen.core.common.GlobalConsts;
import com.sadasen.core.response.JsonResult;
import com.sadasen.core.response.status.Status;
import com.sadasen.finance.base.BaseController;
import com.sadasen.finance.modules.user.dto.UserDto;
import com.sadasen.finance.modules.user.entity.User;
import com.sadasen.finance.modules.user.service.UserService;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
@RestController
@RequestMapping("/user")
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
		if(null==user) {
			return JsonResult.instance(Status.SYSTEM_ERROR);
		}
		if(-1L==user.getId()) {
			return JsonResult.instance(Status.REQUEST_FAILURE);
		}
		if(-2L==user.getId()) {
			return JsonResult.instance("用户名已被注册！", Status.REQUEST_VALID);
		}
		return JsonResult.instance(user);
	}
	
	@PostMapping("/login")
	public JsonResult login(UserDto userDto) {
		User user = userService.findToLogin(userDto);
		if(null==user) {
			return JsonResult.instance(Status.REQUEST_VALID);
		}
		getRequest().getSession().setAttribute(GlobalConsts.LOGIN_USER, user);
		return JsonResult.instance(user);
	}
	
	@GetMapping("/user/{id}")
	public JsonResult userInfo(@PathVariable("id") long id) {
		User user = userService.findById(id);
		if(null==user) {
			return JsonResult.instance(Status.REQUEST_NO_EXISTS);
		}
		return JsonResult.instance(user);
	}
	
	@GetMapping("/info/{id}")
	public JsonResult info(@PathVariable("id") long id) {
		User user = userService.getById(id);
		if(null==user) {
			return JsonResult.instance(Status.REQUEST_NO_EXISTS);
		}
		return JsonResult.instance(user);
	}

}
