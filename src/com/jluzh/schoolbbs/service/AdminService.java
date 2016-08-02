package com.jluzh.schoolbbs.service;

import java.util.List;

import com.jluzh.schoolbbs.dao.AdminDao;
import com.jluzh.schoolbbs.entities.Admin;

public class AdminService {
	private AdminDao adminDao;
	public void setAmdinDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	public Admin login(Admin admin){
		return adminDao.login(admin);
	}

	public List<Admin> findAll() {
		
		return adminDao.findAll();
	}
}
