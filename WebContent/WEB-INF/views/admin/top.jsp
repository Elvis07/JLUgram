<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #C14A1B;	
		margin: 0px;
		color: #ffffff;
	}
	a {
		text-decoration:none;
		color: #ffffff;
		font-weight: 900;
	} 
	a:hover {
		text-decoration: underline;
		color: #ffffff;
		font-weight: 900;
	}
</style>
  </head>
  
  <body>
    <h1 align="center">后台管理页面</h1>
    <div class="span10 last">
	<div class="topNav clearfix">
		<ul>
			<s:if test="#session.existAdmin != null">
			<li id="headerLogin"  style="display: list-item;">
				管理员：<s:property value="#session.exisAdmin.adminName"/>
			<li id="headerRegister" class="headerRegister" style="display: list-item;"><a href="${ pageContext.request.contextPath }/adminLogin.jsp">退出</a>|
			</li>
			</s:if>
		</ul>
	</div>
	
</div>

   
  </body>
</html>
