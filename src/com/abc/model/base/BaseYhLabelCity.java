package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseYhLabelCity<M extends BaseYhLabelCity<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setLabelId(java.lang.Long labelId) {
		set("label_id", labelId);
	}

	public java.lang.Long getLabelId() {
		return get("label_id");
	}

	public void setCityId(java.lang.Long cityId) {
		set("city_id", cityId);
	}

	public java.lang.Long getCityId() {
		return get("city_id");
	}

}
