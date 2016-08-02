<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校园资讯</title>
<link rel="stylesheet" href="css/news_style.css" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/news_js.js"></script>
</head>
<body>
	<jsp:include page="/home_head.jsp" />

	<div id="focus_background" style="width: 100%; height: 500px">
		<!-- 轮换版中间大盒子 -->
		<div id="focus_box">
			<!-- 轮换版小焦点图开始 -->
			<ul class="smal_pic">
				<s:iterator value="#request.news8List" var="nl" status="status">
					<li><a href="NewsManager_findNewsDetail?id=${nl.id }"> <img
							class="backImg" src="${nl.imgUrl }" height="43" width="100%"
							alt="" backImg="${nl.imgUrl }" backColor="#FFFFFF" ;/>
					</a></li>


				</s:iterator>
			</ul>

			<!-- 轮换版小焦点图结束 -->
			<!-- 播放图片按钮开始 -->
			<span class="ico"></span>
			<!-- 播放图片按钮结束 -->
			<!-- 标题开始 -->
			<div class="focus_title">
				<s:iterator value="#request.news8List" var="nl" status="status">
					<a href="NewsManager_findNewsDetail?id=${nl.id }"
						style="display: block">${nl.title } </a>

				</s:iterator>
			</div>



		</div>
	</div>
	<!-- 标题结束 -->
	<jsp:include page="/home_bottom.jsp" />
</body>
</html>