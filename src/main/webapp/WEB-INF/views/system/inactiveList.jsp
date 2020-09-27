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
                <th>Akcje</th>

            </tr>
            <c:forEach items="${inactiveSystems}" var="system">
                <tr>
                    <td>${system.name}</td>
                    <td>${system.type}</td>
                    <td>
                        <div class="buttons">
                            <a href="/system/details/${system.id}"
                               class="button is-info">Szczegóły</a>

                            <a href="/system/activate/${system.id}"
                               class="button is-warning">Przywróć</a>
                        </div>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </section>
</div>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>
<script src="/js/confirm.js"></script>
</body>
</html>