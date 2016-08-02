<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/filetable/table.css">
<link rel="stylesheet" href="css/filetable/uploadButton.css">
<style type="text/css">
.main1{width:800px; margin: 0 auto}
.left1{width: 200px;float: left;background: #ccc}
.right1{width: 600px;float: right;background: #ddd}
</style>
<title>资料模块</title>
</head>
<body>
	<jsp:include page="/WEB-INF/home_head.jsp" />
	<div class="main1">
	<div class="left1"><jsp:include page="/filecatalogue.jsp" /></div>
	<div class="right1"><jsp:include page="/filelist.jsp" /></div>
	</div>
	
</body>

</html>