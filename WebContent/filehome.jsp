<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

<style type="text/css">
.main1 {
	margin: 0 auto
}

.left1 {
	width: 150px;
	height: 300px;
	float: left
}

.right1 {
	width: 1000px;
	height: 300px;
	float: right
}
</style>
<title>JLUgram主页</title>
</head>
<body>
	<jsp:include page="/home_head.jsp" />
	<div class="main1">
		<div class="left1">
			<s:action name="filecatalog" executeResult="true" />
		</div>
		<div class="right1"><jsp:include page="/filelist.jsp" /></div>
	</div>
	

</body>
</html>
