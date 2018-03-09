package com.sadasen.core.common;

import java.io.Serializable;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class Consts implements Serializable {
	
	private static final long serialVersionUID = -3701889279242168374L;

	// 登录用户保存的键
	public static final String LOGIN_USER = "loginUser";
	
	// ====== 返回状态码
	// 正常
	public static final int REQUEST_SUCCESS_CODE = 200;
	// 请求出错（客户端错误）
	public static final int REQUEST_ERROR_CODE = 400;
	public static final int REQUEST_FAILURE_CODE = 401;
	public static final String REQUEST_ERROR_TIP = "请求无效！";
	// 系统错误（服务的错误）
	public static final int SYSTEM_ERROR_CODE = 500;
	public static final String SYSTEM_ERROR_TIP = "系统错误！";

}
