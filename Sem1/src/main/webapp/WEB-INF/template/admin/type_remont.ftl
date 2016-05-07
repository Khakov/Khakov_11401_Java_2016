<#include "../templates/template.ftl">
<@mainTemplate title="All users" body = "class='nav-md'"/>
<#macro m_body>
<div class="container body">
    <div class="main_container">
        <#include "../templates/template_admin.ftl">
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Авто
                            <small>список авто</small>
                        </h3>
                    </div>
                </div>
                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="x_panel">
                            <div class="clearfix"></div>
                            <div class="x_content">
                                <@form.form commandName="typeForm" acceptCharset="UTF-8" action="/admin/add_remont" method="post"
                                class="form-horizontal form-label-left input_mask">
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">имя цвета</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <div>
                                                <@form.input path="type" class="form-control" />
                                                <@form.errors path="type" cssStyle="color: red;" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                            <button type="submit" class="btn btn-success">добавить</button>
                                        </div>
                                    </div>
                                </@form.form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="x_panel">
                            <div class="clearfix"></div>
                            <div class="x_content">
                                <!-- start project list -->
                                <table class="table table-striped projects">
                                    <thead>
                                    <tr>
                                        <th style="width: 20%">тип ремонта</th>
                                        <th style="width: 20%">редактирование</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list types as type>
                                        <tr>
                                            <td>${type.getType()}
                                            <td>
                                                <form action="/admin/delete_remont/${type.getId()}" method="post">
                                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                    <button type="submit" class="btn btn-danger btn-xs"
                                                   onclick="return confirm('вы уверены, что хотите удалить этот тип ремонта?')">
                                                    <i class="fa fa-trash-o"></i> удалить </button></form>
                                            </td>
                                        </tr>
                                        </#list>
                                    </tbody>
                                </table>
                                <!-- end project list -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- footer content -->
            <footer>
                <div class="copyright-info">
                    <p class="pull-right">Autosalon
                    </p>
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->

        </div>
    </div>
</div>
</#macro>
