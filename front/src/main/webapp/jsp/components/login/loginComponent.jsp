<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: taillebourg
  Date: 03/11/18
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<body>



	<form class="login-form" name="myForm" action="login" method="post">

		<div class="login-wrap">

			<p class="login-img">
				<i class="icon_lock_alt"></i>
				<c:choose>
					<c:when test="${empty error}">
						<div>Saisisez vos informations de connexion :</div>
					</c:when>
					<c:otherwise>
						<div>Les informations saisies précédament sont fausses,
							veuillez recommencez</div>
					</c:otherwise>
				</c:choose>
			</p>
			<label for="login">Identifiant (intranet)</label>

			<div class="row">
				<div class="col-lg-9">
					<div class="input-group">
						<span class="input-group-addon"><i class="icon_profile"></i></span>
						<input type="text" id="login" name="login" placeholder="login"
							class="form-control" autofocus>
					</div>
				</div>
				
			</div>

			<label for="password">Mot de passe : </label>
			<div class="input-group">
				<span class="input-group-addon"><i class="icon_key_alt"></i></span>
				<input type="password" id="password" name="password"
					placeholder="*****" class="form-control">
			</div>
			<label class="checkbox"> <input type="checkbox"
				value="remember-me"> Enregitrer l'identifiant <!--<span class="pull-right"> <a href="#"> Forgot Password?</a></span>-->
			</label>
			<button class="btn btn-primary btn-lg btn-block" type="submit">Se
				Connecter</button>

		</div>
	</form>
</body>
</html>
