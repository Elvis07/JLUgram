package com.jluzh.schoolbbs.dao;

import java.util.List;

import com.jluzh.schoolbbs.entities.News;
import com.jluzh.schoolbbs.entities.User;

public class UserManagerDao extends BaseDao{



	public Object getCount() {
		String hql = "select count(*) from User";
		Object count = getSession().createQuery(hql).uniqueResult();
		return count;
	}

	public List<User> getPageEntity(int beginIndex, int pageSize) {
		String hql = "From User";
		List<User> users = getSession().createQuery(hql).setFirstResult(beginIndex).setMaxResults(pageSize).list();
		return users;
	}

	public void delete(User users) {
		 getSession().delete(users);
	}
	
	public User get(Integer id){
		return (User) getSession().get(User.class,id);
				
	}

	public void saveOrUpdate(User user) {
		getSession().saveOrUpdate(user);
	}

/*	public List<User> findUsers() {
		String hql = "From User";
		List<User> findUsers = getSession().createQuery(hql).list();
		return findUsers;
	}*/
	
}
