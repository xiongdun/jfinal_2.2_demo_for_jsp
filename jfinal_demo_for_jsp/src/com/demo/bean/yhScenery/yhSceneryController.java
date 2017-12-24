/**
 * 
 */
package com.demo.bean.yhScenery;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author xiongdun
 *
 */
public class yhSceneryController extends Controller {
	@ActionKey("addScenery")
	public void addScenery() {
		// getBean(yhScenery.class).g
		// boolean isSuccess = getBean(yhScenery.class, "yhscenery").save();
		// System.out.println(isSuccess);
		if (!"".equals(getPara("yhScenery.sceneryId"))) {
			getBean(yhScenery.class).addYhScenery(
					getPara("yhScenery.sceneryId"),
					getPara("yhScenery.sceneryName"),
					getPara("yhScenery.imgPath"),
					getPara("yhScenery.sceneryAddress"),
					getPara("yhScenery.scenerySummary"),
					getPara("yhScenery.provinceId"),
					getPara("yhScenery.provinceName"),
					getPara("yhScenery.cityId"), getPara("yhScenery.cityName"),
					getPara("yhScenery.countyId"),
					getPara("yhScenery.countyName"),
					getPara("yhScenery.gradeId"),
					getPara("yhScenery.commentCount"),
					getPara("yhScenery.questionCount"),
					getPara("yhScenery.blogCount"),
					getPara("yhScenery.viewCount"),
					getPara("yhScenery.bookFlag"), getPara("yhScenery.amount"),
					getPara("yhScenery.amountAdv"), getPara("yhScenery.lat"),
					getPara("yhScenery.source"),
					getPara("yhScenery.labelName"),
					getPara("yhScenery.aliasName"), getPara("yhScenery.intro"),
					getPara("yhScenery.buyNotice"),
					getPara("yhScenery.payMode"),
					getPara("yhScenery.ifUseCard"),
					getPara("yhScenery.traffic"));
			System.out.println(getPara("yhScenery.payMode"));
			System.out.println("-------------this is controller------");
		}
		render("../mywork/addscenery.html");
	}
}
