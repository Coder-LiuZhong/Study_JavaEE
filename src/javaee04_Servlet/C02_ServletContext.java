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
 * 	ServletContext�����ص㣩
 * 		�Ƿ�����������ʱ�򴴽��ģ�Ψһ���ڵĶ���		�رշ��񣬻��Ƴ��������������٣�		���÷�Χ�������Ŀ���涼����ʹ��
 * 		1. ����Ŀ���������Servlet�������Դ�ȡ����
 * 		2. �ܶ�ȡweb.xml�����õ�ȫ�ֲ���:<context-param>
		3. �ܻ�ȡwebӦ���е���Դ
		4. ��ת��ָ��ҳ��
 */
public class C02_ServletContext extends HttpServlet {
	
	//http://localhost:8080/StudyJavaEE/servletContext?username=jack
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.����Ŀ���������Servlet�����ɴ�ȡ����
		String username = request.getParameter("username");		
		ServletContext context = this.getServletContext();		//	ȡ��ServletContext����
		context.setAttribute("un", username);					//	����; ����һ��servlet��ȡ��: context.getAttribute("un") 
	
		// 2.�ܶ�ȡweb.xml�����õ�ȫ�ֲ���:<context-param>
		String email = context.getInitParameter("email");		
		if (email!=null) {
			response.setContentType("text/html;charset=UTF-8");	
			response.getWriter().write("����ʦ���䣺" + email + "<br/>");
		}
		
		// 3.�ܻ�ȡwebӦ���е���Դ
		Properties props = new Properties();
		InputStream is1 = context.getResourceAsStream("/files/temp.properties");	 // 1.�ļ�������WebRoot��
		props.load(is1);
		System.out.println(props.getProperty("temp"));
		
		InputStream is2 = context.getResourceAsStream("/WEB-INF/classes/javaee04_Servlet/ServletContext.properties");  // 2.�ļ���srcĿ¼�£�����֮��Tomcat�õ�classesĿ¼ȥ��
		props.load(is2);
		System.out.println(props.getProperty("cols"));
		
		String path = context.getRealPath("");		// 3.��ȡ��Ŀ��Tomcat�еľ���·����D:\WorkingTools\apache-tomcat-7.0.52\webapps\StudyJavaEE
		System.out.println(path);					 
		InputStream is3 = new FileInputStream(path+"/files/temp.properties");
		props.load(is3);
		System.out.println(props.getProperty("temp"));
		
		// 4.ת��ָ��ҳ��
		RequestDispatcher rd = context.getRequestDispatcher("/index.html");	
		rd.forward(request, response);	
	}
}
