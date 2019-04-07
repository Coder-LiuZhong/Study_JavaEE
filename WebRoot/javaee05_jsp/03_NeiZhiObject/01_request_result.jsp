<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
    <%!
   		//比较后并返回结果
    	public String guess(int numClient,int numServer){
    		if(numClient < numServer){
    			return "猜小了";
    		}else if(numClient > numServer){
    			return "猜大了";
    		}else{
    			return "中了";
    		}
    	}
    %>
  	<%
  		int numClient = Integer.parseInt(request.getParameter("numClient"));	// 取得客户端猜的数字
   		Random r = new Random();
   		int numServer = r.nextInt(10)+1;			// 随机产生1-10整数，作为服务器猜的
   		
  		String msg = guess(numClient,numServer);	// 调用比较方法 
  		response.getWriter().write("客户数字是：" + numClient + "<br/>");
  		response.getWriter().write("系统数字是：" + numServer + "<br/>");
  		response.getWriter().write("<font color='red'>"+msg+"</font>");
  	%>
  </body>
</html>
