<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 07.10.2020
  Time: 08:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/header/engineerHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/engineerLeftMenu.jsp" %>
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
                    <th>Mnager</th>
                    <th>Status</th>
                    <th>Osoba odp. za realizacje</th>
                    <th>Akcje</th>

                </tr>
                <c:forEach items="${projects}" var="project">
                    <tr>
                        <td>${project.id}</td>
                        <td>${project.hospital.name} (${project.hospital.hospitalDetails.city})</td>
                        <td>${project.system.name}</td>
                        <td>${project.manager.fullName}</td>
                        <td>${project.status}</td>
                        <td>${project.engineer.fullName}</td>

                        <td>
                            <div class="buttons">
                                <a href="/engineer/project/details/${project.id}"
                                   class="button is-info">Szczegóły</a>

                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </section>
    </c:if>
</div>
<%@include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>
