<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 25.09.2020
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header/adminHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/adminLeftMenu.jsp" %>

<div class="page">
    <section class="table">
        <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
            <tr>
                <th>Nazwa Systemu</th>
                <th>Typ</th>

            </tr>

            <c:forEach items="${activeSystems}" var="system">
            <tr>
                <td>${system.name}</td>
                <td>${system.type}</td>
                <td>
                    <div class="buttons">
                        <a href="/system/edit/${system.id}"
                           class="button is-warning">Edytuj</a>
                        <a href="/system/details/${system.id}"
                           class="button is-info">Szczegóły</a>
                        <a href="" class="popup button is-danger" data-windowId="#window${system.id}">Zdezaktywuj</a>
                        <div id="window${system.id}" class="popup-outside">
                            <div class="popup-inside">
                                <div class="notification is-link is-light popup-inside">
                                    <br>
                                    <strong>Czy na pewno chesz zdeaktywować?</strong>
                                    <br>
                                    <br>
                                    <br>
                                    <div class="level-right">
                                        <div class="buttons">
                                            <button id="close" class="button is-success">Anuluj</button>
                                            <form method="post" action="/system/remove">
                                                <button id="delete" name="id" value="${system.id}"
                                                        class="button is-danger">Przenieś do nieaktywnych
                                                </button>
                                                <sec:csrfInput/>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            </c:forEach>

</div>
</table>
</section>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@include file="/WEB-INF/views/footer/footer.jsp" %>
<script src="/js/confirm.js"></script>
</body>
</html>