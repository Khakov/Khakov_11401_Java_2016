<#include "../templates/user_temp.ftl">
<@mainTemplate title="Profile" body = "class='nav'"/>
<#macro m_body>
        <!-- page content -->
        <div class="right_col" role="main" style="margin-top: 30pt">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Мой профиль</h3>
                    </div>
                </div>
                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Мои данные</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="col-md-3 col-sm-3 col-xs-12 profile_left">
                                    <div class="profile_img">
                                        <!-- end of image cropping -->
                                        <div id="crop-avatar">
                                            <!-- Current avatar -->
                                            <div class="avatar-view" title="Change the avatar">
                                                <img src="../../resource/image/user.png" alt="Avatar">
                                            </div>

                                    </div>
                                    <h3>${user.getFirstName()} ${user.getLastName()}</h3>
                                    <ul class="list-unstyled user_data">
                                        <li><i class="fa fa-map-marker user-profile-icon"></i> Казань, Россия
                                        </li>
                                        <li>
                                            <i class="fa fa-newspaper-o user-profile-icon"></i>${user.getLogin()}
                                        </li>
                                        <li class="m-top-xs">
                                            <i class="fa fa-phone"></i>
                                        ${user.getNumber()}
                                        </li>
                                    </ul>

                                    <br />
                                </div>
                                    </div>
                                <#--</div>-->
                            <#--<div class="x_content">-->
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <div class="profile_title">
                                        <div class="col-md-6">
                                            <h2>User Activity Report</h2>
                                        </div>
                                    </div>
                                    </div>
                                    <!-- start of user-activity-graph -->
                                    <div>
                                        <#if cars??>
                                            <#list cars as car>
                                            <#if car.getStatus()?string("true", "false") == "true">
                                                <h3>Машина</h3>
                                                производитель: <h3>${car.getCar().getManufacture().getManufacture()}</h3>
                                                модель: <h3> ${car.getCar().getModel().getModel()}</h3>
                                                двигатель:<h3>${car.getCar().getModel().getMotor().getType()}</h3>
                                                мощность:<h3>${car.getCar().getModel().getMotor().getHorsepower()}</h3>
                                            </#if>
                                            </#list>
                                        </#if><#if !cars??>У вас еще нет авто, вы можете дать заявку на предзаказ</#if>
                                    </div>
                                    <!-- end of user-activity-graph -->

                                    <div class="" role="tabpanel" data-example-id="togglable-tabs">
                                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                                            <li role="presentation" class="active"><a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">Акции и новости</a>
                                            </li>
                                            <li role="presentation" class=""><a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">История операций</a>
                                            </li>
                                            <li role="presentation" class=""><a href="#tab_content3" role="tab" id="profile-tab2" data-toggle="tab" aria-expanded="false">Мои заявки</a>
                                            </li>
                                        </ul>
                                        <div id="myTabContent" class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">


                                            </div>
                                            <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">

                                            </div>
                                            <div role="tabpanel" class="tab-pane fade" id="tab_content3" aria-labelledby="profile-tab">
                                                <#if credits??>
                                                   <h1>Заявки на кредит</h1>
                                                   <table id="datatable-responsive"
                                                      class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0"
                                                       width="100%">
                                               <#list credits as credit>
                                                   <tr>
                                                       <td>${credit.getCar().getModel().getModel()}</td>
                                                       <td>${credit.getDate()}</td>
                                                       <td>${credit.getStatus().getStatus()}</td>
                                               </tr></#list>
                                               </table>
                                               </#if>
                                                <#if remonts??>
                                                    <h1>Заявки на ремонт</h1>
                                                    <table id="datatable-responsive"
                                                           class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0"
                                                           width="100%">
                                                        <#list remonts as remont>
                                                            <tr>
                                                                <td>${remont.getCar().getModel().getModel()}</td>
                                                                <td>${remont.getDate()}</td>
                                                                <td>${remont.getResult().getResult()}</td>
                                                            </tr></#list>
                                                    </table>
                                                </#if>
                                                <#if drives??>
                                                    <h1>Заявки на тест драйв</h1>
                                                    <table id="datatable-responsive"
                                                           class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0"
                                                           width="100%">
                                                        <#list drives as drive>
                                                            <tr>
                                                                <td>${drive.getCar().getModel().getModel()}</td>
                                                                <td>${drive.getDate()}</td>
                                                                <td>${drive.getStatus().getStatus()}</td>
                                                            </tr></#list>
                                                    </table>
                                                </#if>
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
                    <p class="pull-right">Autosalon
                    </p>
                </div>
                <div class="clearfix"></div>
            </footer>
            <!-- /footer content -->
        </div>
        <!-- /page content -->
</#macro>