<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body class="body-margin">
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/tableauParamAlerte.css">

<!-- TODO foutre du ajax + transformer un datatable-->
<table class="pure-table">
    <tr>
        <th class="with-border-bot"><button>Ajouter une alerte</button></th>
        <th class="with-border-bot"></th>
        <th class="with-border-bot without-border-left"></th>
        <th class="with-border-bot without-border-left"></th>
        <th class="with-border-bot"><input placeholder="Champs recherche" ></th>
        <th class="with-border-bot">icone recherche</th>
    </tr>
    <tr>
        <th>Checkbox</th>
        <th>Intitulé</th>
        <th>Type de données</th>
        <th>Seuil</th>
        <th>Actions</th>
        <th>Gravité</th>
    </tr>
    <c:forEach var="alerte" items="${alertesBeans}">
        <tr>
            <td>Check</td>
            <td>${alerte.intitule}</td>
            <td>${alerte.type}</td>
            <td>${alerte.seuil}</td>
            <td><button>Editer</button> / <button>Supprimer</button></td>
            <td>${alerte.gravite}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>