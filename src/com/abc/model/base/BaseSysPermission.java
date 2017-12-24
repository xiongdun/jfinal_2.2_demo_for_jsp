package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSysPermission<M extends BaseSysPermission<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

	public void setUrl(java.lang.String url) {
		set("url", url);
	}

	public java.lang.String getUrl() {
		return get("url");
	}

	public void setPercode(java.lang.String percode) {
		set("percode", percode);
	}

	public java.lang.String getPercode() {
		return get("percode");
	}

	public void setParentid(java.lang.Long parentid) {
		set("parentid", parentid);
	}

	public java.lang.Long getParentid() {
		return get("parentid");
	}

	public void setParentids(java.lang.String parentids) {
		set("parentids", parentids);
	}

	public java.lang.String getParentids() {
		return get("parentids");
	}

	public void setSort(java.lang.Integer sort) {
		set("sort", sort);
	}

	public java.lang.Integer getSort() {
		return get("sort");
	}

	public void setAvailable(java.lang.Integer available) {
		set("available", available);
	}

	public java.lang.Integer getAvailable() {
		return get("available");
	}

	public void setSystemType(java.lang.String systemType) {
		set("system_type", systemType);
	}

	public java.lang.String getSystemType() {
		return get("system_type");
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

}
