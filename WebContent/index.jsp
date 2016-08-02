<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta property="qc:admins" content="75440423500632460617364173307742237" />

<link rel="stylesheet" href="css/zerogrid.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/responsiveslides.css">
<script src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	// You can also use "$(window).load(function() {"
	$(function() {
		// Slideshow 
		$("#slider").responsiveSlides({
			auto : true,
			pager : false,
			nav : true,
			speed : 500,
			namespace : "callbacks",
			before : function() {
				$('.events').append("<li>before event fired.</li>");
			},
			after : function() {
				$('.events').append("<li>after event fired.</li>");
			}
		});
	});
</script>
<style type="text/css">
li {
	display: inline-block;
	color: gray;
}
</style>


<title>JLUgram</title>
</head>
<body>
	<jsp:include page="/home_head.jsp" />
	<div class="wrap-body">
		<div class="slider">
			<!-- Slideshow -->
			<div class="callbacks_container">
				<ul class="rslides" id="slider">
					<li><img src="images/login/backgrounds/jlu.jpg" alt="">
					<li><img src="images/2.jpg" alt="">
						<p class="caption">This is another caption</p></li>
					<li><img src="images/3.jpg" alt="">
						<p class="caption">The third caption</p></li>
				</ul>
			</div>
		</div>
	</div>
	`
	<jsp:include page="/home_bottom.jsp" />
</body>
</html>
