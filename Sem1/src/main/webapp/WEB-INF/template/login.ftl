<#include "templates/template.ftl">
<@mainTemplate title="Log in" body = "style='background:#F7F7F7'"/>
<#macro m_body>
<div id="wrapper">
    <div id="login" class="animate form">
        <section class="login_content">
            <form id="loginForm" action="/j_spring_security_check" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <h1>Login Form</h1>
                <div>
                    <input type="text" class="form-control" placeholder="Username" name="j_username"/>
                </div>
                <div>
                    <input type="password" class="form-control" placeholder="Password" name="j_password"/>
                </div>
                <div>
                    <input name="remember_me" type="checkbox"/>
                    <label for="remember_me" class="inline">Запомнить меня</label>
                </div>
                <div>
                    <input type="submit" class="btn btn-default submit" value="Log in"/>
                </div>
                <div class="clearfix"></div>
                <div class="separator">

                    <p class="change_link">Впервые на нашем сайте?
                        <a href="/registration" class="to_register"><i class="fa fa-registered"></i>Зарегестрироваться</a>
                    </p>
                    <div class="clearfix"></div>
                    <br/>
                    <div>
                        <h1><i class="fa fa-car" style="font-size: 26px;"></i> Audi Autosalon</h1>

                        <p>©2016 All Rights Reserved.</p>
                    </div>
                </div>
            </form>
            <!-- form -->
        </section>
    </div>
</div>
</#macro>