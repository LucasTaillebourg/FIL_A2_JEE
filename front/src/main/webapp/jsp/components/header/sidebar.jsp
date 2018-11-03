<%
    String urlFlags = request.getContextPath() + "/flags";
    String urlHistoric = request.getContextPath() + "/historic";
    String urlConf = request.getContextPath() + "/conf";


%>


<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
            <li class="active">
                <a class="" href="<%=urlFlags%>">
                    <i class="icon_target"></i>
                    <span>Flags</span>
                </a>
            </li>

            <li class="active">
                <a class="" href="<%=urlHistoric%>">
                    <i class="icon_documents_alt"></i>
                    <span>historique</span>
                </a>
            </li>

            <li>
                <a class="" href="<%=urlConf%>">
                    <i class="icon_genius"></i>
                    <span>Configuration</span>
                </a>
            </li>

        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->