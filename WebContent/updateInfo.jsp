<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
	<jsp:include page="/home_head.jsp" />
	<div align="left">
		<s:form action="usermodInfo" method="post">
			<s:select headerKey="" headerValue="请选择性别" name="gender1"
				list="#{'男':'男','女':'女','秘密':'秘密'}" />
			<s:textfield label="昵称" name="nickname1" />
			<s:textfield label="签名" name="sign" />
			<s:submit value="修改" />
			<s:fielderror />
		</s:form>
	</div>
</body>
</html>