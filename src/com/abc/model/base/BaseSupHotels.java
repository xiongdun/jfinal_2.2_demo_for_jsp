package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSupHotels<M extends BaseSupHotels<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setPid(java.lang.Long pid) {
		set("pid", pid);
	}

	public java.lang.Long getPid() {
		return get("pid");
	}

	public void setCODE(java.lang.String CODE) {
		set("CODE", CODE);
	}

	public java.lang.String getCODE() {
		return get("CODE");
	}

	public void setBrand(java.lang.String brand) {
		set("brand", brand);
	}

	public java.lang.String getBrand() {
		return get("brand");
	}

	public void setShortName(java.lang.String shortName) {
		set("short_name", shortName);
	}

	public java.lang.String getShortName() {
		return get("short_name");
	}

	public void setZname(java.lang.String zname) {
		set("zname", zname);
	}

	public java.lang.String getZname() {
		return get("zname");
	}

	public void setEname(java.lang.String ename) {
		set("ename", ename);
	}

	public java.lang.String getEname() {
		return get("ename");
	}

	public void setPaymentType(java.lang.Integer paymentType) {
		set("payment_type", paymentType);
	}

	public java.lang.Integer getPaymentType() {
		return get("payment_type");
	}

	public void setCurrency(java.lang.String currency) {
		set("currency", currency);
	}

	public java.lang.String getCurrency() {
		return get("currency");
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

	public void setAreaId(java.lang.Long areaId) {
		set("area_id", areaId);
	}

	public java.lang.Long getAreaId() {
		return get("area_id");
	}

	public void setCityName(java.lang.String cityName) {
		set("city_name", cityName);
	}

	public java.lang.String getCityName() {
		return get("city_name");
	}

	public void setAreaName(java.lang.String areaName) {
		set("area_name", areaName);
	}

	public java.lang.String getAreaName() {
		return get("area_name");
	}

	public void setHotelStarRate(java.lang.String hotelStarRate) {
		set("hotel_star_rate", hotelStarRate);
	}

	public java.lang.String getHotelStarRate() {
		return get("hotel_star_rate");
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

	public void setAcheckInTime(java.lang.String acheckInTime) {
		set("acheck_in_time", acheckInTime);
	}

	public java.lang.String getAcheckInTime() {
		return get("acheck_in_time");
	}

	public void setMcheckOutTime(java.lang.String mcheckOutTime) {
		set("mcheck_out_time", mcheckOutTime);
	}

	public java.lang.String getMcheckOutTime() {
		return get("mcheck_out_time");
	}

	public void setPicSrc(java.lang.String picSrc) {
		set("pic_src", picSrc);
	}

	public java.lang.String getPicSrc() {
		return get("pic_src");
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

	public void setStatus(java.lang.String status) {
		set("status", status);
	}

	public java.lang.String getStatus() {
		return get("status");
	}

	public void setFitDate(java.lang.Integer fitDate) {
		set("fit_date", fitDate);
	}

	public java.lang.Integer getFitDate() {
		return get("fit_date");
	}

	public void setFitSeason(java.lang.String fitSeason) {
		set("fit_season", fitSeason);
	}

	public java.lang.String getFitSeason() {
		return get("fit_season");
	}

	public void setGraphic(java.lang.String graphic) {
		set("graphic", graphic);
	}

	public java.lang.String getGraphic() {
		return get("graphic");
	}

	public void setSupHid(java.lang.String supHid) {
		set("sup_hid", supHid);
	}

	public java.lang.String getSupHid() {
		return get("sup_hid");
	}

	public void setTelephone(java.lang.String telephone) {
		set("telephone", telephone);
	}

	public java.lang.String getTelephone() {
		return get("telephone");
	}

	public void setFax(java.lang.String fax) {
		set("fax", fax);
	}

	public java.lang.String getFax() {
		return get("fax");
	}

	public void setPostcode(java.lang.String postcode) {
		set("postcode", postcode);
	}

	public java.lang.String getPostcode() {
		return get("postcode");
	}

	public void setEmail(java.lang.String email) {
		set("email", email);
	}

	public java.lang.String getEmail() {
		return get("email");
	}

	public void setThemetype(java.lang.String themetype) {
		set("themetype", themetype);
	}

	public java.lang.String getThemetype() {
		return get("themetype");
	}

	public void setBd(java.lang.Long bd) {
		set("bd", bd);
	}

	public java.lang.Long getBd() {
		return get("bd");
	}

	public void setFloor(java.lang.Integer floor) {
		set("floor", floor);
	}

	public java.lang.Integer getFloor() {
		return get("floor");
	}

	public void setWebSite(java.lang.String webSite) {
		set("web_site", webSite);
	}

	public java.lang.String getWebSite() {
		return get("web_site");
	}

	public void setAddressChn(java.lang.String addressChn) {
		set("address_chn", addressChn);
	}

	public java.lang.String getAddressChn() {
		return get("address_chn");
	}

	public void setAdressEng(java.lang.String adressEng) {
		set("adress_eng", adressEng);
	}

	public java.lang.String getAdressEng() {
		return get("adress_eng");
	}

	public void setInteriorNotes(java.lang.String interiorNotes) {
		set("interior_notes", interiorNotes);
	}

	public java.lang.String getInteriorNotes() {
		return get("interior_notes");
	}

	public void setLanguage(java.lang.String language) {
		set("language", language);
	}

	public java.lang.String getLanguage() {
		return get("language");
	}

	public void setAcceptCustom(java.lang.String acceptCustom) {
		set("accept_custom", acceptCustom);
	}

	public java.lang.String getAcceptCustom() {
		return get("accept_custom");
	}

	public void setPinyin(java.lang.String pinyin) {
		set("pinyin", pinyin);
	}

	public java.lang.String getPinyin() {
		return get("pinyin");
	}

	public void setFacilities(java.lang.String facilities) {
		set("facilities", facilities);
	}

	public java.lang.String getFacilities() {
		return get("facilities");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
	}

	public void setKeynames(java.lang.String keynames) {
		set("keynames", keynames);
	}

	public java.lang.String getKeynames() {
		return get("keynames");
	}

	public void setSupplierId(java.lang.Long supplierId) {
		set("supplier_id", supplierId);
	}

	public java.lang.Long getSupplierId() {
		return get("supplier_id");
	}

}