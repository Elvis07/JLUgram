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
import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.service.UserManagerService;
import com.jluzh.schoolbbs.utils.PageBean;
import com.jluzh.schoolbbs.utils.PageMessage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UserManagerAction extends ActionSupport implements RequestAware, ModelDriven<User>,Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserManagerService userManagerService;

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

	private Integer id;
	private File upload;
	private String uploadFileName;
	private String uploadContextType;
	
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer currPage;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	private int pageNo;

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public String input(){
		/*List<User> allUsers = userManagerService.findUsers();
		request.put("allUsers", allUsers);*/
		return "input";
	}

	public void prepareInput(){
		if(id != null){
			user = userManagerService.get(id);
		}
	}
	
	public String findAll() throws Exception {
		int currPage = pageNo;

		int totalNum = Integer.parseInt(String.valueOf(findNum()));

		request.put("totalNum", totalNum);
		request.put("currPage", currPage);
		PageBean pageBean = PageMessage.getPageMessage(currPage, totalNum);
		List<User> users = userManagerService.getPageEntity(pageBean.getBeginIndex(), pageBean.getPageSize());
		
		request.put("users", users);
		return "findAll";
	}
	public String delete(){
		userManagerService.delete(id);
		return "delete";
	}
	
	public String save() throws IOException{
		
		if(upload != null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/images");
			File file = new File(realPath+"//"+uploadFileName);
			FileUtil.copyFile(upload, file);
			user.setUerImage("images/"+uploadFileName);
		}
		userManagerService.saveOrUpdate(user);	
		return "save";
	}
	public void prepareSave(){
		if(id == null){
			user = new User();
		}else{
			user = userManagerService.get(id);
			
		}
	}
	
	private Object findNum() {

		return userManagerService.getCount();
	}

	User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void prepare() throws Exception {
	}
}
