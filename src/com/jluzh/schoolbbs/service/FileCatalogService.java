package com.jluzh.schoolbbs.service;

import java.util.List;

import com.jluzh.schoolbbs.dao.FileCatalogDao;

public class FileCatalogService {
	private FileCatalogDao fileCatalogDao;

	public void setFileCatalogDao(FileCatalogDao fileCatalogDao) {
		this.fileCatalogDao = fileCatalogDao;
	};

	public List getAllFileCatalogs() {
		return fileCatalogDao.getAllCatalogs();

	}

	public int countCatalogs() {
		return fileCatalogDao.countCatalogs();

	}
}
