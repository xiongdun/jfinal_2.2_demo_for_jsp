package com.demo.bean.yhLabel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Model;
import com.mongodb.BasicDBObject;
import com.mongodbUtil.MongoPage;
import com.mongodbUtil.MongoPaginate;
import com.mongodbUtil.MongoQuery;

/**
 * 
 * @author chenguanghai
 * @version 创建时间：2016年5月30日 下午6:06:10
 *
 */
@SuppressWarnings("serial")
public class yhLabel extends Model<yhLabel> {
	public static final yhLabel me = new yhLabel();

	/**
	 * 获取标签列表--按热度排序
	 * 
	 * @return
	 */
	public MongoPage getLabel(int count, int page) {
		MongoQuery query = new MongoQuery();
		query.use("yh_label").gte("heat", "0").descending("heat");
		MongoPage paginate = new MongoPaginate(query, count, page).find();
		return paginate;
	}

	/**
	 * 查询标签
	 * 
	 * @param count
	 * @param page
	 * @return
	 */
	public List<JSONObject> myGetLabel(int count, int page) {
		MongoQuery query = new MongoQuery();
		List<JSONObject> labels = query.use("yh_label").findAll();
		return labels;
	}

	/**
	 * 按Id删除标签
	 * 
	 * @param labelId
	 * @return
	 */
	public long deleteLabelById(String themeId) {
		MongoQuery query = new MongoQuery();
		return query.use("yh_label").eq("themeId", themeId).delete();
	}

	/**
	 * 按Id修改标签
	 * 
	 * @return
	 */
	public long updateLabelById(String themeId, String themeName,
			String source, String heat, String parent_id, String level,
			String type) {
		MongoQuery query = new MongoQuery();
		System.out.println("this is model" + themeId);
		return query.use("yh_label").eq("themeId", themeId)
				.modify("themeName", themeName).modify("source", source)
				.modify("heat", heat).modify("parent_id", parent_id)
				.modify("level", level).modify("type", type).update();
	}

	/**
	 * 获取热门标签列表
	 * 
	 * @return
	 */
	public MongoPage getNewLabel() {
		MongoQuery query = new MongoQuery();
		query.use("yh_label").gte("heat", "0").descending("heat");
		MongoPage paginate = new MongoPaginate(query, 10, 1).find();
		return paginate;
	}

	/**
	 * 按Id查询标签信息
	 * 
	 * @param id
	 * @return
	 */
	public JSONObject getLabelById(String id) {
		MongoQuery query = new MongoQuery();
		List<JSONObject> jo = query.use("yh_label").eq("themeId", id).find();
		if (jo.size() == 1) {
			return jo.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 模糊查询
	 * 
	 * @param info
	 * @return
	 */
	public List<JSONObject> getLikeLabel(String info) {
		MongoQuery query = new MongoQuery();
		List<JSONObject> list = new ArrayList<JSONObject>();
		// list=query.use("yh_label");
		return list;
	}

	/**
	 * 获取引导页标签
	 * 
	 * @param type
	 * @return
	 */
	public List<JSONObject> getYhLabel(String type) {
		MongoQuery query = new MongoQuery();
		List<JSONObject> list = new ArrayList<JSONObject>();
		list = query.use("yh_label").eq("type", type).eq("parent_id", "0")
				.eq("level", "1").projection("themeName").find();
		return list;
	}

	/**
	 * 添加标签
	 * 
	 * @return
	 */
	public long addYhLabel(String themeId, String themeName, String source,
			String heat, String parent_id, String level, String type) {
		MongoQuery query = new MongoQuery();
		System.out.println("-----this is model----");
		return query.use("yh_label").set("themeId", themeId)
				.set("themeName", themeName).set("source", source)
				.set("heat", heat).set("parent_id", parent_id)
				.set("level", level).set("type", type).save();
	}
}
