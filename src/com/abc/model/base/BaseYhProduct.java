package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseYhProduct<M extends BaseYhProduct<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setProductType(java.lang.Integer productType) {
		set("product_type", productType);
	}

	public java.lang.Integer getProductType() {
		return get("product_type");
	}

	public void setAllName(java.lang.String allName) {
		set("all_name", allName);
	}

	public java.lang.String getAllName() {
		return get("all_name");
	}

	public void setShortName(java.lang.String shortName) {
		set("short_name", shortName);
	}

	public java.lang.String getShortName() {
		return get("short_name");
	}

	public void setStatus(java.lang.String status) {
		set("status", status);
	}

	public java.lang.String getStatus() {
		return get("status");
	}

	public void setPicSrc(java.lang.String picSrc) {
		set("pic_src", picSrc);
	}

	public java.lang.String getPicSrc() {
		return get("pic_src");
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

	public void setDefaultId(java.lang.Long defaultId) {
		set("default_id", defaultId);
	}

	public java.lang.Long getDefaultId() {
		return get("default_id");
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

	public void setAddress(java.lang.String address) {
		set("address", address);
	}

	public java.lang.String getAddress() {
		return get("address");
	}

	public void setDescription(java.lang.String description) {
		set("description", description);
	}

	public java.lang.String getDescription() {
		return get("description");
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

	public void setCode(java.lang.String code) {
		set("code", code);
	}

	public java.lang.String getCode() {
		return get("code");
	}

	public void setIsRecommend(java.lang.Boolean isRecommend) {
		set("is_recommend", isRecommend);
	}

	public java.lang.Boolean getIsRecommend() {
		return get("is_recommend");
	}

	public void setIsActivity(java.lang.Boolean isActivity) {
		set("is_activity", isActivity);
	}

	public java.lang.Boolean getIsActivity() {
		return get("is_activity");
	}

	public void setIsBprice(java.lang.Boolean isBprice) {
		set("is_bprice", isBprice);
	}

	public java.lang.Boolean getIsBprice() {
		return get("is_bprice");
	}

	public void setIsDistance(java.lang.Boolean isDistance) {
		set("is_distance", isDistance);
	}

	public java.lang.Boolean getIsDistance() {
		return get("is_distance");
	}

	public void setAverageScore(java.lang.Double averageScore) {
		set("average_score", averageScore);
	}

	public java.lang.Double getAverageScore() {
		return get("average_score");
	}

	public void setUserScore(java.lang.Double userScore) {
		set("user_score", userScore);
	}

	public java.lang.Double getUserScore() {
		return get("user_score");
	}

	public void setPrice(java.lang.Double price) {
		set("price", price);
	}

	public java.lang.Double getPrice() {
		return get("price");
	}

	public void setAloneCrowd(java.lang.Double aloneCrowd) {
		set("alone_crowd", aloneCrowd);
	}

	public java.lang.Double getAloneCrowd() {
		return get("alone_crowd");
	}

	public void setFriend_crowd(java.lang.Double friend_crowd) {
		set("friend__crowd", friend_crowd);
	}

	public java.lang.Double getFriend_crowd() {
		return get("friend__crowd");
	}

	public void setFamilyCrowd(java.lang.Double familyCrowd) {
		set("family_crowd", familyCrowd);
	}

	public java.lang.Double getFamilyCrowd() {
		return get("family_crowd");
	}

	public void setPaternityCrowd(java.lang.Double paternityCrowd) {
		set("paternity_crowd", paternityCrowd);
	}

	public java.lang.Double getPaternityCrowd() {
		return get("paternity_crowd");
	}

	public void setLoversCrowd(java.lang.Double loversCrowd) {
		set("lovers_crowd", loversCrowd);
	}

	public java.lang.Double getLoversCrowd() {
		return get("lovers_crowd");
	}

	public void setOlderCrowd(java.lang.Double olderCrowd) {
		set("older_crowd", olderCrowd);
	}

	public java.lang.Double getOlderCrowd() {
		return get("older_crowd");
	}

}
