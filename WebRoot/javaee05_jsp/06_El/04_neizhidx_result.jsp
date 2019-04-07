<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  		用户名：${param.name}<br/>	
		密码：   ${param.pass}<br/>
		爱好A： ${paramValues.like[0]}
		爱好B： ${paramValues.like[1]}
		爱好C： ${paramValues.like[2]}
	<hr/>
		浏览器相关信息	${ header['User-Agent'] }				
		字符编码			${ headerValues['Accept-Encoding'][0] }	<!-- 多个头（数组，从0开始） -->
	<br/>
	<%--
		Cookie cookie = new Cookie("username","jack");
		cookie.setMaxAge(5*60);
		response.addCookie(cookie);
	--%>
		Cookie的名：${cookie.username.name}<br/>
		Cookie的值：${cookie.username.value}<br/>
  </body>
</html>
