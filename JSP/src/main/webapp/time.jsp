<!-- pageEncoding :声明此JSP文件的编码
     contentType：
      -->
<%@page pageEncoding="utf-8" contentType="text/html" import="java.util.*,java.text.*"%>
<%
   Date d = new Date();
   SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
   String time = sdf.format(d);
%>
<p>
<%=time
%>
</p>