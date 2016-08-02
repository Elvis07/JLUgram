<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
	function checkForm() {
		// 校验用户名:
		// 获得用户名文本框的值:
		var username = document.getElementById("userName").value;
		if (username == null || username == '') {
			alert("用户名不能为空!");
			return false;
		}
		// 校验密码:
		// 获得密码框的值:
		var password = document.getElementById("password").value;
		if (password == null || password == '') {
			alert("密码不能为空!");
			return false;
		}
		// 校验确认密码:
		var repassword = document.getElementById("repassword").value;
		if (repassword != password) {
			alert("两次密码输入不一致!");
			return false;
		}
	}
	$(function() {
		$(":input[name=userName]").change(function() {

			var val = $(this).val();
			val = $.trim(val);
			var $this = $(this);

			if (val != "") {
				//把当前节点后面的所有font兄弟节点删除
				$this.nextAll("font").remove();

				var url = "user_validateUserName";
				var args = {
					"userName" : val,
					"time" : new Date()
				};
				$.post(url, args, function(data) {

					
					if (data == "1") {
						$this.after("<font color='green'>用户名可用</font>");
					} else if (data == "0") {
						$this.after("<font color='red'>用户名不可用</font>");

					} else {
						alert("服务器错误！")

					}
				});
			} else {
				alert("userName不能为空");
				this.focus();
			}
		});
	})
</script>
</head>
<body>
	<h1 align="center">欢迎注册</h1>
	
	<form id="registerForm"
		action="${ pageContext.request.contextPath }/user-regist.action"
		method="post" onsubmit="return checkForm();">
		<table align="center">
			<tbody>
				<tr>
					<th align="right"><span class="requiredField">*</span>用户名:</th>
					<td><input type="text" id="userName" name="userName"
						class="text" maxlength="20" onblur="checkUsername()" /> <span
						id="span1"></span></td>
				</tr>
				<tr>
					<th align="right"><span class="requiredField">*</span>密&nbsp;&nbsp;码:
					</th>
					<td><input type="password" id="password" name="password"
						class="text" maxlength="20"  />
						 <span><s:fielderror fieldName="password"/></span>
					</td>
				</tr>
				<tr>
					<th align="right"><span class="requiredField">*</span>确认密码:</th>
					<td><input id="repassword" type="password" name="repassword"
						class="text" maxlength="20"  />
					</td>
				</tr>

				<tr>
					<th align="right">电话:</th>
					<td><input type="text" name="phone" class="text" />
						<span><s:fielderror fieldName="phone" /></span>
					</td>
				</tr>


				<tr>
					<th>&nbsp;</th>
					<td><input type="submit" class="submit" value="注册"></td>
				</tr>


			</tbody>
		</table>


	</form>
</body>
</html>