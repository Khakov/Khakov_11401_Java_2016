<#include "../templates/user_temp.ftl">
<@mainTemplate title="ошибка 404" body = "class='nav-md'"/>
<#macro m_body>
        <!-- page content -->
        <div class="col-md-12">
            <div class="col-middle" style="margin-top: 60pt;">
                <div class="text-center text-center">
                    <h1 class="error-number">404</h1>
                    <h2>Извините, но такой страницы не существует</h2>
                    <p>либо страница, которую Вы ищите, еще не создана
                    </p>
                </div>
            </div>
        </div>
        <!-- /page content -->
<div id="custom_notifications" class="custom-notifications dsp_none">
    <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
    </ul>
    <div class="clearfix"></div>
    <div id="notif-group" class="tabbed_notifications"></div>
</div>
</#macro>