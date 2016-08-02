package com.jluzh.schoolbbs.appAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.google.gson.GsonBuilder;
import com.jluzh.schoolbbs.entities.Plate;
import com.jluzh.schoolbbs.entities.Post;
import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.service.PostService;
import com.jluzh.schoolbbs.service.ReplyService;
import com.jluzh.schoolbbs.utils.AppPageMessage;
import com.jluzh.schoolbbs.utils.PageBean;
import com.jluzh.schoolbbs.utils.PageMessage;
import com.jluzh.schoolbbs.utils.ResponseObject;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class PostAction extends ActionSupport implements ModelDriven<Post>, Preparable, RequestAware, SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int pageNo = 1;
	private PostService postService;
	private ReplyService replyService;
	private File upload;
	private String uploadFileName;
	private String savepath;
	private Integer postId;
	private Map<String, Object> request;
	private Integer plateid;
	private String key;
	private String post_content;
	private String posttitle;
	private int userId;
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}


	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getPageNo() {
		return pageNo;
	}

	public Integer getPostId() {
		return postId;
	}

	public Map<String, Object> getRequest() {
		return request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public Integer getPlateid() {
		return plateid;
	}

	public void setPlateid(Integer plateid) {
		this.plateid = plateid;
	}

	public ReplyService getReplyService() {
		return replyService;
	}

	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	private Map<String, Object> session;
	private Post post = new Post();

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public String getSavepath() throws Exception {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void sent() throws Exception {
		if (getUploadFileName() != null) {
			/*
			 * FileOutputStream fos = new FileOutputStream(getSavepath() + "\\"
			 * + getUploadFileName()); FileInputStream fin = new
			 * FileInputStream(getUpload()); byte[] buffer = new byte[1024]; int
			 * len = 0; while ((len = fin.read(buffer)) > 0) { fos.write(buffer,
			 * 0, len); } fos.close(); fin.close();
			 */
			post.setPostTime(new Date());
			Plate plate = new Plate();
			plate.setId(plateid);
			post.setPlate(plate);
			System.out.println(getUploadFileName());
			post.setPostImage("/post" + uploadFileName);
			post.setTitle(posttitle);
			post.setContent(post_content);
			User user = new User();
			user.setId(userId);

			post.setUser(user);
			post.setGlanceNum(0);
			post.setReplyNum(0);
			postService.save(post);
		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("文件为空");
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String save() {
		postService.save(post);
		return "save";
	}

	public void prepareSave() {
		if (postId == null) {
			post = new Post();
		} else {
			post = postService.get(postId);
		}
	}

	public String delete() {

		postService.delete(post.getId());
		return "delete";

	}

	@Override
	public Post getModel() {
		// TODO Auto-generated method stub
		return post;
	}

	// 根据板块列出所有帖子
	public void list() throws Exception {
		// List<Reply> lastReplyList=new ArrayList<Reply>();
		Object count = postService.getCount(getPlateid());
		int countTotal = Integer.parseInt(String.valueOf(count));
		PageBean pagebean = AppPageMessage.getPageMessage(pageNo, countTotal);
		List<Post> list = postService.getPageEntity(pagebean.getBeginIndex(), pagebean.getPageSize(), getPlateid());
		/*
		 * for(Post post:list) { Reply reply = new Reply(); reply =
		 * replyService.findlastreplybypostid(post.getPostId());
		 * lastReplyList.add(reply); }
		 */
		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ResponseObject<List<Post>> result = null;
		if (list != null && list.size() > 0) {
			result = new ResponseObject<List<Post>>(1, list);
		} else {
			result = new ResponseObject<List<Post>>(0, "没有帖子数据");
		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();

	}

	// 显示所有帖子
	public void listall() throws Exception {
		// List<Reply> lastReplyList=new ArrayList<Reply>();
		Object count = postService.getCount(getPlateid());
		int countTotal = Integer.parseInt(String.valueOf(count));
		PageBean pagebean = PageMessage.getPageMessage(pageNo, countTotal);
		List<Post> list = postService.getPageEntity(pagebean.getBeginIndex(), pagebean.getPageSize(), getPlateid());
		/*
		 * for(Post post:list) { Reply reply = new Reply(); reply =
		 * replyService.findlastreplybypostid(post.getPostId());
		 * lastReplyList.add(reply); }
		 */
		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		ResponseObject<List<Post>> result = null;
		if (list != null && list.size() > 0) {
			result = new ResponseObject<List<Post>>(1, list);
		} else {
			result = new ResponseObject<List<Post>>(0, "没有帖子数据");
		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();

	}

	public String listbyid() {
		Post postbyid = postService.get(post.getId());
		request.put("post", postbyid);
		return "listbyid";
	}

	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub

	}

	public String reply() {
		return "reply";
	}

	public String search() {
		List<Post> searchlist = postService.getpostbypostkey(getKey());
		request.put("searchlist", searchlist);
		return "search";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;

	}

}