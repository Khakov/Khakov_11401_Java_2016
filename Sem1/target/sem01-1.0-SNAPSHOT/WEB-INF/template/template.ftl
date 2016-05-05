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
    <link rel="stylesheet" type="text/css" href="<@spring.url '../../resource/css/maps/jquery-jvectormap-2.0.3.css'/>"/>
    <script src="<@spring.url '../../resource/js/jquery.min.js'/>"></script>
    <script src="<@spring.url '../../resource/js/nprogress.js'/>"></script>
</head>
<script src="<@spring.url '../../resource/js/custom.js'/>"></script>
<body ${body}>
    <@m_body />
</body>

<script src="../resource/js/bootstrap.min.js"></script>

<!-- bootstrap progress js -->
<script src="../resource/js/progressbar/bootstrap-progressbar.min.js"></script>
<script src="../resource/js/nicescroll/jquery.nicescroll.min.js"></script>
<!-- icheck -->
<script src="../resource/js/icheck/icheck.min.js"></script>
<script src="../resource/js/pace/pace.min.js"></script>

</html>
</#macro>