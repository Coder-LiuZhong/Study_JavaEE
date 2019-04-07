<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
	<%  // PageContext域对象可以将对应的值从指定的四个域对象之一取出和设置
		pageContext.setAttribute("name", "mali");
		pageContext.setAttribute("name", "xixi",pageContext.PAGE_SCOPE);		//	默认就是这个,当前页
		pageContext.setAttribute("name", "trac",pageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "kobe",pageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "camy",pageContext.APPLICATION_SCOPE);		
		
		response.sendRedirect("/CZBK_WEB/jsp/03_NeiZhiObject/16_pageContextValue.jsp");		// 如果报路径错误就把这行删掉，访问之后再粘贴 
		//pageContext.forward("/jsp/03_NeiZhiObject/16_pageContextValue.jsp");
	 %>
	 用户名：<%=pageContext.getAttribute("name") %>
  </body>
</html>
