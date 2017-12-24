package com.demo.bean.yhCountry;

import java.util.List;
import com.jfinal.plugin.activerecord.Model;
import com.mongodb.client.model.Filters;
import com.mongodbUtil.MongoPage;
import com.mongodbUtil.MongoPaginate;
import com.mongodbUtil.MongoQuery;
import com.util.UtilFuns;

/**
 * 
 * @author chenguanghai
 * @version 创建时间：2016年5月30日 下午6:03:59
 *
 */
@SuppressWarnings("serial")
public class yhCountry extends Model<yhCountry> {

	public static final yhCountry me = new yhCountry();

	public List<yhCountry> getNewZone() {
		List<yhCountry> list = yhCountry.me
				.use("mysql")
				.find("select id,name,level,image_key from yh_country order by heat desc,id asc limit 10");
		return list;
	}

	/**
	 * 查询省
	 * 
	 * @return
	 */
	public List<yhCountry> getProvince() {
		List<yhCountry> list = yhCountry.me.use("mysql").find(
				"select * from yh_country where parent_id = 0 and  level = 1");
		return list;
	}

	/**
	 * 查询城市根据省id
	 * 
	 * @param ProvinceId
	 * @return
	 */
	public List<yhCountry> getCityByProvinceId(String ProvinceId) {
		List<yhCountry> list = yhCountry.me.use("mysql").find(
				"select * from yh_country where parent_id = ? and  level = 2",
				ProvinceId);
		return list;
	}

	/**
	 * 查询行政区根据城市id
	 * 
	 * @param CityId
	 * @return
	 */
	public List<yhCountry> getCountyByCityId(String CityId) {
		List<yhCountry> list = yhCountry.me.use("mysql").find(
				"select * from yh_country where parent_id = ? and  level = 3",
				CityId);
		return list;
	}

	/**
	 * 按省份查询景点
	 * 
	 * @param ProvinceId
	 *            省份id
	 * @param sceneryId
	 *            景点id(分页作用)
	 * @return
	 */
	public MongoPage getSceneryByProvinceId(String ProvinceId, int count,
			int page) {
		MongoPage paginate = querySceneryByZone("provinceId", ProvinceId,
				count, page);
		return paginate;
	}

	/**
	 * 按城市查询景点
	 * 
	 * @param cityId
	 *            城市id
	 * @param sceneryId
	 *            景点id(分页作用)
	 * @return
	 */
	public MongoPage getSceneryByCityId(String cityId, int count, int page) {
		MongoPage paginate = querySceneryByZone("cityId", cityId, count, page);
		return paginate;
	}

	/**
	 * 按行政区查询景点
	 * 
	 * @param cityId
	 *            城市id
	 * @param sceneryId
	 *            景点id(分页作用)
	 * @return
	 */
	public MongoPage getSceneryByCountyId(String countyId, int count, int page) {
		MongoPage paginate = querySceneryByZone("countyId", countyId, count,
				page);
		return paginate;
	}

	/**
	 * 根据标签名称与省id获取匹配的景点
	 * 
	 * @param labelName
	 * @param sceneryId
	 * @return
	 */
	public MongoPage getSceneryByLabelNameProinceId(String labelName,
			String provinceId, int count, int page) {
		MongoPage paginate = querySceneryByLabel(labelName, "provinceId",
				provinceId, count, page);
		return paginate;
	}

	/**
	 * 根据标签名与城市id获取景点
	 * 
	 * @param labelName
	 * @param sceneryId
	 * @param cityId
	 * @return
	 */
	public MongoPage getSceneryByLabelNameCityId(String labelName,
			String cityId, int count, int page) {
		MongoPage paginate = querySceneryByLabel(labelName, "cityId", cityId,
				count, page);
		return paginate;
	}

	/**
	 * 根据标签名与行政区id获取景点
	 * 
	 * @param labelName
	 * @param sceneryId
	 * @param CountyId
	 * @return
	 */
	public MongoPage getSceneryByLabelNameCountyId(String labelName,
			String CountyId, int count, int page) {
		MongoPage paginate = querySceneryByLabel(labelName, "countyId",
				CountyId, count, page);
		return paginate;
	}

	/**
	 * 模糊搜索景点
	 * 
	 * @param name
	 * @return
	 */
	public MongoPage search(String name, int count, int page) {
		MongoQuery query = new MongoQuery();
		query.use("yh_scenery").filter(
				Filters.regex("sceneryName", ".*" + name + ".*"));
		query.use("yh_scenery").descending("gradeId","commentCount")
				.projection("sceneryName", "imgPath","gradeId","commentCount");
		MongoPage pages = new MongoPaginate(query, count, page).find();
		return pages;
	}

	/**
	 * 根据区域 + 标签 获取景点
	 * 
	 * @param labelName
	 * @param sceneryId
	 * @param eqKey
	 * @param eqValue
	 * @param list
	 * @return
	 */
	public MongoPage querySceneryByLabel(String labelName, String eqKey,
			String eqValue, int count, int page) {
		MongoPage paginate;
		MongoQuery query = new MongoQuery();
		String[] regexValue = labelName.split(",");
		if (UtilFuns.isNotEmpty(regexValue)) {
			for (String string : regexValue) {
				// 组装正则查询
				query.use("yh_scenery").filter(
						Filters.regex("labelName", ".*" + string + ".*"));
			}
		}
		query.use("yh_scenery").eq(eqKey, eqValue)
				.descending("gradeId", "commentCount");
		paginate = new MongoPaginate(query, count, page).find();
		return paginate;
	}

	/**
	 * 根据区域获取景点
	 * 
	 * @param use
	 * @param sceneryId
	 * @param eqKey
	 * @param eqValue
	 * @param list
	 * @return
	 */
	public MongoPage querySceneryByZone(String eqKey, String eqValue,
			int count, int page) {
		MongoQuery query = new MongoQuery();
		MongoPage paginate;
		query.use("yh_scenery").eq(eqKey, eqValue)
				.descending("gradeId", "commentCount");
		paginate = new MongoPaginate(query, count, page).find();
		return paginate;
	}

}
