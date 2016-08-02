<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="http://javacrazyer.iteye.com/tags/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<style type="text/css">
.img {
	width: 85px;
	height: 85px;
	border-radius: 53px;
	float: left;
}
</style>
<title>JLUgram Forum</title>
</head>
<body>
	<jsp:include page="/home_head.jsp" />

	<s:iterator value="#request.plates">
		<table border="1">
			<tr>
				<td><div style="margin-left: 30px;">
						<a href="post-list?plateid=${Id}"> <img class="img"
							src="${plateImage}">
						</a>
					</div></td>
				<td><div style="margin-left: 45px; width: 650px">
						<strong>${palteName}</strong><br> ${plateDesc}
					</div></td>
					<td><div style="margin-left: 159px;"><br>${postsCount}</div></td>
			</tr>

			<hr></hr>
			
		</table>
	</s:iterator>
	<hr></hr>
	<br>
	<br>
	<jsp:include page="/home_bottom.jsp" />
</body>
</html>