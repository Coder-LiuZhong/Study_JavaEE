<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%-- 
	在jsp中处理异常有三种方式
		局部异常用page标签的属性errorPage
		全局异常在xml设置好
		另外在JSP脚本中写trycatch也是一种异常处理方式
			
       在web.xml文件(属于全局异常处理,局部优先)：					
 		<error-page>
			<error-code>500</error-code>				页面异常，异常代码是500，就返回到指定页面
			<location>/s1_500.jsp</location>		
 		</error-page>	
    	<error-page>									页面异常，异常类型是java.lang.NumberFormatException，就跳转到指定页面
			<exception-type>java.lang.NumberFormatException</exception-type>
        	<location>/s2_500.jsp</location>			如果全局中有code又有type，此时二者同时显示；
		</error-page>	
--%>

<html>
  <body>
  	<%
  		Integer.parseInt("abc");	// 报错，抛出异常，这里没有设置局部异常处理，就会去xml文件中找对应的处理，然后跳转到指定页面
  	 %>
  </body>
</html>
