package com.jluzh.schoolbbs.action;

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
import com.jluzh.schoolbbs.service.PlateService;
import com.jluzh.schoolbbs.service.PostService;
import com.jluzh.schoolbbs.service.ReplyService;
import com.jluzh.schoolbbs.utils.AppPageMessage;
import com.jluzh.schoolbbs.utils.PageBean;
import com.jluzh.schoolbbs.utils.PageMessage;
import com.jluzh.schoolbbs.utils.ResponseObject;
import com.opensymphony.xwork2.ActionContext;
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
	private Integer plateid;
	private int pageNo = 1;
	private PlateService plateService;
	private PostService postService;
	private ReplyService replyService;
	private File upload;
	private String uploadFileName;
	private String savePath;
	private Integer postId;
	private Map<String, Object> request;
    private String plateid1;
    
    public void setPlateid1(String plateid1) {
		this.plateid1 = plateid1;
	}
	
	public void setPlateService(PlateService plateService) {
		this.plateService = plateService;
	}

	public Integer getPlateid() {
		return plateid;
	}

	public void setPlateid(Integer plateid) {
		this.plateid = plateid;
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}

	private String getSavePath() throws Exception {
		return ServletActionContext.getRequest().getRealPath(savePath);
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
		System.out.println(postService);
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public File getUpload() {
		return upload;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String sent() throws Exception {
		User user = (User) session.get("user");
		if (user != null) {
			ActionContext actionContext = ActionContext.getContext();
			@SuppressWarnings("unchecked")
			Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
			requestMap.put("title", getModel().getTitle());
			requestMap.put("text", getModel().getContent());
			if (getUploadFileName() != null) {
				FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + getUploadFileName());
				FileInputStream fin = new FileInputStream(getUpload());
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fin.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				fin.close();
				post.setPostTime(new Date());
				Plate plate = new Plate();
				//plate.setId((Integer) session.get("plate"));
				plate.setId(Integer.parseInt(plateid1));
				post.setPlate(plate);
				System.out.println(getUploadFileName());
				post.setPostImage("post1/" + uploadFileName);
				post.setUser((User) ActionContext.getContext().getSession().get("user"));
				post.setGlanceNum(0);
				post.setReplyNum(0);
				postService.save(post);
				return SUCCESS;
			}
		}
		return "input";
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
	public String list() throws Exception {
		// List<Reply> lastReplyList=new ArrayList<Reply>();
		Object count = postService.getCount(plateid);
		int countTotal = Integer.parseInt(String.valueOf(count));
		PageBean pagebean = AppPageMessage.getPageMessage(pageNo, countTotal);
		List<Post> list = postService.getPageEntity(pagebean.getBeginIndex(), pagebean.getPageSize(), plateid);
		Plate plate=plateService.plateById(plateid+"");
		/*
		 * for(Post post:list) { Reply reply = new Reply(); reply =
		 * replyService.findlastreplybypostid(post.getPostId());
		 * lastReplyList.add(reply); }
		 */
		System.out.println(getPlateid());
		request.put("plate", plate);
		request.put("plateid", plateid);
		request.put("countTotal", countTotal);
		request.put("posts", list);
		request.put("pages", pageNo);

		return "list";

	}

	// 显示所有帖子根据帖子回复时间排序
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
		if (post.getId() != null) {
			Post postbyid = postService.get(post.getId());
			request.put("post", postbyid);
			System.out.println(postbyid.getUser().getUerImage());
			return "listbyid";
		} else {
			Post postbyid = postService.get(postId);
			request.put("post", postbyid);
			System.out.println(postbyid.getUser().getUerImage());
			return "listbyid";
		}

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

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;

	}

}