<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>EL进行运算</title>
</head>

<!-- 这部分没什么看的，知道EL表达式里面可以做运算就行了 -->

  <body>
	10+3=${10+3}<br/>				<!-- 算数运算：true -->
	10-3=${10-3}<br/>
	10*3=${10*3}<br/>
	10/3=${10/3}<br/>
	<hr/>
	10>3=${10>3}<br/>				<!-- 关系运算：true -->
	10>=3=${10>=3}<br/>
	10<3=${10<=3}<br/>				<!-- 尽可能不用小于号，用转义字符&lt; -->
	10<=3=${10<=3}<br/>
	10==3=${10==3}<br/>
	10!=3=${10!=3}<br/>
	<hr/>
	true&&false=${true && false}<br/>		<!-- 逻辑运算：true -->
	true&&true=${true && true}<br/>
	false&&false=${false && false}<br/>
	<hr/>
	true||false=${true || false}<br/>
	true||true=${true || true}<br/>
	false||false=${false || false}<br/>		<!-- 没有|这种短路的情况 -->
	<hr/>
	!false=${!false}<br/>
	!true=${!true}<br/>
	<hr/>
	
	<c:set var="username" value="杰克" scope="session"/>			<!-- 私有信息一般放在session中 -->
	<c:remove var="username" scope="session"/>
	<%--
		session.invalidate();	// 这也是去掉session
	--%>	
	欢迎${!empty username?username:'游客'}光临				<!-- empty运算符和两元运算符 -->
	
</body>
</html>
