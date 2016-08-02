package com.jluzh.schoolbbs.appAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.GsonBuilder;
import com.jluzh.schoolbbs.entities.Post;
import com.jluzh.schoolbbs.entities.Reply;
import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.service.ReplyService;
import com.jluzh.schoolbbs.utils.ResponseObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReplyAction extends ActionSupport implements RequestAware, ModelDriven<Reply>, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Reply reply = new Reply();
	private Integer postId;
	private String replycontent;
	private int userId;
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getReplycontent() {
		return replycontent;
	}

	public void setReplycontent(String replycontent) {
		this.replycontent = replycontent;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	private Map<String, Object> request;
	private ReplyService replyService;
	private Map<String, Object> session;

	public ReplyService getReplyService() {
		return replyService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;

	}

	@Override
	public Reply getModel() {
		System.out.println(reply);
		return reply;
	}

	public String list() {

		List<Reply> replylist = replyService.getAll();
		request.put("replys", replylist);
		return "list";

	}

	public void listbyid() throws Exception {

		List<Reply> replylist = replyService.getbyid(postId);
		System.out.println(replylist);
	//	request.put("replysid", replylist);
		HttpServletResponse response=ServletActionContext.getResponse();  
        //以下代码从JSON.java中拷过来的  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");
        PrintWriter out= response.getWriter();  
        ResponseObject<List<Reply>> result = null;
        if(replylist != null && replylist.size()>0){
        	result = new ResponseObject<List<Reply>>(1,replylist);
        }else{
        	result = new ResponseObject<List<Reply>>(0,"没有评论");
        }
        out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();

	}

	// 追加评论
	public void save() throws IOException {
		User user = (User) session.get("user");
		
			System.out.println(postId);
			Post post = new Post();
			user=new User();
			user.setId(userId);
			post.setId(postId);
			reply.setPost(post);
			reply.setUser(user);;
			reply.setContent(replycontent);
			reply.setReplayTime(new Date());
			replyService.save(reply);
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html");  
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out= response.getWriter(); 
	        out.flush();
			out.close();
			
		
		
	}

	// 删除评论
	public String delete() {
		replyService.delete(reply.getId());
		return "delete";
	}

	// 根据用户id获取评论
	public String listbyuserid() {
		User user = (User) session.get("user");
		List<Reply> replylist = replyService.getbyid(user.getId());
		request.put("replysuserid", replylist);
		return "listbyuserid";

	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;

	}

	
}
