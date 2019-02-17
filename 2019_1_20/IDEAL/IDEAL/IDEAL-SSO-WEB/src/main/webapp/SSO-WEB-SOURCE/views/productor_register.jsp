<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>IDEAL Register</title>
    <meta name="description" content="IDEAL PRODUCTOR注册页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
</head>

<body data-type="login">

<div class="am-g myapp-login">
    <div class="myapp-login-logo-block  tpl-login-max" style="margin-top: 30px">
        <div class="myapp-login-logo-text">
            <div class="myapp-login-logo-text">
                IDEAL-PRODUCTOR<span> Register</span> <i class="am-icon-skyatlas"></i>

            </div>
        </div>

        <div class="login-font">
            <i id="LogIn">Log In </i> or <span id="SignUp"> Sign Up</span>
        </div>
        <div class="am-u-sm-10 login-am-center">
            <form class="am-form" id="form" name="form">
                <fieldset>
                    <div class="am-form-group">
                        <input type="text" class="" id="username" placeholder="用户名">
                    </div>
                    <div class="am-form-group">
                        <input type="password" class="" id="pwd" placeholder="密码">
                    </div>
                    <div class="am-form-group">
                        <input type="text" class="" id="companyzh" placeholder="公司名">
                    </div>
                    <div class="am-form-group">
                        <input type="text" class="" id="mainbusiness" placeholder="主营">
                    </div>
                    <div class="am-form-group">
                        <input type="text" class="" id="type" placeholder="公司类别">
                    </div>
                    <div class="am-form-group">
                        <input type="text" class="" id="employees" placeholder="员工人数">
                    </div>
                    <div class="am-form-group">
                        <input type="text" class="" id="turnover" placeholder="年营业额">
                    </div>
                    <div class="am-form-group">
                        <input type="text" class="" id="phone" placeholder="手机号">
                    </div>
                    <div class="am-form-group">
                        <input type="email" class="" id="email" placeholder="电子邮箱" style="border-radius: 0px 0px 6px 6px">
                    </div>
                    <p><button type="button" class="am-btn am-btn-default" id="submit">注册</button></p>
                </fieldset>
            </form>
        </div>
    </div>
</div>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script>
    $('#submit').click(function() {
        $.ajax({
            type: "post",
            url: "/sso/productor/register",
            data: {
                username: $("#username").val(),
                password: $("#pwd").val(),
                phone:$("#phone").val(),
                email:$("#email").val(),
                companyzh:$("#companyzh").val(),
                mainbusiness:$("#mainbusiness").val(),
                type:$("#type").val(),
                employees:$("#employees").val(),
                turnover:$("#turnover").val()

            },
            dataType: 'JSON',
            success: function (data, status) {
                console.log(data);
                // window.location.href = "http://localhost:8088/productor_login";
            },
            error: function (data) {
                console.log(data);
                alert('注册失败');
            }
        });

    });
    $("#SignUp").click(function () {
        window.location.href = "http://localhost:8088/productor_register";
    });
    $("#LogIn").click(function () {
        window.location.href = "http://localhost:8088/productor_login";
    });

</script>
</body>

</html>