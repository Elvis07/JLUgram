package com.jluzh.schoolbbs.service;

import java.util.List;

import com.jluzh.schoolbbs.dao.FileDao;
import com.jluzh.schoolbbs.entities.FileRes;

public class FileService {
	private FileDao filedao;

	public void setFiledao(FileDao filedao) {
		this.filedao = filedao;
	}

	public List<FileRes> getFileList(int catalogId, int currentPage, int pageSize)
	{
		return filedao.getFileList(catalogId, currentPage, pageSize);
	}
	
	public int getFileNum(int catalogId)
	{
		return filedao.getFileNum(catalogId);
	}
	
	public void addFileRes(FileRes file) {
		 filedao.addFileRes(file);
	}
	
	public void deleteFileRes(String fileResId){
		filedao.deleteFileRes(fileResId);
	}
	
	public void delFileRes(String filepath){
		filedao.delFileRes(filepath);
	}
	public List<FileRes> getFileList(String catalogId)
	{
		return filedao.FlistByCataId(catalogId);
	}
}
