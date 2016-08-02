<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${request.news.title }</title>
</head>
<body>
	<jsp:include page="/home_head.jsp" />
	<div style="width: 800px; padding-left: 220px;">
		<h2 align="center">
			<span>${request.news.title }</span>
			<h2>
				<hr></hr>
				<div align="right" style="margin-bottom: 15px">
					<h5>
						<span>发布人:${request.news.admin.adminName }</span>&nbsp;&nbsp;&nbsp;<span>发布时间:
							<s:date format="yyyy-MM-dd hh:mm:ss"
								name="#request.news.launchTime" />
						</span>
					</h5>
				</div>

				<img alt="加载中..." src="${request.news.imgUrl }"
					style="width: 800px; height: 350px">
				<h6>
					<span style="letter-spacing: 1.5px; line-height: 150%; color: gray">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${request.news.content }</span>
				</h6>
				<h1></h1>
	</div><jsp:include page="/home_bottom.jsp" />
</body>
</html>