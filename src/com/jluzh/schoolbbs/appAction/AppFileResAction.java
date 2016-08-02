package com.jluzh.schoolbbs.appAction;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.GsonBuilder;
import com.jluzh.schoolbbs.entities.FileRes;
import com.jluzh.schoolbbs.service.FileService;
import com.jluzh.schoolbbs.utils.Page;
import com.jluzh.schoolbbs.utils.ResponseObject;
import com.opensymphony.xwork2.ActionSupport;

public class AppFileResAction extends ActionSupport {

	private FileService fileService;
	private String cataid;
	private String filepath;

	public void setCataid(String cataid) {
		this.cataid = cataid;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public void showlist() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = response.getWriter();
		ResponseObject result = null;

		List<FileRes> fileList = fileService.getFileList(cataid);
		if (fileList != null) {
			result = new ResponseObject(1, fileList);
		} else {
			result = new ResponseObject(0, "目录为空");
		}
		out.print(new GsonBuilder().create().toJson(result));
		out.flush();
		out.close();
	}

	public void delFile() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out;
		out = response.getWriter();

		String path = ServletActionContext.getRequest().getRealPath("/");
		File file = new File(path + filepath);// 根据绝对路径创建一个文件对象
		if (file.exists()) {
			fileService.delFileRes(filepath);
			file.delete();// 删除文件
			out.print("1");// 成功
			out.flush();
			out.close();
		}
	}
}
