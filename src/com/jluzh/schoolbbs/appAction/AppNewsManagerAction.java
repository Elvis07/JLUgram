package com.jluzh.schoolbbs.appAction;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.aspectj.util.FileUtil;

import com.google.gson.GsonBuilder;
import com.jluzh.schoolbbs.entities.Admin;
import com.jluzh.schoolbbs.entities.News;
import com.jluzh.schoolbbs.service.AdminService;
import com.jluzh.schoolbbs.service.NewsManagerService;
import com.jluzh.schoolbbs.utils.AppPageMessage;
import com.jluzh.schoolbbs.utils.PageBean;
import com.jluzh.schoolbbs.utils.ResponseObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class AppNewsManagerAction extends ActionSupport implements RequestAware,ModelDriven<News>,Preparable{

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
	private int page;
	public void setPage(int page) {
		this.page = page;
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
	public void findAll() throws Exception{
		int currPage=page;
		
		int totalNum = Integer.parseInt(String.valueOf(findNum()));
		
		/*int pageSize = Constant.a*/
		request.put("totalNum", totalNum);
		request.put("currPage", currPage);
		PageBean pageBean=AppPageMessage.getPageMessage(currPage, totalNum);
		List<News> newsList=newsManagerService.getPageEntity(pageBean.getBeginIndex(),10);
		HttpServletResponse response=ServletActionContext.getResponse();  
        //以下代码从JSON.java中拷过来的  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");
        PrintWriter out;  
        out = response.getWriter();  
        ResponseObject result = null;
        if(newsList != null && newsList.size()>0){
        	result = new ResponseObject(1,newsList);
        	result.setCount(totalNum);
        	result.setPage(currPage);
        	result.setCount(pageBean.getPageCount());
        	
        }else{
        	result = new ResponseObject(0,"没有城市数据");
        }
        out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();
		
			
		
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
