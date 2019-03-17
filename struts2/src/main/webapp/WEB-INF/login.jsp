<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <c:url var='url' value='/message/login.action'/>
  <form action="${ url}" method="post">
    <div>
      <label>用户：</label>
      <input name="u.username" type="text"/>
      <label>密码：</label>
      <input name="u.password" type="password"/>
      
    </div>
    <button type="submit" value="登录"></button>
  </form>
</body>
</html>