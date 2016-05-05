<#ftl/>
<#import "spring.ftl" as spring />
<#macro mainTemplate title="Auto salon" body = "style='background:#F7F7F7'">
    <#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <title>${title}</title>
    <meta charset="UTF-8">
    <link href="<@spring.url '../../resource/css/bootstrap.min.css'/>" rel="stylesheet">
    <link href="<@spring.url '../../resource/fonts/css/font-awesome.min.css'/>" rel="stylesheet">
    <link href="<@spring.url '../../resource/css/animate.min.css'/>" rel="stylesheet">
    <!-- Custom styling plus plugins -->
    <link href="<@spring.url '../../resource/css/custom.css'/>" rel="stylesheet">
    <link href="<@spring.url '../../resource/css/m_css.css'/>" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<@spring.url '../../resource/css/maps/jquery-jvectormap-2.0.3.css'/>"/>
    <script src="<@spring.url '../../resource/js/jquery.min.js'/>"></script>
    <script src="<@spring.url '../../resource/js/nprogress.js'/>"></script>

</head>
<script src="<@spring.url '../../resource/js/custom.js'/>"></script>
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
                        <li class="active-nav"><a href="/"><i class="fa fa-home"></i> главная</a></li>
                        <li class="nav-style"><a href="/catalog"><i class="fa fa-tachometer"></i> каталог авто</a></li>
                        <li class="nav-style"><a href="/auto"><i class="fa fa-calculator"></i> подбор авто</a></li>
                        <li class="nav-style"><a href="/credit"><i class="fa fa-bank"></i> заявка на кредит</a></li>
                        <li class="nav-style"><a href="/test_drive"><i class="fa fa-edit"></i> заяка на тест драйв</a></li>
                        <li class="nav-style"><a href="/remont"><i class="fa fa-edit"></i> заяка на ремонт</a></li>
                        <li class="nav-style"><a href="/profile"><i class="fa fa-newspaper-o"></i>профиль</a></li>
                        <li class="nav-style"><a href="/login"><i class="fa fa-sign-out pull-right"></i> Log Out</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->
        <@m_body />
    </div>
</div>
<script src="../resource/js/bootstrap.min.js"></script>

<!-- bootstrap progress js -->
<script src="../resource/js/progressbar/bootstrap-progressbar.min.js"></script>
<script src="../resource/js/nicescroll/jquery.nicescroll.min.js"></script>
<!-- icheck -->
<script src="../resource/js/icheck/icheck.min.js"></script>

<script src="../resource/js/custom.js"></script>

<!-- image cropping -->
<script src="../resource/js/cropping/cropper.min.js"></script>
<script src="../resource/js/cropping/main.js"></script>

<!-- daterangepicker -->
<script type="text/javascript" src="../resource/js/moment/moment.min.js"></script>
<script type="text/javascript" src="../resource/js/datepicker/daterangepicker.js"></script>

<!-- chart js -->
<script src="../resource/js/chartjs/chart.min.js"></script>

<!-- moris js -->
<script src="../resource/js/moris/raphael-min.js"></script>
<script src="../resource/js/moris/morris.min.js"></script>

<!-- pace -->
<script src="../resource/js/pace/pace.min.js"></script>
</body>
</html>
</#macro>