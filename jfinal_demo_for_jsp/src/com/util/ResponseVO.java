package com.util;


import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
public class ResponseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7267468047024279882L;
	
	private String code;
	private String msg;
	private Object data;
	private String token;
	private String sessionid;
	
	public String getCode() {
		if (StringUtils.isEmpty(this.code)) {
			return ResponseState.SUCCESS.getCode();
		} else {
			return code;
		}
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		if (StringUtils.isEmpty(this.msg)) {
			return ResponseState.SUCCESS.getMsg();
		} else {
			return msg;
		}
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {

		
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the sessionid
	 */
	public String getSessionid() {
		return sessionid;
	}

	/**
	 * @param sessionid the sessionid to set
	 */
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	
}
