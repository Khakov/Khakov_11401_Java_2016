<#macro mainTemplate title="Auto salon" body = "style='background:#F7F7F7'">
    <#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <title>${title}</title>
    <meta charset="UTF-8">
    <link href="../../resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resource/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="../../resource/css/animate.min.css" rel="stylesheet">
    <link href="../../resource/css/colorpicker/bootstrap-colorpicker.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="../../resource/css/custom.css" rel="stylesheet">
    <link href="../../resource/css/m_css.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../resource/css/maps/jquery-jvectormap-2.0.3.css"/>
    <script src="../../resource/js/jquery.min.js"></script>
    <script src="../../resource/js/nprogress.js"></script>

</head>
<script src="../../resource/js/custom.js"></script>
<body ${body}>
<div class="container body">
    <div class="main_container">
        <!-- top navigation -->
        <div class="top_nav" style="margin-left: 0; background: #b7cbff">
            <div class="nav_menu navbar-fixed-top">
                <nav class="" role="navigation">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="/">Autosalon</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="<#if uri =="/">active-nav</#if>"><a href="/"><i class="fa fa-home"></i> главная</a></li>
                        <li class="<#if uri =="/catalog">active-nav</#if>"><a href="/catalog"><i class="fa fa-tachometer"></i> каталог авто</a></li>
                        <li class="<#if uri =="/add_my_car">active-nav</#if>"><a href="/add_my_car"><i class="fa fa-calculator"></i> подбор авто</a></li>
                        <li class="<#if uri =="/credit">active-nav</#if>"><a href="/credit"><i class="fa fa-bank"></i> заявка на кредит</a></li>
                        <li class="<#if uri =="/test_drive">active-nav</#if>"><a href="/test_drive"><i class="fa fa-edit"></i> заяка на тест драйв</a></li>
                        <li class="<#if uri =="/remont">active-nav</#if>"><a href="/remont"><i class="fa fa-edit"></i> заяка на ремонт</a></li>
                        <li class="<#if uri =="/contacts">active-nav</#if>"><a href="/contacts"><i class="fa fa-sticky-note"></i> контакты</a></li>
                        <#if user??>
                        <li class="<#if uri =="/profile">active-nav</#if>"><a href="/profile"><i class="fa fa-newspaper-o"></i>профиль</a></li>
                        <li class="<#if uri =="/login">active-nav</#if>"><a href="/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                        </li>
                        <#if user.getRole()=="ROLE_ADMIN">
                            <li class=""><a href="/admin"><i class="fa fa-sign-out pull-right"></i> admin</a>
                            </li>
                        </#if>
                            <#if user.getRole()=="ROLE_OPERATOR">
                                <li class=""><a href="/operator"><i class="fa fa-sign-out pull-right"></i> operator</a>
                                </li>
                            </#if>
                        </#if>
                        <#if !user??>
                        <li class="<#if uri =="/login">active-nav</#if>"><a href="/login"><i class="fa fa-sign-out pull-right"></i> Log In</a></li>
                        </#if>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->
        <@m_body />
    </div>
</div>
<script src="../../resource/js/bootstrap.min.js"></script>

<!-- bootstrap progress js -->
<script src="../../resource/js/progressbar/bootstrap-progressbar.min.js"></script>
<script src="../../resource/js/nicescroll/jquery.nicescroll.min.js"></script>
<!-- icheck -->
<script src="../../resource/js/icheck/icheck.min.js"></script>

<script src="../../resource/js/custom.js"></script>

<!-- image cropping -->
<script src="../../resource/js/cropping/cropper.min.js"></script>
<script src="../../resource/js/cropping/main.js"></script>

<!-- daterangepicker -->
<script type="text/javascript" src="../../resource/js/moment/moment.min.js"></script>
<script type="text/javascript" src="../../resource/js/datepicker/daterangepicker.js"></script>

<!-- chart js -->
<script src="../../resource/js/chartjs/chart.min.js"></script>

<!-- moris js -->
<script src="../../resource/js/moris/raphael-min.js"></script>
<script src="../../resource/js/moris/morris.min.js"></script>

<!-- pace -->
<script src="../../resource/js/pace/pace.min.js"></script>
</body>
</html>
</#macro>