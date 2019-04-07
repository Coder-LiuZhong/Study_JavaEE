package javaee04_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 当客户浏览器有链接请求的时候，通过web.xml找到对应的servlet；
 * 	   Tomcat容器就会创造servlet对象（调用构造方法），
 * 	     然后第一次请求的时候就初始化init()；
 * 
 * 	1.	构造servlet类;  创建servlet的时候
 * 	2.	init()初始化;	一个servlet只会初始化一次；第一次访问的时候初始化
 * 	3.	doGet();		第一次访问是前三步，以后每次访问都只是doGet()
 * 	4.	destroy()；		重新部署的时候调用
 * 
 *  Servlet实例在服务器部署的时候就创建，不用等到有访问才创建
 *  	WEB-INF/web.xml设置<load-on-startup>1</load-on-startup>   
 *  	1表示tomcat启动的时候就加载，0是有人访问的时候才加载; 
 *  	也可以是2、3、4如果很多servlet都想服务器部署的时候启动，那谁数字越小是先创建；
 * */
public class B01_生命周期 extends HttpServlet {

	public B01_生命周期(){
		System.out.println("NO1:gouzao()" + this.hashCode());
	}
	public void init() throws ServletException {
		System.out.println("NO2:init()" + this.hashCode());
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("NO3:doGet()" + this.hashCode());
	}
	public void destroy() {
		System.out.println("destroy()");		//	重新部署；或者服务器停止的时候调用；
	}
}

