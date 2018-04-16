package com.claims.manage.rest.model;

import com.claims.manage.common.messages.ConstantMessage;

public class BaseResoponse {

	private Integer code;
	private String msg;
	private ConstantMessage title;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public ConstantMessage getTitle() {
		return title;
	}
	public void setTitle(ConstantMessage title) {
	}
}

