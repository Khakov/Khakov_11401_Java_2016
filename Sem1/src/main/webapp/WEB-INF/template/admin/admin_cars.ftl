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
                            <a href="/admin/add_car" class="btn btn-success btn-xs">
                                <span class="fa fa-plus"></span> добавить авто</a>
                            <div class="clearfix"></div>
                            <div class="x_content">
                                <!-- start project list -->
                                <table class="table table-striped projects">
                                    <thead>
                                    <tr>
                                        <th style="width: 20%">Производитель</th>
                                        <th>модель</th>
                                        <th>мощность</th>
                                        <th>цена</th>
                                        <th style="width: 20%">редактирование</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <#list cars as car>
                                        <tr>
                                            <td>${car.getManufacture().getManufacture()}
                                            </td>
                                            <td>${car.getModel().getModel()} - ${car.getModel().getMotor().getType()}
                                            </td>
                                            <td>
                                            ${car.getModel().getMotor().getHorsepower()}
                                            </td>
                                            <td>
                                            ${car.getPrice()}
                                            </td>
                                            <td>
                                                <a href="/admin/edit_car/${car.getId()}" class="btn btn-info btn-xs">
                                                    <i class="fa fa-pencil"></i> изменить </a>
                                                <form action="/admin/delete_car/${car.getId()}" method="post">
                                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                    <button onclick="return confirm('вы уверены, что хотите удалить это авто?')" type="submit" class="btn btn-danger btn-xs">
                                                    <i class="fa fa-trash-o"></i> удалить </button>
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
                    <p class="pull-right">Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
                    </p>
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->

        </div>
    </div>
</div>
</#macro>
