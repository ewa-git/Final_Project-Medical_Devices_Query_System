<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 06.10.2020
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/header/engineerHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/engineerLeftMenu.jsp" %>

<div class="page">
    <p class="title">Tu powstaną pomocne linki</p>
    <div class="tile is-ancestor">
        <div class="tile is-vertical is-8">
            <div class="tile">
                <div class="tile is-parent is-vertical">
                    <article class="tile is-child notification is-primary box is-light">
                        <p class="title is-5">Obliczenia radiacji</p>
                        <br>
                        <div class="subtitle is-6">
                            <div>
                                <span class="icon has-text-success">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                                Dawki promieniowania
                            </div>
                            <div>
                                <span class="icon has-text-success">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                                Zasady obliczeń
                            </div>
                            <div>
                                <span class="icon has-text-success">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                                Program do obliczeń
                            </div>
                        </div>
                    </article>
                    <article class="tile is-child notification is-warning box is-light">
                        <p class="title is-5">Podstawowe zasady</p>
                        <br>
                        <div class="subtitle is-6">
                            <div>
                                <span class="icon has-text-warning">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                                Zasady dot. usytuowania w pomieszczeniu
                            </div>
                            <div>
                                <span class="icon has-text-warning">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                                Minimalne wymiary pomieszczenia i wysokosći
                            </div>
                            <div>
                                <span class="icon has-text-warning">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                                Wymagania i przepisy w poszczególnych krajach
                            </div>
                        </div>
                    </article>
                </div>
                <div class="tile is-parent">
                    <article class="tile is-child notification is-info box is-light">
                        <p class="title is-5">Dokumentacja instalacyjna</p>
                        <br>
                        <div class="subtitle is-6">
                            <div>
                                <span class="icon has-text-info">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                                Wygeneruj standardową dokumentację instalacyjną
                            </div>
                            <div>
                                <span class="icon has-text-info">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                                Wygeneruj dokument instalacyjny dostosowany do potrzeb klienta
                            </div>
                        </div>
                    </article>
                </div>
            </div>
            <div class="tile is-parent">
                <article class="tile is-child notification is-danger box is-light">
                    <p class="title is-5">Dane systemów</p>
                    <br>
                    <div class="subtitle is-6">
                        <div>
                                <span class="icon has-text-danger">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                            Zobacz szczegółowe dane systemu
                        </div>
                        <div>
                                <span class="icon has-text-danger">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                            Zadaj pytanie do działu technicznego
                        </div>
                    </div>
                </article>
            </div>
        </div>
        <div class="tile is-parent">
            <article class="tile is-child notification is-success box is-light">
                <div class="content">
                    <p class="title is-5">Newsy</p>
                    <br>
                    <div class="subtitle is-6">
                        <div>
                                <span class="icon has-text-success">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                            Nasz nowy system!
                        </div>
                        <div>
                                <span class="icon has-text-success">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                            Instalacja w Dubaju!
                        </div>
                        <div>
                                <span class="icon has-text-success">
                                    <i class="fas fa-info-circle"></i>
                                </span>
                            Zobacz co nas czeka w 2020!
                        </div>
                    </div>
                </div>
            </article>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>

