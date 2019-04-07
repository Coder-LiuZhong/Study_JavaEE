<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 
	@include指令[静态包含]
		把指定页面包含进本jsp页面；	先包含再编译成servlet，跟行为那个相反
		看Tomcat的work文件夹，JSP翻译成的servlet代码可以发现：
			out.write("  \thead.jsp\r\n");
			out.write("  \tfoot.jsp\r\n");
		说明，包含进来的只是一个指向；
		    include指令包含多个JSP页面，最后JSP引擎只翻译总JSP页面,即index.jsp页面；
		    include指令包含多个JSP页面，那么被包含的JSP页面原封不动的进入总JSP页面,即index.jsp页面，造成HTML结构非常混乱
	        include指令包含多个JSP页面，多个JSP最终会翻译成一个Servlet，即index_jsp.java页面
--> 
<html>
  <body>
	<%@ include file="../common/head.jsp"%>
		<hr/>
			include指令的用法 
		<hr/>
	<%@ include file="../common/foot.jsp"%>
  </body>
</html>

