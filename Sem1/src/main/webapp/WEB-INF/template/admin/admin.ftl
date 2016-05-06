<#include "../templates/template.ftl">
<@mainTemplate title="Admin page" body = "class='nav-md'"/>
<#macro m_body>
<div class="container body">
    <div class="main_container">
        <#include "../templates/template_admin.ftl">
        <!-- page content -->
        <div class="right_col" role="main">

            <!-- top tiles -->
            <div class="row tile_count">
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-user"></i> всего пользователей</span>
                        <div class="count">${all_users.size()}</div>
                        <span class="count_bottom"><i class="green">4% </i> From last Week</span>
                    </div>
                </div>
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-clock-o"></i> Количество заявок на кредит</span>
                        <div class="count">${all_credits.size()}</div>
                        <span class="count_bottom"><i class="green">
                    </div>
                </div>
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-automobile"></i> Заявки на ремонт</span>
                        <div class="count green"> ${all_remonts.size()}</div>
                        <span class="count_bottom"><i class="green">
                    </div>
                </div>
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-edit"></i> не обработанныхзаявок на кредит</span>
                        <div class="count">${credits.size()} </div>
                    </div>
                </div>
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-automobile"></i>не обработанныхзаявок на ремонт</span>
                        <div class="count">${remonts_no.size()}</div>
                    </div>
                </div>
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-automobile"></i>обработанные заявки на ремонт</span>
                        <div class="count">${remonts_yes.size()}</div>
                    </div>
                </div>

            </div>
            <!-- /top tiles -->
        </div>
    </div>
</div></#macro>