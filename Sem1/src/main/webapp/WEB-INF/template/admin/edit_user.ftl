<#include "../templates/template.ftl">
<@mainTemplate title="Edit user ${user.getId()}" body = "class='nav-md'"/>
<#macro m_body>
<div class="container body">
    <div class="main_container">
        <#include "../templates/template_admin.ftl">
        <div class="right_col" role="main">
            <div class="">
                <div class="row">
                    <div class="col-md-6 col-xs-12">
                        <div class="x_panel" style="margin-left: 50pt">
                            <div class="x_title">
                                <h2>Редактировать пользователя</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br/>
                                <form action="/edit_user/${user_id.getId()}" method="post"
                                      class="form-horizontal form-label-left input_mask">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input name="firstName" class="form-control has-feedback-left"
                                               readonly="readonly" value="${user_id.getFirstName()}"/>
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input name="lastName" readonly="readonly" class="form-control"
                                               value="${user_id.getLastName()}"/>
                                        <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input name="email" readonly="readonly" class="form-control has-feedback-left"
                                               value="${user_id.getLogin()}"/>
                                        <span class="fa fa-envelope form-control-feedback left"
                                              aria-hidden="true"></span>
                                    </div>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input name="number" class="form-control" value="${user_id.getNumber()}"
                                               readonly="readonly"/>
                                        <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">role</label>
                                        <select name="role" class="form-control">
                                            <option value="ROLE_ADMIN" <#if user_id.getRole()=="ROLE_ADMIN">selected</#if>>
                                                ROLE_ADMIN
                                            </option>
                                            <option value="ROLE_USER" <#if user_id.getRole()=="ROLE_USER">selected</#if>>
                                                ROLE_USER
                                            </option>
                                            <option value="ROLE_OPERATOR" <#if user_id.getRole()=="ROLE_OPERATOR">selected</#if>>
                                                ROLE_OPERATOR
                                            </option>
                                        </select>
                                    </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Disabled Input </label>
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <select name="enabled" class="form-control">
                                        <option value="true" <#if user_id.isEnabled()==true>selected</#if>>enable</option>
                                        <option value="false" <#if user_id.isEnabled()==false>selected</#if>>
                                            ban<span class="fa fa-ban"></span></option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                    <button type="submit" class="btn btn-success">Изменить</button>
                                </div>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>