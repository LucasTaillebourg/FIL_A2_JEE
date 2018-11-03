<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.jee.bean.ConstantBean"%>
<html>

<header class="header dark-bg">
	<div class="toggle-nav">
		<div class="icon-reorder tooltips"
			data-original-title="Toggle Navigation" data-placement="bottom">
			<i class="icon_menu"></i>
		</div>
	</div>

	<!--logo start-->
	<a href="index.html" class="logo"><span class="lite">${param.pageName}</span></a>
	<!--logo end-->


	<div class="top-nav notification-row">
		<!-- notificatoin dropdown start-->
		<ul class="nav pull-right top-menu">

			<!-- alert notification start-->
			<jsp:include page="alert-notif-bell.jsp" />
			<!-- alert notification end-->
			<!-- user login dropdown start-->
			<jsp:include page="login-dropdown.jsp" />
			<!-- user login dropdown end -->
			<li><a href="login.html"><i class="icon_key_alt"></i> Deconnexion</a> </li>
		</ul>
		<!-- notificatoin dropdown end-->
	</div>
</header>

</html>