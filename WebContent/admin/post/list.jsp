<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="w" uri="http://javacrazyer.iteye.com/tags/pager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
</head>
<body>
	<div align="center" style="margin-top: 50px;">
	<table border="1" cellpadding="10" cellspacing="0" align="center">
			<tr>
					<td class="ta_01" align="center"  colSpan="10"
						height="26">
						<strong><STRONG>帖子列表</STRONG>
						</strong>
					</td>
				</tr>
			<tr>
				<td width="5%" align="center">序号	</td>
				<td width="25%" align="center">标题</td>
				
				<td  align="center">图片</td>
				<td width="17%" align="center">发表时间</td>
				<td width="10%" align="center">访问次数</td>
				<td width="17%" align="center">所属板块</td>
				<td width="5%" align="center">是否热门</td>
				<td width="17%" align="center">发帖人</td>
				<td width="17%" align="center">删除</td>
				
				

			</tr>
			<s:iterator value="#request.postList" var="pl" status="status">
				<tr>
					<td align="center">${status.count }</td>
					<td align="center">${pl.title}</td>
					
					<td align="center">
						<img width="40" height="45" src="${pl.postImage}">
					</td>
					<td align="center">${pl.postTime }</td>
					<td align="center">${pl.glanceNum }</td>
					<td align="center">${pl.plate.palteName }</td>
					<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												<s:if test="#pl.isHot==1">
													是
												</s:if>
												<s:else>
													否
												</s:else>
											</td>
					<td align="center">${pl.user.nickname}</td>
					
					<td align="center">
						<a href="adminUPManage_delete?id=${id }">Delete</a>
						
					</td>
				
				</tr>
			</s:iterator>
	
		</table>
	</div>
	<div align="center" style="margin-bottom: 0px;">
		<w:pager pageSize="4" pageNo="${pageNo}" url="adminUPManage_findAll" recordCount="${totalNum }"/>
	</div>
</body>
</html>