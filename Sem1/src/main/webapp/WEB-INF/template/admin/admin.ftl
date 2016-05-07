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
                        <div class="count">${all_users}</div>
                        <span class="count_bottom"><i class="green">4% </i> From last Week</span>
                    </div>
                </div>
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-clock-o"></i> заявок на кредит</span>
                        <div class="count">${all_credits}</div>
                        <span class="count_bottom"><i class="green">
                    </div>
                </div>
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-automobile"></i> Заявjr на ремонт</span>
                        <div class="count green"> ${all_remonts}</div>
                        <span class="count_bottom"><i class="green">
                    </div>
                </div>
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-edit"></i> очередь на кредит</span>
                        <span class="count_bottom"><i class="red">
                            <div class="count">${credits} </div>
                        </span></i>
                    </div>
                </div>
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-automobile"></i>очередь на ремонт</span>
                        <div class="count">${remonts_no}</div>
                        <span class="count_bottom"><i class="red">
                    </div>
                </div>
                <div class="animated flipInY col-md-2 col-sm-4 col-xs-4 tile_stats_count">
                    <div class="left"></div>
                    <div class="right">
                        <span class="count_top"><i class="fa fa-automobile"></i>успешный ремонт</span>
                        <div class="count">${remonts_yes}</div>
                    </div>
                </div>
            </div>
            <!-- /top tiles -->
        </div>
    </div>
</div></#macro>