<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 22.09.2020
  Time: 11:27
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
    <title>Login Page</title>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="/js/login.js"></script>
</head>

<body>
<div class="container">
    <div style="text-align: center" id="logo">
        <img src="/images/logo.png">
    </div>
</div>

<section class="center" id="loginForm">
    <form>
        <div class="field">
            <p class="control has-icons-left has-icons-right">
                <input class="input" type="email" placeholder="Email">
                <span class="icon is-small is-left">
                        <i class="fas fa-envelope"></i>
                    </span>
                <span class="icon is-small is-right">
                        <i class="fas fa-check"></i>
                    </span>
            </p>
        </div>
        <div class="field">
            <p class="control has-icons-left">
                <input class="input" type="password" placeholder="Password">
                <span class="icon is-small is-left">
                        <i class="fas fa-lock"></i>
                    </span>
            </p>
        </div>
        <div class="field">
            <p class="control">
                <button class="button is-success">
                    Login
                </button>
            </p>
        </div>
    </form><br>
    <div class="is-link">
        <a href="/register">Nie masz jeszcze konta? Zarejestruj się!</a>
    </div>
</section>

</body>

</html>
<!DOCTYPE html>