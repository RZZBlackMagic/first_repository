<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>注册页</title>
<link href="<%=basePath%>/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<style type="text/css">
body{
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin{
	max-width: 330px;
	padding:15px;
	margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox{
	margin-bottom: 10px;
}

.form-signin .checkbox{
	font-weight: normal;
}

.form-signin .form-control{
	position: relative;
	height: auto;
	-webkit-box-sizing:border-box;
	   -moz-box-sizing:border-box;
	       box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus{
	z-index: 2;
}

.form-signin input[type="email"]{
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"]{
	margin-bottom: 10px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

</style>
<body>
	<div class="container">
		<form class="form-signin" id="register" method="post" action="insertUser">
			<h2 class="form-signin-heading">注册</h2>
			<label for="inputName" class="sr-only">Name</label>
			<input type="name" name="name" class="form-control" placeholder="Name" required autofocus />
			
			<label for="inputUsername" class="sr-only">Username</label>
			<input type="username" name="username" class="form-control" placeholder="Username" required />
			
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="password" class="form-control" placeholder="Password" required />
		
			<button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
			
		</form>
	
	</div>
</body>
</html>