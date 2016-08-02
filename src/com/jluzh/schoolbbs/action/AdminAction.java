package com.jluzh.schoolbbs.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jluzh.schoolbbs.entities.Admin;
import com.jluzh.schoolbbs.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AdminAction extends ActionSupport implements ModelDriven<Admin>,SessionAware,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AdminService adminService;
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String findAll(){
		List<Admin> admins = adminService.findAll();
		return "findAll";
	}
	
	
	public String login(){
		Admin exitAdmin = adminService.login(admin);
		if(exitAdmin == null){
			this.addActionError("登录失败：用户名或密码错误！");
			return "loginfail";
		}else{
			
			session.put("exitAdmin", exitAdmin);
			return "login";
		}
	}
	public void prepareLogin(){
		admin = new Admin();
	}
	
	public String top(){
		return "top";
	}
	public String body(){
		return "body";
	}
	public String left(){
		return "left";
	}

	private Admin admin;
	@Override
	public Admin getModel() {

		return admin;
	}

	


	@Override
	public void prepare() throws Exception {
	}

	private Map<String,Object> session;
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
