package com.jluzh.schoolbbs.appAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.google.gson.GsonBuilder;
import com.jluzh.schoolbbs.entities.Plate;
import com.jluzh.schoolbbs.service.PlateService;
import com.jluzh.schoolbbs.utils.ResponseObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PlateAction extends ActionSupport implements ModelDriven<Plate>,RequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlateService plateService;
	public PlateService getPlateService() {
		return plateService;
	}

	public void setPlateService(PlateService plateService) {
		this.plateService = plateService;
	}
	
	public void list() throws IOException {
		
		List<Plate> list = plateService.getAll();
		//request.put("plates", list);
		HttpServletResponse response=ServletActionContext.getResponse();  
        //以下代码从JSON.java中拷过来的  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");
        PrintWriter out= response.getWriter();  
        ResponseObject<List<Plate>> result = null;
        if(list != null && list.size()>0){
        	result = new ResponseObject<List<Plate>>(1,list);
        }else{
        	result = new ResponseObject<List<Plate>>(0,"没有板块数据");
        }
        out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();
		
	}

	@Override
	public Plate getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
	}

}
