package com.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {
	
	
	public static ActiveUser getCurrentUser(){
		// 取身份信息
		Subject subject = SecurityUtils.getSubject();
		
		ActiveUser user = (ActiveUser) subject.getPrincipal();
		return user;
	}
	
    public static String md5(String password,String salt) {  
        
    	// 原始 密码
		String source =password;
		// 盐
		//String salt = salt;
		// 散列次数
		int hashIterations = 1;
		SimpleHash simpleHash = new SimpleHash("md5", source, salt,
				hashIterations);
		source=simpleHash.toString();
        
        return source;  
    } 
	

}
