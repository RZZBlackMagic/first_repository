<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
   <head>
      <meta charset="utf-8"/>
      <title>JSP案例</title>
   </head>
   <body>
   <!-- 3 JSP 声明 -->
   <%!
   public double bai(double a){
	   return 100*a;
   }
   %>
      <ul>
         <!-- JSP脚本：完整的Java代码 -->
         <%
             for(int i=0;i<10;i++){
          %>
          <!-- JSP表达式 -->
               <li><%=bai(Math.random()) %></li>
          <% 
             }
         %>
      </ul>
      <%@include file="time.jsp" %>>
   </body>
</html>