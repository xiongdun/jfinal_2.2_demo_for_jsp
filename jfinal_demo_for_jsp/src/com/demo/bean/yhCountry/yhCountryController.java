package com.demo.bean.yhCountry;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.ehcache.CacheInterceptor;
import com.jfinal.plugin.ehcache.CacheName;
import com.jfinal.plugin.ehcache.EvictInterceptor;
import com.mongodbUtil.MongoPage;
import com.util.ResponseVO;
import com.util.UtilFuns;

/**
 * 
 * @author chenguanghai
 * @version 创建时间：2016年5月30日 下午6:04:12
 *
 */
public class yhCountryController extends Controller {

	// 获取热门城市
	public void getNewZone() {
		ResponseVO vo = new ResponseVO();
		List<yhCountry> list = yhCountry.me.getNewZone();
		vo.setData(list);
		renderJson(vo);
	}

	// 获取所有省级单位
	public void getZone() {
		ResponseVO vo = new ResponseVO();
		List<yhCountry> list = yhCountry.me.getProvince();
		vo.setData(list);
		renderJson(vo);
	}

	// 根据省查询城市
	public void findByProvinceId() {
		String ProvinceId = getPara("provinceId");
		ResponseVO vo = new ResponseVO();
		List<yhCountry> list = yhCountry.me.getCityByProvinceId(ProvinceId);
		vo.setData(list);
		renderJson(vo);
	}

	// 根据城市查询行政区
	public void findByCityId() {
		String CityId = getPara("cityId");
		ResponseVO vo = new ResponseVO();
		List<yhCountry> list = yhCountry.me.getCountyByCityId(CityId);
		vo.setData(list);
		renderJson(vo);
	}

	// 根据省份查询景点
	public void getSceneryByProvinceId() {
		String ProvinceId = getPara("provinceId");
		ResponseVO vo = new ResponseVO();
		vo.setData(yhCountry.me.getSceneryByProvinceId(ProvinceId,
				UtilFuns.isPage(getParaToInt("count")),
				UtilFuns.isPage(getParaToInt("page"))));
		renderJson(vo);
	}

	// 根据城市查询景点
	public void getSceneryByCityId() {
		String cityId = getPara("cityId");
		ResponseVO vo = new ResponseVO();
		vo.setData(yhCountry.me.getSceneryByCityId(cityId,
				UtilFuns.isPage(getParaToInt("count")),
				UtilFuns.isPage(getParaToInt("page"))));
		renderJson(vo);
	}

	// 根据行政区查询景点
	public void getSceneryByCountyId() {
		String countyId = getPara("countyId");
		ResponseVO vo = new ResponseVO();
		vo.setData(yhCountry.me.getSceneryByCountyId(countyId,
				UtilFuns.isPage(getParaToInt("count")),
				UtilFuns.isPage(getParaToInt("page"))));
		renderJson(vo);
	}

	// 根据传入标签名称与省份id查询符合标签名称的景点
	public void getSceneryByLabelNameProinceId() {
		String labelName = getPara("labelName");
		String provinceId = getPara("provinceId");
		ResponseVO vo = new ResponseVO();
		vo.setData(yhCountry.me.getSceneryByLabelNameProinceId(labelName,
				provinceId, UtilFuns.isPage(getParaToInt("count")),
				UtilFuns.isPage(getParaToInt("page"))));
		renderJson(vo);
	}

	// 根据标签名与城市id查询符合标签景点
	public void getSceneryByLabelNameCityId() {
		String labelName = getPara("labelName");
		String cityId = getPara("cityId");
		ResponseVO vo = new ResponseVO();
		vo.setData(yhCountry.me.getSceneryByLabelNameCityId(labelName, cityId,
				UtilFuns.isPage(getParaToInt("count")),
				UtilFuns.isPage(getParaToInt("page"))));
		renderJson(vo);
	}

	// 根据标签名与行政区id查询符合标签景点
	public void getSceneryByLabelNameCountyId() {
		String labelName = getPara("labelName");
		String countyId = getPara("countyId");
		ResponseVO vo = new ResponseVO();
		vo.setData(yhCountry.me.getSceneryByLabelNameCountyId(labelName,
				countyId, UtilFuns.isPage(getParaToInt("count")),
				UtilFuns.isPage(getParaToInt("page"))));
		renderJson(vo);
	}

	// 模糊搜索景点
	public void search() {
		ResponseVO vo = new ResponseVO();
		MongoPage page = yhCountry.me.search(getPara("name"),
				UtilFuns.isPage(getParaToInt("count")),
				UtilFuns.isPage(getParaToInt("page")));
		if (page != null) {
			vo.setData(page);
		} else {
			vo.setCode("110");
			vo.setMsg("搜索‘" + getPara("name") + "’,无匹配内容");
		}

		renderJson(vo);
	}
}
