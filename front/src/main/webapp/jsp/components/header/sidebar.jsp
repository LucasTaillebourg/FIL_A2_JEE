<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String urlFlags = request.getContextPath() + "/flags";
    String urlHistoric = request.getContextPath() + "/historique";
    String urlConf = request.getContextPath() + "/parametreAlertes";


%>


<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
            <li class="active">
                <a class="" href="<%=urlFlags%>">
                    <i class="icon_target"></i>
                    <span>Alertes</span>
                </a>
            </li>

            <li class="active">
                <a class="" href="<%=urlHistoric%>">
                    <i class="icon_documents_alt"></i>
                    <span>Historique</span>
                </a>
            </li>

            <li>
                <a class="" href="<%=urlConf%>">
                    <i class="icon_genius"></i>
                    <span>Configuration Alertes</span>
                </a>
            </li>

        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->