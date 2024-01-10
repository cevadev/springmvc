<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>JDBC Form</h1>

<sf:form method="POST" modelAttribute="person">
    Nombre: <sf:input path="name"/> <sf:errors path="name"/><br>
    Domicilio: <sf:input path="address"/> <sf:errors path="address"/><br>
    Telefono: <sf:input path="phone"/> <sf:errors path="phone"/><br><br>
    <input type="submit">
</sf:form>

<p><a href="<c:url value="/hibernateList"/>">Regresar</a></p>
</body>
</html>
