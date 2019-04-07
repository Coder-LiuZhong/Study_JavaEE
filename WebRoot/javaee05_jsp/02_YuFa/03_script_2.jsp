<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>jsp脚本进行for循环</title>
</head>

  <body>
  	<%-- 循环输出 --%>
  	<%
		for(int i=1;i<=6;i++){
	%>	
			<h<%=i%>>JavaWebGood!</h<%=i%>>
	<%			
		}
	 %>
	 <hr/>
	 <%
	 	String name = "喜喜";
	 %>
	 用户名：<font color=""><%=name%> 	 
  </body>
</html>
