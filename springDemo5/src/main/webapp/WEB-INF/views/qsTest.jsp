<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>QueryStringParamTest</title>
</head>
<body>
<p>param1 = <c:out value="${param1}"/></p>
<p>param2 = <c:out value="${param2}"/></p>

<p><a href="<c:url value="/qsTest"><c:param name="param1" value="1"/></c:url>">1 param</a></p>

<form method="POST">
    <input type="text" name="param2"><br>
    <input type="submit" value="Enviar">
</form>

<p><a href="<c:url value="/"/>">Regresar</a></p>
</body>
</html>
