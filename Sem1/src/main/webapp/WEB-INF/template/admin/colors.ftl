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
                                <@form.form commandName="colorForm" acceptCharset="UTF-8" action="/admin/add_color" method="post"
                                class="form-horizontal form-label-left input_mask">
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Создание нового
                                            цвета</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <div class="input-group demo2">
                                                <@form.input path="colorEn" value="#e01ab5" class="form-control" />
                                                <span class="input-group-addon"><i></i></span>
                                                <@form.errors path="colorEn" cssStyle="color: red;" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">имя цвета</label>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <div>
                                                <@form.input path="colorRu" class="form-control" />
                                                <@form.errors path="colorRu" cssStyle="color: red;" />
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
                                        <th style="width: 20%">имя цвета</th>
                                        <th>цвет</th>
                                        <th style="width: 20%">редактирование</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list colors as color>
                                        <tr>
                                            <td>${color.getColorRu()}
                                            </td>
                                            <td style="background-color: ${color.getColorEn()};">
                                            </td>
                                            <td>
                                                <form action="/admin/delete_color/${color.getId()}" method ="post">
                                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                    <button type="submit" class="btn btn-danger btn-xs"
                                                           onclick="return confirm('вы уверены, что хотите удалить этот цвет?')">
                                                    <i class="fa fa-trash-o"></i> удалить</button>
                                                </form>
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