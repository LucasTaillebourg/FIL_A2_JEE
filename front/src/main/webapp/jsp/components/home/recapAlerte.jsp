
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading"> Alertes </header>
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th></th>
							<th> </th>
							<th> </th>
						
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${alertesThrown}" var="alerte">
							<tr>
							
							<td><i class="icon-bell-l"></i> ${alerte.gravite}</td>
							<td>${alerte.mesure.date}</td>
							<td>${alerte.mesure.nature} ${alerte.operator} ${alerte.mesure.value}</td>
						
						</tr>

						</c:forEach>
					

					</tbody>
				</table>
			</div>

		</section>
	</div>
</div>