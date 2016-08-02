<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
	<style type="text/css">
	body {
		background: #6C3928;	
		margin: 0px;
		color: #ffffff;
	}
	a {
		text-decoration:none;
		color: #ffffff;
		font-weight: 900;
	} 
	a:hover {
		text-decoration: underline;
		color: #ffffff;
		font-weight: 900;
	}
</style>
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>

	
		<script type="text/javascript">
		

		d = new dTree('d');

		d.add(0,-1,'BBS后台管理');
		d.add(1,0,'帖子模块管理');
		d.add(2,1,'帖子模块管理','${pageContext.request.contextPath}/adminPPManage_findAll.action','帖子模块管理','mainFrame');
		d.add(3,0,'用户帖子管理');
		d.add(4,3,'用户帖子管理','${pageContext.request.contextPath}/adminUPManage_findAll.action?pageNo=1','用户帖子管理','mainFrame');
		d.add(5,0,'资讯贴管理');
		d.add(6,5,'资讯贴管理','${pageContext.request.contextPath}/NewsManager_findAll.action?pageNo=1','新闻贴管理','mainFrame');
		d.add(7,0,'用户管理');
		d.add(8,7,'用户管理','${pageContext.request.contextPath}/UserManager_findAll.action','用户管理','mainFrame');

		
		document.write(d);
		
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
