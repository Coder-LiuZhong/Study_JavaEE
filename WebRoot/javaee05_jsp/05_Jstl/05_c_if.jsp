<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="javaee05_Jsp.temp.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>c:if</title>
  </head>
  <body> 
  
  	<!-- test就看EL表达式是否true；结果赋值给condition；scopes把condition放到指定域  -->
	<c:if var="condition" test="${10>5}" scope="request">    
		10大于5
	</c:if>		
	
	<jsp:forward page="/javaee05_jsp/06_Jstl/05_c_if_value.jsp"></jsp:forward>
  </body>
</html>
