<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 27.09.2020
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header/adminHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/adminLeftMenu.jsp" %>
<div class="page">
    <form:form modelAttribute="system" method="post">
        <p><form:errors path="*" class="help is-danger"/></p>
        <div class="field">
            <label class="label">Nazwa systemu</label>
            <div class="control">
                <form:input class="input" path="name" placeholder="nazwa"/>
                <form:errors path="name" class="help is-danger"/>
            </div>
        </div>
        <div class="field">
            <label class="label">Typ</label>
            <div class="select">
                <form:select class="input" path="type" placeholder="typ">
                    <form:option value="" label="select"/>
                    <form:options items="${type}"/>
                </form:select>
                <form:errors path="type" class="help is-danger"/>
            </div>
        </div>
        <div>
            <br>
        </div>
        <p class="control hide" id="submit">
            <form:button class="button is-success">
                Dodaj
            </form:button>
        </p>
        <sec:csrfInput/>
    </form:form>
</div>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>