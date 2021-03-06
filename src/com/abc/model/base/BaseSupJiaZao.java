package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSupJiaZao<M extends BaseSupJiaZao<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setSupHid(java.lang.Long supHid) {
		set("sup_hid", supHid);
	}

	public java.lang.Long getSupHid() {
		return get("sup_hid");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
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

	public void setCurrency(java.lang.String currency) {
		set("currency", currency);
	}

	public java.lang.String getCurrency() {
		return get("currency");
	}

	public void setCharge(java.lang.Float charge) {
		set("charge", charge);
	}

	public java.lang.Float getCharge() {
		return get("charge");
	}

	public void setUnit(java.lang.String unit) {
		set("unit", unit);
	}

	public java.lang.String getUnit() {
		return get("unit");
	}

	public void setSupplierId(java.lang.Long supplierId) {
		set("supplier_id", supplierId);
	}

	public java.lang.Long getSupplierId() {
		return get("supplier_id");
	}

	public void setChargecommision(java.lang.Float chargecommision) {
		set("chargecommision", chargecommision);
	}

	public java.lang.Float getChargecommision() {
		return get("chargecommision");
	}

	public void setPricetype(java.lang.String pricetype) {
		set("pricetype", pricetype);
	}

	public java.lang.String getPricetype() {
		return get("pricetype");
	}

	public void setZfFloor(java.lang.String zfFloor) {
		set("zf_floor", zfFloor);
	}

	public java.lang.String getZfFloor() {
		return get("zf_floor");
	}

	public void setUpdateBy(java.lang.String updateBy) {
		set("update_by", updateBy);
	}

	public java.lang.String getUpdateBy() {
		return get("update_by");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}

	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}

	public java.lang.String getRemark() {
		return get("remark");
	}

	public void setActive(java.lang.String active) {
		set("active", active);
	}

	public java.lang.String getActive() {
		return get("active");
	}

	public void setSupOid(java.lang.Integer supOid) {
		set("sup_oid", supOid);
	}

	public java.lang.Integer getSupOid() {
		return get("sup_oid");
	}

}
