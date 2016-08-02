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
		<s:fielderror />
		<s:form action="moduserPwd" method="post">
			<s:password label="旧密码" name="pwd1"  />
			<s:password label="新密码" name="pwd2" />
			<s:password label="确认密码" name="pwd3" />
			<s:submit value="修改" />
		</s:form>
	</div>
</body>
</html>