<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="javaee05_Jsp.temp.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	
  <head>
  	<title>c:forEach 迭代</title>
  </head>
  <body>
	<%
		List<Student> list =new ArrayList<Student>();
		list.add(new Student());
		list.add(new Student());
		list.add(new Student());
		pageContext.setAttribute("list", list);
	%>
	<c:forEach var="user" items="${list}">
		${user.name } ----${user.age }
	</c:forEach>
  </body>
</html>
