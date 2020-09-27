<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 27.09.2020
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header/adminHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/adminLeftMenu.jsp" %>
<div class="page">
    <section class="section">
        <div class="tile is-ancestor">
            <div class="tile is-vertical is-8">
                <div class="tile">
                    <div class="tile is-parent is-vertical">
                        <article class="tile is-child notification is-primary">
                            <p class="title">Nazwa systemu</p>
                            <p class="subtitle">${system.name}</p>
                        </article>
                        <article class="tile is-child notification is-warning">
                            <p class="title">Typ</p>
                            <p class="subtitle">${system.type}</p>
                        </article>
                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child notification is-info">
                            <p class="title">Opis</p>
                            <p class="subtitle">${system.description}</p>
                            </article>
                    </div>
                </div>
<%--                <div class="tile is-parent">
                    <article class="tile is-child notification is-info">
                        <p class="title">Zdjęcie</p>
                        <p class="subtitle">With an image</p>
                        <figure class="image is-4by3">
                            <img src="https://bulma.io/images/placeholders/640x480.png">
                        </figure>
                    </article>
                </div>
            </div>--%>

                <%--                <div class="tile is-parent">
                                    <article class="tile is-child notification is-danger">
                                        <p class="title">Wide tile</p>
                                        <p class="subtitle">Aligned with the right tile</p>
                                        <div class="content">
                                            <!-- Content -->
                                        </div>
                                    </article>
                                </div>--%>
            </div>
        </div>
    </section>
    <div class="level-right">
        <div class="level-item">
            <input action="action" class="button is-info" type="button" value="Powrót" onclick="history.go(-1);"/>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>
<script src="/js/confirm.js"></script>
</body>
</html>
