<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
	<%
		// 其实就是servlet里的ServletContext域 ，被整个项目共享
		application.setAttribute("name","jack");
		application.removeAttribute("name");
		String name = (String)application.getAttribute("name");
		if(name!=null){
			response.getWriter().write("用户名："+name);
		}else{
			response.getWriter().write("用户名："+name);
		}
	%>
  </body>
</html>
