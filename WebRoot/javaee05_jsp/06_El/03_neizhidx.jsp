<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>EL的内置对象</title>
</head>

<%--  11个内置对象
		pageContext				可取到pageContext的实例，除了它其他内置对象都是Map类型		${pageContext.request.contextPath}
		pageScope				可取到page作用域里的数据					${pageScope.username}
		requestScope			可取到request作用域里的数据				${request.username}
		sessionScop				可取到session作用域里的数据				${session.username}
		applicationScope		可取到application作用域里的数据			${application.username}
		header					可取到请求头对象里的信息：				${header['User-Agent']}
		hearderValues			可取到请求头对象里的信息(多个)：			${headerValues['Accept-Encoding'][0]}
		param					可取到GET请求带过来的参数：				${param.name}、${param.pass}
		params					可取到GET请求带过来的参数(存在多个值)：	${paramValues.like[0]}
		cookie					可取到cookie：							${cookie.username.name}
		initParam				可取到全局初始化参数(web.xml里定义的):	${initParam.webName}
--%>

<body>
	Web应用名：<%=request.getContextPath()%> <br>			<!-- JSP的内置对象 -->
	Web应用名：${pageContext.request.contextPath}			<!-- EL的内置对象pageContext -->
	
	<form action="/day17"></form>	<br>					<!-- 以后可以用EL代替了 -->
	<a href="${pageContext.request.contextPath}/.../03_neizhidx_result.jsp?name=berry&pass=123&like=sing&like=dance&like=read">单击</a> <br>
		
	<c:set var="username" value="jack" scope="page"/>	
	<c:set var="username" value="marry" scope="request"/>	
	用户名：${pageScope.username}	<br>				    <!-- 指明去pageScope这个域对象中找,前缀指明哪个域 -->	
	<!-- ${username}相当于pageContext.findAttribute()，从page、request、session、application从四个域对象中找 -->
	
	<!-- initParam对象取xml中的配置的参数 -->
	WebName=${initParam.webName}<br/>
	WebAuthor=${initParam.webAuthor}<br/>
	
</body>
</html>
