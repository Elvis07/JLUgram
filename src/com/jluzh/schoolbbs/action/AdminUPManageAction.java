package com.jluzh.schoolbbs.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.aspectj.util.FileUtil;

import com.jluzh.schoolbbs.entities.Admin;
import com.jluzh.schoolbbs.entities.News;
import com.jluzh.schoolbbs.entities.Post;
import com.jluzh.schoolbbs.service.AdminUPManageService;
import com.jluzh.schoolbbs.utils.PageBean;
import com.jluzh.schoolbbs.utils.PageMessage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AdminUPManageAction extends ActionSupport implements ModelDriven<Post>,RequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminUPManageService adminUPManageService;
	public void setAdminUPManageService(AdminUPManageService adminUPManageService) {
		this.adminUPManageService = adminUPManageService;
	}
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	private Integer currPage ;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	private int pageNo;
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public String findAll() throws Exception{
		int currPage=pageNo;
		
		int totalNum = Integer.parseInt(String.valueOf(findNum()));
		
		
		request.put("totalNum", totalNum);
		request.put("currPage", currPage);
		PageBean pageBean=PageMessage.getPageMessage(currPage,totalNum);
		List<Post> postList=adminUPManageService.getPageEntity(pageBean.getBeginIndex(),pageBean.getPageSize());
		request.put("postList", postList);
		
			
		return "findAll";
	}
	public String delete(){
		adminUPManageService.delete(id);
		return "delete";
	}


	
	
	
	private Object findNum() {
		
		return adminUPManageService.getCount();
	}
	private Post post = new Post();
	@Override
	public Post getModel() {
		return post;
	}
	private Map<String,Object> request;
	@Override
 	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
}
