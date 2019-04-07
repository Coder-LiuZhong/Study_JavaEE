package javaee04_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Response的转发和重定向（面试）
 * 		http://localhost:8080/StudyJavaEE/index.html
 * 		转发：	 
 * 			地址栏还是servlet的请求； 
 * 			请求了服务器一次，服务器内部执行后续操作，返回200；
 * 			只能跳转到自己内部的资源；
 * 			可以使用上一次的request对象
 * 		重定向：  
 * 			地址栏显示为新的地址；	  
 * 			请求了服务器两次，第一次请求后返回302跟一个新地址；
 * 			可以跳转到任意路径，不是自己工程的也可以；
 * 			新的请求了，request不是同一个了；
 * */
public class E03_转发和重定向 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");			// 告诉浏览器以UTF-8方式查看，有中文；
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		if( "admin".equals(userName) && "123".equals(password) ){		
			//重定向写法： 重新定位方向  /根目录 
			//response.sendRedirect("login_success.html");		
			
			//请求转发的写法：
			//request.getRequestDispatcher("login_success.html").forward(request, response); 
		}else{
			response.getWriter().write("登录失败");	
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
