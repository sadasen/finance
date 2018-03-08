package com.sadasen.util;

import java.io.Serializable;

/**
 * @date 2018年3月8日
 * @author lei.ys
 * @addr company
 * @desc
 */
public class StringUtil implements Serializable {
	
	private static final long serialVersionUID = -5787975877614020957L;
	
	private StringUtil() {
	}

	/**
	 * 判断字符串是否为null或空
	 * null, "", " " 都将返回true
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string) {
		if(null==string) 
			return true;
		if("".equals(string.trim())) 
			return true;
		return false;
	}
	
	/**
	 * 判断字符串是否不为null或空
	 * null, "", " " 都将返回false
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty(String string) {
		return !isEmpty(string);
	}
	
	/**
	 * 如果string为null则返回defaultString
	 * @param string
	 * @param defaultString
	 * @return
	 */
	public static String ifNull(String string, String defaultString) {
		return null==string ? defaultString : string;
	}
	
	/**
	 * 如果string为null则返回""字符串
	 * @param string
	 * @return
	 */
	public static String ifNull(String string) {
		return ifNull(string, "");
	}
	
	/**
	 * 如果string为空则返回defaultString
	 * @param string
	 * @param defaultString
	 * @return
	 */
	public static String ifEmpty(String string, String defaultString) {
		return isEmpty(string) ? defaultString : string;
	}

}
