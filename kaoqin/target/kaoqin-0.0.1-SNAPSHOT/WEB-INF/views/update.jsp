<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<h3>${user.name != null ? '修改用户信息' : '添加用户信息' }</h3>

<form:form action="../update" method="post" modelAttribute="user">
    <c:if test="${user.name != null}">

        <input type="hidden" name="_method" value="put" />


    </c:if>
    昵称：<form:input path="name"/><br/>

    用户名：<form:input path="username"/><br/>
    密码：<form:input path="password"/><br/>


    <input type="submit" value="${user.name != null ? '修改' : '添加' }" />

</form:form>
</body>
</html>
