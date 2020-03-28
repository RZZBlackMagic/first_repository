<%--
  Created by IntelliJ IDEA.
  User: wangze
  Date: 2019-02-27
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>登录页</title>
    <link href="<%=basePath%>/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script>
        $(function(){
            $('a.delete').click(function(){
                $('form').attr('action',$(this).attr('href')).submit();
                return false;
            })
        })

    </script>


</head>
<body>

<h1>实现对user的删改查</h1>
<c:if test="${empty requestScope.userinfo}">
    <h3>没有用户信息</h3>
</c:if>
<c:if test="${!empty requestScope.userinfo}">
<div class="table-responsive">
    <table class="table table-striped table-bordered table-hover table-condensed">
        <tr>

            <th>昵称</th>
            <th>用户名</th>
            <th>密码</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${requestScope.userinfo}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>
                <a href="queryuser/${user.name}" class="update">update</a>
            </td>
            <td>
                <a href="userinfo/${user.name}" class="delete">delete</a>
            </td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="8"><a href="addUser/0">添加用户</a></td>
        </tr>

    </table>
    <form action="" method="post">
        <input type="hidden" name="_method" value="delete" />
    </form>
</div>
</c:if>
</body>
</html>
