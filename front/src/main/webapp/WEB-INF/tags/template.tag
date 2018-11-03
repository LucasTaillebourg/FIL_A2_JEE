<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="Creative - Bootstrap 3 Responsive Admin Template">
<meta name="author" content="GeeksLabs">
<meta name="keyword"
	content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
<link rel="shortcut icon" href="img/favicon.png">

<title>Elements | Creative - Bootstrap 3 Responsive Admin
	Template</title>

<!-- Bootstrap CSS -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<!-- bootstrap theme -->
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.css"
	rel="stylesheet">
<!--external css-->
<!-- font icon -->
<link
	href="<%=request.getContextPath()%>/resources/css/elegant-icons-style.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css"
	rel="stylesheet" />
<!-- Custom styles -->
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/style-responsive.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/sass_compiled/home.css" />



</head>

<body>
	<section id="container" class="">
		
			<jsp:invoke fragment="header" />
		
			<jsp:doBody />
	
			<jsp:invoke fragment="footer" />
	
	</section>
	<!-- javascripts -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<!-- nice scroll -->
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.scrollTo.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<!-- gritter -->

	<!-- custom gritter script for this page only-->
	<script src="<%=request.getContextPath()%>/resources/js/gritter.js"
		type="text/javascript"></script>
	<!--custome script for all page-->
	<script src="<%=request.getContextPath()%>/resources/js/scripts.js"></script>
</body>
</html>