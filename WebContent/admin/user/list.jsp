<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="w" uri="http://javacrazyer.iteye.com/tags/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理页面</title>
<script type="text/javascript">
	function addUser() {
		window.location.href = "${pageContext.request.contextPath}/admin/user/input.jsp";
	}
</script>
</head>
<body>
	<div align="center" style="margin-top: 50px;">
		<s:if test="#request.users == null || #request.users.size() == 0">
		还未有任何用户！
	</s:if>
		<s:else>
			<table border="1" cellpadding="10" cellspacing="0" align="center">
				<tr>
					<td class="ta_01" align="center" colSpan="10" height="26"><strong><STRONG>用户列表</STRONG>
					</strong></td>
				</tr>
				<tr>
					<td width="5%" align="center">序号</td>
					<td width="17%" align="center">账号</td>
					<td width="17%" align="center">密码</td>
					<td width="5%" align="center">性别</td>
					<td width="10%" align="center">用户头像</td>
					<td width="17%" align="center">个人签名</td>
					<td width="15%" align="center">模块版主的权限</td>
					<td width="5%" align="center">Integral</td>
					<td>DELETE</td>
					<td>EDIT</td>

				</tr>
				<s:iterator value="#request.users" status="status" var="user">
					<tr>
						<td align="center">${status.count }</td>
						<td>${userName}</td>
						<td>不给看</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center">
							<s:if test="#user.gender =='男'.toString() || #user.gender =='1'.toString() ">
								男
							</s:if> <s:elseif test="#user.gender =='女'.toString() || #user.gender =='2'.toString() ">
								女
							</s:elseif> <s:else>
								秘密
							</s:else>
						</td>

						<td align="center" width="5%"><img width="40" height="45"
							src="${uerImage}"></td>
						<td>${sign}</td>
						<td style="CURSOR: hand; HEIGHT: 22px" align="center">
							<s:if test="#user.witchModerator==1">
													计算机模块版主
												</s:if> <s:elseif test="#user.witchModerator==2">
													会计系模块版主
												</s:elseif> <s:elseif test="#user.witchModerator==3">
													旅游系模块版主
												</s:elseif> <s:elseif test="#user.witchModerator==0">
													该用户不是版主！
												</s:elseif>
						</td>
						<td>${Integral }</td>
						<td><a href="UserManager_delete?id=${id }">Delete</a></td>
						<td><a href="UserManager_input?id=${id }">Edit</a></td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="10" align="right"><input type="button" name="add"
						value="添加" onclick="addUser()"></td>

				</tr>
			</table>
		</s:else>
	</div>
	<div align="center" style="margin-bottom: 0px;">
		<w:pager pageSize="4" pageNo="${pageNo}" url="UserManager_findAll"
			recordCount="${totalNum }" />
	</div>
</body>
</html>