<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 29.09.2020
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header/managerHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/managerLeftMenu.jsp" %>
<div class="page">
    <c:if test="${message != null}">
        <h2 class="subtitle">${message}</h2>
    </c:if>
    <c:if test="${message == null}">
        <section class="table">
            <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                <tr>
                    <th>Numer projektu</th>
                    <th>Szpital</th>
                    <th>System</th>
                    <th>Status</th>
                    <th>Osoba odp. za realizacje</th>
                    <th>Akcje</th>

                </tr>
                <c:forEach items="${projects}" var="project">
                    <tr>
                        <td>${project.id}</td>
                        <td>${project.hospital.name} (${project.hospital.hospitalDetails.city})</td>
                        <td>${project.system.name}</td>
                        <td>${project.status}</td>
                        <c:if test="${project.engineer == null}">
                            <td>-</td>
                        </c:if>
                        <c:if test="${project.engineer != null}">
                        <td>${project.engineer.fullName}</td>
                        </c:if>
                        <td>
                            <div class="buttons"><a href="/project/edit/${project.id}"
                                                    class="button is-warning">Edytuj</a>
                                <div class="buttons"><a href="/project/details/${project.id}"
                                                        class="button is-info">Szczegóły</a>
                                <a href="" class="popup button is-danger" data-windowId="#window${project.id}">Usuń</a>
                                <div id="window${project.id}" class="popup-outside">
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
                                                    <form method="post" action="/project/remove">
                                                        <button id="delete" name="id" value="${project.id}"
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
            </table>
        </section>
    </c:if>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%@include file="/WEB-INF/views/footer/footer.jsp" %>
<script src="/js/confirm.js"></script>
</body>
</html>
