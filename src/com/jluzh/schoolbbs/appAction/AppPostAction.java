package com.jluzh.schoolbbs.appAction;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.GsonBuilder;
import com.jluzh.schoolbbs.entities.Post;
import com.jluzh.schoolbbs.service.PostService;
import com.jluzh.schoolbbs.utils.AppPageMessage;
import com.jluzh.schoolbbs.utils.PageBean;
import com.jluzh.schoolbbs.utils.PageMessage;
import com.jluzh.schoolbbs.utils.ResponseObject;
import com.opensymphony.xwork2.ActionSupport;

public class AppPostAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PostService postService;
	private int page = 1;
	private int userId;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void setPage(int page) {
		this.page = page;
	}

	// 显示所有帖子根据帖子回复时间排序
	public void listAll() throws Exception {
		int totalNum = Integer.parseInt(String.valueOf(findNum()));

		PageBean pagebean = AppPageMessage.getPageMessage(page, totalNum);
		List<Post> list = postService.getPageEntity(pagebean.getBeginIndex(), pagebean.getPageSize());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ResponseObject<List<Post>> result = null;
		if (list != null && list.size() > 0) {
			result = new ResponseObject<List<Post>>(1, list);
			result.setCount(pagebean.getPageCount());
			result.setPage(page);
		} else {
			result = new ResponseObject<List<Post>>(0, "没有帖子数据");
		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();

	}
	//根据用户Id查询所有帖子
	public void findPostByUid() throws Exception{
		int totalNum = Integer.parseInt(String.valueOf(findNum1(userId)));

		PageBean pagebean = AppPageMessage.getPageMessage(page, totalNum);
		List<Post> list = postService.getPageEntityByUid(pagebean.getBeginIndex(), pagebean.getPageSize(), userId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ResponseObject<List<Post>> result = null;
		if (list != null && list.size() > 0) {
			result = new ResponseObject<List<Post>>(1, list);
			result.setCount(pagebean.getPageCount());
			result.setPage(page);
		} else {
			result = new ResponseObject<List<Post>>(0, "没有帖子数据");
		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();

	} 
	//根据Id获取所有帖子的数量
	private Object findNum1(int userId){
		return postService.findNum1(userId);
	}
	// 获取所有帖子的数量
	private Object findNum() {

		return postService.findNum();
	}
}
