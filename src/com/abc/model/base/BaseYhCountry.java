package com.abc.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseYhCountry<M extends BaseYhCountry<M>> extends Model<M> implements IBean {

	public void setCountryid(java.lang.Long countryid) {
		set("countryid", countryid);
	}

	public java.lang.Long getCountryid() {
		return get("countryid");
	}

	public void setCountrycd(java.lang.String countrycd) {
		set("countrycd", countrycd);
	}

	public java.lang.String getCountrycd() {
		return get("countrycd");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setDescription(java.lang.String description) {
		set("description", description);
	}

	public java.lang.String getDescription() {
		return get("description");
	}

	public void setActive(java.lang.Integer active) {
		set("active", active);
	}

	public java.lang.Integer getActive() {
		return get("active");
	}

}
