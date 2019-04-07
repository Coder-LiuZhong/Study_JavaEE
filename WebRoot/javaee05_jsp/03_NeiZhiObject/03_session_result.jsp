<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	<%
  		String name = (String)session.getAttribute("name");
  		response.getWriter().write("用户名：" + name);
  	%>
  </body>
</html>
