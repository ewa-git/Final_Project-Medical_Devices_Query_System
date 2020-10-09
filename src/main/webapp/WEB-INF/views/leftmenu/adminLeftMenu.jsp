<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 26.09.2020
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <div class="nav">
        <aside class="menu">

            <p class="menu-label">
                General
            </p>
            <ul class="menu-list">
                <li><a href="/admin/dashboard">Strona główna</a></li>
            </ul>
            <%--<ul class="menu-list">
                <li><a>Edycja danych</a></li>
            </ul>--%>

            <p class="menu-label">
                Pracownicy
            </p>
            <ul class="menu-list">
                <ul>
                    <li><a href="/admin/engineer/add">Dodaj pracownika</a></li>
                    <li><a href="/admin/engineer/list">Lista pracowników</a></li>
                </ul>
            </ul>
            <p class="menu-label">
                Systemy
            </p>
            <ul class="menu-list">
                <ul>
                    <li><a href="/system/add">Dodaj system</a></li>
                    <li><a href="/system/active/list">Lista systemów aktywnych</a></li>
                    <li><a href="/system/inactive/list">Lista systemów nieaktywnych</a></li>
                </ul>
            </ul>
            <p class="menu-label">
                Projekty
            </p>
            <ul class="menu-list">
                <ul>
                    <li><a href="/admin/project/queue">Projekty do przypisania</a></li>
                    <li><a href="/admin/project/inprogress">Lista projektów w realizacji</a></li>
                </ul>
            </ul>
        </aside>
    </div>
</div>
