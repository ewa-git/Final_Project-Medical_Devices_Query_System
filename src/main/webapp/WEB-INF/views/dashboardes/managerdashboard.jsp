<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 23.09.2020
  Time: 07:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>działa</h1>
${userLogin}

<form action="/logout" method="post">
    <input class="fa fa-id-badge" type="submit" value="Wyloguj">
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    <sec:csrfInput/>
</form>
</body>
</html>
