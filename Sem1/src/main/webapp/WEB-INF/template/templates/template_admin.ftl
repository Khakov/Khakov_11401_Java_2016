<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="/admin" class="site_title"><i class="fa fa-automobile"></i> <span>Автосалон</span></a>
        </div>
        <div class="clearfix"></div>

        <!-- menu prile quick info -->
        <div class="profile">
            <div class="profile_info">
                <span>Добро пожаловать!</span>
                <h2>${user.getFirstName()} ${user.getLastName()}</h2>
            </div>
        </div>
        <!-- /menu prile quick info -->
        <br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3><#if user.getRole() =="ROLE_ADMIN" >
    Администратор</#if>
<#if user.getRole() =="ROLE_OPERATOR" >Оператор</#if></h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-home"></i> Главная страница <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="/<#if user.getRole() =="ROLE_ADMIN" >admin</#if>">страница сайта</a>
                            </li>
                        </ul>
                    </li>
                    <#if user.getRole() =="ROLE_ADMIN" >
                    <li><a><i class="fa fa-edit"></i> Модели <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="/admin/colors">Цвета</a>
                            </li>
                            <li><a href="/admin/attributes">аттрибуты</a>
                            </li>
                            <li><a href="/admin/cars">машины</a>
                            </li>
                            <li><a href="/admin/remonts">типы ремонта</a>
                            </li>
                            <li><a href="/users">пользователи</a>
                            </li>
                        </ul>
                    </li>
                    </#if>
                    <li><a><i class="fa fa-desktop"></i> заявки <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="/operator/cars">предзаказ авто</a>
                            </li>
                            <li><a href="/operator/credits">заявки на кредит</a>
                            </li>
                            <li><a href="/operator/test_drive">заявки на тест драйв</a>
                            </li>
                            <li><a href="/operator/remont">заявки на ремонт</a>
                            </li>
                        </ul>
                    </li>

            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a href ="/logout" data-toggle="tooltip" data-placement="top" title="Logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>

<!-- top navigation -->
<div class="top_nav">

    <div class="nav_menu">
        <nav class="" role="navigation">
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<!-- /top navigation -->
