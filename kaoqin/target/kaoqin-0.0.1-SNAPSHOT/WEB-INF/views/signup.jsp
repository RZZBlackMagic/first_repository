<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>注册-考勤网</title>
    <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script>
        function func(){
            var student=$('#userStatus option:eq(1)').val();
            var teacher=$('#userStatus option:eq(2)').val();
            var parent=$('#userStatus option:eq(3)').val();

            if ($('#userStatus option:selected').val() === student){
                $("#userGender").parent().parent().show();
                $("#userUniversity").parent().parent().show();
                $("#userSchool").parent().parent().show();
                $("#userMajor").parent().parent().show();
                $("#userNumber").parent().parent().show();
            }
            else if($('#userStatus option:selected').val() === teacher){
                $("#userGender").parent().parent().show();
                $("#userUniversity").parent().parent().show();
                $("#userSchool").parent().parent().hide();
                $("#userMajor").parent().parent().hide();
                $("#userNumber").parent().parent().hide();
            }
            else if ($('#userStatus option:selected').val() === parent){
                $("#userGender").parent().parent().hide();
                $("#userUniversity").parent().parent().hide();
                $("#userSchool").parent().parent().hide();
                $("#userMajor").parent().parent().hide();
                $("#userNumber").parent().parent().hide();
            } 
        }

    </script>
    <style>

    body {
        margin:0;
        padding:0;
        width:100%;
        font-family:Helvetica,Arial,sans-serif;
        text-rendering:optimizeLegibility;
        box-sizing: border-box;
    }
    header {
        width: 100%;
        background: #fff;
    }
    header::after{
        content:'';clear:both;display: block;
    }
    header .left-header{
        /* background-color: #fff; */
        padding: 20px;
        float: left;
    }
    header .logo{
        height: 50px;
    }
    header .center-header{
        height:50px;
        padding: 20px;
        padding-left: 380px;
        float:left;
        text-align: center;
        line-height: 50px;
    }
    header span{
        font-size: 1.5rem;
        color: #0d669b;
        /* font-weight: bold; */
    }
    header .right-header{
        height:50px;
        padding: 20px 100px;
        float: right;
        text-align: center;
        line-height: 50px;
    }
    header .right-header .login{
        font-size: 1rem;
        color: #848484;
        text-decoration: none;
    }
    #submit {
        padding: 40px 0px;
    }
    #submit .submit-box{
        width: 100%;
        margin-top: 20px;
        height: 40px;
    }
    #submit label{
        float: left;
        padding-left:450px;
        padding-right: 100px;
        line-height: 40px;
        width:100px;
    }
    #submit input{
        width: 20%;
        height: 40px;
        border-radius: 5px;
        background-color: #eff2f3;
        padding-left: 15px;
        border: none;
    }
    #submit select{
        width: 21%;
        height: 40px;
        border-radius: 5px;
        background-color: #eff2f3;
        padding-left: 15px;
        border: none;
    }
    /* #submit .submit-botton{
        width: 100%;
        margin-top: 30px;
    } */
    #submit button {
        display: block;
        margin: 30px auto 0px auto;
        text-align: center;
        line-height: 50px;
        width: 10%;
        border-radius: 5px;
        font-size: 1rem;
        border: none;
        background-color: #0d669b;
        color: white;
        cursor: pointer;
    }
    #submit .login-words{
        text-align: center;
        font-size: 0.8rem;
        text-decoration: none;
        color: #848484;
    }
    </style>
</head>



<body>
    <header>
        <div class="left-header">
            <img src="<%=basePath%>/images/logo01.jpg" class="logo" >
        </div>
        <div class="center-header">
            <span>用</span>
            <span>户</span>
            <span>注</span>
            <span>册</span>
        </div>
        <div class="right-header">
            <a href="/mongod/index" class="login">登陆</a>
        </div>
    </header>



    <div id="submit">
        <form action="signupUser" method="post">

            <div class="submit-box">
                <label for="userStatus">身份</label>
                <div>
                    <select name="userStatus" id="userStatus" required onchange="func()">
                        <option selected disabled>请选择您的身份</option>
                        <option value="student">学生</option>
                        <option value="teacher">老师</option>
                        <option value="parent">家长</option>
                    </select>
                </div>
            </div>

            <div class="submit-box">
                <label for="username">用户名</label>
                <div>
                    <input type="text" id="username" name="username" placeholder="请输入用户名" required>
                </div>
            </div>
                        
            <div class="submit-box">
                <label for="userEmail">真实姓名</label>
                <div>
                    <input type="text" id="userRealname" name="userRealname" placeholder="请输入您的真实姓名" required>
                </div>
            </div>

            
            <div class="submit-box">
                <label for="userPhone">手机号码</label>
                <div>
                    <input type="text" id="userPhone" name="userPhone" placeholder="请输入您的手机号码" required>
                </div>
            </div>
            
            <div class="submit-box">
                <label for="userPassword">密码</label>
                <div>
                    <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required>
                </div>
            </div>
            
            <div class="submit-box">
                <label for="userRePassword">确认密码</label>
                <div>
                    <input type="password" id="userRePassword" name="userRePassword" placeholder="请重复输入密码" required>
                </div>
            </div>
            
            <div class="submit-box">
                <label for="userGender">性别</label>
                <div>
                    <select name="userGender" id="userGender" required>
                        <option value="man" selected>男</option>
                        <option value="woman">女</option>
                    </select>
                </div>
            </div>
            
            <div class="submit-box">
                <label for="userUniversity">所在学校</label>
                <div>
                    <input type="text" id="userUniversity" name="userUniversity" placeholder="学校全称" >
                </div>
            </div>

            <div class="submit-box">
                <label for="userSchool">所在学院</label>
                <div>
                    <input type="text" id="userSchool" name="userSchool" placeholder="学院全称" >
                </div>
            </div>

            <div class="submit-box">
                <label for="userMajor">所在专业</label>
                <div>
                    <input type="text" id="userMajor" name="userMajor" placeholder="专业全称" >
                </div>
            </div>

            <div class="submit-box">
                <label for="userNumber">学号</label>
                <div>
                    <input type="text" id="userNumber" name="userNumber" placeholder="学生学号" >
                </div>
            </div>

            <div>
                <button type="submit">注册</button>
            </div>
            
            <div class="login-words">
                <a href="/mongod/index">已有账号？去登录</a>
            </div>
        </form>
    </div>
</body>
</html>