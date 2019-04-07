package javaee04_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * Servlet����һJava����������Web�����������ڽ��պ���Ӧ�ͻ��˵�http����
 * 
 * 		��������������ӣ�http://localhost:8080/StudyJavaEE/helloworld
 * 			����localhost���������棬8080�˿��ϵ�Tomcat���������ҵ��������µ�Web��ĿStudyJavaEE
 * 			Tomact��������ͨ���������úõ�WEB-INF/web.xml�ļ����ҵ�/helloworld����Ӧ��Servlet��
 * 			Tomcat����Servlet�����service�������������󣬷��ش��������ͻ���(�����)
 * 
 * 		1.	�½�һ��servlet�࣬ʵ��servlet�ӿ�
 * 		2.	��WEB-INF/web.xml��д���ã�����Tomcat���¶����servlet�����ֺ�·��;
 * 		3.	��WEB-INF/web.xml��дӳ�䣬�����������ͨ��ʲô���ӵ�ַ���ʵ����servlet;
 * 		4.	�������http://localhost:8080/StudyJavaEE/helloworld
 * 
 * */
public class A01_Serverlt implements Servlet {		// ����ʵ��Servlet�ӿ�������Servlet����;
	
	// ʵ�ֽӿھͱ�����д�������з���
	public void destroy() {
		
	}
	
	public String getServletInfo() {
		return null;
	}
	
	public ServletConfig getServletConfig() {			
		return null;
	}
	
	public void init(ServletConfig arg0) throws ServletException {			
		
	}
	
	// Tomcat���������ô˷���
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {	
		PrintWriter pw = response.getWriter();	
		pw.write("A01_Helloworld");
	}


	
}
