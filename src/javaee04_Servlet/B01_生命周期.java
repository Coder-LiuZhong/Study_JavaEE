package javaee04_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ���ͻ�����������������ʱ��ͨ��web.xml�ҵ���Ӧ��servlet��
 * 	   Tomcat�����ͻᴴ��servlet���󣨵��ù��췽������
 * 	     Ȼ���һ�������ʱ��ͳ�ʼ��init()��
 * 
 * 	1.	����servlet��;  ����servlet��ʱ��
 * 	2.	init()��ʼ��;	һ��servletֻ���ʼ��һ�Σ���һ�η��ʵ�ʱ���ʼ��
 * 	3.	doGet();		��һ�η�����ǰ�������Ժ�ÿ�η��ʶ�ֻ��doGet()
 * 	4.	destroy()��		���²����ʱ�����
 * 
 *  Servletʵ���ڷ����������ʱ��ʹ��������õȵ��з��ʲŴ���
 *  	WEB-INF/web.xml����<load-on-startup>1</load-on-startup>   
 *  	1��ʾtomcat������ʱ��ͼ��أ�0�����˷��ʵ�ʱ��ż���; 
 *  	Ҳ������2��3��4����ܶ�servlet��������������ʱ����������˭����ԽС���ȴ�����
 * */
public class B01_�������� extends HttpServlet {

	public B01_��������(){
		System.out.println("NO1:gouzao()" + this.hashCode());
	}
	public void init() throws ServletException {
		System.out.println("NO2:init()" + this.hashCode());
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("NO3:doGet()" + this.hashCode());
	}
	public void destroy() {
		System.out.println("destroy()");		//	���²��𣻻��߷�����ֹͣ��ʱ����ã�
	}
}

