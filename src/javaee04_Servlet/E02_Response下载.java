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
 * Response�����ṩ�����ļ����
 * 
 * 1. ֱ��ͨ�������ӾͿ����أ�
 * 		<a href="files/temp.properties">temp.properties</a>
 *    	��Ϊtomcat���и�Ĭ�ϵ�Servlet��DefaultServlet; ��ר�Ŵ�����ڷ������ϵľ�̬��Դ��
 *      temp.properties�����ļ������������ʶ��򿪲鿴�ģ����Բ��ᵯ�����أ���������ʶ���˵ľͻ���ʾ���ء�
 * 
 * 2. ͨ��servlet�����ֶ���������
 * 		<a href="responseDownload?filename=temp.properties">temp.properties</a>
 * 		response.setHeader("Content-Disposition", "attachment;filename=�ļ���","UTF-8")
 * 		ע���������룺request��responseĬ�϶�����IOS8859-1�������ģ���������ҪUTF-8
 * */
public class E02_Response���� extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("filename");					
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");		// ���ҳ���ϵ��ļ������ģ��͵�ת�룬��������ʱ���Ѿ���request���ISO-8859-1��
		
		ServletContext context = this.getServletContext();				
		String path = context.getRealPath("files/"+fileName);	
		System.out.println(path);			
		
		File file = new File(path);
		
		/*
		 * ��������յ������Դ��ʱ�� �����صķ�ʽ�����û���������ֱ��չʾ��
		 * ˳�����һ���ļ���ΪUTF-8�������ҲҪ���ֱ�������Ų������룻
		 * 		IE���߹ȸ����������URLEncoder���룺URLEncoder.encode(file.getName(),"UTF-8")
		 * 		������������Base64���룺base64EncodeFileName(file.getName())
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
	
	
	// ����ļ����ر���ר�ã������ҵĲ��ù�����ôʵ�֣�
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
