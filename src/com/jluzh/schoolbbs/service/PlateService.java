package com.jluzh.schoolbbs.service;

import java.util.List;

import com.jluzh.schoolbbs.dao.PlateDao;
import com.jluzh.schoolbbs.entities.Plate;

public class PlateService {
	public PlateDao plateDao;

	public PlateDao getPlateDao() {
		return plateDao;
	}

	public void setPlateDao(PlateDao plateDao) {
		this.plateDao = plateDao;
	}

	// 列出所有板块
	public List<Plate> getAll() {
		return plateDao.getAll();
	}

	public Plate plateById(String id){
		return plateDao.plateById(id);
	}
}
