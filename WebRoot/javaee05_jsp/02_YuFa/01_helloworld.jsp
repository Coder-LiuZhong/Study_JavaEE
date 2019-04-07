<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!-- 
	JSP的作用	
		HTML是静态的，JSP是动态；JSP可以在页面里面写java代码；
-->

<html>
<head>
	<title>JSP输出</title>
</head>
<body>
	<font size="44" color="red">
		当前时间：<%= new Date().toLocaleString()%>			
	</font>													
</body>														
</html>														
