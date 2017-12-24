package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseYhPlaneOrder<M extends BaseYhPlaneOrder<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setOid(java.lang.Long oid) {
		set("oid", oid);
	}

	public java.lang.Long getOid() {
		return get("oid");
	}

	public void setPid(java.lang.Long pid) {
		set("pid", pid);
	}

	public java.lang.Long getPid() {
		return get("pid");
	}

	public void setPname(java.lang.String pname) {
		set("pname", pname);
	}

	public java.lang.String getPname() {
		return get("pname");
	}

	public void setFlightType(java.lang.String flightType) {
		set("flight_type", flightType);
	}

	public java.lang.String getFlightType() {
		return get("flight_type");
	}

	public void setBeginCity(java.lang.String beginCity) {
		set("begin_city", beginCity);
	}

	public java.lang.String getBeginCity() {
		return get("begin_city");
	}

	public void setEndCity(java.lang.String endCity) {
		set("end_city", endCity);
	}

	public java.lang.String getEndCity() {
		return get("end_city");
	}

	public void setDateBegin(java.util.Date dateBegin) {
		set("date_begin", dateBegin);
	}

	public java.util.Date getDateBegin() {
		return get("date_begin");
	}

	public void setFlightCompany(java.lang.String flightCompany) {
		set("flight_company", flightCompany);
	}

	public java.lang.String getFlightCompany() {
		return get("flight_company");
	}

	public void setBeginAirport(java.lang.String beginAirport) {
		set("begin_Airport", beginAirport);
	}

	public java.lang.String getBeginAirport() {
		return get("begin_Airport");
	}

	public void setEndAirport(java.lang.String endAirport) {
		set("end_Airport", endAirport);
	}

	public java.lang.String getEndAirport() {
		return get("end_Airport");
	}

	public void setFirstAir(java.util.Date firstAir) {
		set("first_air", firstAir);
	}

	public java.util.Date getFirstAir() {
		return get("first_air");
	}

	public void setLatestAir(java.util.Date latestAir) {
		set("Latest_air", latestAir);
	}

	public java.util.Date getLatestAir() {
		return get("Latest_air");
	}

	public void setPlaneModel(java.lang.String planeModel) {
		set("plane_Model", planeModel);
	}

	public java.lang.String getPlaneModel() {
		return get("plane_Model");
	}

	public void setFlightNo(java.lang.String flightNo) {
		set("flight_no", flightNo);
	}

	public java.lang.String getFlightNo() {
		return get("flight_no");
	}

	public void setStopCount(java.lang.Integer stopCount) {
		set("stop_count", stopCount);
	}

	public java.lang.Integer getStopCount() {
		return get("stop_count");
	}

	public void setTicketLang(java.lang.String ticketLang) {
		set("ticket_lang", ticketLang);
	}

	public java.lang.String getTicketLang() {
		return get("ticket_lang");
	}

	public void setModifyDesc(java.lang.String modifyDesc) {
		set("modify_desc", modifyDesc);
	}

	public java.lang.String getModifyDesc() {
		return get("modify_desc");
	}

	public void setReturnDesc(java.lang.String returnDesc) {
		set("return_desc", returnDesc);
	}

	public java.lang.String getReturnDesc() {
		return get("return_desc");
	}

	public void setTurnDesc(java.lang.String turnDesc) {
		set("turn_desc", turnDesc);
	}

	public java.lang.String getTurnDesc() {
		return get("turn_desc");
	}

	public void setTicRemark(java.lang.String ticRemark) {
		set("tic_remark", ticRemark);
	}

	public java.lang.String getTicRemark() {
		return get("tic_remark");
	}

	public void setPrice(java.lang.Double price) {
		set("price", price);
	}

	public java.lang.Double getPrice() {
		return get("price");
	}

	public void setAdultTax(java.lang.Double adultTax) {
		set("adult_tax", adultTax);
	}

	public java.lang.Double getAdultTax() {
		return get("adult_tax");
	}

	public void setBabyTax(java.lang.Double babyTax) {
		set("baby_tax", babyTax);
	}

	public java.lang.Double getBabyTax() {
		return get("baby_tax");
	}

	public void setChildTax(java.lang.Double childTax) {
		set("child_tax", childTax);
	}

	public java.lang.Double getChildTax() {
		return get("child_tax");
	}

	public void setBabyOilFee(java.lang.Double babyOilFee) {
		set("baby_oil_fee", babyOilFee);
	}

	public java.lang.Double getBabyOilFee() {
		return get("baby_oil_fee");
	}

	public void setChildOilFee(java.lang.Double childOilFee) {
		set("child_oil_fee", childOilFee);
	}

	public java.lang.Double getChildOilFee() {
		return get("child_oil_fee");
	}

	public void setIsK(java.lang.String isK) {
		set("is_k", isK);
	}

	public java.lang.String getIsK() {
		return get("is_k");
	}

	public void setIsSc(java.lang.String isSc) {
		set("is_sc", isSc);
	}

	public java.lang.String getIsSc() {
		return get("is_sc");
	}

	public void setAdultOilFee(java.lang.Double adultOilFee) {
		set("adult_oil_fee", adultOilFee);
	}

	public java.lang.Double getAdultOilFee() {
		return get("adult_oil_fee");
	}

	public void setIsRebate(java.lang.String isRebate) {
		set("is_rebate", isRebate);
	}

	public java.lang.String getIsRebate() {
		return get("is_rebate");
	}

	public void setReturnAmount(java.lang.Double returnAmount) {
		set("return_amount", returnAmount);
	}

	public java.lang.Double getReturnAmount() {
		return get("return_amount");
	}

	public void setSid(java.lang.Long sid) {
		set("sid", sid);
	}

	public java.lang.Long getSid() {
		return get("sid");
	}

	public void setSname(java.lang.String sname) {
		set("sname", sname);
	}

	public java.lang.String getSname() {
		return get("sname");
	}

	public void setScode(java.lang.String scode) {
		set("scode", scode);
	}

	public java.lang.String getScode() {
		return get("scode");
	}

	public void setCnumber(java.lang.String cnumber) {
		set("cnumber", cnumber);
	}

	public java.lang.String getCnumber() {
		return get("cnumber");
	}

	public void setCtype(java.lang.Integer ctype) {
		set("ctype", ctype);
	}

	public java.lang.Integer getCtype() {
		return get("ctype");
	}

	public void setOntactName(java.lang.String ontactName) {
		set("ontact_name", ontactName);
	}

	public java.lang.String getOntactName() {
		return get("ontact_name");
	}

	public void setConfirmWay(java.lang.String confirmWay) {
		set("confirm_way", confirmWay);
	}

	public java.lang.String getConfirmWay() {
		return get("confirm_way");
	}

	public void setPhoneNo(java.lang.String phoneNo) {
		set("phone_no", phoneNo);
	}

	public java.lang.String getPhoneNo() {
		return get("phone_no");
	}

	public void setEmail(java.lang.String email) {
		set("email", email);
	}

	public java.lang.String getEmail() {
		return get("email");
	}

	public void setAddress(java.lang.String address) {
		set("address", address);
	}

	public java.lang.String getAddress() {
		return get("address");
	}

	public void setFax(java.lang.String fax) {
		set("fax", fax);
	}

	public java.lang.String getFax() {
		return get("fax");
	}

	public void setInsCost(java.lang.Double insCost) {
		set("ins_cost", insCost);
	}

	public java.lang.Double getInsCost() {
		return get("ins_cost");
	}

	public void setIsCancel(java.lang.Integer isCancel) {
		set("is_cancel", isCancel);
	}

	public java.lang.Integer getIsCancel() {
		return get("is_cancel");
	}

	public void setCancelStartTime(java.util.Date cancelStartTime) {
		set("cancel_start_time", cancelStartTime);
	}

	public java.util.Date getCancelStartTime() {
		return get("cancel_start_time");
	}

	public void setCancelEndTime(java.util.Date cancelEndTime) {
		set("cancel_end_time", cancelEndTime);
	}

	public java.util.Date getCancelEndTime() {
		return get("cancel_end_time");
	}

	public void setCancelAmount(java.lang.Double cancelAmount) {
		set("cancel_amount", cancelAmount);
	}

	public java.lang.Double getCancelAmount() {
		return get("cancel_amount");
	}

	public void setPaymentStatus(java.lang.Integer paymentStatus) {
		set("payment_status", paymentStatus);
	}

	public java.lang.Integer getPaymentStatus() {
		return get("payment_status");
	}

	public void setPaymentType(java.lang.Integer paymentType) {
		set("payment_type", paymentType);
	}

	public java.lang.Integer getPaymentType() {
		return get("payment_type");
	}

	public void setOrderRemark(java.lang.String orderRemark) {
		set("order_remark", orderRemark);
	}

	public java.lang.String getOrderRemark() {
		return get("order_remark");
	}

	public void setStatus(java.lang.String status) {
		set("status", status);
	}

	public java.lang.String getStatus() {
		return get("status");
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

}