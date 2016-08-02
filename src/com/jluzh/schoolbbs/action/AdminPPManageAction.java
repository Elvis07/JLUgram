package com.jluzh.schoolbbs.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.jluzh.schoolbbs.entities.Plate;
import com.jluzh.schoolbbs.service.AdminPPManageService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AdminPPManageAction extends ActionSupport implements ModelDriven<Plate>,Preparable,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AdminPPManageService  adminPPManageService;
	public void setAdminPPManageService(AdminPPManageService adminPPManageService) {
		this.adminPPManageService = adminPPManageService;
	}
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String input(){
		
		return "input";
	} 
	public void prepareInput(){
		if(id != null){
			plate = adminPPManageService.get(id);
		}
	}
	
	
	public String delete(){
		adminPPManageService.delete(id);
		return "delete";
	}
	
	public String save(){
		adminPPManageService.saveOrUpdate(plate);
		return "save";
	}
	public void prepareSave(){
		if(id == null){
			plate = new Plate();
		}else{
			plate = adminPPManageService.get(id);
		}
	}
	
	public String findAll(){
		List<Plate> findAll = adminPPManageService.findAll();
		request.put("plateList", findAll);
		return "findAll";
	}
	
	
	
	@Override
	public void prepare() throws Exception {
	}
	
	private Plate plate;
	@Override
	public Plate getModel() {
		return plate;
	}
	private Map<String,Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	
}
