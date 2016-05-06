<#include "../templates/template.ftl">
<@mainTemplate title="Edit remont" body = "class='nav-md'"/>
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
                                <h2>Изменеине статуса кредита</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br/>
                                <form action="/operator/edit_remont/${remont.getId()}" method="post"
                                      class="form-horizontal form-label-left input_mask">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input name="firstName" class="form-control has-feedback-left"
                                               readonly="readonly" value="${remont.getName()}"/>
                                        <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input type="date" name="date" class="form-control"
                                               value="${remont.getDate()}"/>
                                        <span class="fa fa-calendar form-control-feedback right"
                                              aria-hidden="true"></span>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input name="email" readonly="readonly" class="form-control"
                                               value="${remont.getCar().getManufacture().getManufacture()} -
                                               ${remont.getCar().getModel().getModel()}"/>
                                    </div>

                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                                        <input name="id" class="form-control" value="${remont.getNumber()}"
                                               readonly="readonly"/>
                                        <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                                    </div>
                                    <div class="form-group">
                                        <textarea name="description" class="form-control" readonly="readonly">
                                        ${remont.getDescription()}
                                        </textarea>
                                        <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">role</label>
                                        <select name="status" class="form-control">
                                            <#list results as result>
                                                <option value="${result.getId()}"
                                                    <#if remont.getResult().getId() == result.getId()>
                                                        selected</#if>>${result.getResult()}
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
