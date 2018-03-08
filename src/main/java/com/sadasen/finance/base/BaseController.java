package com.sadasen.finance.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class BaseController {

	public HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
		return attrs.getRequest();
	}

}
