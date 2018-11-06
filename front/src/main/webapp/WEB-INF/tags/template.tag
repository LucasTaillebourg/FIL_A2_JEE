<%@tag description="Overall Page template" pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="projet Jee">
<meta name="author" content="filA2">
<meta name="keyword" content="poop">
<link rel="shortcut icon" href="img/favicon.png">

<title>Veolia - Consultation de capteurs</title>

<!-- Bootstrap CSS -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
		integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
		crossorigin="anonymous">
<!-- font icon -->
<link
	href="${pageContext.request.contextPath}/resources/css/elegant-icons-style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	rel="stylesheet" />
<!-- Custom styles -->

<link
	href="${pageContext.request.contextPath}/resources/css/style-responsive.css"
	rel="stylesheet" />

	<link href="${pageContext.request.contextPath}/resources/css/theme-maison.css"
	rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/form.css"
	rel="stylesheet">


</head>
<header>
	<jsp:include page="../../jsp/components/header/header.jsp">
		<jsp:param name="pageName" value="Page des parametres des alertes" />
	</jsp:include>
</header>

<body>

	<section id="container" class="">
		<jsp:include page="../../jsp/components/header/sidebar.jsp"></jsp:include>
		<section id="main-content">
			<section class="wrapper">
				<jsp:doBody />
			</section>
		</section>
	</section>


	<footer>
		<jsp:include page="../../jsp/components/footer/footer.jsp" />
	</footer>
	<!-- javascripts -->
	


	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<!-- nice scroll -->
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.scrollTo.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.nicescroll.js"
		type="text/javascript"></script>
	<!-- gritter -->

	<!-- custom gritter script for this page only-->
	<script src="${pageContext.request.contextPath}/resources/js/gritter.js"
		type="text/javascript"></script>
	<!--custome script for all page-->
	<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>

	<!--     Graphiques -->
	<script
		src="${pageContext.request.contextPath}/resources/js/chartjs-custom.js"></script>


</body>
</html>