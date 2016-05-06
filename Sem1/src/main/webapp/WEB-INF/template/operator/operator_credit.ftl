<#include "../templates/template.ftl">
<@mainTemplate title="Заявки на кредит" body = "class='nav-md'"/>
<#macro m_body>
<div class="container body">
    <div class="main_container">
        <#include "../templates/template_admin.ftl">
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Пользователи
                        </h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search for...">
                  <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Поиск!</button>
                        </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="" role="tabpanel" data-example-id="togglable-tabs">
                    <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab"
                                                                  data-toggle="tab"
                                                                  aria-expanded="true">Необработанные </a>
                        </li>
                        <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab"
                                                            data-toggle="tab" aria-expanded="false">в обработке</a>
                        </li>
                        <li role="presentation" class=""><a href="#tab_content3" role="tab" id="profile-tab2"
                                                            data-toggle="tab" aria-expanded="false">отказ</a>
                        <li role="presentation" class=""><a href="#tab_content4" role="tab" id="profile-tab2"
                                                            data-toggle="tab" aria-expanded="false">принятые</a>
                        </li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="tab_content1"
                             aria-labelledby="home-tab">
                            <table id="datatable-responsive"
                                   class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0"
                                   width="100%">
                                <thead>
                                <tr>
                                    <th>имя пользователя</th>
                                    <th>телефон</th>
                                    <th>дата заявки</th>
                                    <th>Модель авто</th>
                                    <th>тип двигателя</th>
                                    <th>цена авто</th>
                                    <th>статус</th>
                                    <th>изменить статус</th>
                                </tr>
                                </thead>
                                <tbody id="res">
                                    <#if credits??>
                                        <#list credits as credit>
                                        <tr>
                                            <td>${credit.getName()}</td>
                                            <td>${credit.getNumber()}</td>
                                            <td>${credit.getDate()}</td>
                                            <td>${credit.getCar().getManufacture().getManufacture()}
                                                - ${credit.getCar().getModel().getModel()} -
                                            </td>
                                            <td>${credit.getCar().getModel().getMotor().getType()}</td>
                                            <td>${credit.getCar().getPrice()}</td>
                                            <td>${credit.getStatus().getStatus()}</td>
                                            <td><a href="/operator/edit_credit/${credit.getId()}"><span
                                                    class="fa fa-edit"></span></a></td>
                                        </tr>
                                        </#list>
                                    </#if>
                                </tbody>
                            </table>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
                            <table id="datatable-responsive"
                                   class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0"
                                   width="100%">
                                <thead>
                                <tr>
                                    <th>имя пользователя</th>
                                    <th>телефон</th>
                                    <th>дата заявки</th>
                                    <th>Модель авто</th>
                                    <th>тип двигателя</th>
                                    <th>цена авто</th>
                                    <th>статус</th>
                                    <th>изменить статус</th>
                                </tr>
                                </thead>
                                <tbody id="res">
                                    <#if credits1??>
                                        <#list credits1 as credit>
                                        <tr>
                                            <td>${credit.getName()}</td>
                                            <td>${credit.getNumber()}</td>
                                            <td>${credit.getDate()}</td>
                                            <td>${credit.getCar().getManufacture().getManufacture()}
                                                - ${credit.getCar().getModel().getModel()} -
                                            </td>
                                            <td>${credit.getCar().getModel().getMotor().getType()}</td>
                                            <td>${credit.getCar().getPrice()}</td>
                                            <td>${credit.getStatus().getStatus()}</td>
                                            <td><a href="/operator/edit_credit/${credit.getId()}"><span
                                                    class="fa fa-edit"></span></a></td>
                                        </tr>
                                        </#list>
                                    </#if>
                                </tbody>
                            </table>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-tab">
                            <table id="datatable-responsive"
                                   class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0"
                                   width="100%">
                                <thead>
                                <tr>
                                    <th>имя пользователя</th>
                                    <th>телефон</th>
                                    <th>дата заявки</th>
                                    <th>Модель авто</th>
                                    <th>тип двигателя</th>
                                    <th>цена авто</th>
                                    <th>статус</th>
                                    <th>изменить статус</th>
                                </tr>
                                </thead>
                                <tbody id="res">
                                    <#if credits2??>
                                        <#list credits2 as credit>
                                        <tr>
                                            <td>${credit.getName()}</td>
                                            <td>${credit.getNumber()}</td>
                                            <td>${credit.getDate()}</td>
                                            <td>${credit.getCar().getManufacture().getManufacture()}
                                                - ${credit.getCar().getModel().getModel()} -
                                            </td>
                                            <td>${credit.getCar().getModel().getMotor().getType()}</td>
                                            <td>${credit.getCar().getPrice()}</td>
                                            <td>${credit.getStatus().getStatus()}</td>
                                            <td><a href="/operator/edit_credit/${credit.getId()}"><span
                                                    class="fa fa-edit"></span></a></td>
                                        </tr>
                                        </#list>
                                    </#if>
                                </tbody>
                            </table>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="tab_content4" aria-labelledby="profile-tab">
                            <table id="datatable-responsive"
                                   class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0"
                                   width="100%">
                                <thead>
                                <tr>
                                    <th>имя пользователя</th>
                                    <th>телефон</th>
                                    <th>дата заявки</th>
                                    <th>Модель авто</th>
                                    <th>тип двигателя</th>
                                    <th>цена авто</th>
                                    <th>статус</th>
                                    <th>изменить статус</th>
                                </tr>
                                </thead>
                                <tbody id="res">
                                    <#if credits3??>
                                        <#list credits3 as credit>
                                        <tr>
                                            <td>${credit.getName()}</td>
                                            <td>${credit.getNumber()}</td>
                                            <td>${credit.getDate()}</td>
                                            <td>${credit.getCar().getManufacture().getManufacture()}
                                                - ${credit.getCar().getModel().getModel()} -
                                            </td>
                                            <td>${credit.getCar().getModel().getMotor().getType()}</td>
                                            <td>${credit.getCar().getPrice()}</td>
                                            <td>${credit.getStatus().getStatus()}</td>
                                            <td><a href="/operator/edit_credit/${credit.getId()}"><span
                                                    class="fa fa-edit"></span></a></td>
                                        </tr>
                                        </#list>
                                    </#if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- footer content -->
            <footer>
                <div class="copyright-info">
                    <p class="pull-right">Autosalon</a>
                    </p>
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->
        </div>
        <!-- /page content -->
    </div>
</div>
</#macro>