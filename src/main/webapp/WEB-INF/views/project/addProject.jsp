<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 29.09.2020
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header/managerHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/managerLeftMenu.jsp" %>

<div class="page">
    <form:form method="post" modelAttribute="project">
        <form:hidden path="manager.id" value="${loggedUser.id}"/>
        <div class="level-right">
            <p><form:errors path="*" class="help is-danger"/></p>
        </div>

        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">Nazwa pokoju</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control is-expanded">
                        <form:input path="projectDetails.roomName" class="input" placeholder="Nazwa pokoju"/>
                        <p><form:errors path="projectDetails.roomName" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">Wysokość</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <form:input path="projectDetails.height" class="input" placeholder="Wysokość"/>
                        <p><form:errors path="projectDetails.height" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">Długość pokoju</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <form:input path="projectDetails.roomLength" class="input" placeholder="długość pokoju"/>
                        <p><form:errors path="projectDetails.roomLength" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">Szerokość pokoju</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="control">
                        <form:input path="projectDetails.roomWidth" class="input" placeholder="szerokość pokoju"/>
                        <p><form:errors path="projectDetails.roomWidth" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="field is-horizontal">
            <div class="field-label is-normal">
                <label class="label">System</label>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="select">
          <%--              Użytkownik<form:select path="user.id">
                        <form:option value="0" label="Wybierz autora"/>
                        <form:options items="${users}" itemValue="id" itemLabel="name"/>
                    </form:select><br>
                        <form:errors path="user" cssClass="error"/><br>--%>


                        <form:select class="input" path="system.id">
                            <form:option value="0" label="Wybierz system"/>
                            <form:options items="${systems}" itemValue="id" itemLabel="name"/>
                        </form:select>
                        <p><form:errors path="system" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
            <div class="field-body">
                <div class="field">
                    <div class="select">
                        <form:select class="input" path="hospital.id">
                            <form:option value="0" label="Wybierz szpital"/>
                            <form:options items="${hospitals}" itemValue="id" itemLabel="name"/>
                        </form:select>
                        <p><form:errors path="hospital" class="help is-danger"/></p>
                    </div>
                </div>
            </div>
        </div>
        <p class="control">
        <div class="level-right">
            <form:button class="button is-success">
                Dodaj projekt
            </form:button>
        </div>
        </p>
        <sec:csrfInput/>
    </form:form><br>
</div>
<%@include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>

