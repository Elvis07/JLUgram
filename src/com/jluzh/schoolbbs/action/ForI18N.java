package com.jluzh.schoolbbs.action;

import com.opensymphony.xwork2.ActionSupport;

public class ForI18N extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String index1() {
		return "index1";
	}

	public String index3() {
		return "index3";
	}

	public String reg() {
		return "reg";
	}

	public String login() {
		return "login";
	}
	
	public String modPwd() {
		return "modPwd";
	}
	
	public String UpdateInfo() {
		return "UpdateInfo";
	}
}
