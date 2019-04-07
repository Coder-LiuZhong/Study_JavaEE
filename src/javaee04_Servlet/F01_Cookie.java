package javaee04_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * �Ự
 * 	    �û���һ��������������������ӣ����ʷ��������web��Դ��Ȼ��ر���������������̳�֮Ϊһ���Ự��
 *    ��ͬ�������ͬ����վ������һ���Ự
 * 		���磬�û�A�ڳ��й�����κ���Ʒ��Ӧ�÷���A�Ĺ��ﳵ�ڣ��������û�Aʲôʱ�乺��ģ��ⶼ������ͬһ���Ự�ģ�
 * 			   ���ܷ����û�B���û�C�Ĺ��ﳵ�ڣ��ⲻ����ͬһ���Ự��
 * 		WebӦ�ó�����ʹ��HTTPЭ�鴫�����ݵġ�HTTPЭ������״̬��Э��(������-����-Ӧ��-�ر����ӡ�)��
 * 		һ�����ݽ�����ϣ��ͻ�����������˵����Ӿͻ�رգ��ٴν���������Ҫ�����µ����ӡ������ζ�ŷ������޷��������ϸ��ٻỰ��
 * 		���û�A������һ����Ʒ���빺�ﳵ�ڣ����ٴι�����Ʒʱ�������Ѿ��޷��жϸù�����Ϊ�������û�A�ĻỰ�����û�B�ĻỰ�ˡ�Ҫ���ٸûỰ����������һ�ֻ��ơ�
 * 
 * Cookie
 * 		���������͸��ͻ��˵�һ��С���ݣ�������Ϊ��������ͨ��֤
 * 		�ͻ�������������������������Ҫ��¼���û�״̬����ʹ��response��ͻ���������䷢һ��Cookie��
 * 		�ͻ�����������Cookie��������������������������վʱ����������������ַ��ͬ��Cookieһͬ�ύ����������
 * 		����������Cookie���Դ��������û�״̬�������������Ը�����Ҫ�޸�Cookie�����ݡ�
 *   
 * Session
 * 		����cookie���ͻ������ݴ���ڷ����
 * 		���˵Cookie������ͨ�����ͻ����ϵġ�ͨ��֤����ȷ���ͻ���ݵĻ���
 *		��ôSession���ƾ���ͨ�����������ϵġ��ͻ���ϸ����ȷ�Ͽͻ���ݡ�
 *		Session�൱�ڳ����ڷ������Ͻ�����һ�ݿͻ��������ͻ����õ�ʱ��ֻ��Ҫ��ѯ�ͻ�������Ϳ����ˡ�   
 *   
 * CZBK  
 *		����û����������ͨ��һ��servlet���Թ�����һ����Ʒ��������Ӧ����취��ÿһ���û��������Ʒ�����ڸ��Եĵط���
 *  	�Ա�����Щ�û������servletʱ������servlet���Եõ��û����Թ������ƷΪ�û����ʡ�
 *		���˵����������Ҫ�и������������servlet����һЩ��Ϣ��ǰ������ѧ��ServletContext��HttpServletRequest���������
 *			request,  ����Ƿ������½������ǾͲ����ˣ�
 *			context,  tomcat������JVM�У�JVM�������ڴ������д�С���Ƶģ����ԣ�context������������������ʹ�ã�ÿ���û������Ϣ���Ǵ���վ�������ˣ�
 *		���ԣ��������µ������
 *  	��������ÿ���û���������cookie����ʽд���û����Ե��������
 *  	���û�ʹ���������ȥ���ʷ������е�web��Դʱ���ͻ���Ÿ��Ե�����ȥ��������web��Դ����ľ����û����Ե������ˡ�
 *		Session�Ƿ������˼������������������������������ʱ����Ϊÿһ���û������������һ��������session����
 *		����sessionΪ�û���������������û��ڷ��ʷ�������web��Դʱ�����԰Ѹ��Ե����ݷ��ڸ��Ե�session�У�
 *		���û���ȥ���ʷ������е�����web��Դʱ������web��Դ�ٴ��û����Ե�session��ȡ������Ϊ�û�����
 *
 * Cookie
 *   1)Cookie�ǿͻ��˵ļ���;
 *   2)ÿ�η�������ʱ���ͻ��˶�����ϸ����ѵĲ�ͬCookie������ˣ������һ����Cookie����֪�����ĸ��ͻ��˷��͹�������Ϣ;
 *   3)һ��Cookieֻ�ܴ洢һ�����͵���Ϣ
 *   4)����ĳ��Cookie�����������дһ����ͬ����Cookie
 *   5)Cookieһ��Ҫ����һ����Чʱ�䣬��������õĻ���Ĭ�ϸ�������ʽ����󣬸�Cookie�Զ����٣���רҵ����������Cookie��Ĭ����Ч��ʱһ����Ч�Ự����
 *  
 * Cookieϸ��
 *	  1)Cookieֻ�ܷ�װһ�����͵���Ϣ�����Ҹ���Ϣ��ֵֻ����String����
 *	  2)Cookie�ɷ���˲���������ڿͻ���
 *	  3)Cookie�洢ĳ���������������
 *	  4)��Ĭ������£�Cookie�ǻỰ����һ����������Ҫ��Cookie�������Ĵ��ʱ�䣬����Ϊ��λ
 *	  5)������������������һ����Cookie����ʾ����ԭCookie
 *	  6)���Ҫɾ��Cookie,�������ø�Cookie�Ĵ��ʱ��Ϊ0   
 *
 * ���ӣ�Cookie��ʲôȱ�㣿
 *		��ȫ�Բ���;���ڿͻ��ˣ��ܱ�������������cookie���Ǵ�ļ�������;
 *      cookie����ٸ������Ƶ�
 *		ĳЩ����ϵͳƽ̨�����е������������ֹ�����д��Cookie
 *
 * ��Ʒ�����¼����
 * 		��Ʒҳ����ͼƬ��������Ʒ���飺  ��������ҳ��������servlet��
		����servletȡ�����������������ƷID�������һ�η�������Ʒ��cookie==null;  new Cookie("history",ID1)
		���cookie!=null��ȡ����ǰ��cookie������ƷID�÷���ƴ���ٷ���cookie��
		��ת��jsp����ҳ�棬ȡ��cookieֵ���ָ��ַ����õ��Ѿ����ʹ�����Ʒid��������ʾ��
 * */
public class F01_Cookie extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		// ��һ�η��ʣ����ͻ���һ��cookie
		Cookie cookie = new Cookie("username","haha");			//����Cookie����������String����ֵ�ԣ�
		cookie.setMaxAge(1*24*60*60);							//����Cookie���ʱ�䣻����Ϊ-1,��������˾�ʧЧ�������д����������գ�Cookie��û�ˣ�
		//cookie.setDomain(".itheima.com");						//����ֻ������.itheima.com����������������cookie
		//cookie.setPath("/cookie");							//����ֻ�з���/cookie���·��������cookie��  �ۺϣ�����www.itheima.com/cookied�������cookie
		response.addCookie(cookie);								//����˽�Cookieд���ͻ����ݴ�
		
		// �ڶ��η��ʣ�ȥ���ͻ��˵�����cookie
		Cookie[] cookies = request.getCookies();				
		Cookie usernameCookie = null;
		if(cookies!=null){
			for(Cookie c : cookies){
				if(c.getName().equals("username")){
					usernameCookie = c;
					break;
				}
			}
			if(usernameCookie!=null){
				System.out.println("Cookie�����֣�" + usernameCookie.getName());			// ��
				System.out.println("Cookie��ֵ��" + usernameCookie.getValue());			// ֵ
				usernameCookie.setValue("SB"); 											// �����µ�ֵ
				System.out.println("Cookie��������" + usernameCookie.getMaxAge());		// ����-1������Cooki����������
				System.out.println("Cookie��·����" + usernameCookie.getPath());			// ����null��Ĭ�ϴ���ǰӦ��StudyJavaEE/��
			}
		}	// HttpWatch ���Կ���
	}
}

