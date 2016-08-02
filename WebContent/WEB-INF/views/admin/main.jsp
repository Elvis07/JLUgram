<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
* {
	font-size: 10pt;
}

body {
	text-align: center;
}
.tdLeft{width: 190px;padding:5px;}
.table {
	width: 1200px;
	height: 100%;
	border: 1px solid #15B69A;
	border-collapse: collapse;
}

.table td {
	border: 1px solid #15B69A;
}

.trTop {
	
}

.tdTop {
	text-align: center;
	height: 100px;
}



.tdBody {
	border-top-width: 0px;
}

iframe {
	width: 100%;
	height: 100%;
}
</style>
</head>
  
  <body>
    <table class="table" align="center">
	<tr  class="trTop">
		<td colspan="2" class="tdTop">
			<iframe frameborder="0" src="forword-top.action"></iframe>
		</td>
	</tr>

	<tr>

		<td class="tdLeft" rowspan="2"> 
			<iframe frameborder="0" src="forword-left.action" name="left"></iframe>
		</td>
		<td style="border-top-width: 0px;">
			<iframe frameborder="0" src="forword-body.action"  name="body"></iframe>
		</td>
	</tr>
	</table>
  </body>
</html>
