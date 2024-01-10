<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Form data demo</title>
</head>
<body>
Name: ${formData.name}<br>
Address: ${formData.address}<br>
Phone: ${formData.phone}<br>
<p>
    <sf:form method="POST" modelAttribute="formData">
    Name: <sf:input path="name"/> <sf:errors path="name"/><br>
    Address: <sf:input path="address"/> <sf:errors path="address"/><br>
    Phone: <sf:input path="phone"/> <sf:errors path="phone"/><br>
    <input type=checkbox name="chkRedirect" id="chkRedirect" value="true"/>
    <label for="chkRedirect">Hacer redirect</label><br><br>
    <input type="submit">
    </sf:form>

<p><a href="<c:url value="/"/>">Regresar</a></p>
</body>
</html>
