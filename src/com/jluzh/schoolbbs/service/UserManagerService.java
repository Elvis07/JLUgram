package com.jluzh.schoolbbs.service;

import java.util.List;

import com.jluzh.schoolbbs.dao.UserManagerDao;
import com.jluzh.schoolbbs.entities.News;
import com.jluzh.schoolbbs.entities.User;

public class UserManagerService {
	private UserManagerDao userManagerDao;
	public void setUserManagerDao(UserManagerDao userManagerDao) {
		this.userManagerDao = userManagerDao;
	}

	public Object getCount() {
		return userManagerDao.getCount();
	}

	public List<User> getPageEntity(int beginIndex, int pageSize) {
		return userManagerDao.getPageEntity(beginIndex,pageSize);
	}

	public void delete(Integer id) {
		User users = userManagerDao.get(id);
		if(users != null )
			userManagerDao.delete(users);
	}

	public User get(Integer id) {
		User user = userManagerDao.get(id);
		return user;
	}

	public void saveOrUpdate(User user) {
		userManagerDao.saveOrUpdate(user);
	}

	/*public List<User> findUsers() {
		return userManagerDao.findUsers();
	}*/
}
