<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帖子模块管理页面</title>
<script type="text/javascript">
			function addPlate(){
				window.location.href = "${pageContext.request.contextPath}/admin/plate/input.jsp";
			}
		</script>
</head>
<body >
	<s:if test="#request.plateList == null || #request.plateList.size() == 0">
		还未创造任何模块
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0" align="center">
			<tr>
					<td class="ta_01" align="center"  colSpan="10"
						height="26">
						<strong><STRONG>模块列表</STRONG>
						</strong>
					</td>
				</tr>
			<tr>
				<td>序号</td>
				<td>模块名</td>
				<td>模块详情</td>
				<td>DELETE</td>
				<td>EDIT</td>

			</tr>
			<s:iterator value="#request.plateList" status="status">
				<tr>
					<td align="center">${status.count }</td>
					<td>${palteName}</td>
					<td>${plateDesc }</td>
					
					<td>
						<a href="adminPPManage_delete?id=${id }">Delete</a>
						
					</td>
					<td>
						<a href="adminPPManage_input?id=${id }">Edit</a>
					</td>
				</tr>
			</s:iterator>
			<tr>
				<td colspan="6" align="right">
					<input type="button" name="add" value="添加"  onclick="addPlate()">
					
					
				</td>
				
			</tr>
		</table>
	</s:else>
</body>
</html>