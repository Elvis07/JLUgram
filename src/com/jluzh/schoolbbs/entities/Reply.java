package com.jluzh.schoolbbs.entities;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String content;
	private String replyImage;
	private Date replayTime;
	private User user;
	private Post post;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReplyImage() {
		return replyImage;
	}
	public void setReplyImage(String replyImage) {
		this.replyImage = replyImage;
	}
	public Date getReplayTime() {
		return replayTime;
	}
	public void setReplayTime(Date replayTime) {
		this.replayTime = replayTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
}
