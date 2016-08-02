package com.jluzh.schoolbbs.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.jluzh.schoolbbs.entities.FileRes;
import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.utils.FileUtil;

public class FileDao extends BaseDao {

	public List<FileRes> getFileList(int catalogId, int currentPage, int pageSize) {
		Query query = getSession().createQuery(
				"from FileRes f LEFT OUTER JOIN FETCH f.user LEFT OUTER JOIN FETCH f.filedCategory where f.filedCategory.id="
						+ catalogId);
		int startrow = (currentPage - 1) * pageSize;
		query.setFirstResult(startrow);
		query.setMaxResults(pageSize);
		List<FileRes> fileList = query.list();
		return fileList;
	}

	public List<FileRes> FlistByCataId(String catalogId) {
		Query query = getSession().createQuery(
				"from FileRes f LEFT OUTER JOIN FETCH f.user LEFT OUTER JOIN FETCH f.filedCategory where f.filedCategory.id="
						+ catalogId);
		List<FileRes> fileList = query.list();
		return fileList;
	}

	public int getFileNum(int catalogId) {
		Query query = getSession().createQuery(
				"from FileRes f LEFT OUTER JOIN FETCH" + " f.filedCategory where f.filedCategory.id=" + catalogId);
		return query.list().size();
	}

	public void deleteFileRes(String fileResId) {
		Query query = getSession().createQuery("delete from FileRes f where f.id=" + fileResId);
		query.executeUpdate();
	}

	public void delFileRes(String filepath) {
		Query query = getSession().createQuery("delete from FileRes f where f.filedPath='" + filepath + "'");
		query.executeUpdate();
	}

	public void addFileRes(FileRes file) {
		getSession().saveOrUpdate(file);
	}

}
