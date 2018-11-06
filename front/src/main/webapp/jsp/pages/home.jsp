<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<jsp:body>
 <jsp:include page="../components/home/recapAlerte.jsp" />
        <jsp:include page="../components/home/mapCapteur.jsp" />
        <jsp:include page="../components/home/graph.jsp" />

    </jsp:body>
</t:template>
