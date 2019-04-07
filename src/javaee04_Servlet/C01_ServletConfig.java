package javaee04_Servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	ServletConfig����
 * 		������ȡweb.xml�����servlet��ǰ���úõ�һЩ��ʼ��������Ϣ<init-param>��
 * 		�ô���  ������õ���Ϣ�б䶯��ֱ�Ӹ�web.xml����������Ҫ��servlet����
 * 
 * 	���ַ�ʽ�õ�ServletConfig����
 * 		init(ServletConfig config)	  ��������init(),Tomcat���������ServletConfig��������������;
 * 		this.getServletConfig()		 doGet()�еõ��������������ͬʱ���ڡ���
 * 
 *  ServletConfig������������
 * 		config.getInitParameter("tel")		ĳһ��<init-param>
 * 		config.getInitParameterNames()		���е�<init-param>
 * */
public class C01_ServletConfig extends HttpServlet {
	private ServletConfig config;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = this.getServletConfig();					// �õ�ServletConfig����
		String encoding = config.getInitParameter("encoding");		
		response.setContentType("text/html;charset="+encoding);
		response.getWriter().write("ServletConfig����");
		
		Enumeration<String> enums = config.getInitParameterNames();		// �õ����г�ʼ������
		while(enums.hasMoreElements()){
			String key = enums.nextElement();
			String value = config.getInitParameter(key);
			System.out.println(key+"--"+value);
		}
	}
}
