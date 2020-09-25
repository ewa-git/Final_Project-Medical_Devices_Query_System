<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 25.09.2020
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header/header.jsp" %>
<%@include file="/WEB-INF/views/menu/leftmenu.jsp" %>
<div class="page">
    <form:form modelAttribute="hospital" method="post">
        <p><form:errors path="*" class="help is-danger"/></p>
        <div class="field">
            <label class="label">Nazwa szpitala</label>
            <div class="control">
                <form:input class="input" path="name" placeholder="nazwa"/>
                <form:errors path="name" class="help is-danger"/>
            </div>
        </div>
        <div class="field">
            <label class="label">Miasto</label>
            <div class="control">
                <form:input class="input" path="hospitalDetails.city" placeholder="miasto"/>
                <form:errors path="hospitalDetails.city" class="help is-danger"/>
            </div>
        </div>
        <div class="field">
            <label class="label">Ulica</label>
            <div class="control">
                <form:input class="input" path="hospitalDetails.street" placeholder="ulica"/>
                <form:errors path="hospitalDetails.street" class="help is-danger"/>
            </div>
        </div>
        <div class="field">
            <label class="label">Nip</label>
            <div class="control">
                <form:input class="input" path="hospitalDetails.nip" placeholder="nip"/>
                <form:errors path="hospitalDetails.nip" class="help is-danger"/>
            </div>
        </div>
        <div class="field">
            <label class="label">Regon</label>
            <div class="control">
                <form:input class="input" path="hospitalDetails.regon" placeholder="regon"/>
                <form:errors path="hospitalDetails.regon" class="help is-danger"/>
            </div>
        </div>
        <form:hidden path="hospitalDetails.manager.id" value="${user.id}"/>
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
