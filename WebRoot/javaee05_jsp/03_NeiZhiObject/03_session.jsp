<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<%-- 在转发和重定向情况下，session域不会销毁 --%>
  <body>
	<%
		session.setAttribute("name","杰克");
		
		//转发到result.jsp页面，相对路径~
		request
			.getRequestDispatcher("03_session_result.jsp")
			.forward(request,response);
		
		//重定向到result.jsp页面
		//response.sendRedirect("/CZBK_WEB/jsp/03_NeiZhiObject/10_session_result.jsp");	
	%>  	
		
  </body>
</html>
