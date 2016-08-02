package com.jluzh.schoolbbs.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.jluzh.schoolbbs.service.FileCatalogService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileCatalogAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = 1L;
	private FileCatalogService fileCatalogService;

	public void setFileCatalogService(FileCatalogService fileCatalogService) {
		this.fileCatalogService = fileCatalogService;
	}

	public String browseCatalog() {
		List catalogs = null;
		catalogs = fileCatalogService.getAllFileCatalogs();
		request.put("catalogs", catalogs);
		return SUCCESS;
	}

	
	Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		request=arg0;
	}
}
