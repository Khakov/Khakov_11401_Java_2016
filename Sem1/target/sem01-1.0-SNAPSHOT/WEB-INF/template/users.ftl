<#ftl/>
<#import "spring.ftl" as spring />
<#include "template.ftl">
<@mainTemplate title="All users" body = "class='nav-md'"/>
<#macro m_body>
<div class="container body">
    <div class="main_container">
        <#include "template_admin.ftl">
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

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Пользователи</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <input type="hidden" id = "id_us" value="1"/>
                                <input type="hidden" id = "id_fn" value="0"/>
                                <input type="hidden" id = "id_ln" value="0"/>
                                <input type="hidden" id = "id_mail" value="0"/>
                                <input type="hidden" id = "id_enable" value="0"/>
                                <input type="hidden" id = "id_role" value="0"/>
                                <table id="datatable-responsive"
                                       class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0"
                                       width="100%">
                                    <thead>
                                    <tr>
                                        <th><a href="" id="id_user" onclick="OrderById();return false;"><i class="fa fa-sort-numeric-asc"></i>Id</a></th>
                                        <th><a href="" id = "f_name" onclick="OrderByFirstName();return false;"><i class="fa fa-sort"></i>First name</a></th>
                                        <th><a href="" id = "l_name" onclick="OrderByLastName();return false;"><i class="fa fa-sort"></i>Last name</a></th>
                                        <th><a href="" id = "mail_name" onclick="OrderByMail();return false;"><i class="fa fa-sort"></i>E-mail</a></th>
                                        <th><a href="" id = "is_baned" onclick="OrderByEnable();return false;"><i class="fa fa-sort"></i>not baned</a></th>
                                        <th><a href="" id = "role_name" onclick="OrderByRole();return false;"><i class="fa fa-sort"></i>role</a></th>
                                        <th>Age</th>
                                        <th>Start date</th>
                                        <th>Salary</th>
                                        <th>Extn.</th>
                                    </tr>
                                    </thead>
                                    <tbody id = "res">
                                    <#list users as user>
                                    <tr>
                                        <td>${user.getId()}</td>
                                        <td>${user.getFirstName()}</td>
                                        <td>${user.getLastName()}</td>
                                        <td>${user.getUsername()}</td>
                                        <td>${user.getRole()}</td>
                                        <td><a href="/edit_user/${user.getId()}"><span class="fa fa-edit"></span></a></td>
                                        <td>$320,800</td>
                                        <td>5421</td>
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
    </div>
</div>
<script type="application/javascript">
    OrderById = function(){
        val_1 = $("#id_us").val();
        if(val_1 == 1){
            $("#id_us").val(0);
            $("#id_user").html("<i class='fa fa-sort-numeric-desc'></i>Id");
        }else
        {
            $("#id_us").val(1);
            $("#id_user").html("<i class='fa fa-sort-numeric-asc'></i>Id");
        }
        $("#f_name").html("<i class='fa fa-sort'></i>First name");
        $("#l_name").html("<i class='fa fa-sort'></i>Last name");
        $("#mail_name").html("<i class='fa fa-sort'></i>E-mail");
        $("#is_baned").html("<i class='fa fa-sort'></i>not baned");
        $("#role_name").html("<i class='fa fa-sort'></i>role");
        Search("id" + val_1);
    };
    OrderByFirstName = function(){
        val_1 = $("#id_fn").val();
        if(val_1 == 1){
            $("#id_fn").val(0);
            $("#f_name").html("<i class='fa fa-sort-alpha-desc'></i>First Name");
        }else
        {
            $("#id_fn").val(1);
            $("#f_name").html("<i class='fa fa-sort-alpha-asc'></i>First Name");
        }
        $("#id_user").html("<i class='fa fa-sort'></i>Id");
        $("#l_name").html("<i class='fa fa-sort'></i>Last name");
        $("#mail_name").html("<i class='fa fa-sort'></i>E-mail");
        $("#is_baned").html("<i class='fa fa-sort'></i>not baned");
        $("#role_name").html("<i class='fa fa-sort'></i>role");
        Search("fn" + val_1);
    };
    OrderByLastName = function(){
        val_1 = $("#id_ln").val();
        if(val_1 == 1){
            $("#id_ln").val(0);
            $("#l_name").html("<i class='fa fa-sort-alpha-desc'></i>Last Name");
        }else
        {
            $("#id_ln").val(1);
            $("#l_name").html("<i class='fa fa-sort-alpha-asc'></i>Last Name");
        }
        $("#id_user").html("<i class='fa fa-sort'></i>Id");
        $("#f_name").html("<i class='fa fa-sort'></i>First name");
        $("#mail_name").html("<i class='fa fa-sort'></i>E-mail");
        $("#is_baned").html("<i class='fa fa-sort'></i>not baned");
        $("#role_name").html("<i class='fa fa-sort'></i>role");
        Search("ln" + val_1);
    };
    OrderByMail = function(){
        val_1 = $("#id_mail").val();
        if(val_1 == 1){
            $("#id_mail").val(0);
            $("#mail_name").html("<i class='fa fa-sort-alpha-desc'></i>E-mail");
        }else
        {
            $("#id_mail").val(1);
            $("#mail_name").html("<i class='fa fa-sort-alpha-asc'></i>E-mail");
        }
        $("#id_user").html("<i class='fa fa-sort'></i>Id");
        $("#l_name").html("<i class='fa fa-sort'></i>Last name");
        $("#f_name").html("<i class='fa fa-sort'></i>First name");
        $("#is_baned").html("<i class='fa fa-sort'></i>not baned");
        $("#role_name").html("<i class='fa fa-sort'></i>role");
        Search("mail" + val_1);
    };
    OrderByEnable = function(){
        val_1 = $("#id_enable").val();
        if(val_1 == 1){
            $("#id_enable").val(0);
            $("#is_baned").html("<i class='fa fa-sort-alpha-desc'></i>not baned");
        }else
        {
            $("#id_enable").val(1);
            $("#is_baned").html("<i class='fa fa-sort-alpha-asc'></i>not baned");
        }
        $("#id_user").html("<i class='fa fa-sort'></i>Id");
        $("#l_name").html("<i class='fa fa-sort'></i>Last name");
        $("#f_name").html("<i class='fa fa-sort'></i>First name");
        $("#mail_name").html("<i class='fa fa-sort'></i>E-mail");
        $("#role_name").html("<i class='fa fa-sort'></i>role");
        Search("enable" + val_1);
    };
    OrderByRole = function(){
        val_1 = $("#id_role").val();
        if(val_1 == 1){
            $("#id_role").val(0);
            $("#role_name").html("<i class='fa fa-sort-alpha-desc'></i>role");
        }else
        {
            $("#id_role").val(1);
            $("#role_name").html("<i class='fa fa-sort-alpha-asc'></i>role");
        }
        $("#id_user").html("<i class='fa fa-sort'></i>Id");
        $("#l_name").html("<i class='fa fa-sort'></i>Last name");
        $("#f_name").html("<i class='fa fa-sort'></i>First name");
        $("#is_baned").html("<i class='fa fa-sort'></i>not baned");
        $("#mail_name").html("<i class='fa fa-sort'></i>E-mail");
        Search("role" + val_1);
    };

    Search = function (value1) {
        $.ajax({
            url: "/user",
            data: {"q": value1},
            dataType: "json",
            success: function (response_data) {
                if (response_data.length > 0) {
                    $("#res").html("");
                    for (var i = 0; i < response_data.length; i++) {
                        $("#res").append("<tr><td>"+response_data[i].id +"</td><td>"+
                                response_data[i].firstName +"</td><td>"+ response_data[i].lastName +
                                "</td><td>"+ response_data[i].username  +"</td><td>"+response_data[i].enabled
                                +"</td><td>"+ response_data[i].authorities[0].authority + "</td></tr>");
                    }
                } else {
                    $("#res").html("");
                }
            }
        });
    }
</script>
</#macro>