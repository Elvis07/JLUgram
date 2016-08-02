package com.jluzh.schoolbbs.dao;

import java.util.List;

import com.jluzh.schoolbbs.entities.Plate;

public class AdminPPManageDao extends BaseDao{
	public List<Plate> findAll(){
		String hql = "FROM Plate ";
		
		List<Plate> list = getSession().createQuery(hql).list();
		return list;
	}
	
	public void saveOrUpdate(Plate plate){
		getSession().saveOrUpdate(plate);
	}
	public Plate get(Integer id){
		return (Plate) getSession().get(Plate.class, id);
	}
	
	public void delete(Plate plate){
		getSession().delete(plate);
	}
}
