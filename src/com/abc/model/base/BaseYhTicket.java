package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseYhTicket<M extends BaseYhTicket<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setParentCode(java.lang.String parentCode) {
		set("parent_code", parentCode);
	}

	public java.lang.String getParentCode() {
		return get("parent_code");
	}

	public void setPid(java.lang.Long pid) {
		set("pid", pid);
	}

	public java.lang.Long getPid() {
		return get("pid");
	}

	public void setCode(java.lang.String code) {
		set("code", code);
	}

	public java.lang.String getCode() {
		return get("code");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setLevel(java.lang.String level) {
		set("level", level);
	}

	public java.lang.String getLevel() {
		return get("level");
	}

	public void setTitleId(java.lang.String titleId) {
		set("title_id", titleId);
	}

	public java.lang.String getTitleId() {
		return get("title_id");
	}

	public void setTitleName(java.lang.String titleName) {
		set("title_name", titleName);
	}

	public java.lang.String getTitleName() {
		return get("title_name");
	}

	public void setThemeId(java.lang.String themeId) {
		set("theme_id", themeId);
	}

	public java.lang.String getThemeId() {
		return get("theme_id");
	}

	public void setThemeName(java.lang.String themeName) {
		set("theme_name", themeName);
	}

	public java.lang.String getThemeName() {
		return get("theme_name");
	}

	public void setStartMonth(java.lang.String startMonth) {
		set("start_month", startMonth);
	}

	public java.lang.String getStartMonth() {
		return get("start_month");
	}

	public void setEndMonth(java.lang.String endMonth) {
		set("end_month", endMonth);
	}

	public java.lang.String getEndMonth() {
		return get("end_month");
	}

	public void setRplaySeason(java.lang.String rplaySeason) {
		set("rplay_season", rplaySeason);
	}

	public java.lang.String getRplaySeason() {
		return get("rplay_season");
	}

	public void setCountryId(java.lang.Long countryId) {
		set("country_id", countryId);
	}

	public java.lang.Long getCountryId() {
		return get("country_id");
	}

	public void setCountryName(java.lang.String countryName) {
		set("country_name", countryName);
	}

	public java.lang.String getCountryName() {
		return get("country_name");
	}

	public void setProvinceId(java.lang.Long provinceId) {
		set("province_id", provinceId);
	}

	public java.lang.Long getProvinceId() {
		return get("province_id");
	}

	public void setProvinceName(java.lang.String provinceName) {
		set("province_name", provinceName);
	}

	public java.lang.String getProvinceName() {
		return get("province_name");
	}

	public void setCityCode(java.lang.Long cityCode) {
		set("city_code", cityCode);
	}

	public java.lang.Long getCityCode() {
		return get("city_code");
	}

	public void setCityName(java.lang.String cityName) {
		set("city_name", cityName);
	}

	public java.lang.String getCityName() {
		return get("city_name");
	}

	public void setAreaId(java.lang.Long areaId) {
		set("area_id", areaId);
	}

	public java.lang.Long getAreaId() {
		return get("area_id");
	}

	public void setAreaName(java.lang.String areaName) {
		set("area_name", areaName);
	}

	public java.lang.String getAreaName() {
		return get("area_name");
	}

	public void setAddress(java.lang.String address) {
		set("address", address);
	}

	public java.lang.String getAddress() {
		return get("address");
	}

	public void setPlatitude(java.lang.String platitude) {
		set("platitude", platitude);
	}

	public java.lang.String getPlatitude() {
		return get("platitude");
	}

	public void setPlongitude(java.lang.String plongitude) {
		set("plongitude", plongitude);
	}

	public java.lang.String getPlongitude() {
		return get("plongitude");
	}

	public void setOpenCycle(java.lang.String openCycle) {
		set("open_cycle", openCycle);
	}

	public java.lang.String getOpenCycle() {
		return get("open_cycle");
	}

	public void setUsuallyStartTime(java.lang.String usuallyStartTime) {
		set("usually_start_time", usuallyStartTime);
	}

	public java.lang.String getUsuallyStartTime() {
		return get("usually_start_time");
	}

	public void setUsuallyEndTime(java.lang.String usuallyEndTime) {
		set("usually_end_time", usuallyEndTime);
	}

	public java.lang.String getUsuallyEndTime() {
		return get("usually_end_time");
	}

	public void setHolidaysStartTime(java.lang.String holidaysStartTime) {
		set("holidays_start_time", holidaysStartTime);
	}

	public java.lang.String getHolidaysStartTime() {
		return get("holidays_start_time");
	}

	public void setHolidaysEndTime(java.lang.String holidaysEndTime) {
		set("holidays_end_time", holidaysEndTime);
	}

	public java.lang.String getHolidaysEndTime() {
		return get("holidays_end_time");
	}

	public void setSuggestMinTime(java.lang.Double suggestMinTime) {
		set("suggest_min_time", suggestMinTime);
	}

	public java.lang.Double getSuggestMinTime() {
		return get("suggest_min_time");
	}

	public void setSuggestMaxTime(java.lang.Double suggestMaxTime) {
		set("suggest_max_time", suggestMaxTime);
	}

	public java.lang.Double getSuggestMaxTime() {
		return get("suggest_max_time");
	}

	public void setStartTime(java.lang.String startTime) {
		set("start_time", startTime);
	}

	public java.lang.String getStartTime() {
		return get("start_time");
	}

	public void setEndTime(java.lang.String endTime) {
		set("end_time", endTime);
	}

	public java.lang.String getEndTime() {
		return get("end_time");
	}

	public void setBanStartTime(java.lang.String banStartTime) {
		set("ban_start_time", banStartTime);
	}

	public java.lang.String getBanStartTime() {
		return get("ban_start_time");
	}

	public void setBanEndTime(java.lang.String banEndTime) {
		set("ban_end_time", banEndTime);
	}

	public java.lang.String getBanEndTime() {
		return get("ban_end_time");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

	public void setAdultPrice(java.lang.String adultPrice) {
		set("adult_price", adultPrice);
	}

	public java.lang.String getAdultPrice() {
		return get("adult_price");
	}

	public void setElderPrice(java.lang.Double elderPrice) {
		set("elder_price", elderPrice);
	}

	public java.lang.Double getElderPrice() {
		return get("elder_price");
	}

	public void setChildPrice(java.lang.Double childPrice) {
		set("child_price", childPrice);
	}

	public java.lang.Double getChildPrice() {
		return get("child_price");
	}

	public void setHadultPrice(java.lang.String hadultPrice) {
		set("hadult_price", hadultPrice);
	}

	public java.lang.String getHadultPrice() {
		return get("hadult_price");
	}

	public void setHelderPrice(java.lang.Double helderPrice) {
		set("helder_price", helderPrice);
	}

	public java.lang.Double getHelderPrice() {
		return get("helder_price");
	}

	public void setHchildPrice(java.lang.Double hchildPrice) {
		set("hchild_price", hchildPrice);
	}

	public java.lang.Double getHchildPrice() {
		return get("hchild_price");
	}

	public void setPrice(java.lang.Double price) {
		set("price", price);
	}

	public java.lang.Double getPrice() {
		return get("price");
	}

	public void setIsPreordain(java.lang.String isPreordain) {
		set("is_preordain", isPreordain);
	}

	public java.lang.String getIsPreordain() {
		return get("is_preordain");
	}

	public void setPreordainDay(java.lang.String preordainDay) {
		set("preordain_day", preordainDay);
	}

	public java.lang.String getPreordainDay() {
		return get("preordain_day");
	}

	public void setPreordainTime(java.lang.String preordainTime) {
		set("preordain_time", preordainTime);
	}

	public java.lang.String getPreordainTime() {
		return get("preordain_time");
	}

	public void setBuyNotice(java.lang.String buyNotice) {
		set("buy_notice", buyNotice);
	}

	public java.lang.String getBuyNotice() {
		return get("buy_notice");
	}

	public void setDescription(java.lang.String description) {
		set("description", description);
	}

	public java.lang.String getDescription() {
		return get("description");
	}

	public void setGraphic(java.lang.String graphic) {
		set("graphic", graphic);
	}

	public java.lang.String getGraphic() {
		return get("graphic");
	}

	public void setIncreaseRate(java.lang.String increaseRate) {
		set("increase_rate", increaseRate);
	}

	public java.lang.String getIncreaseRate() {
		return get("increase_rate");
	}

	public void setIncreaseMoney(java.lang.Double increaseMoney) {
		set("increase_money", increaseMoney);
	}

	public java.lang.Double getIncreaseMoney() {
		return get("increase_money");
	}

	public void setDiscount(java.lang.Double discount) {
		set("discount", discount);
	}

	public java.lang.Double getDiscount() {
		return get("discount");
	}

	public void setSuitCustom(java.lang.String suitCustom) {
		set("suit_custom", suitCustom);
	}

	public java.lang.String getSuitCustom() {
		return get("suit_custom");
	}

	public void setCreateId(java.lang.Long createId) {
		set("create_id", createId);
	}

	public java.lang.Long getCreateId() {
		return get("create_id");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setUpdateId(java.lang.Long updateId) {
		set("update_id", updateId);
	}

	public java.lang.Long getUpdateId() {
		return get("update_id");
	}

	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}

	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

	public void setStatus(java.lang.String status) {
		set("status", status);
	}

	public java.lang.String getStatus() {
		return get("status");
	}

	public void setParentId(java.lang.Long parentId) {
		set("parent_id", parentId);
	}

	public java.lang.Long getParentId() {
		return get("parent_id");
	}

	public void setTcScore(java.lang.Double tcScore) {
		set("tc_score", tcScore);
	}

	public java.lang.Double getTcScore() {
		return get("tc_score");
	}

	public void setXcScore(java.lang.Double xcScore) {
		set("xc_score", xcScore);
	}

	public java.lang.Double getXcScore() {
		return get("xc_score");
	}

	public void setTnScore(java.lang.Double tnScore) {
		set("tn_score", tnScore);
	}

	public java.lang.Double getTnScore() {
		return get("tn_score");
	}

	public void setYhScore(java.lang.Double yhScore) {
		set("yh_score", yhScore);
	}

	public java.lang.Double getYhScore() {
		return get("yh_score");
	}

	public void setTip1(java.lang.String tip1) {
		set("tip1", tip1);
	}

	public java.lang.String getTip1() {
		return get("tip1");
	}

	public void setTip2(java.lang.String tip2) {
		set("tip2", tip2);
	}

	public java.lang.String getTip2() {
		return get("tip2");
	}

	public void setTelephone(java.lang.String telephone) {
		set("telephone", telephone);
	}

	public java.lang.String getTelephone() {
		return get("telephone");
	}

}
