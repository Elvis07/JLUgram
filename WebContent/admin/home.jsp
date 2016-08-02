<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   
  </head>
  
<frameset rows="103,*" frameborder=0 border="0" framespacing="0">
  <frame src="${pageContext.request.contextPath}/admin/top.jsp" name="topFrame" scrolling="NO" noresize>
  <frameset cols="180,*" frameborder="0" border="0" framespacing="0">
		<frame src="${pageContext.request.contextPath}/admin/left.jsp" name="leftFrame" noresize scrolling="YES">
		<frame src="${pageContext.request.contextPath}/admin/welcome.jsp" name="mainFrame">
  </frameset>
</frameset>
</html>
