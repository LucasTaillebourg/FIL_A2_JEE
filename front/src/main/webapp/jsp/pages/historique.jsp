<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<jsp:body>
	<script
			src="${pageContext.request.contextPath}/resources/js/chartjs-custom.js"></script>
      <jsp:include page="../components/historique/formulaire.jsp" />
     <jsp:include page="../components/historique/graphique.jsp" />

    </jsp:body>

</t:template>