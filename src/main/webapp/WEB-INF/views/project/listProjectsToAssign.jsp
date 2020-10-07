<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 04.10.2020
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <c:if test="${choose != null}">
            ${choose}
        </c:if>
        </p>
        <section class="table">
            <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
                <tr>
                    <th>Numer projektu</th>
                    <th>Szpital</th>
                    <th>System</th>
                    <th>Manager</th>
                    <th>Status</th>
                    <th>Akcje</th>
                </tr>
                <c:forEach items="${project}" var="project">
                    <tr>
                        <td>${project.id}</td>
                        <td>${project.hospital.name} (${project.hospital.hospitalDetails.city})</td>
                        <td>${project.system.name}</td>
                        <td>${project.manager.fullName}</td>
                        <td>${project.status}</td>
                        <td>
                            <form method="post" action="/admin/project/assign">
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
                                    <input type="submit" class="button is-success level-item" value="Przypisz"/>
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

<%--                            <form:form method="post" modelAttribute="project" action="/admin/project/assign">
                                <form:hidden path="id"/>
                                <nav class="level">
                                    <div class="field">
                                        <div class="control">
                                            <div class="select is-primary">

                                                <form:select class="input" path="engineer.id">
                                                    <form:option value="" label="Wybierz pracownika"/>

                                                    <form:options items="${engineersList}" itemValue="id"
                                                                  itemLabel="fullName"/>

                                                </form:select>
                                                <p><form:errors path="engineer" class="help is-danger"/></p>
                                            </div>
                                        </div>
                                    </div>
                                    <form:button class="button is-success">
                                        Przypisz
                                    </form:button>
                                </nav>
                                <sec:csrfInput/>
                            </form:form>--%>