package com.sadasen.core.common;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class JsonResult {
	
	private Object data;
	private int code = Consts.REQUEST_SUCCESS_CODE;
	private String msg = "";
	
	public JsonResult() {
	}
	
	public JsonResult(Error error) {
		if(error==Error.REQUEST) {
			code = Consts.REQUEST_ERROR_CODE;
			msg = Consts.REQUEST_ERROR_TIP;
		} else if(error==Error.SYSTEM) {
			code = Consts.SYSTEM_ERROR_CODE;
			msg = Consts.SYSTEM_ERROR_TIP;
		}
	}
	
	public JsonResult(Object data) {
		this.data = data;
	}
	
	public JsonResult(String msg, int code) {
		this.msg = msg;
		this.code = code;
	}
	
	public JsonResult(Object data, int code, String msg) {
		this.data = data;
		this.code = code;
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static void main(String[] args) {
		System.out.println(Error.REQUEST);
	}

}
