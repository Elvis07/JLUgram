package com.jluzh.schoolbbs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jluzh.schoolbbs.entities.FiledCategory;

import com.jluzh.schoolbbs.entities.Plate;
import com.jluzh.schoolbbs.utils.FileUtil;

public class FileCatalogDao extends BaseDao {

	public List getAllCatalogs() {

		List list = null;
		Query query = getSession().createQuery("from FiledCategory");
		System.out.println(query);
		list = query.list();
		return list;
	}

	public int countCatalogs() {

		List list = null;
		Query query = getSession().createQuery("from FiledCategory");
		System.out.println(query);
		return query.list().size();
	}
}
