package javaee04_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*	
 * Servlet			��ͨ�õĹ淶
 * GenericServlet	��ͨ�õ�ʵ��
 * HttpServlet		��ר�Ŵ���http����		HttpServlet�̳�GenericServlet���������������Ҫ�õ�servlet��
 * 
 * ��service()Դ������Է���
 *		doGeT()��doPost()���������汻���ã�����ֻҪ��д�������������൱����д��service()
 *
 * MyEclipse�п���ֱ���½�servlet�������½���
 */
public class A03_HttpServlet extends HttpServlet {
	
	//������������get��ʽ�ύ����дdoGet()������
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.write("<ol>");
			pw.write("<li>JavaServlet</li>");
			pw.write("<li>JavaJsp</li>");
			pw.write("<li>JavaStruts</li>");		// д����Ӧ��
		pw.write("</ol>");
	}

	
	//����Ǳ���ʽ����dopost()
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)	  // һ����Ŀ��doGet��doPost�����еģ�
			throws ServletException, IOException {
	}
	
}
