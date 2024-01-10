<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Test time</title>
</head>
<body>
test Time.
<c:out value="${curTime}"/>
<p>
  <a href="<c:url value="/"/>">Regresar</a>
</body>
</html>
