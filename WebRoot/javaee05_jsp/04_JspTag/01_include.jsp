<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!-- 
	内置标签jsp:include，可以包含其他jsp页面进来

	内置标签include和指令@include的区别
		标签include是动态包含，执行；把其他JSP运行的结果拿过来放到当前JSP里
			看work文件夹jsp被翻译成servlet后的代码：
				org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/common/head.jsp", out, false);
			其实是一个方法的调用；动态包含，碰到这个方法的时候才去调用执行；
			N张jsp生成N个servlet；总的jsp生成的结构良好
		
		指令@include	是静态包含，翻译；跟其他JSP一起被翻译成servlet
			多个JSP最终会翻译成一个Servlet；JSP引擎只翻译总JSP页面；
			被包含的JSP页面原封不动的进入总JSP页面,造成HTML结构非常混乱
-->

<html>
  <body>
  	<jsp:include page="../common/head.jsp"/>					<hr/>  
  		JSP内置标签：include										<hr/>
  	<jsp:include page="../common/foot.jsp" flush="false"/>		<hr/>
  	
  	<!-- flush="true"先将当前jsp页面的输出输到浏览器后，再加入包含的页面；false(将原新内容同时输到浏览器)(默认) -->
  </body>
</html>
