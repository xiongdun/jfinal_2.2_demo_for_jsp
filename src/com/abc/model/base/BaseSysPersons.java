package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSysPersons<M extends BaseSysPersons<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setMid(java.lang.Long mid) {
		set("mid", mid);
	}

	public java.lang.Long getMid() {
		return get("mid");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setCtype(java.lang.Integer ctype) {
		set("ctype", ctype);
	}

	public java.lang.Integer getCtype() {
		return get("ctype");
	}

	public void setCnumber(java.lang.String cnumber) {
		set("cnumber", cnumber);
	}

	public java.lang.String getCnumber() {
		return get("cnumber");
	}

	public void setPhone(java.lang.String phone) {
		set("phone", phone);
	}

	public java.lang.String getPhone() {
		return get("phone");
	}

	public void setTelephone(java.lang.String telephone) {
		set("telephone", telephone);
	}

	public java.lang.String getTelephone() {
		return get("telephone");
	}

	public void setEmail(java.lang.String email) {
		set("email", email);
	}

	public java.lang.String getEmail() {
		return get("email");
	}

	public void setWeixin(java.lang.String weixin) {
		set("weixin", weixin);
	}

	public java.lang.String getWeixin() {
		return get("weixin");
	}

	public void setWeibo(java.lang.String weibo) {
		set("weibo", weibo);
	}

	public java.lang.String getWeibo() {
		return get("weibo");
	}

	public void setValidity(java.util.Date validity) {
		set("validity", validity);
	}

	public java.util.Date getValidity() {
		return get("validity");
	}

	public void setCreateId(java.lang.Long createId) {
		set("create_id", createId);
	}

	public java.lang.Long getCreateId() {
		return get("create_id");
	}

	public void setUpdateId(java.lang.Long updateId) {
		set("update_id", updateId);
	}

	public java.lang.Long getUpdateId() {
		return get("update_id");
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

	public void setStatus(java.lang.String status) {
		set("status", status);
	}

	public java.lang.String getStatus() {
		return get("status");
	}

}