<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta property="qc:admins" content="75440423500632460617364173307742237" />
<link rel="stylesheet" href="css/zerogrid.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/menu.css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>



<script type="text/javascript">
	function toFilePage() {

		var user = "${user}";
		if ("" == user) {
			alert("你尚未登录！！");
		} else {
			location.href = "goindex3";
		}
	}
	function toUserInfo() {

		var user = "${user}";
		if ("" == user) {
			alert("你尚未登录！！");
		} else {
			location.href = "showuserInfo";
		}
	}
</script>

<script src="js/jquery-1.9.1.min.js"></script>

<style type="text/css">
li {
	display: inline-block;
	color: gray;
}
</style>

<title>JLUgram主页</title>
</head>
<body>
	<div class="wrap-body">

		<!--////////////////////////////////////Header-->
		<header>
			<div class="zerogrid">
				<div class="wrap-header">
					<div class="row">
						<div class="col-1-3">
							<div class="wrap-col">
								<div class="logo">
									<h1 href="#">JLUgram</h1>
								</div>
							</div>
						</div>
						<div class="col-1-3 offset-1-3">
							<div>
								<ul align="right">
									<select name="pageselect"
										onchange="self.location.href=options[selectedIndex].value">
										<OPTION><s:text name="language" /></OPTION>
										<OPTION value="i18n11?request_locale=zh_CN"><s:text
												name="china" /></OPTION>
										<OPTION value="i18n11?request_locale=en_US"><s:text
												name="america" /></OPTION>
									</select>
									<s:if test="#session.user!=null">

										<li>${user.nickname}&nbsp;<s:text name="welcome" />&nbsp;&nbsp;
										</li>
										<li><a href="userCancel"><s:text name="cancel" /></a></li>
									</s:if>
									<s:else>
										<li><a href="gologin"><s:text name="login" /></a></li>
										<li><a href="goreg"><s:text name="regist" /></a></li>
										<li><a href="userq1"><img
												src="images/Connect_logo_3.png"></a></li>
									</s:else>
								</ul>
							</div>
							<div class="wrap-col">
								<form method="get" action="/search" id="search" class="f-right">
									<input name="q" type="text" size="40" placeholder="Search..." />
								</form>
							</div>
						</div>
					</div>
				</div>
				<nav id="menu-wrap">
					<div id="menu-trigger">Menu</div>
					<ul id="menu" style="display: none;">
						<li><a href="NewsManager_find8News"><s:text name="index1" /></a></li>
						<li><a href="plate-list"><s:text name="index2" /></a></li>
						<li><a href="#" onclick="toFilePage()"><s:text
									name="index3" /></a></li>
						<li><a href="#" onclick="toUserInfo()"><s:text
									name="index4" /></a></li>
					</ul>
				</nav>