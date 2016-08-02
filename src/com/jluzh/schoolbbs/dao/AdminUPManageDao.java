package com.jluzh.schoolbbs.dao;

import java.util.List;

import com.jluzh.schoolbbs.entities.Post;

public class AdminUPManageDao extends BaseDao{

	public List<Post> getPageEntity(int beginIndex, int pageSize) {
		String hql = "From Post p LEFT OUTER JOIN FETCH p.plate LEFT OUTER JOIN FETCH p.user";
		List<Post> list = (List<Post>) getSession().createQuery(hql).setFirstResult(beginIndex).setMaxResults(pageSize).list();
		
 		
		return list;
	}

	public Object getCount() {
		String hql = "select count(*) from Post";
		Object count = getSession().createQuery(hql).uniqueResult();
		return count;
	}

	public void delete(Post post) {
		 getSession().delete(post);
	}
	
	public Post get(Integer id){
		return (Post) getSession().get(Post.class,id);
				
	}
}
