package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseYhTravel<M extends BaseYhTravel<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setUId(java.lang.Long uId) {
		set("u_id", uId);
	}

	public java.lang.Long getUId() {
		return get("u_id");
	}

	public void setTNo(java.lang.String tNo) {
		set("t_no", tNo);
	}

	public java.lang.String getTNo() {
		return get("t_no");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setBeginDate(java.util.Date beginDate) {
		set("begin_date", beginDate);
	}

	public java.util.Date getBeginDate() {
		return get("begin_date");
	}

	public void setEndDate(java.util.Date endDate) {
		set("end_date", endDate);
	}

	public java.util.Date getEndDate() {
		return get("end_date");
	}

	public void setImageKey(java.lang.String imageKey) {
		set("image_key", imageKey);
	}

	public java.lang.String getImageKey() {
		return get("image_key");
	}

	public void setTotalDays(java.lang.String totalDays) {
		set("total_days", totalDays);
	}

	public java.lang.String getTotalDays() {
		return get("total_days");
	}

	public void setCount(java.lang.Integer count) {
		set("count", count);
	}

	public java.lang.Integer getCount() {
		return get("count");
	}

	public void setMeetMind(java.lang.String meetMind) {
		set("meet_mind", meetMind);
	}

	public java.lang.String getMeetMind() {
		return get("meet_mind");
	}

	public void setTicketCount(java.lang.Integer ticketCount) {
		set("ticket_count", ticketCount);
	}

	public java.lang.Integer getTicketCount() {
		return get("ticket_count");
	}

	public void setRestCount(java.lang.Integer restCount) {
		set("rest_count", restCount);
	}

	public java.lang.Integer getRestCount() {
		return get("rest_count");
	}

	public void setHotelCount(java.lang.Integer hotelCount) {
		set("hotel_count", hotelCount);
	}

	public java.lang.Integer getHotelCount() {
		return get("hotel_count");
	}

	public void setAdditionalExperience(java.lang.String additionalExperience) {
		set("additional_experience", additionalExperience);
	}

	public java.lang.String getAdditionalExperience() {
		return get("additional_experience");
	}

	public void setPrice(java.lang.Double price) {
		set("price", price);
	}

	public java.lang.Double getPrice() {
		return get("price");
	}

	public void setCurrency(java.lang.String currency) {
		set("currency", currency);
	}

	public java.lang.String getCurrency() {
		return get("currency");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setCreateId(java.lang.Long createId) {
		set("create_id", createId);
	}

	public java.lang.Long getCreateId() {
		return get("create_id");
	}

	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}

	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

	public void setUpdateId(java.lang.Long updateId) {
		set("update_id", updateId);
	}

	public java.lang.Long getUpdateId() {
		return get("update_id");
	}

	public void setStatus(java.lang.String status) {
		set("status", status);
	}

	public java.lang.String getStatus() {
		return get("status");
	}

	public void setUsercode(java.lang.String usercode) {
		set("usercode", usercode);
	}

	public java.lang.String getUsercode() {
		return get("usercode");
	}

}
