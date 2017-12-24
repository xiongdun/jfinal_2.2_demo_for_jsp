package com.util;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServletResponse帮助类
 */
public final class ResponseUtils {
	
	
	
	
	
	
	public static final String REQUEST_TYPE_XML="text/xml;charset=UTF-8";
	public static final String REQUEST_TYPE_JSON="application/json;charset=UTF-8";
	public static final String REQUEST_TYPE_TEXT="text/plain;charset=UTF-8";
	public static final String REQUEST_TYPE_HTML="text/html;charset=UTF-8";

	/**
	 * 发送文本。使用UTF-8编码。
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param text
	 *            发送的字符串
	 */
	public static void renderText(HttpServletResponse response, String text) {
		render(response, "text/plain;charset=UTF-8", text);
	}

	/**
	 * 发送json。使用UTF-8编码。
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param text
	 *            发送的字符串
	 */
	public static void renderJson(HttpServletResponse response, String text) {
		render(response, "application/json;charset=UTF-8", text);
	}

	/**
	 * 发送xml。使用UTF-8编码。
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param text
	 *            发送的字符串
	 */
	public static void renderXml(HttpServletResponse response, String text) {
		render(response, "text/xml;charset=UTF-8", text);
	}

	/**
	 * 发送内容。使用UTF-8编码。
	 * 
	 * @param response
	 * @param contentType
	 * @param text
	 */
	public static void render(HttpServletResponse response, String contentType,
			String text) {
		response.setContentType(contentType);
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		try {
			ServletOutputStream out=response.getOutputStream();
		    out.write(text.getBytes());
		} catch (IOException e) {
		}
	}
}
