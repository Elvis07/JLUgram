package com.jluzh.schoolbbs.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.jluzh.schoolbbs.entities.Plate;
import com.jluzh.schoolbbs.service.PlateService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PlateAction extends ActionSupport implements ModelDriven<Plate>, RequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlateService plateService;
	private Map<String, Object> request;

	public PlateService getPlateService() {
		return plateService;
	}

	public void setPlateService(PlateService plateService) {
		this.plateService = plateService;
	}

	public String list() {

		List<Plate> list = plateService.getAll();
		request.put("plates", list);
		return "list";

	}

	@Override
	public Plate getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

}
