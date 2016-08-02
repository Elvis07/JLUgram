package com.jluzh.schoolbbs.service;

import java.util.List;

import com.jluzh.schoolbbs.dao.AdminPPManageDao;
import com.jluzh.schoolbbs.entities.Plate;

public class AdminPPManageService {
	private AdminPPManageDao adminPPManageDao;
	public void setAdminPPManageDao(AdminPPManageDao adminPPManageDao) {
		this.adminPPManageDao = adminPPManageDao;
	}
	public List<Plate> findAll(){
		return adminPPManageDao.findAll();
	}
	public void saveOrUpdate(Plate plate){
		adminPPManageDao.saveOrUpdate(plate);
	}
	public Plate get(Integer id){
		return adminPPManageDao.get(id);
	}
	public void delete(Integer id){
		Plate plate = adminPPManageDao.get(id);
		if(plate != null){
			adminPPManageDao.delete(plate);
		}
	}
	
}
