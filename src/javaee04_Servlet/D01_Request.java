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
  	request��װ�˿ͻ����ύ������һ������

	request���Ի�ȡ����ͷ����Ϣ
 		request.getHeader(key):  	String				�õ�ĳ������ͷ(key)��Ӧ��ֵ
      	request.getHeaderNames():	Enumeration			�õ����е�����ͷ��key
      	request.getHeaders(key): 	Enumeration 		�õ�ĳ������ͷ���������ֵ����Щkey�ж��ֵ
      
    requestȡ�ÿͻ��ύ��������Ϣ�������壩
      	request.getParameter(String):		String
      	request.getParameterValues():		Map
 * */
public class D01_Request extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �������Ϣ
		String url = request.getRequestURL().toString();		//	����·����http://localhost:8080/StudyJavaEE/request
		System.out.println(url);
		String uri = request.getRequestURI().toString();		//	��Ҫ·����/StudyJavaEE/request
		System.out.println(uri);
		String query = request.getQueryString();				//	�������֣�name=liuzhong&password=123
		System.out.println(query);
		String pathInfo = request.getPathInfo();				//	·��֮�����Ϣ�����û�У�����null��λ��Servlet·��֮��Ͳ�ѯ����֮ǰ�����ݣ���/��ͷ��
		System.out.println(pathInfo);
		
		String clienIP = request.getRemoteAddr();				//	�ͻ���IP��		127.0.0.1
		String clienHost = request.getRemoteHost();				//	������	127.0.0.1
		int clientPort = request.getRemotePort();				//	�˿ڣ�	15355
		System.out.println("�ͻ��ˣ�"+clienIP+":"+clienHost+":"+clientPort);
		
		String serverIP = request.getLocalAddr();				//	�����IP��		127.0.0.1
		String serverHost = request.getLocalName();				//	������	www.liuzhong.com
		int serverPort = request.getLocalPort();				//	�˿ڣ�	8080
		System.out.println("����ˣ�"+serverIP+":"+serverHost+":"+serverPort);
		
		// ����ͷ��Ϣ
		String acceptLanguage = request.getHeader("Accept-Language");		//	Accept-Language = zh-CN
		String userAgent = request.getHeader("User-Agent");		//	User-Agent = Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; NP06)
		String host = request.getHeader("Host");				//	Host = www.liuzhong.com:8081
		response.getWriter().write("Accept-Language = "+acceptLanguage+"</br>");
		response.getWriter().write("User-Agent = "+userAgent+"</br>");
		response.getWriter().write("Host = "+host+"</br>");
		
		Enumeration<String> enums = request.getHeaderNames();
		while (enums.hasMoreElements()) {
			String key = enums.nextElement();						// key��ʾ����ͷ
			Enumeration<String> enums2 = request.getHeaders(key);	// һ��key���ܶ�Ӧ���ֵ��
			while(enums2.hasMoreElements()){
				String value = enums2.nextElement();
				System.out.println(key+"<->"+value);
			}
		}
		
		// ��������Ϣ(�������Ĳ���)
		String name = request.getParameter("name");
		System.out.println(name);
		
		Map<String,String[]> map = request.getParameterMap();
		Set<String> keySet = map.keySet();
		Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			String key = (String) iterator.next();
			System.out.println("key="+key + "--��ֵ�����У�"+map.get(key).length);
			String value = map.get(key)[0];
			System.out.println(key+" ======= "+ value);
		}
	}
}