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
    <script src="../../resource/js/bootstrap.min.js"></script>
    <!-- bootstrap progress js -->
    <script src="../../resource/js/progressbar/bootstrap-progressbar.min.js"></script>
    <script src="../../resource/js/nicescroll/jquery.nicescroll.min.js"></script>
    <!-- icheck -->
    <script src="../../resource/js/icheck/icheck.min.js"></script>
    <script src="../../resource/js/pace/pace.min.js"></script>

    <!--color-->
    <script src="../../resource/js/colorpicker/bootstrap-colorpicker.min.js"></script>
    <script src="../../resource/js/colorpicker/docs.js"></script>
</head>
<#--<script src="../../resource/js/custom.js"></script>-->
<body ${body}>
    <@m_body />
</body>
<script src="../../resource/js/custom.js"></script>
</html>
</#macro>