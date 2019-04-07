package javaee04_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 返回数据给客户端
 * 		以后的学习中不会是这种方式输出的；
 * 		注意输出有中文，会乱码的问题:  request和response默认都是用IOS8859-1码表解析的；而中文需要UTF-8解析
 */
public class E01_Response extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//以字节方式返回；输出文件用它（当然文字也可以）
		//response.getOutputStream().write(96);						//	a			
		//response.getOutputStream().write((97+"").getBytes());		//	97,数字转换成字符串；write只能接int和byte[]参数；
	
		//以字符流方式返回；输出文字用它
		//response.getWriter().write(97);							//	A
		
		//设置返回的相应信息
		//response.setStatus("");						// 设置当前这个请求的处理状态码
		//response.setHeader(name, value);				// 设置一个头
		//response.setContentType(type);				// 设置相应的内容以及编码
		
		/*
		 * 返回输出中文乱码问题
		 * 	   确保出去时候的编码，和客户端浏览器看这份数据用的编码是一样就行
		 * */ 
		
		//response.setHeader("Content-Type", "text/heml;charset=UTF-8");	 //字符方式输出得提前设置编码；告诉浏览器以UTF-8方式查看；
		//response.getWriter().write("美国");							
		
		response.setContentType("text/heml;charset=UTF-8");			    //跟上面是一个意思
		response.getOutputStream().write("中国".getBytes("UTF-8"));		//输出设置为UTF-8形式；getBytes()默认就是UTF-8形式？不用到getBytes就是IOS8859-1编码;
	}
}
