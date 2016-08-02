<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="http://javacrazyer.iteye.com/tags/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
	$(window).scroll(function() {
		var t = document.documentElement.scrollTop || document.body.scrollTop;
		var backtop_div = document.getElementById("backtotop");
		var search_div1 = document.getElementById("search");
		var search_div = document.getElementById("search_main");
		var search_text = document.getElementById("search_text");
		var search_text1 = document.getElementById("search_text1");
		var fixed_bg = document.getElementById("fixed_bg");
		if (t >= 100) {
			backtop_div.style.visibility = "visible";
			search_div.style.position = "fixed";
			search_div.style.left = "500px";
			search_div.style.top = "0px";
			search_div.style.visibility = "visible";
			fixed_bg.style.visibility = "visible";
			search_text1.value = search_text.value;

		} else {
			backtop_div.style.visibility = "hidden";
			search_div.style.position = "absolute";
			search_div.style.left = "500px";
			search_div.style.visibility = "hidden";
			search_text.value = search_text1.value;
			fixed_bg.style.visibility = "hidden";

		}
	});
</script>
<style type="text/css">
.img {
	width: 25px;
	height: 25px;
	border-radius: 15px;
	float: left;
}
</style>
<title>${request.plate.palteName}-JLUgram Forum</title>
</head>
<body>
	<jsp:include page="/home_head.jsp" />
	<!-- <div class="body">
		<div class="fixed-bg" id="fixed_bg">
		<div id="search_main"
			style="float: left; left: 500px; position: fixed; visibility: hidden; border: 1px red; width: 100%; height: 40px">
			<input type="text" id="search_text1"> <input type="button"
				value="板块搜索"> <input type="button" value="全部搜索"
				onclick="window.location.href='post-search?key='document.getElementById('search_text').value'">
		</div>
	</div> -->

	<div class="contain">


		<div class="middle">

			<s:if test="#session.user!=null">
				<div style="border: 2px;">
					<s:iterator value="#request.posts" var="post">
						<table align="center">
							<tr>
								<td><div style="margin-left: 30px; margin-top: 7px;">
										<img src="images/ff.png">
									</div></td>
								<td><div
										style="margin-left: 200px; margin-top: 6px; width: 350px">
										<a href="post-listbyid?postId=${post.id}" id="titlehref"><strong>${post.title}</strong>
										</a>
									</div></td>
								<td><div style="margin-left: 50px; width: 150px;">
										<font style="line-height: 130%;">${post.user.nickname}<br>
											<s:date format="yyyy-M-dd" name="#post.postTime" /></font>
									</div></td>
								<td><div style="margin-left: 120px; margin-top: 6px;">${post.glanceNum}/
										${post.replyNum}</div></td>
							</tr>
							<hr></hr>
						</table>
					</s:iterator>
					<hr></hr>
				</div>
			</s:if>
		</div>
		<div class="foot1" align="left">
			<p:pager pageSize="10" pageNo="${pages}" url="post-list"
				recordCount="${countTotal}" />
		</div>
		<br>
		<div align="center">
			<strong>快速发帖</strong>
		</div>
		<div class="foot2" align="center">
			<s:form action="post-sent" method="post"
				enctype="multipart/form-data" id="form">
				<input name="plateid" type="hidden" value="${plateid}">
				
				<input name="plateid1" type="hidden" value="${request.plate.id}">
				<s:textfield id="title" name="title" label="帖子标题" />
				<s:textarea name="content" cssStyle="width:500px;height:200px"
					label="帖子内容" />
				<s:file name="upload" label="上传图片" />
				<s:submit value="发表帖子"></s:submit>
				<!-- <input id="submit" type="button" value="发表" /> -->
			</s:form>
		</div>
		<jsp:include page="/home_bottom.jsp" />
	</div>
	<div class="rightbody">

		<ul type="square"
			style="position: fixed; list-style: none; bottom: 200px; right: 0px">
			<li>
			<li><input type="button" align="middle" value="刷新"
				style="margin: 10px" onclick="window.location.reload(true)"></li>
			<!-- 	<li><input type="button" align="middle" value="分享"
				style="margin: 10px"></li> -->
			<li><input type="button" align="middle" value="发帖"
				onclick="document.getElementById('title').focus()"
				style="margin: 10px"></li>
			<li id="backtotop" style="visibility: hidden;"><input
				type="button" align="middle" value="回到&#13;&#10;顶部"
				onclick="window.location.href='#top'" style="margin: 10px"></li>

		</ul>
	</div>
	<div class="clear"></div>
	</div>

</body>

</html>