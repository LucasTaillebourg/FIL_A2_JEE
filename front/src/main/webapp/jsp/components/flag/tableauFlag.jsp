<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading"> Alertes </header>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Gravite</th>
							<th><i class="icon_calendar"></i> Date</th>
							<th><i class="icon_pin_alt"></i> Capteur</th>
							<th>Alerte</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach items="${warnings}" var="warning">
							<tr>
								<td>${warning.alerte.gravite}</td>
								<td>${warning.mesure.dateToString}</td>
								<td>${warning.mesure.sensor.city}-
									${warning.mesure.sensor.id}</td>
								<td>${warning.mesure.nature}${warning.alerte.operator}
									${warning.mesure.value}</td>
							</tr>
						</c:forEach>


					</tbody>
				</table>
			</div>

		</section>
	</div>
</div>