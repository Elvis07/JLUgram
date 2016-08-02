package com.jluzh.schoolbbs.appAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.GsonBuilder;
import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.service.UserService;
import com.jluzh.schoolbbs.utils.ResponseObject;
import com.jluzh.schoolbbs.utils.SomeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AppUserAction extends ActionSupport {

	/**
	 * 
	 */
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private static final long serialVersionUID = 1L;
	private String nickname;
	private String userImg;
	private String gender;
	private String userName;
	private String password;
	private String infoChanged;
	private String infoFlag;
	private String userid;

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}

	private String getSavePath() throws Exception {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public File getUpload() {
		return this.upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return this.uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadFileName() {
		return this.uploadFileName;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setInfoFlag(String infoFlag) {
		this.infoFlag = infoFlag;
	}

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setInfoChanged(String infoChanged) {
		this.infoChanged = infoChanged;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void userRegist1() throws IOException {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);

		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = response.getWriter();
		if (userService.userNameIsValid(user.getUserName()) && user.getPassword() != null) {
			userService.regist(user);
			out.print("1");// 成功
			out.flush();
			out.close();
		} else {
			out.print("0");// 失败
			out.flush();
			out.close();

		}

	}

	public void unameValidate() throws IOException {
		User user = new User();
		user.setUserName(userName);

		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = response.getWriter();
		if (userService.userNameIsValid(user.getUserName())) {
			out.print("1");// 成功
			out.flush();
			out.close();
		} else {
			out.print("0");// 失败
			out.flush();
			out.close();

		}

	}

	public void updateUinfo() throws IOException {

		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = response.getWriter();
		switch (infoFlag) {
		case "0":
			userService.updateNickname(userid, infoChanged);
			out.print("0");// 成功
			break;

		case "1":
			userService.updateGender(userid, infoChanged);
			out.print("1");// 成功
			break;

		case "2":
			userService.updateSign(userid, infoChanged);
			out.print("2");// 成功
			break;
		}

		out.flush();
		out.close();

	}

	public void userLogin() throws IOException {
		User user1 = new User();
		user1.setUserName(userName);
		user1.setPassword(password);
		user1 = userService.login(user1);

		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = response.getWriter();
		ResponseObject result = null;
		if (user1 != null) {
			result = new ResponseObject(1, user1);
		} else

		{
			result = new ResponseObject(0, "无数据");

		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();
	}

	public void uploadImage() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		// 以下代码从JSON.java中拷过来的
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = response.getWriter();

		String path = ServletActionContext.getRequest().getRealPath("/");
		File file = new File(path + userService.ImgByUid(userid));// 根据绝对路径创建一个文件对象
		if (file.exists()) {
			if (!"avatar/default.jpg".equals(userService.ImgByUid(userid))) {
				file.delete();// 删除文件
			}
		}

		String newName = UUID.randomUUID() + uploadFileName.substring(uploadFileName.lastIndexOf("."));
		// 以服务器的文件保存地址和随机文件名建立上传文件输出流
		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + newName);
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0) {
			fos.write(buffer, 0, len);
		}
		setUploadFileName(newName);
		fis.close();
		fos.close();

		userService.uploadImg(userid, "avatar/" + newName);
		ResponseObject result = new ResponseObject(1, "avatar/" + newName);
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();

	}

	public void qqLogin() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = response.getWriter();
		ResponseObject result = null;

		User user1 = new User();

		if (userService.userNameIsValid(nickname)) {
			user1.setGender(gender);
			user1.setNickname(nickname);
			user1.setUerImage(userImg);
			user1.setUserName(nickname);
			userService.addQInfo2UInfo(user1);
			result = new ResponseObject(1, user1);
		} else {
			user1 = userService.backQQuser(nickname);
			result = new ResponseObject(0, user1);
		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();
	}

	public void checkIn() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = response.getWriter();
		ResponseObject result = null;

		User user1 = new User();
		int a = SomeUtil.getDay();
		if (SomeUtil.getDay() != userService.checkDayByUid(userid)) {
			userService.checkIn(userid, SomeUtil.getDay());
			user1 = userService.backQQuser1(userid);
			result = new ResponseObject(1, user1);
		} else {
			result = new ResponseObject(0, "已签到了");
		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();
	}
}
