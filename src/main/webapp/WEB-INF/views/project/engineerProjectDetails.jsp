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
                            <p class="title is-5">Numer projektu</p>
                            <p class="subtitle is-6">${project.id}</p>
                        </article>

                        <article class="tile is-child notification is-primary">
                            <p class="title is-5">System</p>
                            <p class="subtitle is-6">${project.system.name}</p>
                        </article>
                    </div>
                    <div class="tile is-parent is-vertical">
                        <article class="tile is-child notification is-warning">
                            <p class="title is-5">Szpital</p>
                            <p class="subtitle is-6">${project.hospital.name}
                                (${project.hospital.hospitalDetails.city})</p>
                        </article>
                        <article class="tile is-child notification is-warning">
                            <p class="title is-5">Nazwa pokoju</p>
                            <p class="subtitle is-6">${project.projectDetails.roomName}</p>
                        </article>
                    </div>
                    <div class="tile is-parent is-vertical">
                        <article class="tile is-child notification is-warning">
                            <p class="title is-5">Wysokość pokoju</p>
                            <p class="subtitle is-6">${project.projectDetails.height}</p>
                        </article>
                        <article class="tile is-child notification is-info">
                            <p class="title is-5">Szerokość pokoju</p>
                            <p class="subtitle is-6">${project.projectDetails.roomLength}</p>
                        </article>
                    </div>
                    <div class="tile is-parent">
                        <article class="tile is-child notification is-info">
                            <p class="title is-5">Długość pokoju</p>
                            <p class="subtitle is-6">${project.projectDetails.roomWidth}</p>
                        </article>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="level-left">
        <div class="level-item">
            <form method="post" enctype="multipart/form-data" action="/files/upload/mailAttachments">
                <label>Dodaj plik:
                    <input type="file" name="file"
                           accept="application/pdf,image/*"/>
                </label>
                <button name="idProject" value="${project.id}" type="submit" class="button is-success">Dodaj
                </button>
                <sec:csrfInput/>
            </form>
        </div>
    </div>
    <br>
    <div class="level-left">
        <div class="level-item">
            <c:if test="${emptyFile != null}">
                ${emptyFile}
            </c:if>

            <c:if test="${emptyList != null}">
                ${emptyList}
            </c:if>
            <c:if test="${emptyList == null}">
                <table class="table">
                    <thead>
                    <tr>
                        <td>Dodane pliki:</td>
                    </tr>
                    </thead>
                    <c:forEach items="${project.files}" var="file">
                        <tr>
                            <td>
                                    ${file.originalFileName}
                            </td>
                            <td>
                                <form action="/files/delete" method="post">
                                    <input type="hidden" value="${file.id}" name="fileId">
                                    <button name="projectFileId" value="${project.id}" type="submit"
                                            class="button is-success">Usuń plik
                                    </button>
                                    <sec:csrfInput/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </div>
    <br>
    <div class="level-left">
        <div class="level-item">
            <form action="/engineer/project/complete" method="post">
                <input type="hidden" value="${project.manager.id}" name="managerId">
                <label for="comm">Dodaj komentarz</label>
                <textarea id="comm" name="comments" class="textarea" placeholder="Komentarze do zamówienia"></textarea><br>
                <button name="id" value="${project.id}" type="submit" class="button is-success">Ukończ</button>
                <sec:csrfInput/>
            </form>
        </div>
    </div>
    <div class="level-right">
        <div class="level-item">
            <input action="action" class="button is-info" type="button" value="Powrót"
                   onclick="history.go(-1);"/>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>