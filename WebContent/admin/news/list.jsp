<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="w" uri="http://javacrazyer.iteye.com/tags/pager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
			function addNews(){
				window.location.href = "${pageContext.request.contextPath}/NewsManager_input.action";
			}
		</script>
</head>
</head>
<body>
	<div align="center" style="margin-top: 50px;">
	<table border="1" cellpadding="10" cellspacing="0" align="center">
			<tr>
					<td class="ta_01" align="center"  colSpan="10"
						height="26">
						<strong><STRONG>资讯列表</STRONG>
						</strong>
					</td>
				</tr>
			<tr>
				<td width="5%" align="center">序号	</td>
				<td width="25%" align="center">标题</td>
				
				<td  align="center">图片</td>
				<td width="17%" align="center">发表时间</td>
				<td width="17%" align="center">管理员人</td>
				<td width="17%" align="center">删除</td>
				<td width="17%" align="center">编辑</td>
				

			</tr>
			<s:iterator value="#request.newsList" var="nl" status="status">
				<tr>
					<td align="center">${status.count }</td>
					<td align="center">${nl.title}</td>
					
					<td align="center">
						<img width="40" height="45" src="${nl.imgUrl}">
					</td>
					<td align="center">${nl.launchTime }</td>
					
					<td align="center">${nl.admin.adminName }</td>
					
					<td align="center">
						<a href="NewsManager_delete?id=${id }">Delete</a>
						
					</td>
					<td align="center">
						<a href="NewsManager_input?id=${id }">Edit</a>
					</td>
				</tr>
			</s:iterator>
			<tr>
				<td colspan="10" align="right">
					<input type="button" name="add" value="添加"  onclick="addNews()">
					
					
				</td>
				
			</tr>
		</table>
	</div>
	<div align="center" style="margin-bottom: 0px;">
		<w:pager pageSize="4"  pageNo="${pageNo}" url="NewsManager_findAll" recordCount="${totalNum }"/>
	</div>
</body>
</html>