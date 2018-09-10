<%--
  Created by IntelliJ IDEA.
  User: 805524
  Date: 08.02.2018
  Time: 17:14
  To change this template use File | Settings | File Templates.



--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>My spring test</title>
</head>
<br>
str = ${str} <br/>
<table border="1">
    <tr>
        <th>Идентификатор</th>
        <th>Имя</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
