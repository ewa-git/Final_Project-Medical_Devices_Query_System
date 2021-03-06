<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 24.09.2020
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html class="list">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/js/registration.js"></script>
</head>
<body>
<header>
    <section class="hero is-light is-small is-bold">
        <div class="hero-body navbar-end">
            <div class="container has-image-right">
                <img src="/images/logosmall.png" alt="Logo" width="200px" height="200px">
            </div>
        </div>
        <div class="hero-body navbar-end">
            <div class="container has-image-right">
                Jesteś zalogowany jako : <strong>${loggedUser.fullName}</strong>
            </div>
        </div>
        <div class="hero-foot ">
            <!-- Main container -->
            <nav class="level">

                <!-- Right side -->
                <div class="navbar-end">
                <div class="level-right">

                    <p class="level-item"><a href="/system/active/list">Aktywne systemy</a></p>
                    <p class="level-item"><a href="/system/inactive/list">Nieaktywne systemy</a></p>
                    <p class="level-item"><a href="/system/add" class="button is-success">Dodaj system</a></p>

                    <p class="level-item">
                    <form action="/logout" method="post">
                        <input type="submit" class="button is-info" value="Wyloguj"/>
                        <sec:csrfInput/>
                    </form>
                    </p>
                </div>
                </div>
            </nav>
        </div>
    </section>
</header>

