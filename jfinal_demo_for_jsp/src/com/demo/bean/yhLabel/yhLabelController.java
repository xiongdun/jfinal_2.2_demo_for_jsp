package com.demo.bean.yhLabel;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.util.LabelConst;
import com.util.ResponseVO;
import com.util.UtilFuns;

/**
 * 
 * @author chenguanghai
 * @version 创建时间：2016年5月30日 下午6:06:15
 *
 */
public class yhLabelController extends Controller {

	// 查询标签
	public void getLabelList() {
		ResponseVO vo = new ResponseVO();
		vo.setData(yhLabel.me.getLabel(UtilFuns.isPage(getParaToInt("count")),
				UtilFuns.isPage(getParaToInt("page"))));
		renderJson(vo);
	}

	public void getNewLabel() {
		ResponseVO vo = new ResponseVO();
		vo.setData(yhLabel.me.getNewLabel());
		renderJson(vo);
	}

	public void getYhLabel() {
		JSONObject schedule = new JSONObject();
		ResponseVO vo = new ResponseVO();
		schedule.put("theme", yhLabel.me.getYhLabel(LabelConst.THEME));
		schedule.put("crowd", yhLabel.me.getYhLabel(LabelConst.CROWD));
		schedule.put("preference", yhLabel.me.getYhLabel(LabelConst.PREFERENCE));
		vo.setData(schedule);
		renderJson(vo);
	}

	// 怎么访问控制器中的方法，然后取到页面中的数据，这么多数据怎么写，一个一个写？？？
	@ActionKey("addLabel")
	public void addLabel() {
		System.out.println(getPara("yhLabel.themeId"));
		if (getBean(yhLabel.class) != null) {
			getBean(yhLabel.class).addYhLabel(getPara("yhLabel.themeId"),
					getPara("yhLabel.themeName"), getPara("yhLabel.source"),
					getPara("yhLabel.heat"), getPara("yhLabel.parent_id"),
					getPara("yhLabel.level"), getPara("yhLabel.type"));
		}
		render("../mywork/addlabel.html");
	}

	@ActionKey("getLabel")
	public void myGetLabel() {
		/*
		 * ResponseVO vo = new ResponseVO();
		 * vo.setData(yhLabel.me.getLabel(UtilFuns
		 * .isPage(getParaToInt("count")),
		 * UtilFuns.isPage(getParaToInt("page")))); renderJson(vo);
		 */
		getNewPage();
		render("../mywork/getlabel.jsp");
	}

	/**
	 * 查看详情
	 */
	@ActionKey("toDetail")
	public void detail() {
		System.out.println(getPara("id"));
		JSONObject jo = getBean(yhLabel.class).getLabelById(getPara("id"));
		setAttr("label", jo);
		render("../mywork/update.jsp");
	}

	/**
	 * 修改
	 */
	@ActionKey("updateLabel")
	public void updateLabel() {
		if (getBean(yhLabel.class) != null) {
			System.out.println("this is controller "
					+ getPara("yhLabel.themeId"));
			getBean(yhLabel.class).updateLabelById(getPara("yhLabel.themeId"),
					getPara("yhLabel.themeName"), getPara("yhLabel.source"),
					getPara("yhLabel.heat"), getPara("yhLabel.parent_id"),
					getPara("yhLabel.level"), getPara("yhLabel.type"));
			getNewPage();
		}
		render("../mywork/getlabel.jsp");
	}

	/**
	 * 删除
	 */
	@ActionKey("deleteLabel")
	public void delete() {
		String id = getPara("id");
		System.out.println(id);
		if (id != null) {
			getBean(yhLabel.class).deleteLabelById(id);
			getNewPage();
		}
		render("../mywork/getlabel.jsp");
	}

	/**
	 * 刷新页面
	 */
	public void getNewPage() {
		List<JSONObject> list = new ArrayList<JSONObject>();
		list = getBean(yhLabel.class).myGetLabel(
				UtilFuns.isPage(getParaToInt("count")),
				UtilFuns.isPage(getParaToInt("page")));
		setAttr("list", list);
	}
}
