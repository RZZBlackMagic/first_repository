<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>IDEAL Login</title>
  <meta name="description" content="IDEAL登陆页面">
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

<body data-type="login" >

  <div class="am-g myapp-login">
	<div class="myapp-login-logo-block  tpl-login-max" style="margin-top: 200px">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				IDEAL<span> Login</span> <i class="am-icon-skyatlas"></i>
				
			</div>
		</div>

		<div class="login-font">
			<i id="LogIn">Log In </i> or <span id="SignUp"> Sign Up</span>
		</div>
		<div class="am-u-sm-10 login-am-center">
			<form class="am-form">
				<fieldset>
					<div class="am-form-group">
						<input type="text" class="" id="username" placeholder="用户名">
					</div>
					<div class="am-form-group">
						<input type="password" class="" id="pwd" placeholder="密码">
					</div>
					<p><button type="button" class="am-btn am-btn-default" id="submit">登录</button></p>
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
              url: "/sso/user/login",
              data: {
                  username: $("#username").val(),
                  password: $("#pwd").val()
              },
              dataType: 'JSON',
              success: function (data, status) {
                  console.log(data)
              },
              error: function () {
                  alert('登陆失败');
              }
          });

      });
      $("#SignUp").click(function () {
          window.location.href = "http://localhost:8088/user/register";
      });
      $("#LogIn").click(function () {
          window.location.href = "http://localhost:8088/user/login";
      });
  </script>
</body>

</html>