<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Login Page</title>
</head>
<body>
	<h1 align="center">管理员登录</h1>
	<center><s:actionerror/></center>
	<form action="admin_login" method="post">
		<table align="center">
			<tbody>
			<tr>
				<th align="left">
					登录名
				</th>
				<td>
					<input type="text"  name="adminName"/>
					
				</td>
			</tr>
			<tr>
				<th align="left">
					密&nbsp;&nbsp;&nbsp;码
				</th>
				<td>
					<input type="password"  name="adminPassword"/>
					
				</td>
			</tr>
			<tr>
				<th>&nbsp;
					
				</th>
				<td>
					<input type="submit" class="submit" value="登录">
				</td>
			</tr>
			</tbody>
		</table>
	</form>
</body>
</html>