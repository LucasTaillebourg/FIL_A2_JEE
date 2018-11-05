<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading"> Alertes </header>
			<div class="table-responsive">
				<table class="table">

					<tr>
						<th class="with-border-bot"><button>Ajouter une
								alerte</button></th>
						<th class="with-border-bot"></th>
						<th class="with-border-bot without-border-left"></th>
						<th class="with-border-bot without-border-left"></th>
						<th class="with-border-bot"><input
							placeholder="Champs recherche"></th>
						<th class="with-border-bot">icone recherche</th>
					</tr>
					<tr>
						<th>Checkbox</th>
						<th>Intitule</th>
						<th>Type de donnees</th>
						<th>Seuil</th>
						<th>Actions</th>
						<th>Gravite</th>
					</tr>
					<c:forEach var="alerte" items="${alertesBeans}">
						<tr>
							<td>Check</td>
							<td>${alerte.intitule}</td>
							<td>${alerte.type}</td>
							<td>${alerte.seuil}</td>
							<td><button>Editer</button> /
								<button>Supprimer</button></td>
							<td>${alerte.gravite}</td>
						</tr>
					</c:forEach>

				</table>
			</div>

		</section>
	</div>
</div>