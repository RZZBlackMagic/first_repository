<%@page pageEncoding="utf-8" %>
<html>
   <head></head>
   <body>
   <form action="">
       <p>体重：<input type="text" name="weight"/></p>
       <p>身高：<input type="text" name="height"/></p>
       <input type="submit" value="确定"/>
       <p>bmi:<input type="text" value="${result }"/></p>
       </form>
   </body>
</html>