<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>IDEAL</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="assets/toastr/toastr.min.css">
</head>

<body>
<div class="container">
    <div class="info">
        <h1>IDEAL - MERCHANT</h1>
    </div>
</div>
<div class="form">
    <%--<div class="thumbnail"><img src="assets/css/hat.svg"/></div>--%>
    <form class="register-form">
        <input type="text" id="reg-username" placeholder="账户名"/>
        <input type="password" id="reg-pwd" placeholder="密码"/>
        <input type="text" id="reg-email" placeholder="电子邮箱"/>
        <input type="text" id="reg-phone" placeholder="手机">
        <button id="merchant-register">注册</button>
        <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
    <form class="login-form">
        <input type="text" placeholder="公司名" id="login-username"/>
        <input type="password" placeholder="密码" id="login-pwd"/>
        <select id="type" style="width: 100%;border: 0;margin: 0 0 15px;padding: 15px;background: #f2f2f2;border-radius: 3px;box-sizing: border-box;font-size: 14px;appearance:none; -moz-appearance:none; -webkit-appearance:none;">
            <option value="MANAGER">管理员</option>
            <option value="PRODUCT">生产商</option>
            <option value="MERCHANT" selected>代理商</option>
        </select>
        <button id="login" type="button">登陆</button>
        <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
</div>
<script src='assets/js/jquery.min.js'></script>
<script src="assets/toastr/toastr.min.js"></script>
<script src="assets/js/index.js"></script>
<script>
    toastr.options = {
        "closeButton": true, //是否显示关闭按钮
        "debug": false, //是否使用debug模式
        "positionClass": "toast-top-center",//弹出窗的位置
        "showDuration": "300",//显示的动画时间
        "hideDuration": "1000",//消失的动画时间
        "timeOut": "2000", //展现时间
        "extendedTimeOut": "1000",//加长展示时间
        "showEasing": "swing",//显示时的动画缓冲方式
        "hideEasing": "linear",//消失时的动画缓冲方式
        "showMethod": "fadeIn",//显示时的动画方式
        "hideMethod": "fadeOut" //消失时的动画方式
    };
    $('#login').click(function() {
        $.ajax({
            type: "post",
            url: "/sso/login",
            data: {
                username: $("#login-username").val(),
                password: $("#login-pwd").val(),
                type: $("#type").find("option:selected").attr("value")
            },
            dataType: 'JSON',
            success: function (res, status) {
                if (res.status == 400){
                    toastr.error(res.msg);
                }else {
                    toastr.success("登陆成功");
                    window.location.href = "http://localhost:8083/index.html";
                }
            }
        });
    });
    $("#merchant-register").click(function () {
        if ($("#reg-username").val()&&$("#reg-pwd").val()&&$("#reg-phone").val()&&$("#reg-email").val()){
            $.ajax({
                type: "post",
                url: "/sso/merchant/register",
                data: {
                    username: $("#reg-username").val(),
                    password: $("#reg-pwd").val(),
                    phone:$("#reg-phone").val(),
                    email:$("#reg-email").val()
                },
                dataType: 'JSON',
                success: function (res, status) {
                    console.log(res)
                    if (res.status == 400){
                        toastr.error(res.msg);
                    } else if (res.status == 200) {
                        toastr.success("注册成功");
                    } else {
                        toastr.error("参数错误");
                    }
                },
                error: function (data) {
                    toastr.error("注册失败");
                }
            });
        }else {
            toastr.info("所有字段不能为空")
        }

    });
</script>
</body>
</html>
