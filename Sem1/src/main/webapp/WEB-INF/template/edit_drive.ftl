<#ftl/>
<#import "spring.ftl" as spring />
<#include "template.ftl">
<@mainTemplate title="Edit drive" body = "class='nav-md'"/>
<#macro m_body>
<div class="container body">
    <div class="main_container">
        <#include "template_admin.ftl">
        <div class="right_col" role="main">
            <div class="">
                <div class="row">
                    <div class="col-md-6 col-xs-12">
                        <div class="x_panel" style="margin-left: 50pt">
                            <div class="x_title">
                                <h2>Изменеине статуса кредита</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br/>
                                <form action="/operator/edit_drive/${drive.getId()}" method="post"
                                      class="form-horizontal form-label-left input_mask">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input name="firstName" class="form-control has-feedback-left"
                                               readonly="readonly" value="${drive.getName()}"/>
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="date" name="date" class="form-control"
                                               value="${drive.getDate()}"/>
                                        <span class="fa fa-calendar form-control-feedback right" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input name="email" readonly="readonly" class="form-control"
                                               value="${drive.getCar().getManufacture().getManufacture()} -
                                               ${drive.getCar().getModel().getModel()}"/>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input name="id" class="form-control" value="${drive.getNumber()}"
                                               readonly="readonly"/>
                                        <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                                    </div>                                    <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">role</label>
                                    <select name="status" class="form-control">
                                        <#list statuses as status>
                                            <option value="${status.getId()}"
                                                <#if drive.getStatus().getId() == status.getId()> selected</#if> >${status.getStatus()}
                                            </option>
                                        </#list>
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
