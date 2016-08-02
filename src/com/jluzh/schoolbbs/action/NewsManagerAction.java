package com.jluzh.schoolbbs.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.aspectj.util.FileUtil;

import com.jluzh.schoolbbs.entities.Admin;
import com.jluzh.schoolbbs.entities.News;
import com.jluzh.schoolbbs.service.AdminService;
import com.jluzh.schoolbbs.service.NewsManagerService;
import com.jluzh.schoolbbs.utils.PageBean;
import com.jluzh.schoolbbs.utils.PageMessage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class NewsManagerAction extends ActionSupport implements RequestAware,ModelDriven<News>,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private NewsManagerService newsManagerService;
	public void setNewsManagerService(NewsManagerService newsManagerService) {
		this.newsManagerService = newsManagerService;
	}
	private AdminService adminService;
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	private Integer id;
	public void setId(Integer id) {
		this.id = id;
	}
	private Integer currPage;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	private int pageNo=1;
	private int moderId;
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public void setModerId(int moderId) {
		this.moderId = moderId;
	}
	//文件上传参数
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
	public String findAll() throws Exception{
		int currPage=pageNo;
		
		int totalNum = Integer.parseInt(String.valueOf(findNum()));
		System.out.println(moderId);
		
		request.put("totalNum", totalNum);
		request.put("currPage", currPage);
		PageBean pageBean=PageMessage.getPageMessage(currPage,totalNum);
		List<News> newsList=newsManagerService.getPageEntity(pageBean.getBeginIndex(),pageBean.getPageSize());
		request.put("newsList", newsList);
		
			
		return "findAll";
	}
	
	
	public String find8News(){
		List<News> news8List=newsManagerService.get8News();
		request.put("news8List", news8List);
		return "find8News";
		
	}
	
	public String findNewsDetail(){
		News news = newsManagerService.findNewsDetail(id);
		
		request.put("news", news);
		return "findNewsDetail";
	}
	
	public String delete(){
		newsManagerService.delete(id);
		return "delete";
	}
	public String input(){
		List<Admin> admins = adminService.findAll();
		request.put("admins", admins);
		return "input";
	}

	public void prepareInput(){
		if(id != null){
			news = newsManagerService.get(id);
		}
	}
	public String save() throws IOException{
		news.setLaunchTime(new Date());
		if(upload != null){
			String realPath = ServletActionContext.getServletContext().getRealPath("/images");
			File file = new File(realPath+"//"+uploadFileName);
			FileUtil.copyFile(upload, file);
			news.setImgUrl("images/"+uploadFileName);
		}
		newsManagerService.saveOrUpdate(news);	
		return "save";
	}
	public void prepareSave(){
		if(id == null){
			news = new News();
		}else{
			news = newsManagerService.get(id);
			
		}
	}
	
	
	
	private Object findNum() {
		
		return newsManagerService.getCount();
	}
	
	private Map<String,Object> request;
	@Override
 	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}
	private News news = new News();
	@Override
	public News getModel() {
		return news;
	}

	@Override
	public void prepare() throws Exception {
	}
}
