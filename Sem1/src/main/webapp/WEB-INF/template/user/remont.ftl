<#include "../templates/user_temp.ftl">
<@mainTemplate title="Ремонт авто" body = "class='nav'"/>
<#macro m_body>
<div class="right_col" role="main">
    <div class="">
        <div class="row">
            <div class="col-md-6 col-xs-12">
                <div class="x_panel" style="margin-left: 100pt; margin-top: 50pt">
                    <div class="x_title">
                        <h2>Заявка на кредит</h2>
                        <div class="clearfix"></div>
                    </div>
                <div class="x_content">
                    <br/>
                    <@form.form commandName="remontForm" acceptCharset="UTF-8" action="/remont" method="post"
                    class="form-horizontal form-label-left input_mask">
                    <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->

                        <div class="form-group has-feedback">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Введите ваше имя</label>
                            <@form.input path="firstName" class="form-control has-feedback-left"/>
                            <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                            <@form.errors path="firstName" cssStyle="color: red;" />
                        </div>
                        <div class="form-group has-feedback">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Ваш телефон</label>
                            <@form.input path="number" class="form-control"/>
                            <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                            <@form.errors path="number" cssStyle="color: red;" />
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">Производитель</label>
                            <@form.select path ="id" class="form-control">
                                <#list cars as car>
                                    <#if (car_id?? && car.getId() = car_id.getId())>
                                        <@form.option value= "${car.getId()}" selected = "selected">
                                        ${car.getManufacture().getManufacture()} ${car.getModel().getModel()} -
                                        ${car.getModel().getMotor().getType()}
                                        </@form.option>
                                    <#else>
                                        <@form.option value="${car.getId()}">
                                        ${car.getManufacture().getManufacture()} ${car.getModel().getModel()} -
                                        ${car.getModel().getMotor().getType()}
                                        </@form.option>
                                    </#if>
                                </#list>
                            </@form.select>
                            <@form.errors path="id" cssStyle="color: red;" />
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">тип ремонта</label>
                            <@form.select path ="type" class="form-control">
                                <#list types as type>
                                    <@form.option value="${type.getId()}">
                                    ${type.getType()}</@form.option>
                                </#list>
                            </@form.select>
                            <@form.errors path="type" cssStyle="color: red;" />
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">описание</label>
                            <@form.textarea path ="description" class="form-control" placeholder = "Описание проблемы"/>
                            <@form.errors path="description" cssStyle="color: red;" />
                        </div>
                    </div>
                        <div class="form-group">
                            <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                <button type="submit" class="btn btn-success">Подать заявку</button>
                            </div>
                        </div>
                    </@form.form>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>