package javaee04_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*	
 * Servlet			是通用的规范
 * GenericServlet	是通用的实现
 * HttpServlet		是专门处理http请求		HttpServlet继承GenericServlet；这才是我们最终要用的servlet；
 * 
 * 看service()源代码可以发现
 *		doGeT()和doPost()都是在里面被调用；所以只要重写这两个方法就相当于重写了service()
 *
 * MyEclipse中可以直接新建servlet，不用新建类
 */
public class A03_HttpServlet extends HttpServlet {
	
	//如果浏览器是以get方式提交，则覆写doGet()方法；
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.write("<ol>");
			pw.write("<li>JavaServlet</li>");
			pw.write("<li>JavaJsp</li>");
			pw.write("<li>JavaStruts</li>");		// 写入响应体
		pw.write("</ol>");
	}

	
	//如果是表单形式就用dopost()
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	  // 一般项目中doGet和doPost都会有的；
			throws ServletException, IOException {
	}
	
}
