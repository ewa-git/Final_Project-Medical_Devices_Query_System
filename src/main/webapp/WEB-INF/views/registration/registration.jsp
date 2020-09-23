<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 21.09.2020
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello Bulma!</title>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/js/registration.js"></script>
    <!--   -->
</head>

<body>
<div class="container">
    <div style="text-align: center" id="logo">
        <img src="/images/logo.png">
    </div>
</div>

<section class="center" id="registerForm">
    <form:form method="post" modelAttribute="user" action="/register">
        <p><form:errors path="*" class="help is-danger"/></p>
        <div class="field hide" id="firstName">
            <div class="control">
                <form:input path="fisrtName" class="input" name="firstName" placeholder="Imię"/>
                <p><form:errors path="fisrtName" class="help is-danger"/></p>
            </div>
        </div>
        <div class="field hide" id="lastName">
            <div class="control">
                <form:input path="lastName" class="input" placeholder="Nazwisko"/>
                <p><form:errors path="lastName" class="help is-danger"/></p>
            </div>
        </div>
        <div class="field hide" id="email">
            <div class="control">
                <form:input path="email" class="input" placeholder="Email"/>
                <p><form:errors path="email" class="help is-danger"/></p>
            </div>
        </div>
        <div class="field hide" id="password">
            <div class="control">
                <form:password path="password" class="input" placeholder="Hasło"/>
                <p><form:errors path="password" class="help is-danger"/></p>
            </div>
        </div>
              <div class="field hide" id="passwordRepeat">
                  <div class="control">
                      <form:password path="repeatPassword" class="input" placeholder="Powtórz hasło" />
                      <p><form:errors path="repeatPassword" class="help is-danger"/></p>
                  </div>
              </div>
        <p class="control hide" id="submit">
            <form:button class="button is-success">
                Załóż konto
            </form:button>
        </p>
        <sec:csrfInput/>
    </form:form><br>
</section>
<%--    </div>--%>
<%--</div>--%>
</body>
</html>