package com.jluzh.schoolbbs.service;

import java.util.List;

import com.jluzh.schoolbbs.dao.ReplyDao;
import com.jluzh.schoolbbs.entities.Post;
import com.jluzh.schoolbbs.entities.Reply;

public class ReplyService {
	private ReplyDao replyDao;

	public ReplyDao getReplyDao() {
		return replyDao;
	}

	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}

	// 获取所有评论
	public List<Reply> getAll() {

		return replyDao.getAll();
	}

	// 追加评论
	public void save(Reply reply) {
		
		replyDao.save(reply);
	}

	// 根据帖子id获得评论
	public List<Reply> getbyid(Integer postid) {
		List<Reply> list = replyDao.getbyid(postid);
		System.out.println(list);

		return list;
	}

	// 根据用户id获得评论
	public List<Reply> getbyuserid(Integer userid) {
		List<Reply> list = replyDao.getuserbyid(userid);
		System.out.println(list);

		return list;
	}

	// 删除评论
	public void delete(Integer replyId) {
		replyDao.delete(replyId);
	}

	public Reply findlastreplybypostid(Integer postid) {
		return replyDao.findlastreplybypostid(postid);
	}
	// 根据帖子id获得评论 带分页

	public List<Reply> getPageEntity(int beginIndex, int pageSize, int postId) {
		return replyDao.getPageEntity(beginIndex, pageSize, postId);
	}

	// 获取所有回复贴的数量
	public Object findNum(int postId) {
		return replyDao.findNum(postId);
	}

}
