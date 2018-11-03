<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: taillebourg
  Date: 03/11/18
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<c:choose>
    <c:when test="${empty error}">
        <div>Saisisez vos informations de connexion : </div>
    </c:when>
    <c:otherwise>
        <div>Les informations saisies précédament sont fausses, veuillez recommencez</div>
    </c:otherwise>
</c:choose>


<form name="myForm" action="login" method="post" >
    <fieldset>
        <p>Login : </p>
        <input type="text" id="login" name="login" placeholder="login"/>
        <p>Password : </p>
        <input type="password" id="password" name="password" placeholder="*****"/>
        <input type="submit" >
    </fieldset>
</form>
</body>
</html>
