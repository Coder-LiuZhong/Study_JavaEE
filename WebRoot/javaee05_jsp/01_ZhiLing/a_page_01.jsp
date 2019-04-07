<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <body>
  		JSP指令
			告诉JSP引擎如何处理JSP页面中除了显示输出外的其余部分。指令是程序员控制JSP引擎做什么的依据;
    		JSP指令（directive）是为JSP引擎而设计的，它们并不直接产生任何可见输出;
    		
    	JSP三大指令
    		@page   @include	@tablib(后面会讲，导入标签库)
    		
    	page指令的属性
	    	language				当前JSP文件支持的语言，默认为java语言；就是说可以在里面写java代码
	       	import					当前JSP页面中，需要导入的包，其中import可以写多次；一般不用手动导，快捷键就行;
	      	pageEncoding="UTF-8" 	JSP页面的中文采用UTF-8方式编码；
	      						    JSP保存时采用UTF-8方式编码；
      						       	告诉浏览器以UTF-8方式查看;(前提是在IDE工具中，才有三种意思)
      						       	
      	指令可以把属性分开多行显示，也可以把属性写在一行				
      	
      	以下page属性基本默认就行，了解即可	       	
	        session="true"			false不需要服务器创建session"  /  true表示需要服务器创建session，默认true; 
 									jsp翻译后的java文件，里面会有getSession()； 在页面上就可以调用session
	 		isELIgnored="false"		false表法JSP引擎不忽略EL表达式语言   /  true表法JSP引擎忽略EL表达式语言"    
			buffer="8kb"			JSP输出使用的缓存大小，默认8kb（jsp请求后输出，它先在tomcat一个缓冲区中去，缓冲区满了就会输出，或者这个jsp缓冲完了就输出）
			autoFlush="true"        true表示当缓存满时，web容器是自动刷新到客户端 / false需要手工刷新到客户端"，默认true
	        isThreadSafe="true"     true表示web服务器确保线程安全  / false不确保线程安全	默认true;就是容器给你加锁；
			info="text"				表示jsp的相关描述信息，可以通过getServletInfo()取得该jsp的信息
		    contentType="text/html;charset=UTF-8"		告诉浏览器我是什么内容类型，以及使用什么编码
  </body>
</html>
