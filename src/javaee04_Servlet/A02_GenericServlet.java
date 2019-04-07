package javaee04_Servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * Servlet接口需要实现它的所有方法，不好；
 * 
 * GenericServlet是Servlet子类；
 *		扩展GenericServlet实现Servlet程序;这样就不要全部实现servlet接口的方法,只需要用service即可；	
 *
 * <url-pattern>/helloworld</url-pattern>	正常全路径		http://localhost:8080/StudyJavaEE/helloworld
 * <url-pattern>/*</url-pattern>			注意没有/了		http://localhost:8080/StudyJavaEE/xxxx;   最好别这样，如果跳转去静态文件就麻烦了
 * <url-pattern>*.asp</url-pattern>	   		* 匹配任意文字	http://localhost:8080/StudyJavaEE/xxx.asp
 * */
public class A02_GenericServlet extends GenericServlet{		
	public void service(ServletRequest request, ServletResponse response)throws ServletException, IOException {
		//通知客户端以指定的编码方式来显示中文:	回写的信息是html文件，同时告诉它以utf-8来解析;
		response.setContentType("text/html;charset=UTF-8");			
		response.getWriter().write("欢迎学习GenericServlet程序");
	}
	
}
