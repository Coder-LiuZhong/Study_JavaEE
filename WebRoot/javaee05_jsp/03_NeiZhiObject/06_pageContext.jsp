<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  	<%	
  		//能够取得其它8个内置对象
  		//HttpServletRequest requestCopy = (HttpServletRequest)pageContext.getRequest();
		//JspWriter outCopy = pageContext.getOut();
		//String ip = requestCopy.getRemoteAddr();
		//outCopy.write("你是IP是：" + ip);
		
		//具有转发和包含的功能 
		pageContext.forward("/jsp/03_NeiZhiObject/13_out.jsp");
  	%>
  </body>
</html>
