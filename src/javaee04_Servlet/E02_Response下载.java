package javaee04_Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

/* 
 * Response可以提供下载文件输出
 * 
 * 1. 直接通过超链接就可下载：
 * 		<a href="files/temp.properties">temp.properties</a>
 *    	因为tomcat里有个默认的Servlet：DefaultServlet; 它专门处理放在服务器上的静态资源。
 *      temp.properties这种文件是浏览器可以识别打开查看的，所以不会弹出下载；但是其他识别不了的就会提示下载。
 * 
 * 2. 通过servlet处理手动编码下载
 * 		<a href="responseDownload?filename=temp.properties">temp.properties</a>
 * 		response.setHeader("Content-Disposition", "attachment;filename=文件名","UTF-8")
 * 		注意中文乱码：request和response默认都是用IOS8859-1码表解析的；而中文需要UTF-8
 * */
public class E02_Response下载 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("filename");					
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");		// 如果页面上的文件是中文，就得转码，传过来的时候已经被request搞成ISO-8859-1了
		
		ServletContext context = this.getServletContext();				
		String path = context.getRealPath("files/"+fileName);	
		System.out.println(path);			
		
		File file = new File(path);
		
		/*
		 * 让浏览器收到这份资源的时候， 以下载的方式提醒用户，而不是直接展示；
		 * 顺便编码一下文件名为UTF-8，浏览器也要这种编码解析才不会乱码；
		 * 		IE或者谷歌浏览器是用URLEncoder编码：URLEncoder.encode(file.getName(),"UTF-8")
		 * 		火狐浏览器是用Base64编码：base64EncodeFileName(file.getName())
		 * */
		String clientType = request.getHeader("User-Agent");
		if(clientType.contains("Firefox")){
			response.setHeader("Content-Disposition", "attachment;filename="+base64EncodeFileName(file.getName()));	
		}else{
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(file.getName(),"UTF-8"));	
		}
		
		InputStream is = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len=is.read(buf))>0) {
			os.write(buf, 0, len);
		}
		os.close();
		is.close();
	}
	
	
	// 火狐文件下载编码专用（网上找的不用管它怎么实现）
	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?"
					+ new String(base64Encoder.encode(fileName
							.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
