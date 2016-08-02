<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JLUgram主页</title>

<link rel="stylesheet" href="css/filetable/uploadButton.css">
<link rel="stylesheet" href="css/filetable/table2.css">
</head>
<body>
	<s:fielderror />
	<s:if test="#request.cataid">


		<div class="div1" align="right">
			<div class="div2" align="right">选择文件</div>
			<form action="uploadfile" method="post" enctype="multipart/form-data">
				<input type="file" name="upload" class="inputstyle"> <input
					type="hidden" name="cataId" value="${request.cataid}"> <br>
				<div align="center">
					<button type="submit" class="button gray">上传文件</button>
				</div>
			</form>
		</div>

		<br>
		<br>
		<br>
		<s:if test="#request.page.totalSize !=0">
			<div class="tab_all" id="tab">
				<table cellspacing="0" id="mytable" width="99%" class="tab_main">
					<tr height="27px;" class="tab_title">
						<th width="17%">文件名</th>
						<th width="17%">文件大小</th>
						<th width="13%">上传者</th>
						<th width="16%">上传时间</th>
						<th width="22%">操作</th>
					</tr>
					<s:iterator value="#request.filelist" var="filelists">
						<tr height="27px;" class="tab_list">
							<td align="center">${filelists.filedName}</td>
							<td align="center">${filelists.filedSize}</td>
							<td align="center">${filelists.user.nickname}</td>
							<td align="center"><s:date format="yyyy-MM-dd hh:mm:ss"
									name="#filelists.upTime" /></td>
							<td align="center"><a
								href="downloadfile?inputPath=/${filelists.filedPath}&downFileName=${filelists.filedName}&contentType=${filelists.filetype}">Download</a>&nbsp;
								<s:if test="#session.user.userName eq(#filelists.user.userName)">
									<a
										href="deletefile?delId=${filelists.id}&delpath=${filelists.filedPath}&cataId=${request.cataid}">Delete</a>
								</s:if></td>  
						</tr>
					</s:iterator>
					<br>
					<div align="center">
						${page.currentPage}&nbsp;&nbsp;of&nbsp;&nbsp;${page.totalPage}</div>
					<br>
				</table>
				<br>
				<div align="center">
					<s:set name="pa" value="#request.page" />
					<s:if test="#pa.hasFirst">
						<a class="button black small"
							href="fileshow?cataId=${request.cataid}&currentPage=1"><span>first</span></a>
					</s:if>
					<s:if test="#pa.hasPrevious">
						<a class="button black small"
							href="fileshow?cataId=${request.cataid}&currentPage=<s:property value="#pa.currentPage-1"/> "><span>previous</span></a>
					</s:if>
					<s:if test="#pa.hasNext">
						<a class="button black small"
							href="fileshow?cataId=${request.cataid}&currentPage=<s:property value="#pa.currentPage+1"/> "><span>next</span></a>
					</s:if>
					<s:if test="#pa.hasLast">
						<a class="button black small"
							href="fileshow?cataId=${request.cataid}&currentPage=${page.totalPage}"><span>last</span></a>
					</s:if>
				</div>
			</div>
		</s:if>
		<s:else><br><div align="center">没有资源</div></s:else>
	</s:if>
</body>
</html>