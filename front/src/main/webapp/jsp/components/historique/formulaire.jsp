
<div class="row">
	<div class="col-lg-12">
		<section class="panel">
			<header class="panel-heading"> Recherche: </header>
			<div class="panel-body">
				<form class="form-horizontal " method="get">
					<div class="form-group col-sm-3">
						<div class="row">
							<label class="control-label">Date Debut</label>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<input type="text" class="form-control">
							</div>
						</div>
					</div>
					<div class="form-group col-sm-3">
						<div class="row">
							<label class="control-label">Date Fin</label>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<input type="text" class="form-control">
							</div>
						</div>
					</div>

					<div class="form-group col-sm-3">
						<div class="row">
							<label class="control-label">Capteurs</label>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<select multiple class="form-control">
									<option>Nantes - 1</option>
									<option>Nantes - 2</option>
									<option>Nantes - 3</option>
									<option>Nantes - 4</option>
									<option>Nantes - 5</option>
								</select>
							</div>

						</div>
					</div>




					<div class="form-group col-sm-4">
						<label class="control-label col-lg-2" for="inputSuccess">Nature</label>
						<div class="col-lg-10">
							<div class="checkbox">
								<label> <input type="checkbox" value="">
									Temperature
								</label>
							</div>
							<div class="checkbox">
								<label> <input type="checkbox" value="">
									Direction du vent
								</label>
							</div>
							<div class="checkbox">
								<label> <input type="checkbox" value="">
									Puissance du vent
								</label>
							</div>
							<div class="checkbox">
								<label> <input type="checkbox" value="">
									Pression
								</label>
							</div>

						</div>
					</div>

					<div class="form-group col-sm-4">
						<label class="control-label col-lg-2" for="inputSuccess">Echelle</label>
						<div class="col-lg-10">

							<select class="form-control m-bot15">
								<option>Minute</option>
								<option>Heure</option>
								<option>Jour</option>
								<option>Mois</option>
								<option>Annee</option>
							</select>
						</div>
					</div>
					<div class="col-lg-offset-2 col-lg-10">
						<button type="submit" class="btn btn-danger">Afficher</button>
					</div>

				</form>
			</div>
		</section>
	</div>
</div>
