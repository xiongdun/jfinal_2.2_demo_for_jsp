package com.demo.bean.yhUser;

import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.upload.UploadFile;
import com.mongodbUtil.MongoGridFsUtil;
import com.mongodbUtil.MongoPlugin;
import com.mongodbUtil.MongoQuery;
import com.util.MathUtil;
import com.util.ShiroUtils;
import com.util.UtilFuns;

/**
 * 
 * @author chenguanghai
 * @version 创建时间：2016年5月30日 下午6:06:23
 *
 */
@SuppressWarnings("serial")
public class yhUser extends Model<yhUser> {

	public static final yhUser me = new yhUser();

	public boolean isOnlyByPhone(String phone, String password) {
		boolean flg = false;
		List<yhUser> list = me.use("mysql").find(
				"select id from yh_user where phone = ?", phone);
		if (!UtilFuns.listValid(list)) {
			// 生成盐
			String salt = MathUtil.getFixLenthString(6);
			me.use("mysql").set("id", null);
			me.use("mysql").set("password", ShiroUtils.md5(password, salt));
			me.use("mysql").set("salt", salt);
			me.use("mysql").set("phone", phone);
			me.use("mysql").set("username", phone);
			flg = me.use("mysql").save();
		}
		return flg;
	}

	public yhUser login(String phone, String password) {
		List<yhUser> list = me.use("mysql").find(
				"select * from yh_user where phone = ?", phone);
		if (UtilFuns.listValid(list)) {
			if (list.get(0)
					.get("password")
					.equals(ShiroUtils.md5(password, list.get(0).get("salt")
							.toString()))) {
				return list.get(0);
			}
		}
		return null;
	}

	public yhUser queryUserById(Long id) {
		List<yhUser> list = me
				.use("mysql")
				.find("select username,gender,phone,email,himage from yh_user where id=?",
						id);
		if (!UtilFuns.listValid(list)) {
			return null;
		}
		return list.get(0);
	}

	public boolean updateUserName(String name, Long id) {
		boolean flg = false;
		flg = me.use("mysql").findById(id).set("username", name)
				.set("update_time", new Date()).update();
		return flg;
	}

	@SuppressWarnings("deprecation")
	public boolean updateImage(Long id, UploadFile image) {
		boolean flg = false;
		String key = MongoGridFsUtil.addFile(image.getFile(), MongoPlugin
				.getMongoClient().getDB("yoohooo"));
		flg = me.use("mysql").findById(id).set("himage", key)
				.set("update_time", new Date()).update();
		if (!flg) {
			MongoGridFsUtil.deleteFile(key,
					MongoPlugin.getMongoClient().getDB("yoohooo"));
		}
		return flg;
	}

	public long addUserLabel(Long id, String labelname) {
		MongoQuery query = new MongoQuery();
		return query.use("yh_user_label").set("uid", id)
				.set("labelname", labelname).save();
	}

	public long updateUserLabel(Long id, String labelname) {
		MongoQuery query = new MongoQuery();
		return query.use("yh_user_label").eq("uid", id)
				.modify("labelname", labelname).update();
	}

	/**
	 * 用户搜索内容记录
	 * 
	 * @param id
	 * @param search
	 */
	public boolean searchLog(Long id, String search) {
		boolean flg = false;
		MongoQuery query = new MongoQuery();
		if (id != null) {
			query.use("yh_user_search_log").set("uid", id);
		}
		query.use("yh_user_search_log").set("search", search);
		long count = query.save();
		if (count == 1) {
			flg = true;
		}
		return flg;
	}
}
