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
<%@include file="/WEB-INF/views/header/managerHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/managerLeftMenu.jsp" %>
<div class="page">
    <section class="table">
        <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
            <tr>
                <th>Nazwa szpitala</th>
                <th>Miasto</th>
                <th>Ulica</th>
                <th>NIP</th>
                <th>Regon</th>
                <th>Akcje</th>

            </tr>
            <c:forEach items="${hospitalList}" var="hospital">
                <tr>
                    <td>${hospital.name}</td>
                    <td>${hospital.hospitalDetails.city}</td>
                    <td>${hospital.hospitalDetails.street}</td>
                    <td>${hospital.hospitalDetails.nip}</td>
                    <td>${hospital.hospitalDetails.regon}</td>
                    <td>
                        <div class="buttons"><a href="/hospital/edit/${hospital.id}"
                                                class="button is-warning">Edytuj</a>
                            <a href="" class="popup button is-danger" data-windowId="#window${hospital.id}">Usuń</a>
                            <div id="window${hospital.id}" class="popup-outside">
                                <div class="popup-inside">
                                    <div class="notification is-link is-light popup-inside">
                                        <br>
                                        <strong>Czy na pewno chesz usunąć?</strong>
                                        <br>
                                        <br>
                                        <br>
                                        <div class="level-right">
                                            <div class="buttons">
                                                <button id="close" class="button is-success">Anuluj</button>
                                                <form method="post" action="/hospital/remove">
                                                    <button id="delete" name="id"  value="${hospital.id}" class="button is-danger">Usuń</button>
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
        </table>
    </section>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@include file="/WEB-INF/views/footer/footer.jsp" %>
<script src="/js/confirm.js"></script>
</body>
</html>