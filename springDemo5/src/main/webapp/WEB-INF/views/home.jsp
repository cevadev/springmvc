<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Home page</h1>
<p><a href="<c:url value="/qsTest"/>">Param demo</a> |
    <a href="<c:url value="/pathParam/raul"/>">Path param demo</a> |
    <a href="<c:url value="/form"/>">Form demo</a>
</p>
</body>
</html>
