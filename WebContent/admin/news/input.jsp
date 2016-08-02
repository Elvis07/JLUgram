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
		action="${pageContext.request.contextPath}/NewsManager_save.action"
		method="post" enctype="multipart/form-data">
		&nbsp;
		<table cellSpacing="1" cellPadding="5" width="50%" align="center"
			bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
			<tr>
				<td align="center" height="26"><strong><STRONG>发布资讯</STRONG>
				</strong></td>
			</tr>

			<tr>
				
				<s:if test="id != null">
					<s:textfield name="title" label="资讯名称"></s:textfield>
					<s:hidden name="id"></s:hidden>
				</s:if>
				<s:else>
					<s:textfield name="title" label="资讯名称"></s:textfield>
				</s:else>
			</tr>

			<tr>
				<td width="18%" align="center" bgColor="#f5fafe">图片：</td>
				<td class="ta_01" bgColor="#ffffff" colspan="3"><input
					type="file" name="upload" value="upload"/></td>
			</tr>
			<tr>
				
				<td class="ta_01" bgColor="#ffffff" colspan="3">
				
					<s:select list="#request.admins"
						listKey="id" listValue="adminName" name="admin.id" label="发布人">
					</s:select>	
				</td>
			</tr>
			
			<tr>
				
				<s:textarea label="资讯详情" name="content" cols="30" rows="5"/>
			</tr>
			<tr>
				<td class="ta_01" style="WIDTH: 100%" align="center"
					bgColor="#f5fafe" colSpan="4">
					<button type="submit" value="确定">&#30830;&#23450;</button> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
					<button type="reset" value="重置">&#37325;&#32622;</button> <FONT
					face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT> <INPUT
					type="button" onclick="history.go(-1)" value="返回" /> 
				</td>
			</tr>
		</table>
	</form>
</body>
</HTML>