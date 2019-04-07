package javaee04_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	Get方式请求服务器
 * 		发送过来的数据，有中文，那在url地址栏上就已经被编码成乱码了，Servlet里面接收到的就是乱码
 * 		request.getParameter("username")  默认是用IOS-8859-1去解码(里面没中国字,而中文需要UTF-8)；
 * 
 * 		直接在Tomcat里做配置，以后get请求过来的数据永远都是UTF-8编码；了解就行
 * 		Tomcat目录下conf/service.xml中，搜索8080那一行，加上属性 ：URIEncoding="UTF-8"
 * 		
 *	Post方式
 *		request.setCharacterEncoding("UTF-8");    设置请求体里面的文字编码；get方式没用，因为参数不在请求体里面
 *		 
 * */
public class D02_Request乱码 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String username = request.getParameter("username");
		System.out.println(username);					//	这个时候都还是ISO8859-1乱码；
		
		//中文解码
		byte[] buf = username.getBytes("ISO8859-1");	//	查一下ISO8859-1码表，逆转还原为%E5%B0%8F%E7%8E%8B，并变成字节数组;
		username = new String(buf,"UTF-8");				//	查UTF-8  转换成utf-8字符  就是中文了
		if(username!=null || username.trim().length()>0){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("用户名:" + username);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");			// post方式，加上在第一行
	}
}
