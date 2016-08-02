package com.jluzh.schoolbbs.service;

import java.util.List;
import com.jluzh.schoolbbs.dao.PostDao;
import com.jluzh.schoolbbs.entities.Post;

public class PostService {
	private PostDao postDao;

	public PostDao getPostDao() {
		return postDao;
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

	// 保存或者发表帖子
	public void save(Post post) {
		postDao.save(post);

	}

	// 获取全部帖子根据回复时间排序
	public List<Post> getAll() {
		List<Post> list = postDao.getAll();
		System.out.println(list);
		return list;
	}

	// 根据帖子id删除帖子
	public void delete(Integer postId) {
		postDao.delete(postId);
	}

	// 根据帖子id获取帖子
	public Post get(Integer postid) {
		return postDao.get(postid);
	}

	// 根据模块确定页面数
	public Object getCount(Integer plateid) {
		return postDao.getCount(plateid);

	}

	// 获取当前页面的帖子
	public List<Post> getPageEntity(int beginIndex, int pageSize, Integer plateid) {
		return postDao.getPageEntity(beginIndex, pageSize, plateid);
	}

	// 增加帖子的浏览数
	public void addglanceNum(Integer postId) {
		postDao.addglancenum(postId);
	}

	// 增加帖子的回复数
	public void addreplyNum(Integer postId) {
		postDao.addreplynum(postId);
	}

	// 搜索帖子
	public List<Post> getpostbypostkey(String key) {
		return postDao.getpostbypostkey(key);
	}

	// 获取所有帖子的数量
	public Object findNum() {
		return postDao.findNum();
	}

	// 获取所有帖子
	public List<Post> getPageEntity(int beginIndex, int pageSize) {
		return postDao.getPageEntity(beginIndex, pageSize);
	}

	// 根据postId获得post对象
	public Post findPostById(int postId) {

		return postDao.findPostById(postId);
	}

	public void saveOrUpdate(Post post) {
		postDao.saveOrUpdate(post);
	}

	// 根据用户Id获取所有帖子的数量
	public Object findNum1(int userId) {
		return postDao.findNum1(userId);
	}

	// 根据用户Id获取所有帖子
	public List<Post> getPageEntityByUid(int beginIndex, int pageSize, int userId) {
		return postDao.getPageEntityByUid(beginIndex, pageSize, userId);
	}
}
