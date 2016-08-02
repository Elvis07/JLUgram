<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'success.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table border="2" bordercolor="#00ff00">
		<tr>
			<td>${requestScope.title }</td>
		</tr>
		<tr>
			<td style="font-style: italic;">${requestScope.text}</td>
		</tr>
		<tr>
			<td><img src='upload/<s:property value="uploadFileName"/>'
				width="100px" height="100px"></td>
		</tr>
		<tr>
			<td align="right"><input type="button" value="评论"> <input
				type="button" value="赞">
	   </td>
	   </tr>
	   <tr><td></td></tr>
	   <tr><td>${sessionScope.comment}</td></tr>
	   </table>
			
</body>
</html>
