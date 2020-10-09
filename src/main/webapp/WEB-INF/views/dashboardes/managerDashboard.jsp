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
<%@include file="/WEB-INF/views/header/managerHeader.jsp" %>
<%@include file="/WEB-INF/views/leftmenu/managerLeftMenu.jsp" %>

<div class="page">
    <p class="title">Tu powstaną hot newsy:D</p>
    <div class="tile is-ancestor">
        <div class="tile is-vertical is-8">
            <div class="tile">
                <div class="tile is-parent is-vertical">
                    <article class="tile is-child notification is-primary box is-light">
                        <p class="title is-5">Jakie są zalety systemu XYZ?</p>
                        <br>
                        <p class="subtitle is-6">
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ac bibendum urna, quis
                            interdum felis. Vestibulum vehicula nulla vitae diam mattis consectetur. Donec odio ligula,
                            varius eget vehicula vitae, rutrum sed diam. Duis vel ligula arcu. Etiam sit amet mollis
                            arcu, id laoreet felis. Ut ut turpis mattis, malesuada lorem eget, consequat erat.
                        </p>
                    </article>
                    <article class="tile is-child notification is-warning box is-light">
                        <p class="title is-5">Generacja kosztorysów - pracujemy nad tym</p>
                        <br>
                        <p class="subtitle is-6">
                            Aenean blandit ligula a lectus scelerisque fringilla. Maecenas cursus ligula ipsum, vitae
                            consequat nisl pretium vitae. Morbi eget tortor aliquet, imperdiet tortor quis, interdum
                            nisi. Donec at maximus sem, in sodales magna. Donec sapien sem, vehicula ac arcu id,
                            tincidunt varius sem. Suspendisse potenti.
                        </p>
                    </article>
                </div>
                <div class="tile is-parent">
                    <article class="tile is-child notification is-info box is-light">
                        <p class="title is-5">Nowy system już w sprzedaży!</p>
                        <br>
                        <p class="subtitle is-6">
                            Nam pretium vitae odio tristique tincidunt. Pellentesque habitant morbi tristique senectus
                            et netus et malesuada fames ac turpis egestas. Pellentesque et convallis justo.
                            Nullam iaculis quam elit, sit amet congue ante dapibus sit amet.
                        </p>
                        <figure class="image is-4by3">
                            <img src="/images/system.png">
                        </figure>
                    </article>
                </div>
            </div>
            <div class="tile is-parent">
                <article class="tile is-child notification is-danger box is-light">
                    <p class="title is-5">Instalacja w szpitalu w Dubaju</p>
                    <br>
                    <p class="subtitle is-6">
                        Cras congue turpis mi, ut rhoncus dolor lacinia non. Nullam porttitor
                        massa sit amet lorem varius, nec dignissim lacus laoreet. Pellentesque sollicitudin eros leo,
                        nec accumsan nibh bibendum in. Duis posuere hendrerit sagittis. Sed ac ex tellus. Maecenas id
                        arcu aliquet, auctor magna nec, auctor nunc.
                    </p>
                    <div class="content">
                    </div>
                </article>
            </div>
        </div>
        <div class="tile is-parent">
            <article class="tile is-child notification is-success box is-light">
                <div class="content">
                    <p class="title is-5">Trwają konsulatacje nad nową funkcjonalnośćią</p>
                    <br>
                    <p class="subtitle is-6">
                        In tincidunt non est in placerat. Etiam scelerisque pretium arcu, a sodales mi molestie nec.
                        Etiam sed sollicitudin ex, sit amet semper velit. Suspendisse fringilla ultricies massa, vel
                        viverra urna porta vitae. Phasellus eleifend, ante ac consequat varius, odio dolor blandit
                        purus, nec ultrices magna orci sed massa. Etiam nec mauris viverra, ullamcorper mi sit amet,
                        vehicula mi. Nam id bibendum tellus. Suspendisse maximus ornare ex eu efficitur. Fusce dui
                        neque, cursus nec pretium egestas, cursus vel felis. Etiam tristique ut elit eleifend suscipit.
                        Cras molestie ut lectus nec viverra. Vestibulum malesuada massa vel quam sagittis, a vestibulum
                        velit pretium. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac
                        turpis egestas. Vivamus dictum pulvinar enim quis ultrices.
                        Suspendisse lorem arcu, laoreet vitae mauris eget, lacinia lobortis justo. Morbi accumsan neque
                        a enim efficitur vehicula. Class aptent taciti sociosqu ad litora torquent per conubia nostra,
                        per inceptos himenaeos. Integer elit nulla, viverra vel semper quis, dictum non urna. Nulla
                        facilisi. Praesent dapibus, lorem vitae dictum egestas, dui metus egestas est, in aliquam est
                        mi vitae sem. Fusce dolor ligula, condimentum vitae hendrerit in, vehicula in dui. Nulla quis
                        iaculis sapien, sed fringilla nisl. Sed imperdiet felis vitae sodales suscipit. Integer sem
                        justo, tristique vitae suscipit non, rhoncus ut mauris. Sed diam ex, tempus vitae nibh sed,
                        auctor laoreet nibh. Cras porttitor, arcu tempus sodales venenatis, neque nibh tincidunt metus,
                        eget pretium eros lectus quis felis. Praesent semper ut magna ac aliquam. Morbi sollicitudin
                        ligula et quam maximus blandit.
                    </p>
                </div>
            </article>
        </div>
    </div>
</div>
</div>
<%@include file="/WEB-INF/views/footer/footer.jsp" %>
</body>
</html>
