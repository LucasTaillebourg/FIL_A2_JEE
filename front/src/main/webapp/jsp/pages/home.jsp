<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:attribute name="header" >
     <jsp:include page="../components/header/header.jsp">
     		<jsp:param name="pageName" value="Page des paramêtres des alertes" />
    </jsp:include> 
      </jsp:attribute>

	<jsp:attribute name="footer">
     <jsp:include page="../components/footer/footer.jsp" />
    </jsp:attribute>
	<jsp:body>
        <jsp:include page="../components/home/mapCapteur.jsp" />
    </jsp:body>
</t:template>


