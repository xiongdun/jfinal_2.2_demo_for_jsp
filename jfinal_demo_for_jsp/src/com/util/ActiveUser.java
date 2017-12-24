package com.util;

import java.io.Serializable;
import java.util.List;

import com.demo.bean.yhUser.yhUser;

public class ActiveUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8994504700076460715L;

	private Long userid;

	private String usercode;

	private String username;

	private String salt;

	private List<yhUser> menus;

	private List<yhUser> permissions;

	/**
	 * @return the userid
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * @return the usercode
	 */
	public String getUsercode() {
		return usercode;
	}

	/**
	 * @param usercode
	 *            the usercode to set
	 */
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public List<yhUser> getMenus() {
		return menus;
	}

	public void setMenus(List<yhUser> menus) {
		this.menus = menus;
	}

	public List<yhUser> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<yhUser> permissions) {
		this.permissions = permissions;
	}

	/**
	 * @return the salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt
	 *            the salt to set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

}
