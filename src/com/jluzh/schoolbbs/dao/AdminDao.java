package com.jluzh.schoolbbs.dao;

import java.util.List;

import org.hibernate.Query;

import com.jluzh.schoolbbs.entities.Admin;
import com.jluzh.schoolbbs.entities.News;



public class AdminDao extends BaseDao{
	
	
	
	public Admin login(Admin admin){
		String hql = "From Admin a where a.adminName = ? and a.adminPassword = ?";
		Query query = getSession().createQuery(hql).setString(0, admin.getAdminName()).setString(1, admin.getAdminPassword());
		if(query != null){
			return (Admin) query.uniqueResult();
		}
		return null;
	}

	public List<Admin> findAll() {
		String hql = "From Admin";
		List<Admin> admins = getSession().createQuery(hql).list();
		return admins;
	}
}
