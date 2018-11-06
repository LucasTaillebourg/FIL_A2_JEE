<%@page contentType="text/html" pageEncoding="UTF-8"%>
<li id="alert_notificatoin_bar" class="dropdown"><a
	data-toggle="dropdown" class="dropdown-toggle" href="#"> <i
		class="icon-bell-l"></i> <span class="badge bg-important">7</span>
</a>
	<ul class="dropdown-menu extended notification">
		<div class="notify-arrow notify-arrow-blue"></div>
		<li>
			<p class="blue">Alertes depuis la dernière connexion</p>
		</li>
		<c:forEach items="${warnings}" var="warning">
			<li><a href="#"> <span class="label label-warning"><i
						class="icon_pin"></i></span> ${warning.mesure.sensor.city}-${warning.mesure.sensor.id} ${warning.mesure.nature}${warning.alerte.operator}${warning.mesure.value}<span
					class="small italic pull-right">${warning.mesure.dateDiff}</span>
			</li>
		</c:forEach>




		<li><a href="#">See all notifications</a></li>
	</ul></li>