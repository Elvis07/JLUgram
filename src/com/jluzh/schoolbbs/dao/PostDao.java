package com.jluzh.schoolbbs.dao;

import java.util.List;

import org.hibernate.Hibernate;

import com.jluzh.schoolbbs.entities.Post;

public class PostDao extends BaseDao {

	public List<Post> getAll() {

		String hql = "FROM Post ";
		@SuppressWarnings("unchecked")
		List<Post> list = getSession().createQuery(hql).list();
		for (Post post : list) {
			Hibernate.initialize(post);
		}
		return list;
	}

	public void save(Post post) {
		getSession().save(post);
	}

	public Post get(Integer postId) {
		String hql = "From Post p LEFT OUTER JOIN FETCH p.user LEFT OUTER JOIN FETCH p.plate where p.id = ?";
		Post post = (Post) getSession().createQuery(hql).setInteger(0, postId).uniqueResult();
		return  post;
	}

	public void delete(Post post) {
		getSession().delete(post);
	}

	public void delete(Integer postId) {
		String hql = "DELETE FROM Post p WHERE p.id = ?";
		getSession().createQuery(hql).setInteger(0, postId).executeUpdate();
	}

	public Object getCount(Integer plateid) {
		String hql = "select count(*) from Post where plate.id=? ";
		Object count = getSession().createQuery(hql).setInteger(0, plateid).uniqueResult();
		return count;
	}

	public List<Post> getPageEntity(int beginIndex, int pageSize, Integer plateid) {
		String hql = "From Post p LEFT OUTER JOIN FETCH p.plate LEFT OUTER JOIN FETCH p.user  where p.plate.id=? ";
		@SuppressWarnings("unchecked")
		List<Post> list = (List<Post>) getSession().createQuery(hql).setFirstResult(beginIndex).setMaxResults(pageSize)
				.setInteger(0, plateid).list();
		for (Post post : list) {
			System.out.println(post);
			Hibernate.initialize(post);
			Hibernate.initialize(post.getUser());
			Hibernate.initialize(post.getPlate());

		}
		return list;
	}

	// 增加浏览数
	public void addglancenum(Integer postId) {
		String hql = "update from Post set glanceNum=glanceNum=1 where postId=?";
		getSession().createQuery(hql);

	}

	// 增加回复数
	public void addreplynum(Integer postId) {

		String hql = "update from Post set replyNum=replyNum=1 where postId=?";
		getSession().createQuery(hql);
	}

	// 搜索帖子

	public List<Post> getpostbypostkey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	// 搜索所有帖子数量
	public Object findNum() {
		String hql = "select count(*) from Post";
		Object count = getSession().createQuery(hql).uniqueResult();
		return count;
	}

	// 搜索所有帖子
	public List<Post> getPageEntity(int beginIndex, int pageSize) {
		String hql = "From Post p LEFT OUTER JOIN FETCH p.plate LEFT OUTER JOIN FETCH p.user ";
		// String hql = "From Post p LEFT OUTER JOIN FETCH p.plate LEFT OUTER
		// JOIN FETCH p.user,Reply r LEFT OUTER JOIN FETCH r.user,LEFT OUTER
		// JOIN FETCH r.post";
		// List<Post> postList = getSession().createQuery(hql).list();
		@SuppressWarnings("unchecked")
		List<Post> postList = getSession().createQuery(hql).setFirstResult(beginIndex).setMaxResults(pageSize).list();
		return postList;
	}

	public Post findPostById(int postId) {
		String hql = "From Post where id = ?";
		Post post = (Post) getSession().createQuery(hql).setInteger(0, postId).uniqueResult();
		return post;
	}

	public void saveOrUpdate(Post post) {

		getSession().saveOrUpdate(post);
	}

	// 根据userId获取所有帖子的数量
	public Object findNum1(int userId) {
		// String hql = "SELECT COUNT(*) FROM POST p WHERE p.user.id = ?";
		String hql = "select count(*) from Post where user.id = ?";
		Object count = getSession().createQuery(hql).setInteger(0, userId).uniqueResult();
		return count;
	}

	public List<Post> getPageEntityByUid(int beginIndex, int pageSize, int userId) {
		String hql = "From Post p LEFT OUTER JOIN FETCH p.plate LEFT OUTER JOIN FETCH p.user where p.user.id = ? ";
		@SuppressWarnings("unchecked")
		List<Post> postList = (List<Post>) getSession().createQuery(hql).setFirstResult(beginIndex)
				.setMaxResults(pageSize).setInteger(0, userId).list();
		return postList;
	}

}
