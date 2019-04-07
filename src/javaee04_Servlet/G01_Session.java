package javaee04_Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * http://localhost:8081/CZBK_WEB/D36?name=jack&pass=123
 * 		�ͻ��˵�һ�η��ʷ�����������һ��session(HttpSession����ֵ��)����ڷ�����
 * 			HttpSession session = request.getSession();
 * 		��Ӧ��ʱ�򣬷���˻��session��id�ŷ��������������������ڻ����У�ÿ���������id�Ƿ���ھ���
 * 			Ҫ����������������У���Ҫ�õ�cookie������
 * 			���cookies���ڴ�cookies����һ��Ĳ�һ������������������Ĺرն���ʧ
 * 			���������������棬�ǻ��Բ�������ʽ��������ͷ�з��ͣ�?id=123;
 * 		Session�Ǵ���ڷ������ڴ��е�һ�����ݣ�������������Ҳ�������٣����ǹ��˷���������session�Ựʱ�����
 * 			tomcatĿ¼conf/web.xml,����session�����������˻Ự��ʱ��ʱ����30���ӣ�(������ʾ�Ա����˶�ʱ��������µ�½)
 * 		
 * ���ﳵ����
 * 		�ҵ�½�Ա����������ڷ�����������һ����Ӧ��session��sessionid�����ҵ�cookie�ص������;
 * 		�൱�����ڷ���������һ�������������ҵĸ��ֶ���
 * 		session������һ�����ﳵ��Ϣcart��������ҷŽ�ȥ����Ʒ������������Map<String,Integer>������
 * 		����һ����Ʒ�����ﳵ�������ȵõ�session.getAttribute("cart")������Ʒ��������1�Ž�Map; ������Ʒ�����ھ�����+1
 * 		�ٰ�map������session��session.setAttribute("cart",map);
 * 		������ﳵ����չ��ﳵ��servlet��session.removeAttribute("cart");	   ���� session.invalidate() ֱ�Ӱ��ҵĻỰ����ɵ�����������Ҳû����
 * 
 * HttpSession����API
 *		HttpSession session = request.getSession()	//ȡ�ø��������Ӧ��HttpSession
 *		sesison.setAttribute(String,Object) 		//��
 *		sesison.getAttribute(String)      			//ȡ��
 *		session.getId()
 * 		session.isNew()��true��ʾ��HttpSession��false��ʾ��HttpSession
 *  
 * HttpSessionϸ��
 *	1)�ɷ������ڷ���˲���HttpSession������ڷ����
 *	2)ÿ��������ͻ��˶�Ӧ�ķ����HttpSessin��Ψһ
 *	3)ˢ��ҳ������ԭ���ÿͻ�����HttpSession���򷵻�false����ʾΪԭHttpSession
 *	4)HttpSession�л���Cookie�ģ�ʹ��Cookie�����洢session��id�ţ�����������ֹCookie��Session���Բ�����ʽ���͵������� 
 *	5)HttpSession�ײ��ǻ���Cookie��URL��д������HttpSession�ᶯ̬�ж�
 *	6)��ȫ���ֹCookie������£�
 *		a)�ض���response.encodeRedirectURL("/day08/ShowBookServlet");
 *		b)��action������<a>��response.encodeURL(url);
 *	7)������»Ự����ԭ�Ự�����ݣ����Ը���ԭJSESSIONID��ֵ����
 *
 *
 *ʲô���ĳ�����ѡ�ò�ͬ�������
	  1)context
		ÿ���û��������Ϣ�������û���������
		����������webӦ��ʱ��web����������
		���٣����²���webӦ�û�ֹͣweb������
		����ת�����ض�����context	
	
		
	  2)request(ת��)
	        һ���Ե���Ϣ�����������Ϣ
		������ÿ�����󶼻���web����������
		���٣�ÿ���������		
		����ת������request
		�ض��򲻹���request
	
	  3)session
		ÿ���û��������Ϣ�����繺�ﳵ
		������request.getSession()	
		���٣�
			a)30���Ӻ��Զ����٣����ٲ�����null
			b)�ֹ����٣�session.invalidate()
		����ת�����ض�����session	
 */

public class G01_Session extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//ȡ�ø��������Ӧ��HttpSession
		HttpSession session = request.getSession();		// ��һ�ξ��Ǵ�����������ȡ��;
		String sessionID = session.getId();				// �ỰID: ���Զ��ŵ�cookie����ȥ
		System.out.println(sessionID);
		
		//�����û�������Ϣ�󶨵�session��
		session.setAttribute("NAME",name);
		session.setAttribute("PASS",pass);
		
		//ת��������servlet��ʾ���û��ĸ�����Ϣ
		request.getRequestDispatcher("/D37").forward(request,response);
	}
}




