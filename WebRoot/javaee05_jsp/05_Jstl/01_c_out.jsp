<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="javaee05_Jsp.temp.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>c:out </title>
  </head>
  
  	<%
		Address address = new Address();
		address.setLocation("广州");
		User user = new User();
		user.setUsername("思思");
		user.setAddress(address);
		request.setAttribute("user", user);
	 %>
  
  <body> 
		地址:  <c:out value="${user.address.location}"/>								<br>	<!-- EL表达式用来取值 -->	
		用户名:<c:out value="${user.username}" default="找不到user.username来这里"/>	<br>	<!-- value:要输出的内容 -->	
		
	           <c:out value="<a href='#'>下载</a>" escapeXml="true"/>	
	       	   <!-- escapeXml：指定是否将><'"等特殊字符进行html编码转换后在进行输出。默认true -->			
  </body>
</html>
