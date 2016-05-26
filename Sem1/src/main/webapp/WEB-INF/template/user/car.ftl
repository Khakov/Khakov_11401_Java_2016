<#include "../templates/user_temp.ftl">
<@mainTemplate title="Car" body = "class='nav'"/>
<#macro m_body>
<div class="">
    <div class="page-title">
        <div class="title_left">
            <h3>Product</h3>
        </div>

        <div class="title_right">
            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                  <span class="input-group-btn">
                            <button class="btn btn-default" type="button">Go!</button>
                        </span>
                </div>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>

    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="x_panel">
                <div class="x_title">
                    <h2>${car.getManufacture().getManufacture()} - ${car.getModel().getModel()}</h2>
                    <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <#if pages??>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <#list pages as page>
                                <#if page.getId()==0>
                                    <div class="product_gallery">
                                        <img src="${page.getPath()}" alt="..."/>
                                    </div>
                                </#if>
                                <#if page.getId() != 0>
                                    <#if page.getId()==1>
                                    <div class="product_gallery">
                                    </#if>
                                    <a>
                                        <img src="${page.getPath()}" alt="..." style ="width: 100%;"/>
                                    </a>
                                    <#if page.getId()==length-1>
                                    </div>
                                    </#if>
                                </#if>
                            </#list>
                        </div>
                    </#if>
                    <div class="col-md-6 col-sm-6 col-xs-12" style="border:0px solid #e5e5e5;">
                        <h3 class="prod_title">${car.getManufacture().getManufacture()}
                            - ${car.getModel().getModel()}</h3>
                        <p>${car.getModel().getMotor().getHorsepower()} л.с.
                            -  ${car.getModel().getMotor().getType()}</p>
                        <br/>
                        <div class="">
                            <h2>Популярные цвета</h2>
                            <ul class="list-inline prod_color">
                                <li>
                                    <p>Белый</p>
                                    <div class="color bg"></div>
                                </li>
                                <li>
                                    <p>Синий</p>
                                    <div class="color bg-blue"></div>
                                </li>
                                <li>
                                    <p>Красный</p>
                                    <div class="color bg-red"></div>
                                </li>
                                <li>
                                    <p>Металлик</p>
                                    <div class="color bg-info"></div>
                                </li>
                            </ul>
                        </div>
                        <br/>

                        <div class="">
                            <div class="product_price">
                                <h1 class="price">${car.getPrice()} рублей</h1>
                                <br>
                            </div>
                        </div>

                        <div class="">
                            <a href="/add_my_car" type="button" class="btn btn-default btn-lg">Предзаказ</a>
                            <a href="/test_drive" type="button" class="btn btn-default btn-lg">Записаться на тест
                                драйв</a>
                            <a href="/credit" type="button" class="btn btn-default btn-lg">подсчитать в кредит</a>
                        </div>
                    </div>
                    <div class="col-md-12">

                        <div class="" role="tabpanel" data-example-id="togglable-tabs">
                            <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab"
                                                                          data-toggle="tab" aria-expanded="true">Информация</a>
                                </li>
                                <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab"
                                                                    data-toggle="tab" aria-expanded="false">Дополнительное
                                    оборудование</a>
                                </li>

                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <div role="tabpanel" class="tab-pane fade active in" id="tab_content1"
                                     aria-labelledby="home-tab">
                                    <p>новая эпоха новых технологий</p>
                                </div>
                                <div role="tabpanel" class="tab-pane fade" id="tab_content2"
                                     aria-labelledby="profile-tab">
                                    <p>
                                    <table class="table table-striped responsive-utilities jambo_table bulk_action">
                                        <thead>
                                        <tr class="headings">
                                            <th class="column-title">оборудование</th>
                                            <th class="column-title">описание</th>
                                            <th class="column-title">цена</th>
                                        </tr>
                                        </thead>
                                    <tbody>
                                    <#list attributes as attribute>
                                    <tr class="even pointer">
                                        <td class="">${attribute.getName()}</td>
                                        <td class="">${attribute.getDescription()}</td>
                                        <td class="">${attribute.getPrice() * car.getKof()}</td>
                                    </tr>
                                    </#list>
                                    </tbody>
                                    </table>
                                    </p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
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
</#macro>