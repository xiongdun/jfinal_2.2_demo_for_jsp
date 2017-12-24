package com.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class MyHandler extends Handler {

	@SuppressWarnings("deprecation")
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled) {
		if (target.endsWith(".do")) {
			target = target.substring(0, target.length() - 3);
			nextHandler.handle(target, request, response, isHandled);
		}
	}
}
