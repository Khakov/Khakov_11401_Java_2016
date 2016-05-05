<#ftl/>
<#import "spring.ftl" as spring />
<#include "user_temp.ftl">
<@mainTemplate title="Catalog" body = "class='nav'"/>
<#macro m_body>
    <!-- page content -->
    <div class="right_col" role="main">
        <div class="">
            <div class="page-title">
                <div class="title_left">
                    <h3>Каталог автомобилей</h3>
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


            <div class="row">

                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Каталог авто</h2>
                            <div class="clearfix"></div>
                        </div>

                        <div class="x_content">

                            <table class="table table-striped responsive-utilities jambo_table bulk_action">
                                <thead>
                                <tr class="headings">
                                    <th class="column-title">Производитель</th>
                                    <th class="column-title">Модель</th>
                                    <th class="column-title">мощность</th>
                                    <th class="column-title">тип двигателя</th>
                                    <th class="column-title">расход</th>
                                    <th class="column-title">цена</th>
                                    <th class="column-title no-link last"><span class="nobr">фото</span>
                                    </th>
                                </tr>
                                </thead>

                                <tbody>
                                    <#list cars as car>
                                    <tr class="even pointer">
                                        <td class=" ">${car.getManufacture().getManufacture()}</td>
                                        <td class=" ">${car.getModel().getModel()}</td>
                                        <td class=" ">${car.getModel().getMotor().getHorsepower()}</td>
                                        <td class=" ">${car.getModel().getMotor().getType()}</td>
                                        <td class=" ">${car.getModel().getMotor().getConsumption()}</td>
                                        <td class="a-right a-right ">$745</td>
                                        <td class=" last"><a href="/car/${car.getId()}">View</a>
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>

                            </table>
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

    </div>
    <!-- /page content -->
</#macro>