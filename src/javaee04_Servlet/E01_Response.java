package javaee04_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * �������ݸ��ͻ���
 * 		�Ժ��ѧϰ�в��������ַ�ʽ����ģ�
 * 		ע����������ģ������������:  request��responseĬ�϶�����IOS8859-1�������ģ���������ҪUTF-8����
 */
public class E01_Response extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//���ֽڷ�ʽ���أ�����ļ���������Ȼ����Ҳ���ԣ�
		//response.getOutputStream().write(96);						//	a			
		//response.getOutputStream().write((97+"").getBytes());		//	97,����ת�����ַ�����writeֻ�ܽ�int��byte[]������
	
		//���ַ�����ʽ���أ������������
		//response.getWriter().write(97);							//	A
		
		//���÷��ص���Ӧ��Ϣ
		//response.setStatus("");						// ���õ�ǰ�������Ĵ���״̬��
		//response.setHeader(name, value);				// ����һ��ͷ
		//response.setContentType(type);				// ������Ӧ�������Լ�����
		
		/*
		 * �������������������
		 * 	   ȷ����ȥʱ��ı��룬�Ϳͻ������������������õı�����һ������
		 * */ 
		
		//response.setHeader("Content-Type", "text/heml;charset=UTF-8");	 //�ַ���ʽ�������ǰ���ñ��룻�����������UTF-8��ʽ�鿴��
		//response.getWriter().write("����");							
		
		response.setContentType("text/heml;charset=UTF-8");			    //��������һ����˼
		response.getOutputStream().write("�й�".getBytes("UTF-8"));		//�������ΪUTF-8��ʽ��getBytes()Ĭ�Ͼ���UTF-8��ʽ�����õ�getBytes����IOS8859-1����;
	}
}
