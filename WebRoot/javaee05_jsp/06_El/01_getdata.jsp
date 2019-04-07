<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>EL获取数据</title>
</head>

  <%-- EL表达式的主要作用：可以从四个域里面取到数据，然后显示在JSP里面 --%>
		
  <body>
  	<!-- 普通变量 -->
	<c:set var="username" value="jack" scope="page"/>	<!-- usename赋值放进page域对象 -->
	用户名：${username}	<br>							<!-- 依次在page、request、session、application四个域里面找usename显示；没有就空白字符串 -->
	
		
	<!-- 数组 -->
	<%
		int[] intArray = {10,20,30};
		pageContext.setAttribute("intArray",intArray);
	%>
	数组第一个元素值为：${pageScope.intArray[0]}	<br>	<!-- 指定域对象pageScope里面找intArray -->	
	

	<!-- javabean -->
	<jsp:useBean id="user" class="javaee05_Jsp.temp.User" scope="page"/>	<!-- javaBean对象放到page作用域 -->	
	<c:set target="${user}" property="username" value="marry"/>				<!-- 四个域里找到user对象，给属性username赋值 -->	
	<c:set target="${user}" property="age" value="22"/>		 				<!-- 会自动把字符转为int类型 -->
	用户名: ${user.username} <br>
	年龄:   ${user.age}		 <br>
	
	
	<!-- Collection -->
	<jsp:useBean id="map" class="java.util.LinkedHashMap" scope="page"/>
	<c:set target="${map}" property="key"   value="one"/>
	<c:set target="${map}" property="value" value="jack"/>
	<c:set target="${map}" property="key"   value="two"/>	 <!-- 这样会把上面的覆盖，而不是像集合都放在里面了 -->
	<c:set target="${map}" property="value" value="rose"/>
	第一个元素的key值：${map.key}		<br>
	第一个元素的value值：${map.value}	<br>
	
	<%	
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		request.setAttribute("LIST",list);			// 放进request域对象
	%>
	集合中第二个元素：${LIST[1]}	<br>				<!-- 域对象里找到LIST，输出第二个对象 -->
	
 </body>
</html>
