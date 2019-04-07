<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page errorPage="a_page_03_isErrorPage.jsp" %>		
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%--
	page指令的属性：errorPage="xxx.jsp"  
		如果页面有错误就会抛出异常，转到指定错误页面去处理异常。 属于局部的异常处理 
		路径是相对路径
--%>

<html>
  <body>
  	<%
  		Integer.parseInt("abc");		// 有错，会抛出异常 
  	 %>
  </body>
</html>
