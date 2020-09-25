<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 23.09.2020
  Time: 07:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/views/header/header.jsp"%>
<%@include file="/WEB-INF/views/menu/leftmenu.jsp"%>
<%--<h1>działa</h1>
${userLogin}

<form action="/logout" method="post">
    <input class="fa fa-id-badge" type="submit" value="Wyloguj">
    &lt;%&ndash;<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>&ndash;%&gt;
    <sec:csrfInput/>
</form>--%>
<div class="page">
    <section class="table">
        <table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
            <tr>
                <th>cos
                </th>
            </tr>
            <tr>
                <td>1</td>
            </tr>
            <tr>
                <td>2</td>
            </tr>
        </table>
    </section>
</div>
</div>
<%@include file="/WEB-INF/views/footer/footer.jsp"%>
</body>
</html>
