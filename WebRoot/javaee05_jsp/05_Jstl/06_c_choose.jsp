<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>c:choose</title>
  </head>
  <body>
  	<%-- 
  		http://...?age=15 
  		param：EL的内置对象，代表请求参数
  	--%>
  	<c:set var="age" value="${param.age}" scope="page"/>
  	<c:choose>
		<c:when test="${age<16}">
			你未成年
		</c:when>
		<c:otherwise>
			你已成年
		</c:otherwise>  	
  	</c:choose>	
  </body>
</html>
