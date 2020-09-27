<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 27.09.2020
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header/adminHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/adminLeftMenu.jsp" %>
<div class="page">

    <form:form method="post" modelAttribute="user">
        <div class="level-right">
            <p><form:errors path="*" class="help is-danger"/></p>
        </div>

        <div class="field is-horizontal" id="firstName">
            <div class="field-label is-normal">
                <label class="label">Imię</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control is-expanded">
                        <form:input path="fisrtName" class="input" name="firstName" placeholder="Imię"/>
                        <p><form:errors path="fisrtName" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal" id="lastName">
            <div class="field-label is-normal">
                <label class="label">Nazwisko</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <form:input path="lastName" class="input" placeholder="Nazwisko"/>
                        <p><form:errors path="lastName" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal" id="email">
            <div class="field-label is-normal">
                <label class="label">Email</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <form:input path="email" class="input" placeholder="Email"/>
                        <p><form:errors path="email" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
        </div>

 <%--       <div class="field is-horizontal" id="password">
            <div class="field-label is-normal">
                <label class="label">Hasło</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <form:password path="password" class="input" placeholder="Hasło"/>
                        <p><form:errors path="password" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal" id="passwordRepeat">
            <div class="field-label is-normal">
                <label class="label">Powtórz hasło</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <form:password path="repeatPassword" class="input" placeholder="Powtórz hasło"/>
                        <p><form:errors path="repeatPassword" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
        </div>--%>
        <p class="control" id="submit">
        <div class="level-right">
            <form:button class="button is-success">
                Dodaj pracownika
            </form:button>
        </div>
        </p>
        <sec:csrfInput/>
    </form:form><br>
</div>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>