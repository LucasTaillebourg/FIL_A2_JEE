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
	<a href="<%=request.getContextPath()%>/home" class="logo"><span class="lite">${param.pageName}</span></a>
	<!--logo end-->


	<div class="top-nav notification-row">
		<!-- notificatoin dropdown start-->
		<ul class="nav pull-right top-menu">

	
			<!-- user login dropdown end -->
			<li><a href="<%=request.getContextPath()%>/logout"> Retour a l'intranet</a> </li>
		</ul>
		<!-- notificatoin dropdown end-->
	</div>
</header>

</html>