package javaee04_Servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * Servlet�ӿ���Ҫʵ���������з��������ã�
 * 
 * GenericServlet��Servlet���ࣻ
 *		��չGenericServletʵ��Servlet����;�����Ͳ�Ҫȫ��ʵ��servlet�ӿڵķ���,ֻ��Ҫ��service���ɣ�	
 *
 * <url-pattern>/helloworld</url-pattern>	����ȫ·��		http://localhost:8080/StudyJavaEE/helloworld
 * <url-pattern>/*</url-pattern>			ע��û��/��		http://localhost:8080/StudyJavaEE/xxxx;   ��ñ������������תȥ��̬�ļ����鷳��
 * <url-pattern>*.asp</url-pattern>	   		* ƥ����������	http://localhost:8080/StudyJavaEE/xxx.asp
 * */
public class A02_GenericServlet extends GenericServlet{		
	public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException {
		//֪ͨ�ͻ�����ָ���ı��뷽ʽ����ʾ����:	��д����Ϣ��html�ļ���ͬʱ��������utf-8������;
		response.setContentType("text/html;charset=UTF-8");			
		response.getWriter().write("��ӭѧϰGenericServlet����");
	}
	
}
