<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  <%
  		pageContext.removeAttribute("name", PageContext.SESSION_SCOPE);
   %>
	用户名：<%=pageContext.getAttribute("name") %>	<br>
	用户名：<%=request.getAttribute("name") %>		<br>
	用户名：<%=session.getAttribute("name") %>		<br>
	用户名：<%=pageContext.getAttribute("name",PageContext.APPLICATION_SCOPE) %>		<br>
  </body>
</html>
