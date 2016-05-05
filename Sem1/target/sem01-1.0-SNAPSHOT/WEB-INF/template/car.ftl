<#ftl/>
<#import "spring.ftl" as spring />
<#include "user_temp.ftl">
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

                    <div class="col-md-7 col-sm-7 col-xs-12">
                        <div class="product-image">
                            <img src="images/prod1.jpg" alt="..." />
                        </div>
                        <div class="product_gallery">
                            <a>
                                <img src="images/prod2.jpg" alt="..." />
                            </a>
                            <a>
                                <img src="images/prod3.jpg" alt="..." />
                            </a>
                            <a>
                                <img src="images/prod4.jpg" alt="..." />
                            </a>
                            <a>
                                <img src="images/prod5.jpg" alt="..." />
                            </a>
                        </div>
                    </div>

                    <div class="col-md-5 col-sm-5 col-xs-12" style="border:0px solid #e5e5e5;">

                        <h3 class="prod_title">${car.getManufacture().getManufacture()} - ${car.getModel().getModel()}</h3>

                        <p>${car.getModel().getMotor().getHorsepower()} л.с.  -  ${car.getModel().getMotor().getType()}</p>
                        <br />

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
                        <br />

                        <div class="">
                            <div class="product_price">
                                <h1 class="price">цена</h1>
                                <br>
                            </div>
                        </div>

                        <div class="">
                            <a href="" type="button" class="btn btn-default btn-lg">Предзаказ</a>
                            <a href="" type="button" class="btn btn-default btn-lg">Записаться на тест драйв</a>
                            <a href="/credit" type="button"class="btn btn-default btn-lg">подсчитать в кредит</a>
                        </div>
                    </div>
                    <div class="col-md-12">

                        <div class="" role="tabpanel" data-example-id="togglable-tabs">
                            <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Информация</a>
                                </li>
                                <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">Дополнительное оборудование</a>
                                </li>

                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
                                    <p>новая эпоха новых технологий</p>
                                </div>
                                <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
                                    <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo
                                        booth letterpress, commodo enim craft beer mlkshk aliquip</p>
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