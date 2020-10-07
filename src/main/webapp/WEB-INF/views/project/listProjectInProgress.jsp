<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 06.10.2020
  Time: 08:22
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
        <p class="help is-danger"/>
        <c:if test="${change != null}">
            ${change}
        </c:if>
        </p>
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
                            <form method="post" action="/admin/project/change">
                                <input type="hidden" name="projectId" value="${project.id}">
                                    <%--                                <nav class="level">--%>
                                <div class="buttons">
                                    <div class="field">
                                        <div class="control">
                                            <div class="select is-primary">

                                                <select name="userId" class="select is-primary level-item">
                                                    <option value="">wybierz pracownika</option>
                                                    <c:forEach items="${engineersList}" var="engineer">
                                                        <option value="${engineer.id}">${engineer.fullName}</option>
                                                        name="userId">${engineer.fullName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <input type="submit" class="button is-success level-item" value="Zmień"/>
                                        <%--                                </nav>--%>
                                </div>
                                <sec:csrfInput/>
                            </form>

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