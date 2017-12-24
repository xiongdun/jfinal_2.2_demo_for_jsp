package com.demo.bean.yhUser;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.redis.Redis;
import com.jfinal.upload.UploadFile;
import com.mongodbUtil.FileBean;
import com.mongodbUtil.MongoGridFsUtil;
import com.mongodbUtil.MongoPlugin;
import com.util.CheckErrorResultBean;
import com.util.MathUtil;
import com.util.ResponseVO;
import com.util.ShiroUtils;

/**
 * 
 * @author chenguanghai
 * @version 创建时间：2016年5月30日 下午6:06:27
 *
 */
public class yhUserController extends Controller {

	String rr;

	/**
	 * 用户注册
	 */
	@Before(yhUserValidator.class)
	public void addUser() {
		ResponseVO vo = new ResponseVO();
		if (yhUser.me.isOnlyByPhone(getPara("phone"), getPara("password"))) {
			String sessionid = getSession().getId();
			vo.setSessionid(sessionid);
			Redis.use("user").set(sessionid, yhUser.me.get("id"));
		} else {
			vo.setData(new CheckErrorResultBean("phone", "该手机号已注册"));
		}
		renderJson(vo);
	}

	/**
	 * 用户登录
	 */
	@Before(yhUserValidator.class)
	public void login() {
		ResponseVO vo = new ResponseVO();
		yhUser user = yhUser.me.login(getPara("phone"), getPara("password"));
		if (user != null) {
			String sessionid = getSession().getId();
			vo.setSessionid(sessionid);
			Redis.use("user").set(sessionid, user.get("id"));
		} else {
			vo.setData(new CheckErrorResultBean("phone", "输入的帐号密码有错误"));
		}
		renderJson(vo);
	}

	/**
	 * 用户退出
	 */
	public void exit() {
		ResponseVO vo = new ResponseVO();
		if (Redis.use().del(getPara("sessionid")) == 0) {
			vo.setData(new CheckErrorResultBean("msg", "退出失败！"));
		}
		renderJson(vo);
	}

	/**
	 * 用户修改密码
	 */
	public void updateUserPassword() {
		ResponseVO vo = new ResponseVO();
		Long id = Redis.use().get(getPara("sessionid"));
		String password = getPara("password");
		String newPassword = getPara("newpassword");
		if (id != null && StringUtils.isNotBlank(password)) {
			yhUser user = yhUser.me.findById(id);
			if (user != null) {
				String pass = ShiroUtils.md5(password, user.getStr("salt"));
				if (user.getStr("password").equals(pass)) {
					String salt = MathUtil.getFixLenthString(6);
					boolean flg = yhUser.me.use("mysql").findById(id)
							.set("password", ShiroUtils.md5(newPassword, salt))
							.set("salt", salt).set("update_time", new Date())
							.update();
					if (!flg) {
						vo.setData(new CheckErrorResultBean("password",
								"修改失败，请重试!"));
					}
				} else {
					vo.setData(new CheckErrorResultBean("password", "原密码错误！"));
				}
			}
		}
		renderJson(vo);
	}

	/**
	 * 获取用户个人信息
	 */
	public void queryUser() {
		ResponseVO vo = new ResponseVO();
		Long id = Redis.use().get(getPara("sessionid"));
		if (id != null) {
			yhUser user = yhUser.me.queryUserById(id);
			vo.setData(user);
		} else {
			vo.setData(new CheckErrorResultBean("sessionid", "请重新登录"));
		}
		renderJson(vo);
	}

	/**
	 * 用户打标签
	 */
	public void addUserLabel() {
		ResponseVO vo = new ResponseVO();
		String labelName = getPara("labelId");
		Long id = Redis.use().get(getPara("sessionid"));
		if (yhUser.me.addUserLabel(id, labelName) == 0) {
			vo.setData(new CheckErrorResultBean("labelName", "添加失败,请重新添加"));
		}
		renderJson(vo);
	}

	/**
	 * 用户修改标签
	 */
	public void updateUserLabel() {
		ResponseVO vo = new ResponseVO();
		String labelName = getPara("labelId");
		Long id = Redis.use().get(getPara("sessionid"));
		if (yhUser.me.updateUserLabel(id, labelName) == 0) {
			vo.setData(new CheckErrorResultBean("labelName", "修改失败,请重新修改"));
		}
		renderJson(vo);
	}

	/**
	 * 修改用户昵称
	 */
	public void updateName() {
		ResponseVO vo = new ResponseVO();
		String name = getPara("name");
		Long id = Redis.use().get(getPara("sessionid"));
		if (id != null) {
			boolean flg = yhUser.me.updateUserName(name, id);
			if (!flg) {
				vo.setData(new CheckErrorResultBean("name", "修改失败,请重试！"));
			}
		} else {
			vo.setData(new CheckErrorResultBean("sessionid", "请重新登录"));
		}
		renderJson(vo);
	}

	/**
	 * 修改用户性别
	 */
	public void updateGender() {
		ResponseVO vo = new ResponseVO();
		String gender = getPara("gender");
		Long id = Redis.use().get(getPara("sessionid"));
		if (id != null) {
			if (!yhUser.me.use("mysql").findById(id).set("gender", gender)
					.set("update_time", new Date()).update()) {
				vo.setData(new CheckErrorResultBean("gender", "修改失败,请重试！"));
			}
		} else {
			vo.setData(new CheckErrorResultBean("sessionid", "请重新登录"));
		}
		renderJson(vo);
	}

	/**
	 * 修改用户邮箱
	 */
	public void updateEmail() {
		ResponseVO vo = new ResponseVO();
		String email = getPara("email");
		Long id = Redis.use().get(getPara("sessionid"));
		if (id != null) {
			if (!yhUser.me.use("mysql").findById(id).set("email", email)
					.set("update_time", new Date()).update()) {
				vo.setData(new CheckErrorResultBean("email", "修改失败,请重试！"));
			}
		} else {
			vo.setData(new CheckErrorResultBean("sessionid", "请重新登录"));
		}
		renderJson(vo);
	}

	/**
	 * 用户搜索记录
	 */
	public void searchLog() {
		ResponseVO vo = new ResponseVO();
		Long id = Redis.use().get(getPara("sessionid"));
		String search = getPara("name");
		if (!yhUser.me.searchLog(id, search)) {
			vo.setData(new CheckErrorResultBean("search", "记录失败,请重试！"));
		}
		renderJson(vo);
	}

	/**
	 * 修改用户头像
	 */
	public void updateImageByUser() {
		ResponseVO vo = new ResponseVO();
		UploadFile image = getFile("pic");
		Long id = Redis.use().get(getPara("sessionid"));
		if (id != null) {
			if (!yhUser.me.updateImage(id, image)) {
				vo.setData(new CheckErrorResultBean("pic", "上传出错,请重新上传"));
			}
		} else {
			vo.setData(new CheckErrorResultBean("sessionid", "请重新登录"));
		}
		renderJson(vo);
	}

	/**
	 * 查询图片
	 * 
	 * @throws IOException
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public void getImage() throws IOException, Exception {
		HttpServletResponse response = getResponse();
		String key = getPara(0);
		if (StringUtils.isBlank(key))
			return;

		OutputStream out = null;
		InputStream is = null;
		try {
			FileBean bean = MongoGridFsUtil.getFileBean(key, MongoPlugin
					.getMongoClient().getDB("yoohooo"));

			if (bean == null)
				return;

			is = bean.getInputStream();
			response.reset();
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType(bean.getFileType());
			response.setHeader("Content-Disposition", "filename="
					+ java.net.URLEncoder.encode(bean.getFileName(), "utf-8"));
			out = new BufferedOutputStream(response.getOutputStream());
			byte[] buffer = new byte[16 * 1024];
			int len = 0;
			while ((len = is.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			out.flush();
		} finally {
			if (is != null)
				is.close();
		}
		renderNull();
	}

}
