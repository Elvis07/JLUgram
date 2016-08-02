package com.jluzh.schoolbbs.entities;

import java.util.Date;

public class FileRes {
	private Integer id;
	private String filedName;
	private String filedPath;
	private String filedSize;
	private String filetype;
	private Date upTime;

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	private User user;
	private FiledCategory filedCategory;

	public String getFiledSize() {
		return filedSize;
	}

	public void setFiledSize(String filedSize) {
		this.filedSize = filedSize;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFiledName() {
		return filedName;
	}

	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}

	public String getFiledPath() {
		return filedPath;
	}

	public void setFiledPath(String filedPath) {
		this.filedPath = filedPath;
	}

	public Date getUpTime() {
		return upTime;
	}

	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FiledCategory getFiledCategory() {
		return filedCategory;
	}

	public void setFiledCategory(FiledCategory filedCategory) {
		this.filedCategory = filedCategory;
	}

}
