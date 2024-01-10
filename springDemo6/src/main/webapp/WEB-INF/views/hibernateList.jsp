<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>JDBC List</h1>

<table align="center" border="1">
    <tr>
        <td>Name</td><td>Address</td><td>Phone</td><td>&nbsp;</td>
    </tr>
    <c:forEach items="${list}" var="person">
        <tr>
            <td><c:out value="${person.name}"/></td>
            <td><c:out value="${person.address}"/></td>
            <td><c:out value="${person.phone}"/></td>
            <td><a href="<c:url value="hibernateDelete/${person.id_person}"/>">[Del]</a></td>
        </tr>
    </c:forEach>
</table>

<p><a href="<c:url value="/hibernateForm"/>">Nuevo registro</a></p>
<p><a href="<c:url value="/"/>">Regresar</a></p>
</body>
</html>
