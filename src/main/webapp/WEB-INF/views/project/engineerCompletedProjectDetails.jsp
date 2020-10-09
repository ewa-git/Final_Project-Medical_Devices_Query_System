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
<%@include file="/WEB-INF/views/header/engineerHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/engineerLeftMenu.jsp" %>

<div class="page">
    <section class="section">
        <div class="tile is-ancestor">
            <div class="tile is-vertical is-8">
                <div class="tile">
                    <div class="tile is-parent is-vertical">
                        <article class="tile is-child notification is-primary">
                            <p class="title is-4">Numer projektu</p>
                            <p class="subtitle is-6">${project.id}</p>
                        </article>

                        <article class="tile is-child notification is-primary">
                            <p class="title is-4">System</p>
                            <p class="subtitle is-6">${project.system.name}</p>
                        </article>
                    </div>
                    <div class="tile is-parent is-vertical">
                        <article class="tile is-child notification is-warning">
                            <p class="title is-4">Szpital</p>
                            <p class="subtitle is-6">${project.hospital.name}
                                (${project.hospital.hospitalDetails.city})</p>
                        </article>
                        <article class="tile is-child notification is-warning">
                            <p class="title is-4">Nazwa pokoju</p>
                            <p class="subtitle is-6">${project.projectDetails.roomName}</p>
                        </article>
                    </div>
                    <div class="tile is-parent is-vertical">
                        <article class="tile is-child notification is-warning">
                            <p class="title is-4">Wysokość pokoju</p>
                            <p class="subtitle is-6">${project.projectDetails.height}</p>
                        </article>
                        <article class="tile is-child notification is-info">
                            <p class="title is-4">Szerokość pokoju</p>
                            <p class="subtitle is-6">${project.projectDetails.roomLength}</p>
                        </article>
                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child notification is-info">
                            <p class="title is-4">Długość pokoju</p>
                            <p class="subtitle is-6">${project.projectDetails.roomWidth}</p>
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
    </div>
</div>


<%@include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>