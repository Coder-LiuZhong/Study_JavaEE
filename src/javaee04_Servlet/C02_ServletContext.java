package javaee04_Servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	ServletContext对象（重点）
 * 		是服务器启动的时候创建的，唯一存在的对象；		关闭服务，或移除出服务器就销毁；		作用范围：这个项目里面都可以使用
 * 		1. 被项目里面的所有Servlet共享；可以存取数据
 * 		2. 能读取web.xml中配置的全局参数:<context-param>
		3. 能获取web应用中的资源
		4. 跳转到指定页面
 */
public class C02_ServletContext extends HttpServlet {
	
	//http://localhost:8080/StudyJavaEE/servletContext?username=jack
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.被项目里面的所有Servlet共享；可存取数据
		String username = request.getParameter("username");		
		ServletContext context = this.getServletContext();		//	取得ServletContext对象；
		context.setAttribute("un", username);					//	存入; 在另一个servlet中取出: context.getAttribute("un") 
	
		// 2.能读取web.xml中配置的全局参数:<context-param>
		String email = context.getInitParameter("email");		
		if (email!=null) {
			response.setContentType("text/html;charset=UTF-8");	
			response.getWriter().write("赵老师邮箱：" + email + "<br/>");
		}
		
		// 3.能获取web应用中的资源
		Properties props = new Properties();
		InputStream is1 = context.getResourceAsStream("/files/temp.properties");	 // 1.文件存在于WebRoot下
		props.load(is1);
		System.out.println(props.getProperty("temp"));
		
		InputStream is2 = context.getResourceAsStream("/WEB-INF/classes/javaee04_Servlet/ServletContext.properties");  // 2.文件在src目录下，编译之后Tomcat得到classes目录去找
		props.load(is2);
		System.out.println(props.getProperty("cols"));
		
		String path = context.getRealPath("");		// 3.获取项目在Tomcat中的绝对路径：D:\WorkingTools\apache-tomcat-7.0.52\webapps\StudyJavaEE
		System.out.println(path);					 
		InputStream is3 = new FileInputStream(path+"/files/temp.properties");
		props.load(is3);
		System.out.println(props.getProperty("temp"));
		
		// 4.转向指定页面
		RequestDispatcher rd = context.getRequestDispatcher("/index.html");	
		rd.forward(request, response);	
	}
}
