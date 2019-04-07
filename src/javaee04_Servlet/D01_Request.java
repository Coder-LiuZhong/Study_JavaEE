package javaee04_Servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  	request封装了客户端提交过来的一切数据

	request可以获取请求头的信息
 		request.getHeader(key):  	String				得到某个请求头(key)对应的值
      	request.getHeaderNames():	Enumeration			得到所有的请求头的key
      	request.getHeaders(key): 	Enumeration 		得到某个请求头里面的所有值，有些key有多个值
      
    request取得客户提交过来的信息（请求体）
      	request.getParameter(String):		String
      	request.getParameterValues():		Map
 * */
public class D01_Request extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 请求的信息
		String url = request.getRequestURL().toString();		//	完整路径：http://localhost:8080/StudyJavaEE/request
		System.out.println(url);
		String uri = request.getRequestURI().toString();		//	主要路径：/StudyJavaEE/request
		System.out.println(uri);
		String query = request.getQueryString();				//	参数部分；name=liuzhong&password=123
		System.out.println(query);
		String pathInfo = request.getPathInfo();				//	路径之外的信息，如果没有，返回null；位于Servlet路径之后和查询参数之前的内容，以/开头；
		System.out.println(pathInfo);
		
		String clienIP = request.getRemoteAddr();				//	客户端IP：		127.0.0.1
		String clienHost = request.getRemoteHost();				//	主机：	127.0.0.1
		int clientPort = request.getRemotePort();				//	端口：	15355
		System.out.println("客户端："+clienIP+":"+clienHost+":"+clientPort);
		
		String serverIP = request.getLocalAddr();				//	服务端IP：		127.0.0.1
		String serverHost = request.getLocalName();				//	主机：	www.liuzhong.com
		int serverPort = request.getLocalPort();				//	端口：	8080
		System.out.println("服务端："+serverIP+":"+serverHost+":"+serverPort);
		
		// 请求头信息
		String acceptLanguage = request.getHeader("Accept-Language");		//	Accept-Language = zh-CN
		String userAgent = request.getHeader("User-Agent");		//	User-Agent = Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; NP06)
		String host = request.getHeader("Host");				//	Host = www.liuzhong.com:8081
		response.getWriter().write("Accept-Language = "+acceptLanguage+"</br>");
		response.getWriter().write("User-Agent = "+userAgent+"</br>");
		response.getWriter().write("Host = "+host+"</br>");
		
		Enumeration<String> enums = request.getHeaderNames();
		while (enums.hasMoreElements()) {
			String key = enums.nextElement();						// key表示请求头
			Enumeration<String> enums2 = request.getHeaders(key);	// 一个key可能对应多个值；
			while(enums2.hasMoreElements()){
				String value = enums2.nextElement();
				System.out.println(key+"<->"+value);
			}
		}
		
		// 请求体信息(传过来的参数)
		String name = request.getParameter("name");
		System.out.println(name);
		
		Map<String,String[]> map = request.getParameterMap();
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			String key = (String) iterator.next();
			System.out.println("key="+key + "--的值总数有："+map.get(key).length);
			String value = map.get(key)[0];
			System.out.println(key+" ======= "+ value);
		}
	}
}