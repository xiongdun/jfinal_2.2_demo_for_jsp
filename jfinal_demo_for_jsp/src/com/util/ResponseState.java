package com.util;

public enum ResponseState {
	
	SUCCESS("1", "请求成功"), 
	CHECKERROR("2","请求失败"),
	TIMEOUT("3", "登录超时"), 
	ERROR("4", "服务器异常"),
	NOTLOGIN("5","用户未登陆"),
	AUTHCCHECKERROR("6","权限认证失败"),
	LOGINSUCCESS("7","用户已登录");
	// 成员变量
	private String code;
	private String msg;

	// 构造方法
	private ResponseState(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
