<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/login/reset.css">
<link rel="stylesheet" href="css/login/supersized.css">
<link rel="stylesheet" href="css/login/style.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/user.js"></script>
<script src="js/login/supersized.3.2.7.min.js"></script>
<script src="js/login/supersized-init.js"></script>
<script src="js/login/scripts.js"></script>
<title>JLUgram Regist</title>
</head>
<body>
<body>
	<div class="page-container">
		<h1><s:text name="regist" /></h1>


		<form action="userRegist" method="POST">
			<div class="int" id="userText">

				<input type="text" name="username" id="username"
					placeholder=<s:text name="unameHint" /> />

			</div>
			<div class="int">
				<input type="password" name="pwd" id="password"
					placeholder=<s:text name="pwdHint" /> />

			</div>
			<div class="int">
				<input type="text" name="nickVal" id="nickname" placeholder=<s:text name="nickHint" /> />

			</div>

			<button type="submit" style="width: 150px;"><s:text name="signIn" /></button>
			<button type="reset" style="width: 150px;"><s:text name="reset" /></button>
			<s:token />
		</form>
		<div id="registerText"></div>
		<div id="check"></div>
		<div class="connect">
			<p><s:text name="regCue" /></p>
			<p>
				<a class="facebook" href="goindex1"></a>
			</p>
		</div>
	</div>
</body>
</html>