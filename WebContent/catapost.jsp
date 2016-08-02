<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="p" uri="http://javacrazyer.iteye.com/tags/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link charset="utf-8" rel="stylesheet" type="text/css"
	href="css/frame.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<!-- //处理滑动事件 -->

<script type="text/javascript">
$(window).scroll(function(){
		var t = document.documentElement.scrollTop || document.body.scrollTop;
		var backtop_div = document.getElementById("backtotop");
		var search_div1 =  document.getElementById("search");
		var search_div =  document.getElementById("search_main");
		var search_text =  document.getElementById("search_text");
		var search_text1 =  document.getElementById("search_text1");
		var fixed_bg =  document.getElementById("fixed_bg");
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

<!-- //处理异步提交事件 -->
<script type="text/javascript">
	
</script>

<!-- //处理按钮事件 -->
<script type="text/javascript">
	
</script>



<title>用戶主界面</title>
</head>
<body>
	<div class="body">
		<div class="fixed-bg" id="fixed_bg">
			<div id="search_main"
				style="float: left; left: 500px; position: fixed; visibility: hidden; border: 1px red; width: 100%; height: 40px">
				<input type="text" id="search_text1"> <input type="button"
					value="板块搜索"> <input type="button" value="全部搜索"
					onclick="window.location.href='post-search?key='document.getElementById('search_text').value'">
			</div>
		</div>
		<div class="clear"></div>
		<div class="leftbody"></div>
		<div class="contain">
			<div class="top">
				<div id="div_information" style="float: left">
					<a href="post/post.jsp?plateid=${plate}">首页</a> <a
						href="post/post.jsp?plateid=${plate}">发帖</a> <a href="plate-list">返回版块</a>
					<s:if test="#session.user==null">
						<a href="login.jsp">登录</a>
					</s:if>
					<s:else>
               ${sessionScope.user.nickname}
            
				
					</s:else>
				</div>
				<div id="search"
					style="float: left; left: 500px; position: absolute;">
					<input type="text" id="search_text"> <input type="button"
						value="板块搜索"> <input type="button" value="全部搜索"
						onclick="window.location.href='post-search?key='document.getElementById('search_text').value''">
				</div>


			</div>
			<div class="clear"></div>


			<div id="left" class="left"></div>

			<div class="middle">

				<s:if test="#session.user!=null">
					<div style="border: 2px;">
						<s:iterator value="#request.posts" var="post">
							<table align="center" bgcolor="#ffffff" rules="none" border="1"
								onmouseover="setAttribute('bgcolor', '#bbffff')"
								onmouseout="setAttribute('bgcolor', '#ffffff')">

								<%-- <s:hidden>
                          <s:textfield id="postid">${postId}</s:textfield>
                        </s:hidden> --%>
								<tr>

									<td>回复数：${replyNum}</td>
									<td width="300px"><a href="post-listbyid?postId=${postId}"
										style="text-decoration: none;" id="titlehref"
										onmouseover="setAttribute('style', 'text-decoration: underline;');setAttribute('style', 'color:#005888 ;')"
										onmouseout="setAttribute('style', 'text-decoration: none;')">
											<font color="#005888">${title }</font>
									</a></td>
									<td colspan="2">发帖人：${user.username}</td>
								</tr>
								<tr>
									<td></td>
									<td style="font-style: italic;" width="300px">${content}</td>
									<td>最后发帖人<%-- ${postId} --%></td>
									<td>最后回复时间 <%-- ${lastReply.replytime} --%>
									</td>
								</tr>
								<tr>
									<td></td>
									<td colspan="2"><img src='${postImage}' width="100px"
										height="100px"></td>
									<td align="right" valign="bottom"><input type="button"
										onclick="window.location.href='post-delete?postId=${postId}&plateid=${sessionScope.plate}'"
										value="删除"></td>
								</tr>

							</table>
						</s:iterator>
					</div>
				</s:if>
			</div>
			<div class="foot1" align="left">
				<p:pager pageSize="10" pageNo="${pages}" url="post-list"
					recordCount="${countTotal}" />
			</div>
			<div class="foot2" align="center">
				<s:form action="post-sent" method="post"
					enctype="multipart/form-data" id="form">
					<s:textfield id="title" name="title" label="贴子标题" />
					<s:textarea name="content" cssStyle="width:500px;height:200px"
						label="帖子内容" />
					<s:file name="upload" label="上传图片" />
					<s:submit value="发表2"></s:submit>
					<!-- <input id="submit" type="button" value="发表" /> -->
				</s:form>
			</div>

		</div>
		<div class="rightbody">

			<ul type="square"
				style="position: fixed; list-style: none; bottom: 200px; right: 0px">
				<li>
				<li><input type="button" align="middle" value="刷新"
					style="margin: 10px" onclick="window.location.reload(true)"></li>
				<li><input type="button" align="middle" value="分享"
					style="margin: 10px"></li>
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