<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.net.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!-- 
	jsp:forward
		跳转去指定页面；转向的是相对路径；
		
	jsp:param
		去指定页面带上参数，看servlet代码相当于Get方式一样在链接后面接上；
-->

<html>
  <body>
  	<!-- Get方式传递中文乱码得用到java.net.URLEncoder编码 -->
	<jsp:forward page="xxx.jsp">
		<jsp:param name='uname' value='<%=URLEncoder.encode("杰克","UTF-8")%>'/>		
		<jsp:param name='pass' value='123'/>
	</jsp:forward>
	<!-- 另外一个页面接收通过解码： name = URLDecoder.decode(name, "UTF-8")  URLDecoder解码，注意不是URLEncoder-->
	
	<%-- <jsp:forward page="javaee05_jsp/04_JspTag/02_forward_to.jsp" /> --%>		<%-- 绝对路径、单行不带参数形式 --%>	
  </body>
</html>