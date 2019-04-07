<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="javaee05_Jsp.temp.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>c:catch捕获异常，用一个变量表示异常</title>
  </head>
  	
  <body> 
	<c:catch var="myException">
	  	<%
			Integer.parseInt("abc");	  	
	  	%>
	</c:catch>
	
	错误原因：<c:out value="${myException}"></c:out>
  </body>
</html>
