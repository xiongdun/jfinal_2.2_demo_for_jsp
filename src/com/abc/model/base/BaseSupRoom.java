package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSupRoom<M extends BaseSupRoom<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setHid(java.lang.Long hid) {
		set("hid", hid);
	}

	public java.lang.Long getHid() {
		return get("hid");
	}

	public void setRoomTypeCode(java.lang.Long roomTypeCode) {
		set("room_type_code", roomTypeCode);
	}

	public java.lang.Long getRoomTypeCode() {
		return get("room_type_code");
	}

	public void setRoomTypeName(java.lang.String roomTypeName) {
		set("room_type_name", roomTypeName);
	}

	public java.lang.String getRoomTypeName() {
		return get("room_type_name");
	}

	public void setStandardOccupancy(java.lang.Integer standardOccupancy) {
		set("standard_occupancy", standardOccupancy);
	}

	public java.lang.Integer getStandardOccupancy() {
		return get("standard_occupancy");
	}

	public void setSize(java.lang.String size) {
		set("size", size);
	}

	public java.lang.String getSize() {
		return get("size");
	}

	public void setBedTypeCode(java.lang.String bedTypeCode) {
		set("bed_type_code", bedTypeCode);
	}

	public java.lang.String getBedTypeCode() {
		return get("bed_type_code");
	}

	public void setQuantity(java.lang.Integer quantity) {
		set("quantity", quantity);
	}

	public java.lang.Integer getQuantity() {
		return get("quantity");
	}

	public void setRoomAmenity(java.lang.String roomAmenity) {
		set("room_amenity", roomAmenity);
	}

	public java.lang.String getRoomAmenity() {
		return get("room_amenity");
	}

	public void setDescriptive(java.lang.String descriptive) {
		set("descriptive", descriptive);
	}

	public java.lang.String getDescriptive() {
		return get("descriptive");
	}

	public void setAveragePrice(java.lang.Double averagePrice) {
		set("average_price", averagePrice);
	}

	public java.lang.Double getAveragePrice() {
		return get("average_price");
	}

	public void setGamount(java.lang.Double gamount) {
		set("gamount", gamount);
	}

	public java.lang.Double getGamount() {
		return get("gamount");
	}

	public void setBreakfast(java.lang.Integer breakfast) {
		set("breakfast", breakfast);
	}

	public java.lang.Integer getBreakfast() {
		return get("breakfast");
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

	public void setRoomAmenityStr(java.lang.String roomAmenityStr) {
		set("room_amenity_str", roomAmenityStr);
	}

	public java.lang.String getRoomAmenityStr() {
		return get("room_amenity_str");
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

	public void setAddBed(java.lang.String addBed) {
		set("add_bed", addBed);
	}

	public java.lang.String getAddBed() {
		return get("add_bed");
	}

	public void setCode(java.lang.String code) {
		set("code", code);
	}

	public java.lang.String getCode() {
		return get("code");
	}

	public void setSupRid(java.lang.String supRid) {
		set("sup_rid", supRid);
	}

	public java.lang.String getSupRid() {
		return get("sup_rid");
	}

	public void setPid(java.lang.Long pid) {
		set("pid", pid);
	}

	public java.lang.Long getPid() {
		return get("pid");
	}

	public void setSupplierId(java.lang.Long supplierId) {
		set("supplier_id", supplierId);
	}

	public java.lang.Long getSupplierId() {
		return get("supplier_id");
	}

}
