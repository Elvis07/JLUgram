package com.jluzh.schoolbbs.appAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.GsonBuilder;
import com.jluzh.schoolbbs.entities.FiledCategory;
import com.jluzh.schoolbbs.service.FileCatalogService;
import com.jluzh.schoolbbs.utils.ResponseObject;
import com.opensymphony.xwork2.ActionSupport;

public class AppFileCatalogAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private FileCatalogService fileCatalogService;

	public void setFileCatalogService(FileCatalogService fileCatalogService) {
		this.fileCatalogService = fileCatalogService;
	}

	public void catalog() throws IOException {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = response.getWriter();
		ResponseObject result = null;

		List<FiledCategory> catalogs = fileCatalogService.getAllFileCatalogs();
		int count = fileCatalogService.countCatalogs();
		if (catalogs != null && catalogs.size() > 0) {
			result = new ResponseObject(1, catalogs);
			result.setCount(count);

		} else {
			result = new ResponseObject(0, "目录为空");
		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();
	}

}
