<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.img {
	width: 115px;
	height: 115px;
	border-radius: 73px;
	float: left;
}
</style>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script>
	$(window).scroll(function() {
		var t = document.documentElement.scrollTop || document.body.scrollTop;
		var backtop_div = document.getElementById("backtotop");
		var fixed_bg = document.getElementById("fixed-bg");
		if (t >= 100) {
			backtop_div.style.visibility = "visible";
			fixed_bg.style.visibility = "visible";
		} else {
			backtop_div.style.visibility = "hidden";
			fixed_bg.style.visibility = "hidden";
		}
	});
</script>
<title>${requestScope.post.title}</title>
<script type="text/javascript">
	function focus() {
		document.getElementById('content').focus();
	}
</script>

</head>
<body>
	<jsp:include page="/home_head.jsp" />

	<div class="楼主">
		<hr></hr>
		<table>
			<tr>
				<td style="width: 150px"><font style="line-height: 80%;">
						<div align="center">${requestScope.post.user.nickname}</div> <br>
				</font>
					<div style="margin-left: 17px">
						<img src="${requestScope.post.user.uerImage}" class="img">
					</div></td>

				<div>
					<td>
						<div style="background-color: #505252;width: 1050px;">
							<font style="color: white;">&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.post.title}
							</font>
						</div>
						<div align="right">${requestScope.post.postTime}</div>
				</div>
				${requestScope.post.content}
				<br>
				<img src="${requestScope.post.postImage}">
				</td>
				</div>
			</tr>
		</table>
		<br>

	</div>

	<s:iterator value="#request.replysid" var="reply">
		<table>
			<tr>
				<td><div style="margin-left: 17px">
						<a href="userOther?message=${reply.user.id}"> <img src="${reply.user.uerImage}"
							class="img" width="100px" height="100px"></a>
					</div> <br>
					<div align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${reply.user.nickname}</div></td>
				<td><div style="margin-left: 940px">
						<s:date format="yyyy-M-dd hh:mm:ss" name="#reply.replayTime" />
					</div>

					<div style="margin-left: 17px">${reply.content}</div></td>
			</tr>
			<hr>
		</table>
	</s:iterator>

	<hr>
	<div class="foot2" align="center">
		<s:form action="reply-save" method="post"
			enctype="multipart/form-data" id="form">
			<input type="hidden" value="${post.id}" name="postId">
			<s:textarea name="content" cssStyle="width:500px;height:200px"
				label="回复" id="content" />
			<%-- <s:file name="upload" label="上传图片" /> --%>
			<s:submit value="发表回复"></s:submit>
			<!-- <input id="submit" type="button" value="回复" /> -->
		</s:form>

	</div>
	<jsp:include page="/home_bottom.jsp" />
	<br>
	<div class="rightbody">

		<ul type="square"
			style="position: fixed; list-style: none; bottom: 200px; right: 50px">
			<li>
			<li><input type="button" align="middle" value="刷新"
				style="margin: 10px" onclick="window.location.reload(true)"></li>

			<li><input type="button" align="middle" value="回复"
				onclick="document.getElementById('content').focus()"
				style="margin: 10px"></li>
			<li id="backtotop" style="visibility: hidden;"><input
				type="button" align="middle" value="回到&#13;&#10;顶部"
				onclick="window.location.href='#top'" style="margin: 10px"></li>

		</ul>
	</div>
</body>
</html>