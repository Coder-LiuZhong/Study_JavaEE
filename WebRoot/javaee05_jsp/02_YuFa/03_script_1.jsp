<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>jsp脚本</title>
</head>

  <body>
  	<%="这是JSP的脚本输出表达式"%>
  	<hr/>
  	10000以内的随机数是：<%=new Random().nextInt(1000)%>
  	<hr/>
  	<%	
  		//以下代码是JSP的脚本片段
  		Random r = new Random();
  		double num = r.nextDouble();
  	%>
  	Double随机数是：<%=num%><br/>
  </body>
</html>
