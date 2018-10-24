
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>nom : ${employe.nom}</p>

<c:forEach var="empl" items="${employes}">
    <p>${empl}</p>
</c:forEach>

</body>
</html>