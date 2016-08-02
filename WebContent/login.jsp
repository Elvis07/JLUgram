<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/login/reset.css">
<link rel="stylesheet" href="css/login/supersized.css">
<link rel="stylesheet" href="css/login/style.css">



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JLUgram Login</title>
</head>
<body>
	<div class="page-container">
		<h1>
			<s:text name="login" />
		</h1>
		<s:fielderror />
		<form action="userLogin" method="post">
			<input type="text" name="username" 
				placeholder=<s:text name="unameHint" />> <input
				type="password" name="pwd"
				placeholder=<s:text name="pwdHint" />>
			<button type="submit">
				<s:text name="login1" />
			</button>
			<div class="error">
				<span>+</span>
			</div>
		</form>
		<div class="connect">
			<p>
				<s:text name="loginCue" />
			</p>
			<p>
				<a class="facebook" href="goreg"></a>
			</p>
		</div>
	</div>

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/login/supersized.3.2.7.min.js"></script>
	<script src="js/login/supersized-init.js"></script>
	<script src="js/login/scripts.js"></script>
</body>
</html>