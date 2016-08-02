<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>资料模块</title>
</head>
<body>

	<s:iterator value="#request.catalogs" id="catalog">
		<a href="fileshow?cataId=${catalog.id}&currentPage=1">${catalog.fcDesc}</a>
		<br>
	</s:iterator>
</body>

</html>