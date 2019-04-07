<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="javaee05_Jsp.temp.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>c:remove删除</title>
  </head>
  	
  	<%
		session.setAttribute("username", "杰克");		// 加入session域
	 %> 
  	
  <body> 
	 <c:remove var="username" scope="session"/>
	 <c:out value="${username}" default="无名" />
  </body>
</html>
