<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	background: #6C3928;
	margin: 0px;
	color: #ffffff;
}

a {
	text-decoration: none;
	color: #ffffff;
	font-weight: 900;
}

a:hover {
	text-decoration: underline;
	color: #ffffff;
	font-weight: 900;
}
</style>
<link href="${pageContext.request.contextPath}/css/Style.css"
	rel="stylesheet" type="text/css">
</HEAD>
<body>
	<h1 align="center">后台管理中心</h1>

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" valign="bottom">
				<table width="100%" border="0">
					<tr>
						<td width="85%" align="left">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </script> </font>
						</td>
						<td width="15%">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="16"></td>
									<td width="155" valign="bottom">管理员： <font
										color="blue"><s:property
												value="#session.exitAdmin.adminName" /></font>
									</td>

								</tr>
							</table>
						</td>
						<td align="right" width="5%"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</HTML>
