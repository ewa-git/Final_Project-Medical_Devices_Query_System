<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 27.09.2020
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header/adminHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/adminLeftMenu.jsp" %>


<div class="page">
<c:if test="${message != null}">
    <h2 class="subtitle">${message}</h2>
</c:if>
<c:if test="${message == null}">
    <section class="table">
        <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
            <tr>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Email</th>
            </tr>

            <c:forEach items="${engineers}" var="engineer">
            <tr>
                <td>${engineer.fisrtName}</td>
                <td>${engineer.lastName}</td>
                <td>${engineer.email}</td>
                <td>
                    <div class="buttons">
                        <a href="/admin/engineer/edit/${engineer.id}"
                           class="button is-warning">Edytuj</a>
                        <a href="/admin/engineer/details/${engineer.id}"
                           class="button is-info">Szczegóły</a>
                        <a href="" class="popup button is-danger" data-windowId="#window${engineer.id}">Usuń</a>
                        <div id="window${engineer.id}" class="popup-outside">
                            <div class="popup-inside">
                                <div class="notification is-link is-light popup-inside">
                                    <br>
                                    <strong>Czy na pewno chesz usunąć użytkownika?</strong>
                                    <br>
                                    <br>
                                    <br>
                                    <div class="level-right">
                                        <div class="buttons">
                                            <button id="close" class="button is-success">Anuluj</button>
                                            <form method="post" action="/admin/engineer/remove">
                                                <button id="delete" name="id" value="${engineer.id}"
                                                        class="button is-danger">Usuń
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
</c:if>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@include file="/WEB-INF/views/footer/footer.jsp" %>
<script src="/js/confirm.js"></script>
</body>
</html>