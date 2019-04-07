package javaee04_Servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	ServletConfig对象
 * 		用来获取web.xml中这个servlet提前配置好的一些初始化参数信息<init-param>；
 * 		好处：  如果配置的信息有变动，直接改web.xml参数，不需要改servlet代码
 * 
 * 	两种方式得到ServletConfig对象
 * 		init(ServletConfig config)	  带参数的init(),Tomcat服务器会把ServletConfig当做参数传进来;
 * 		this.getServletConfig()		 doGet()中得到；两种情况不能同时存在……
 * 
 *  ServletConfig对象两个方法
 * 		config.getInitParameter("tel")		某一个<init-param>
 * 		config.getInitParameterNames()		所有的<init-param>
 * */
public class C01_ServletConfig extends HttpServlet {
	private ServletConfig config;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = this.getServletConfig();					// 得到ServletConfig对象
		String encoding = config.getInitParameter("encoding");		
		response.setContentType("text/html;charset="+encoding);
		response.getWriter().write("ServletConfig对象");
		
		Enumeration<String> enums = config.getInitParameterNames();		// 得到所有初始化参数
		while(enums.hasMoreElements()){
			String key = enums.nextElement();
			String value = config.getInitParameter(key);
			System.out.println(key+"--"+value);
		}
	}
}
