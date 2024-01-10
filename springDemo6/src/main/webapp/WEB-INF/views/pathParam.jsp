<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>pathParam demo</title>
</head>
<body>
<p>Mostrar informaci&oacute;n de: <c:out value="${name}"/></p>
<p><a href="<c:url value="/"/>">Regresar</a></p>
</body>
</html>
