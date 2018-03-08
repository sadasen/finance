package com.sadasen.finance.util;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sadasen.core.common.Consts;
import com.sadasen.finance.user.entity.User;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class Utils implements Serializable {
	
	private static final long serialVersionUID = 3998903802827987642L;
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	private Utils() {
	}

	/**
	 * 获得当前登录用户
	 * @param request
	 * @return
	 */
	public static User getLoginUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(Consts.LOGIN_USER);
	}
	
	/**
	 * 获得当前登录用户的ID
	 * @param request
	 * @return
	 */
	public static long getLoginUserId(HttpServletRequest request) {
		return getLoginUser(request).getId();
	}
	
	/**
	 * Object对象转为json字符串
	 * @param object
	 * @return
	 */
	public static String writeJson(Object object) {
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			Utils.printError("jackson write json string error : "+e);
		}
		return null;
	}
	
	public static void printInfo(String string) {
		System.out.println("LOG INFO : " + string);
	}
	
	public static void printError(String string) {
		System.out.println("LOG ERROR : " + string);
	}
	
	public static void printDebug(String string) {
		System.out.println("LOG DEBUG : " + string);
	}
	
	
	public static void main(String[] args) {
		String s = "abcdefg";
		String end3 = s.substring(s.length()-3);
		System.out.println(end3);
	}

}
