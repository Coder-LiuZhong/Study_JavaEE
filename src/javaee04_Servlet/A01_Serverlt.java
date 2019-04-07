package javaee04_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * Servlet就是一Java程序，运行在Web服务器，用于接收和响应客户端的http请求；
 * 
 * 		浏览器上输入链接：http://localhost:8080/StudyJavaEE/helloworld
 * 			请求localhost服务器里面，8080端口上的Tomcat服务器，找到服务器下的Web项目StudyJavaEE
 * 			Tomact服务器再通过事先配置好的WEB-INF/web.xml文件，找到/helloworld所对应的Servlet类
 * 			Tomcat调用Servlet类里的service方法，处理请求，返回处理结果到客户端(浏览器)
 * 
 * 		1.	新建一个servlet类，实现servlet接口
 * 		2.	在WEB-INF/web.xml中写配置，告诉Tomcat，新定义的servlet的名字和路径;
 * 		3.	在WEB-INF/web.xml中写映射，设置浏览器上通过什么链接地址访问到这个servlet;
 * 		4.	浏览器：http://localhost:8080/StudyJavaEE/helloworld
 * 
 * */
public class A01_Serverlt implements Servlet {		// 必须实现Servlet接口来开发Servlet程序;
	
	// 实现接口就必须重写它的所有方法
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
	
	// Tomcat服务器调用此方法
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {	
		PrintWriter pw = response.getWriter();	
		pw.write("A01_Helloworld");
	}


	
}
