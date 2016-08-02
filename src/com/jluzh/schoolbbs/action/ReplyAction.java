package com.jluzh.schoolbbs.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.JsonArray;
import com.jluzh.schoolbbs.entities.Post;
import com.jluzh.schoolbbs.entities.Reply;
import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.service.ReplyService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*import sun.org.mozilla.javascript.internal.json.JsonParser;*/

public class ReplyAction extends ActionSupport implements RequestAware, ModelDriven<Reply>, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Reply reply ;
	private Map<String, Object> request;
	private ReplyService replyService;
	private Map<String, Object> session;
	private Integer postId;
	private InputStream inputStream;
	private String content;
	private String replyId;
	
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public void setPostId(Integer postId) {
		this.postId = postId;
	}


	public ReplyService getReplyService() {
		return replyService;
	}

	public void setReplyService(ReplyService replyService) {
		if(replyService!=null)
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
		request.put("replysid", replylist);
		return "list";

	}

	public String listbyid() {

		List<Reply> replylist = replyService.getbyid(postId);
		request.put("replysid", replylist);
		return "listbyid";

	}

	// 追加评论
	public String save() {
		User user = (User) session.get("user");
		if (user != null) {
			System.out.println(postId);
			Post post = new Post();
			post.setId(postId);			
			Reply reply1=new Reply();
			reply1.setPost(post);			
			reply1.setUser(user);
			reply1.setContent(content);
			SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
			Date dates=new Date();
			 date.format(dates);
			reply1.setReplayTime(dates);
			replyService.save(reply1);
			return "save";
		}
		return "error";
	}

	// 删除评论
	public String delete() throws Exception {
		replyService.delete(Integer.parseInt(replyId));
		inputStream=new ByteArrayInputStream("1".getBytes("utf-8"));
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
//ajax增加评论
	public String saveajax() throws Exception {
		User user = (User) session.get("user");
		if (user != null) {
			System.out.println(postId);
			Post post = new Post();
			post.setId(postId);
			reply.setPost(post);
			reply.setUser(user);
			SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
			Date dates=new Date();
			date.format(dates);
			reply.setReplayTime(dates);
			replyService.save(reply);
			return "saveajax";
	}
		
		return "errorajax";
	
}
}
