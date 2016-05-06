<#include "../templates/template.ftl">
<@mainTemplate title="редактирование авто" body = "class='nav-md'"/>
<#macro m_body>
<div class="container body">
    <div class="main_container">
        <#include "../templates/template_admin.ftl">
        <div class="right_col" role="main">
            <div class="">
                <div class="row">
                    <div class="col-md-6 col-xs-12">
                        <div class="x_panel" style="margin-left: 100pt; margin-top: 50pt">
                            <div class="x_title">
                                <h2>редактировние авто</h2>
                                <div class="clearfix"></div>
                            </div>
                        <div class="x_content">
                            <br/>
                            <@form.form commandName="carForm" acceptCharset="UTF-8" action="/admin/edit_car/${car.getId()}" method="post"
                            class="form-horizontal form-label-left input_mask">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Производитель</label>
                                    <@form.select path="manufacture" class="form-control has-feedback-left">
                                        <#list manufactures as manufacture>
                                            <@form.option value="${manufacture.getId()}">
                                            ${manufacture.getManufacture()}
                                            </@form.option>
                                        </#list>
                                    </@form.select>
                                    <@form.errors path="manufacture" cssStyle="color: red;" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">модель</label>
                                    <@form.select path="model" class="form-control">
                                        <#list models as model>
                                            <@form.option value="${model.getId()}">
                                            ${model.getModel()} - ${model.getMotor().getType()}
                                                - ${model.getMotor().getHorsepower()} л.с.
                                            </@form.option>
                                        </#list>
                                    </@form.select>
                                    <@form.errors path="model" cssStyle="color: red;" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">цена</label>
                                    <@form.input type="number" path ="price" class="form-control"/>
                                    <@form.errors path="price" cssStyle="color: red;" />
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">коэфицент авто</label>
                                    <@form.input path ="kof" class="form-control"/>
                                    <@form.errors path="kof" cssStyle="color: red;" />
                                </div>
                            </div>
                                <div class="form-group">
                                    <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                        <button type="submit" class="btn btn-success">изменить</button>
                                    </div>
                                </div>
                            </@form.form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>