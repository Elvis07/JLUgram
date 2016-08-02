package com.jluzh.schoolbbs.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.jluzh.schoolbbs.entities.FileRes;
import com.jluzh.schoolbbs.entities.FiledCategory;
import com.jluzh.schoolbbs.entities.User;
import com.jluzh.schoolbbs.service.FileService;
import com.jluzh.schoolbbs.utils.FileUtil;
import com.jluzh.schoolbbs.utils.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FileAction extends ActionSupport implements ModelDriven<FileRes>, RequestAware {
	private static final long serialVersionUID = 1L;
	private FileService fileService;
	private String delpath;
	private String delId;

	private String uploadFileName;
	private String savePath;
	private File upload;
	private String uploadContentType;
	private int cataId;
	private int currentPage = 1;

	private String inputPath;
	private String contentType;
	private String downFileName;
	private String contentLength;

	public String getContentLength() {
		return contentLength;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	public void setDelId(String delId) {
		this.delId = delId;
	}

	public void setDelpath(String delpath) {
		this.delpath = delpath;
	}

	public void setInputPath(String inputPath) throws Exception {

		this.inputPath = new String(inputPath.getBytes("iso-8859-1"), "utf-8");
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setDownFileName(String downFileName) throws Exception {

		this.downFileName = downFileName;
	}

	public String getDownFileName() {
		String downName = downFileName;

		try {
			downName = new String(downName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return downName;

	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}

	private String getSavePath() throws Exception {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setCataId(int cataId) {
		this.cataId = cataId;
	}

	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public String showFileList() {

		int totalSize = fileService.getFileNum(cataId);
		Page page = new Page(currentPage, totalSize);
		List<FileRes> FileList = fileService.getFileList(cataId, currentPage, page.getPageSize());
		request.put("cataid", cataId);
		request.put("filelist", FileList);
		request.put("page", page);
		return "fileok";
	}

	public InputStream getTargetFile() throws Exception {
		return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
	}

	public String delFileRes() {

		FiledCategory fileCatagory = new FiledCategory();
		fileCatagory.setId(cataId);
		
		fileService.deleteFileRes(delId);
		String path = ServletActionContext.getRequest().getRealPath("/");
		File file = new File(path + delpath);// 根据绝对路径创建一个文件对象
		boolean a = file.exists();
		if (file.exists()) {
			file.delete();// 删除文件
		}

		return SUCCESS;
	}

	public String uploadFile() throws Exception {

		if (uploadFileName != null) {
			String newname = UUID.randomUUID() + uploadFileName.substring(uploadFileName.lastIndexOf("."));
			// 以服务器的文件保存地址和随机文件名建立上传文件输出流

			FiledCategory fileCatagory = new FiledCategory();
			fileCatagory.setId(cataId);

			Date date = new Date();

			FileOutputStream fos = new FileOutputStream(getSavePath() + "\\" + newname);
			FileInputStream fis = new FileInputStream(getUpload());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}

			fis.close();
			fos.close();

			fileres.setUser((User) ActionContext.getContext().getSession().get("user"));
			fileres.setFiledName(uploadFileName);
			fileres.setFiledPath("fileres/" + newname);
			fileres.setUpTime(date);
			fileres.setFiletype(uploadContentType);
			fileres.setFiledSize(FileUtil.bytes2kb((long) upload.length()));
			fileres.setFiledCategory(fileCatagory);
			fileService.addFileRes(fileres);
		}
		return "upFileOK";

	}


	FileRes fileres = new FileRes();

	@Override
	public FileRes getModel() {
		return fileres;
	}

	Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		request = arg0;
	}

}
