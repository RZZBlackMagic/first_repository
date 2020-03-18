<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>这是一个充满了妥协的考勤网</title>
    <style>
        * {
    box-sizing: border-box;}
body {
    margin:0;
    padding:0;
    width:100%;
    font-family:Helvetica,Arial,sans-serif;
    text-rendering:optimizeLegibility;
}

h1, h2, h3, h4, h5, h6, p, a, li, span, div, input, button, label, form {
    font-family: Hiragino Sans GB, STHeiti, Microsoft Yahei, sans-serif !important;
}

header {
    background-color: #fff;
    width: 100%;
    z-index: 10;
    padding: 20px;
}
header .left-header{
    float:left;
}
header .logo{
    height: 50px;
} 

header .right-header{
    float:right;
    line-height: 50px;
}
header .right-header .download{
    margin-right: 40px;
    padding: 0;
    border: none;
    text-decoration: none;
    color: #848484;
}
header .right-header .signup{
    margin-right: 40px;
    margin-left: 40px;
    padding: 0;
    border: none;
    text-decoration: none;
    color: #848484;
}

#slogan {
    text-align: center;
    overflow: hidden;
    width: 100%;
    padding-top: 60px;
    padding-bottom: 40px;
}

#slogan .mainSlogan {
    font-size: 50px;
    text-align: center;
    color: #333333;
    font-family: HiraginoSansGB-W6 !important;
}
#slogan span {
    color: #0d669b !important;
}
#slogan .subSlogan{
    font-size: 18px;
    margin-top: 10px;
}

#login{
    text-align: center;
    overflow: hidden;
    width: 25%;
    margin: auto;
}
#login #phoneNumber{
    width: 100%;
    height: 53px;
    border-radius: 5px;
    background-color: #eff2f3;
    margin-top: 14.5px;
    padding-left: 15px;
    border: none;
}
#login #password{
    width: 100%;
    height: 53px;
    border-radius: 5px;
    background-color: #eff2f3;
    margin-top: 14.5px;
    padding-left: 15px;
    border: none;
}
#login .status{
    height: 20px;
    vertical-align: middle;
    margin-top: 14.5px;
}
#login button{
    width: 100%;
    height: 53px;
    border-radius: 5px;
    background-color: #0d669b;
    color: #fff;
    font-size: 1rem;
    margin-top: 14.5px;
    border: none;
}

footer .container{
    margin-top: 30px;
    text-align: left;
    background: #f0f0f0;
    padding: 20px 0 24px;
    font-size: 12px;
}
footer ul{
    list-style-type: none;
}
footer p{
    padding-left: 40px;
}
    </style>
</head>

<body>
    <!--描述：header部分-->
    <header>
        <div class="left-header">
            <img src="<%=basePath%>/images/logo01.jpg" class="logo" >
        </div>

        <div class="right-header">
            <!-- <a href="#" class="download">下载</a> -->
            <a href="/mongod/signup" class="signup">注册</a>
        </div>
    </header>
    <!--描述：header部分-->
    
    <!--描述：nav部分-->
    <!--描述：nav部分-->

    <!--描述：slogan部分-->
    <div id="slogan">  
        <div class="mainSlogan">这是一个</div>
        <div class="mainSlogan">
            <span>考勤</span>网站
        </div >
        <div class="subSlogan">赶快登陆获取你的考勤信息吧！</div>
    </div>
    <!--描述：slogan部分-->
    
    <!--描述：login部分-->
    <div id="login">
        <form action="loginUser">
            <div>
                <input id="phoneNumber" type="text" placeholder="用户名" required name="username">
            </div>
            <div>
                <input id="password" type="password" placeholder="密码" required name="password">
            </div>
            <div class="status">
                <input id="teacher" type="radio" name="status" value="teacher" checked>老师
                <input id="student" type="radio" name="status" value="student">学生
                <input id="parent" type="radio" name="status" value="parent">家长
            </div>
            <div>
                <button type="submit">点击登陆</button>
            </div>
        </form>
    </div>
    <!--描述：signup部分-->

    <!--描述：footer底部内容区-->
    <footer>
        <div class="container">
            <div class="row">
                <ul>
                    <li>特殊链接1</li>
                    <li>特殊链接2</li>
                    <li>特殊链接3</li>
                    <li>特殊链接4</li>
                </ul>
                <p>其他信息和声明</p>
            </div>
            <div class="row">

            </div>
        </div>
    </footer>
    <!--描述：footer底部内容区-->

</body>
</html>