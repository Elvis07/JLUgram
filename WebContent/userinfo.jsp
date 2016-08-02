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
				src="${user.uerImage}" />
			</span> </br> </br>


			<div class="div1" align="center" style="margin-left: 19px;">
				<div class="div2">选择图片</div>
				<form action="userUpImg" method="post" enctype="multipart/form-data">
					<input type="file" name="upload" class="inputstyle"> <br>

					<div align="center">
						<button type="submit" class="button black">
							<span>上传头像</span>
						</button>
					</div>
				</form>
			</div>
		</div>

		<div class="left2" align="left">
			<s:if test="#session.user.gender =='男'.toString()">
				<img class="gender" src="images/boy.png" />
			</s:if>
			<s:elseif test="#user.gender =='女'.toString()">
				<img class="gender" src="images/girl.png" />
			</s:elseif>
			<s:else>
				<img class="gender" src="images/unknown.png" />
			</s:else>





			<div class="nick">${user.nickname}</div>
			</br> 个性签名:${user.sign} </br> 积分:${user.integral}<br> <a
				href="userCheckIn"><img src="images/checkin.png" align="center" /></a>
		</div>
		<div class="right1">
			<a href="gomodPwd">修改密码</a> <br> <a href="goUpdateInfo">更新资料</a>
			<br> <a href="modifypwd.jsp">查看发帖</a> <br>


		</div>
	</div>
	.
	<jsp:include page="/home_bottom.jsp" />
</body>

</html>