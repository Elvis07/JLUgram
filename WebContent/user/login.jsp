<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://localhost/bbs/script/jquery-1.9.1.min.js"></script>
<!--异步提交登录表单  -->
<script type="text/javascript">
	$(function() {
		var username = $("#username");
		var password = $("#password").val();
		//检查用户名
		$("#username").change(function() {
			var val = $(this).val();
			val = $.trim(val);
			var $this = $(this);
			if (val != "" || password != "") {
				var args = {
					"username" : val,
					"password" : password
				};
				$this.nextAll("font").remove();
				$.post("user-validateusername", args, function(data) {
					if (data == "1") {
						$this.after("<font color='green'>用户名存在!</font>");
					} else if (data == "0") {
						$this.after("<font color='red'>用户名不存在!</font>");
					}
					//服务器错误
					else {
						alert("服务器错误");
					}
				})
			} else {
				alert("用户名或密码不能为空");
				$(this).val("");
				$this.focus();
			}
		})
     //是否成功登录
         $("#login").click(function () {
        	 $.post("user-login", $("#form_login").serialize(), function(data) {
  
        		   if(data=="1")
        		 {
        			window.location.href="plate-list";
        		 }
        		   if(data=="0")
          		 {
          			alert("用户名或者密码错误!");
          		 }
        	 })
		})
     
		
	})
</script>



<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<s:form action="user-login" method="post" id="form_login">
			<s:textfield name="username" label="用户名" id="username"></s:textfield>
			<s:password name="password" label="密码" id="password" ></s:password>
			
		</s:form>
		<input id="login" name="login" type="button" value="登录">
	</div>
</body>
</html>