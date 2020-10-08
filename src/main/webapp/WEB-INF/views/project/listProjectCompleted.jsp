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
                            <div class="buttons">
                                <a href="/project/details/${project.id}"
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
