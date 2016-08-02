<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>

<body>
	<!--  -->
	<form id="userAction_save_do" name="Form1"
		action="${pageContext.request.contextPath}/UserManager_save.action"
		method="post" enctype="multipart/form-data">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="50%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td align="center" height="26"><strong><STRONG>添加u用户</STRONG>
				</strong></td>
			</tr>

			<tr>

				<s:if test="id != null">
					<s:textfield name="userName" label="用户名称"></s:textfield>
					<s:textfield name="password" label="用户密码"></s:textfield>
					<s:hidden name="id"></s:hidden>
				</s:if>
				<s:else>
					<s:textfield name="userName" label="用户名称"></s:textfield>
					<s:textfield name="password" label="用户密码"></s:textfield>
				</s:else>
			</tr>

			<tr>
				<%-- <s:file name="upload" label="图片" colspan="3" value="upload"></s:file> --%>
				<td width="18%" align="center" bgColor="#f5fafe">图片：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><input
					type="file" name="upload" value="upload" /></td>
			</tr>
			<tr>	
			<td>
				<s:select id="gender" name="gender" list="#{'1':'男','2':'女'}" 
 					headerKey="" headerValue="---请选择性别---" label="性别"></s:select>
 			</td>
			<td>
				<s:select id="witchModerator" name="witchModerator" list="#{'0':'不是版主','1':'计算机系','2':'会计系','3':'旅游系'}" 
 					headerKey="" headerValue="---请选择性别---" label="模块权限"></s:select>
 			</td>
					
			<tr>
				<td>
					<s:textfield name="Integral" label="积分"></s:textfield>
				</td>
			</tr>

			<tr>

				<s:textarea label="个性签名" name="sign" cols="30" rows="5" />
			</tr>

			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<button type="submit" value="确定">&#30830;&#23450;</button> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<button type="reset" value="重置">&#37325;&#32622;</button> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					type="button" onclick="history.go(-1)" value="返回" /> <
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>