<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 24.09.2020
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.0/css/bulma.min.css">
    <title>Wystąpił błąd</title>
</head>
<body>

<section class="section">
    <div class="container has-text-centered">
        <div class="notification is-danger">
            ${errorMessage}
        </div>
        <div class="level-right">
            <div class="level-item">
                <input action="action" class="button is-info" type="button" value="Powrót" onclick="history.go(-1);"/>
            </div>
        </div>
    </div>
</section>
</body>
</html>
