package com.demo.bean.yhScenery;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class HelloFreeMarkerServlet
 */
@SuppressWarnings("serial")
public class HelloFreeMarkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 负责管理FreeMarker模板的Configuration实例
	private Configuration cfg = null;

	public void init() throws ServletException {
		// 创建一个FreeMarker实例
		cfg = new Configuration();
		// 指定FreeMarker模板文件的位置
		cfg.setServletContextForTemplateLoading(getServletContext(),
				"/WEB-INF/templates");
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloFreeMarkerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 建立数据模型
		Map root = new HashMap();
		root.put("message", "hello world");
		root.put("name", "java小强");
		// 获取模板文件
		Template template = cfg.getTemplate("test.ftl");
		// 使用模板文件的charset作为本页面的charset
		// 使用text.xml MIME-type
		response.setContentType("text/html;charset=" + template.getEncoding());
		Writer out = response.getWriter();
		// 合并数据模型和模板，并将结果输出到out中
		try {
			template.process(root, out);// 往模板里面写数据
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
