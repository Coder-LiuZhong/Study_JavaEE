<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<%-- 
	page指令的属性：isErrorPage="true"
		容器会自动创建exception对象，在页面上可以调用exception；	
--%>


<html>
  <body>
		出错了：<%=exception.getMessage()%>
  </body>
</html>
