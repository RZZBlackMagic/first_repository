<%@page pageEncoding="utf-8" import="empDAO.*,java.util.*"%>
<!doctype html>
<html>
  <head>
     <meta charset="utf-8">
     <title>emp</title>
     <style type="text/css">
        table{
           border:1px solid red;
           border-collapse:collapse;
        }
        td{
           border:1px solid red;
        }
     </style>
  </head>
  <body>
    <table>
      <tr>
        <td>姓名</td>
        <td>学号</td>
        <td>性别</td>
        <td>成绩</td>
      </tr>
      <%
        DAO d = new DAO();
        List<emp> list = d.findAll();
        for(emp e:list){
      %>
         <tr>
            <td><%=e.getName() %></td>
            <td><%=e.getStu() %></td>
            <td><%=e.getSex() %></td>
            <td><%=e.getScore() %></td>
         </tr>
      <% 
        }
      %>
    </table>
  </body>
</html>