<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>

	<jsp:body>
<script>
	$(document).ready(function() {

		var lineChartData = {
			labels: ["12h","12h30","13h","13h30","14h"],
			datasets : [ {
				borderColor : "#857DB1",
				label : "Moyenne",
				data : [ 25, 59, 20, 61, 56]
			}, {
				borderColor : "#3e95cd",
				label : "Min",
				data : [ 8, 4, 0, 1, 9,]
			}, {
				borderColor : "#55AA55",
				label : "Max",
				data : [ 38, 68, 90, 99, 96, ]
			} ]

		};

		new Chart(document.getElementById("hist-graph").getContext("2d"), {
			type : "line",
			data : lineChartData,
			options : {
				title : {
					display : true,
					text : 'Temperature'
				}
			}
		});

	});
</script>
      <jsp:include page="../components/historique/formulaire.jsp" />
     <jsp:include page="../components/historique/graphique.jsp" />

    </jsp:body>

</t:template>