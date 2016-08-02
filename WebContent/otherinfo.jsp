<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" href="css/filetable/uploadButton.css">
<style type="text/css">
.main {
	margin: 0 auto
}

.left1 {
	width: 25%;
	height: 300px;
	float: left
}

.left2 {
	width: 50%;
	height: 300px;
	float: left;
}

.right1 {
	width: 25%;
	height: 300px;
	float: right
}

.normalFace {
	width: 183px;
	height: 183px;
	border-radius: 120px;
}

.gender {
	width: 45px;
	height: 45px;
	border-radius: 33px;
	float: left;
}
</style>
<title>个人中心</title>
</head>
<body>
	<jsp:include page="/home_head.jsp" />
	<s:fielderror />
	<div class="main">
		<div class="left1">
			<span class="content1-picture"> <img class="normalFace"
				src="${other.uerImage}" />
			</span> </br> </br>


			
		</div>

		<div class="left2" align="left">
			<s:if test="#request.other.gender =='男'.toString()">
				<img class="gender" src="images/boy.png" />
			</s:if>
			<s:elseif test="#request.other.gender =='女'.toString()">
				<img class="gender" src="images/girl.png" />
			</s:elseif>
			<s:else>
				<img class="gender" src="images/unknown.png" />
			</s:else>

			<div class="nick">${other.nickname}</div>
			</br> 个性签名:${other.sign} </br> 积分:${other.integral}<br> 
			
		</div>
		<div class="right1">
			<a href="#">添加好友</a> <br> <a href="goUpdateInfo">私信</a>
			<br> <a href="#">查看发帖</a> <br>


		</div>
	</div>
	.
	<jsp:include page="/home_bottom.jsp" />
</body>

</html>