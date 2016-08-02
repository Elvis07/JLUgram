<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发帖页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript"
	src="http://localhost/bbs/script/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	 $(function(){$("#submit").click(
			 function () {
		         $.post("post-sent",$("#form").serialize(),function(data)
		         {
		        	 alert("dd");
		        	 
		         })
	}
			 )}
		
	)
	
	</script>
</head>

<body>
    ${plate}
	<s:form action="post-sent" method="post" enctype="multipart/form-data" id="form">
		<s:textfield name="title" label="贴子标题" />
		<s:textarea name="content" cssStyle="width:500px;height:200px"
			label="帖子内容" />
		<s:file name="upload" label="上传图片" />
		<s:submit value="发表2"></s:submit>
		<input id="submit" type="button" value="发表"  />
	</s:form>
	<div></div>
</body>
</html>