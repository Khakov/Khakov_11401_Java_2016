<#include "../templates/user_temp.ftl">
<@mainTemplate title="credit" body = "class='nav'"/>
<#macro m_body>
<div class="right_col" role="main">
    <div class="">
        <div class="row">
            <div class="col-md-6 col-xs-12">
                <div class="x_panel" style="margin-left: 100pt; margin-top: 50pt">
                    <div class="x_title">
                        <h2>Предзаказ авто</h2>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <br/>
                        <form action="/add_my_car" method="post"
                              class="form-horizontal form-label-left input_mask">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Желаемый цвет авто</label>
                                <select name="color" class="form-control">
                                    <#list colors as color>
                                        <option value="${color.getId()}" style="background-color: ${color.getColorEn()}">
                                        ${color.getColorRu()}</option>
                                    </#list>
                                </select>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">Желаемое авто</label>
                                <select name="car" class="form-control">
                                    <#list cars as car>
                                        <option value="${car.getId()}">
                                        ${car.getManufacture().getManufacture()} ${car.getModel().getModel()} -
                                        ${car.getModel().getMotor().getType()}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">выбрать опции</label>
                                <#list attributes as attribute>
                                    <input type="checkbox" name="attribute${attribute.getId()}"/>
                                <i>${attribute.getName()}</i> (${attribute.getDescription()})<br>
                                </#list>
                            </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                            <button type="submit" class="btn btn-success">Подать заявку</button>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>