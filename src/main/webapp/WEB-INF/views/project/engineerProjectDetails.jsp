<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 07.10.2020
  Time: 08:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/header/engineerHeader.jsp"%>
<%@include file="/WEB-INF/views/leftmenu/engineerLeftMenu.jsp"%>

<div class="page">
    <section class="section">
        <div class="tile is-ancestor">
            <div class="tile is-vertical is-8">
                <div class="tile">
                    <div class="tile is-parent is-vertical">
                        <article class="tile is-child notification is-primary">
                            <p class="title">Numer projektu</p>
                            <p class="subtitle">${project.id}</p>
                        </article>
                        <article class="tile is-child notification is-primary">
                            <p class="title">System</p>
                            <p class="subtitle">${project.system.name}</p>
                        </article>
                        <article class="tile is-child notification is-warning">
                            <p class="title">Szpital</p>
                            <p class="subtitle">${project.hospital.name} (${project.hospital.hospitalDetails.city})</p>
                        </article>
                        <article class="tile is-child notification is-warning">
                            <p class="title">Nazwa pokoju</p>
                            <p class="subtitle">${project.projectDetails.roomName}</p>
                        </article>
                        <article class="tile is-child notification is-warning">
                            <p class="title">Wysokość pokoju</p>
                            <p class="subtitle">${project.projectDetails.height}</p>
                        </article>
                        <article class="tile is-child notification is-info">
                            <p class="title">Szerokość pokoju</p>
                            <p class="subtitle">${project.projectDetails.roomLength}</p>
                        </article>
                        <article class="tile is-child notification is-info">
                            <p class="title">Długość pokoju</p>
                            <p class="subtitle">${project.projectDetails.roomWidth}</p>
                        </article>
                    </div>
                </div>
            </div>

        </div>


    </section>
    <div class="level-right">
        <div class="level-item">
            <input action="action" class="button is-info" type="button" value="Powrót" onclick="history.go(-1);"/>
        </div>


        <div class="level-item">
            <a href="/engineer/project/complete/${project.id}" class="button is-success" type="button" >Ukończ</a>

    </div>
</div>


<%@include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>