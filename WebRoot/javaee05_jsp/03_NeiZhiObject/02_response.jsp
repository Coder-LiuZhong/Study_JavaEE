<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!--  
	response对象
    	response.getWriter().write("用户名：" + username);
    	response.sendRedirect("/CZBK_WEB/jsp/03_NeiZhiObject/10_session_result.jsp");
    	
    http://www.liuzhong.com:8081/CZBK_WEB/jsp/03_NeiZhiObject/08_response.jsp?username=ss
-->

<html>
  <body>
  	<%
  		request.setCharacterEncoding("UTF-8");					
  		String username = request.getParameter("username");		
  		response.getWriter().write("用户名：" + username);			//使用response对象输出到浏览器
  		/*	
  		中文编码问题
  			因为pageEncoding="UTF-8"告诉浏览器以UTF-8方式查看，所以不用写response.setContentType....
  			在servlet中
  				response.setContentType("text/heml;charset=UTF-8");			// 字符方式输出得提前设置编码
  				response.getWriter().write("美国");
  				response.getOutputStream().write("中国".getBytes("UTF-8"));	//字符串查查UTF-8来转字符数组，不设置就是IOS8859-1;
  			tomcat会自动把流关闭，所以也不需要写close();
  		*/
  	%>
  </body>
</html>
