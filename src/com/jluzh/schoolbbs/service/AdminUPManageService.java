package com.jluzh.schoolbbs.service;

import java.util.List;

import com.jluzh.schoolbbs.dao.AdminUPManageDao;
import com.jluzh.schoolbbs.entities.Post;


public class AdminUPManageService {
	private AdminUPManageDao adminUPManageDao;
	public void setAdminUPManageDao(AdminUPManageDao adminUPManageDao) {
		this.adminUPManageDao = adminUPManageDao;
	}
	public List<Post> getPageEntity(int beginIndex, int pageSize) {
		
		return adminUPManageDao.getPageEntity(beginIndex,pageSize);
	}
	public Object getCount() {
		return adminUPManageDao.getCount();
	}
	public void delete(Integer id) {
		Post post = adminUPManageDao.get(id);
		if(post != null )
			adminUPManageDao.delete(post);
	}
	

	
	

}
