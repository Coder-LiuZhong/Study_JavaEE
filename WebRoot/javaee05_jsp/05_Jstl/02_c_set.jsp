<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="javaee05_Jsp.temp.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>c:set</title>
  </head>
  <body> 
	<%-- 
		var username="哈哈";	
		pageContext.setAttribute("username",username);       变量放到page域；scope默认指定到page域
	--%>
	<c:set var="username" value="哈哈" scope="page" />	
	
	
	<%-- 
		EL表达式的作用就是从域中取到值显示；
		${username} 没有指定从哪个域取出，就默认依次从page、request、session、application中找到显示；
		${pageScope.name} 指定从page域里面取name
	--%>
	用户名：<c:out value="${username}"/> <br>				
	
  
	<%-- 
		JavaBean
	--%>
  	<jsp:useBean id="user" class="javaee05_Jsp.temp.User"></jsp:useBean>
  	<jsp:setProperty name="user" property="age" value="18"/>		<!-- JSP标签方式 -->
		年龄：<c:out value="${username}"></c:out>
  	<c:set target="${user}" property="username" value="丁丁" />		<!-- EL表达式取值显示，JSTL标签out输出 -->
  		用户名：<c:out value="${user.username}"></c:out><br>
  	
  	
	<%-- 
		Map
	--%>
  	<jsp:useBean id="map" class="java.util.HashMap" scope="page"></jsp:useBean>
  	<c:set target="${map}" property="key" value="1" />
  	<c:set target="${map}" property="value" value="jack" />
	ID： <c:out value="${map.key}"></c:out>	<br>
	姓名:<c:out value="${map.value}" />
  
  
  	<!-- var: 指定要设置的web域属性的名称 -->
  	<!-- value:指定属性值 -->
  	<!-- scope: 指定属性所在的web域 -->
  	<!-- target: 指定要设置的属性对象，这个对象必须是javabean或者map -->
  	<!-- propety:指定当前要为对象设置的属性名称 -->
  </body>
</html>
