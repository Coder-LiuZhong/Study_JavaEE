<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	<%
  		// out内置对象的类型是JspWriter,它是一个带有缓冲的PrintWriter对象
  		out.write("先");
		// response内置对象输出
  		response.getWriter().write("后");
  	%>
  </body>
</html>
