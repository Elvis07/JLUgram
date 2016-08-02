<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加模块页面</title>
</head>
<body>
	<h2 align="center">添加模块界面</h2>
	<s:form action="adminPPManage_save" method="post" >
		<table align="center">
			
			<s:if test="id != null">
				<s:textfield name="palteName" label="模块名" disabled="true"></s:textfield>
				<s:hidden name="id"></s:hidden>
				
			</s:if>	
			<s:else>
				<s:textfield name="palteName" label="模块名"></s:textfield>
			</s:else>
			<s:textarea label="模块详情" name="plateDesc" cols="30" rows="5"/>
			
			<s:submit ></s:submit>
		</table>
	</s:form>
</body>
</html>