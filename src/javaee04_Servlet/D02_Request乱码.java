package javaee04_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	Get��ʽ���������
 * 		���͹��������ݣ������ģ�����url��ַ���Ͼ��Ѿ�������������ˣ�Servlet������յ��ľ�������
 * 		request.getParameter("username")  Ĭ������IOS-8859-1ȥ����(����û�й���,��������ҪUTF-8)��
 * 
 * 		ֱ����Tomcat�������ã��Ժ�get���������������Զ����UTF-8���룻�˽����
 * 		TomcatĿ¼��conf/service.xml�У�����8080��һ�У��������� ��URIEncoding="UTF-8"
 * 		
 *	Post��ʽ
 *		request.setCharacterEncoding("UTF-8");    ������������������ֱ��룻get��ʽû�ã���Ϊ������������������
 *		 
 * */
public class D02_Request���� extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String username = request.getParameter("username");
		System.out.println(username);					//	���ʱ�򶼻���ISO8859-1���룻
		
		//���Ľ���
		byte[] buf = username.getBytes("ISO8859-1");	//	��һ��ISO8859-1�����ת��ԭΪ%E5%B0%8F%E7%8E%8B��������ֽ�����;
		username = new String(buf,"UTF-8");				//	��UTF-8  ת����utf-8�ַ�  ����������
		if(username!=null || username.trim().length()>0){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write("�û���:" + username);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");			// post��ʽ�������ڵ�һ��
	}
}
