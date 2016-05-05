<#ftl/>
<#import "spring.ftl" as spring />
<#include "template.ftl">
<@mainTemplate title="Registration" body = "style='background:#F7F7F7'"/>
<#macro m_body>
<div class="">
    <div id="wrapper">
        <div id="login" class="animate form">
            <section class="login_content">
            <@form.form commandName="regForm" action="/registration" acceptCharset="UTF-8" method="post" class="form-horizontal">
                <h1>Create Account</h1>
                <#if error??>
                    <h2 style="text-align: center; color: red">${error}</h2>
                </#if>
                <div>
                    <@form.input path="firstName" class="form-control" placeholder="first name"/>
                    <@form.errors path="firstName" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input name="lastName" path="lastName" placeholder = "last name" class="form-control"/>
                    <@form.errors path="lastName" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input path="phone" class="form-control" placeholder="номер телефона"/>
                    <@form.errors path="phone" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.input path="email" class="form-control" placeholder = "Email"/>
                    <@form.errors path="email" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.password path="password" class="form-control" placeholder="Password"/>
                    <@form.errors path="password" cssStyle="color: red;" />
                </div>
                <div>
                    <@form.password path="confirmPassword" class="form-control" placeholder="confirm password"/>
                    <@form.errors path="confirmPassword" cssStyle="color: red;" />
                </div>
                <div>
                    <input type="submit" class="btn btn-default submit" value="Регистрация">
                </div>
                <div class="clearfix"></div>
                <div class="separator">
                    <div class="clearfix"></div>
                    <br/>
                    <div>
                        <h1><i class="fa fa-car" style="font-size: 26px;"></i> Audi Autosalon</h1>
                        <p>©2015 All Rights Reserved. khan☺ </p>
                    </div>
                </div>
            </@form.form>
            </section>
        </div>
    </div>
</#macro>
