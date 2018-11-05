<%@tag description="Overall Page template" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description"
          content="projet Jee">
    <meta name="author" content="filA2">
    <meta name="keyword"
          content="poop">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Veolia - Consultation de capteurs</title>

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
            rel="stylesheet"/>
    <link
            href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css"
            rel="stylesheet"/>
    <!-- Custom styles -->
    <link href="<%=request.getContextPath()%>/resources/css/style.css"
          rel="stylesheet">
    <link
            href="<%=request.getContextPath()%>/resources/css/style-responsive.css"
            rel="stylesheet"/>
    <link rel="stylesheet"
          href="<%=request.getContextPath()%>/resources/sass_compiled/home.css"/>


</head>
<header>
    <jsp:include page="../../jsp/components/header/header.jsp">
        <jsp:param name="pageName" value="Page des parametres des alertes"/>
    </jsp:include>
</header>

<body>

    <section id="container" class="">
        <jsp:include page="../../jsp/components/header/sidebar.jsp"></jsp:include>
        <section id="main-content">
            <section class="wrapper">
                <jsp:doBody/>
            </section>
        </section>
    </section>


    <footer>
        <jsp:include page="../../jsp/components/footer/footer.jsp"/>
    </footer>
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