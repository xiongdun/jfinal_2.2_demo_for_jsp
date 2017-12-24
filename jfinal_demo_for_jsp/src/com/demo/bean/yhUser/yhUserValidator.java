package com.demo.bean.yhUser;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.util.CheckErrorResultBean;
import com.util.ResponseState;
import com.util.ResponseVO;

/**
 * 
* @author  chenguanghai
* @version 创建时间：2016年5月30日 下午6:06:31
*
 */
public class yhUserValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		validateRegex("phone", "^[1][3,4,5,7,8][0-9]{9}$", "phone", "请输入正确的手机号!");
		validateString("password", 6, 18, "password", "请正确输入密码!");
		
	}

	@Override
	protected void handleError(Controller c) {
		ResponseVO vo = new ResponseVO();
		vo.setData(new CheckErrorResultBean("phone", "请输入正确的手机号"));
		vo.setCode(ResponseState.CHECKERROR.getCode());
		vo.setMsg(ResponseState.CHECKERROR.getMsg());
		c.renderJson(vo);
	}

}
