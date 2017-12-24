/**
 * 
 */
package com.demo.bean.yhScenery;

import com.jfinal.plugin.activerecord.Model;
import com.mongodbUtil.MongoQuery;

/**
 * @author xiongdun
 *
 */
public class yhScenery extends Model<yhScenery> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1917757230466354547L;

	public static final yhScenery me = new yhScenery();

	public long addYhScenery(String sceneryId, String sceneryName,
			String imgPath, String sceneryAddress, String scenerySummary,
			String provinceId, String provinceName, String cityId,
			String cityName, String countyId, String countyName,
			String gradeId, String commentCount, String questionCount,
			String blogCount, String viewCount, String bookFlag, String amount,
			String amountAdv, String lat, String source, String labelName,
			String aliasName, String intro, String buyNotice, String payMode,
			String ifUseCard, String traffic) {
		MongoQuery query = new MongoQuery();
		System.out.println(sceneryName);
		System.out.println("--------------this is model-------");
		return query.use("yh_scenery").set("sceneryId", sceneryId)
				.set("sceneryName", sceneryName).set("imgPath", imgPath)
				.set("sceneryAddress", sceneryAddress)
				.set("scenerySummary", scenerySummary)
				.set("provinceId", provinceId)
				.set("provinceName", provinceName).set("cityId", cityId)
				.set("cityName", cityName).set("countyId", countyId)
				.set("countyName", countyName).set("gradeId", gradeId)
				.set("commentCount", commentCount)
				.set("questionCount", questionCount)
				.set("blogCount", blogCount).set("viewCount", viewCount)
				.set("bookFlag", bookFlag).set("amount", amount)
				.set("amountAdv", amountAdv).set("lat", lat)
				.set("source", source).set("labelName", labelName)
				.set("aliasName", aliasName).set("intro", intro)
				.set("buyNotice", buyNotice).set("payMode", payMode)
				.set("ifUseCard", ifUseCard).set("traffic", traffic).save();
	}

}
