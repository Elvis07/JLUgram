package com.jluzh.schoolbbs.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserUpAvatarAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	private User user1 = new User();
	private UserService userService;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;

	public void setUserService(UserService userService) {
		this.userService = userService;
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

	@Override
	public String execute() throws Exception {

		if (uploadFileName != null) {
			String newName = UUID.randomUUID() + uploadFileName.substring(uploadFileName.lastIndexOf("."));
			// 以服务器的文件保存地址和随机文件名建立上传文件输出流
			user1 = (User) ActionContext.getContext().getSession().get("user");
			String d = getSavePath() + "\\" + newName;
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

			// 网络资源//user1.setUerImage("http://1508n3z468.iok.la/SchoolBBS/avatar/"+newName);
			if (getUpload() == null) {
				addFieldError("上传头像", "尚未选择上传的文件");
				return INPUT;
			}
			user1.setUerImage("avatar/" + newName);

			userService.updateUserImg(user1);
		}
		return "updateImg";

	}

	public void validate() {
		if (uploadFileName== null||"".equals(uploadFileName)){
			addFieldError("上传头像", "你还未选择上传的图片");
		}
	};

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user1;
	}

}
