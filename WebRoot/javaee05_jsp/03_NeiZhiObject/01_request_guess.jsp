<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<!-- 
	request对象
		request.getParameter("numClient")
    	request.getRequestDispatcher("10_session_result.jsp").forward(request,response);
-->

<html>
  <body>
  	<form action="/CZBK_WEB/javaee05_jsp/03_NeiZhiObject/01_request_result.jsp" method="post">
  		输入数字：<input size="1" type="text" name="numClient"/>[1-10之间的整数]
  		<br/>
  		<input type="submit" value="我猜"/>
  	</form>
  </body>
</html>
