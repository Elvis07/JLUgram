package com.jluzh.schoolbbs.appAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.GsonBuilder;
import com.jluzh.schoolbbs.entities.Post;
import com.jluzh.schoolbbs.entities.Reply;
import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.service.PostService;
import com.jluzh.schoolbbs.service.ReplyService;
import com.jluzh.schoolbbs.utils.AppPageMessage;
import com.jluzh.schoolbbs.utils.PageBean;
import com.jluzh.schoolbbs.utils.ResponseObject;
import com.opensymphony.xwork2.ActionSupport;

public class AppReplyAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ReplyService replyService;
	private PostService postService;
	private int page = 1;
	private int postId;
	private int userId;
	private String replyContent;

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	// 根据帖子Id查询所有相关回复
	public void findReplyByPostId() throws Exception {
		// 增加浏览次数
		Post post = postService.findPostById(postId);
		int glanceNum = post.getGlanceNum() + 1;
		post.setGlanceNum(glanceNum);
		postService.saveOrUpdate(post);

		int totalNum = Integer.parseInt(String.valueOf(findNum(postId)));
		PageBean pagebean = AppPageMessage.getPageMessage(page, totalNum);
		List<Reply> list = replyService.getPageEntity(pagebean.getBeginIndex(), pagebean.getPageSize(), postId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ResponseObject<List<Reply>> result = null;
		if (list != null && list.size() > 0) {
			result = new ResponseObject<List<Reply>>(1, list);
			result.setCount(pagebean.getPageCount());
			result.setPage(page);
			// result.setSize(totalNum);
		} else {
			result = new ResponseObject<List<Reply>>(0, "没有帖子数据");
		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();

	}

	// 获取所有回复帖子的数量
	private Object findNum(int postId) {

		return replyService.findNum(postId);
	}

	public void save() throws IOException {
		// 回复贴数量加1
		Post post1 = postService.findPostById(postId);
		int replyNum = post1.getReplyNum() + 1;
		post1.setReplyNum(replyNum);
		postService.saveOrUpdate(post1);

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		Reply reply = new Reply();
		User user = new User();
		user.setId(userId);
		Post post = new Post();
		post.setId(postId);
		reply.setPost(post);
		reply.setUser(user);
		Date date = new Date();
		reply.setReplayTime(date);

		//String replyContents = new String(replyContent.getBytes("iso-8859-1"), "UTF-8");
		reply.setContent(replyContent);

		replyService.save(reply);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		out.print("1");
		out.flush();
		out.close();
	}

}
