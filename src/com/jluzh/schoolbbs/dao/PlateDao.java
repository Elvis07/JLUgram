package com.jluzh.schoolbbs.dao;

import java.util.List;

import com.jluzh.schoolbbs.entities.Plate;

public class PlateDao extends BaseDao {

	@SuppressWarnings("unchecked")
	public List<Plate> getAll() {
		String hql = "from Plate";
		return getSession().createQuery(hql).list();
	}

	public Plate plateById(String id) {
		String hql = "from Plate where id=" + id;
		return (Plate) getSession().createQuery(hql).uniqueResult();
	}
}
