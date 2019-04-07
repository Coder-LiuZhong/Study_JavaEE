<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.*"%>
<%@ page buffer="8kb" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!-- 建议先访问这个文件，然后去Tomcat目录下的works里面找到jsp翻译成的那个servlet代码看看更易懂 -->

<html>
<head>
	<title>jsp声明和注释</title>
</head>
	
  <body>
  	<!--
	  	HTML注释（JSP引擎会将其翻译成servlet内容）       
    -->
    <%-- 
    	JSP注释(写JSP优先推荐使用)	JSP引擎不会理睬这种注释，上面的注释会翻译成servlet
    --%>
	<%!									// jsp声明 ,有感叹号
		String name = "呵呵"; 			// 在HttpJspBase类下面声明方法
	%>  								 
	<%!
		public String getName(){		// 在HttpJspBase类下面声明方法；它下面还有_jspService()
			return name;				// HttpJspBase跟HttpServlet一样，都是继承的servlet，是jsp翻译过来的Servlet
		}
	%>
	<%
		String name = "局部变量";		// 是在JSP翻译成servlet后的_jspService()方法的局部变量，没感叹号
	%>
	
	该实例变量为：<%=getName()%>		<br>
	另外一个：<%=name%>
  </body>
</html>
