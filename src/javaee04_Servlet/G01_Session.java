package javaee04_Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * http://localhost:8081/CZBK_WEB/D36?name=jack&pass=123
 * 		客户端第一次访问服务器，创建一个session(HttpSession，键值对)存放在服务器
 * 			HttpSession session = request.getSession();
 * 		响应的时候，服务端会把session的id号发给浏览器，浏览器保存在缓存中，每次请求看这个id是否存在就行
 * 			要保存在浏览器缓存中，就要用到cookie技术；
 * 			这个cookies是内存cookies，跟一般的不一样，它会随着浏览器的关闭而消失
 * 			如果浏览器不允许缓存，那会以参数的形式存在请求头中发送；?id=123;
 * 		Session是存放在服务器内存中的一份数据，就算关了浏览器也不会销毁，除非关了服务器或者session会话时间过期
 * 			tomcat目录conf/web.xml,搜索session，里面设置了会话超时的时间是30分钟；(例如提示淘宝过了段时间叫你重新登陆)
 * 		
 * 购物车案例
 * 		我登陆淘宝买东西，会在服务器上生产一个对应的session，sessionid给到我的cookie回到浏览器;
 * 		相当于我在服务器上有一块区域来放置我的各种东西
 * 		session里面有一个购物车信息cart，存放了我放进去的商品名和数量，用Map<String,Integer>来保存
 * 		新增一个商品到购物车，就是先得到session.getAttribute("cart")，把商品名，数量1放进Map; 或者商品名存在就数量+1
 * 		再把map更新入session：session.setAttribute("cart",map);
 * 		情况购物车：清空购物车的servlet：session.removeAttribute("cart");	   或者 session.invalidate() 直接把我的会话区域干掉，其他数据也没有了
 * 
 * HttpSession常用API
 *		HttpSession session = request.getSession()	//取得该浏览器对应的HttpSession
 *		sesison.setAttribute(String,Object) 		//绑定
 *		sesison.getAttribute(String)      			//取出
 *		session.getId()
 * 		session.isNew()：true表示新HttpSession，false表示旧HttpSession
 *  
 * HttpSession细节
 *	1)由服务器在服务端产生HttpSession，存放在服务端
 *	2)每个浏览器客户端对应的服务端HttpSessin都唯一
 *	3)刷新页面后，如果原来该客户端有HttpSession，则返回false，表示为原HttpSession
 *	4)HttpSession中基于Cookie的，使用Cookie技术存储session的id号，如果浏览器禁止Cookie，Session就以参数形式发送到服务器 
 *	5)HttpSession底层是基于Cookie或URL重写技术，HttpSession会动态判段
 *	6)在全面禁止Cookie的情况下：
 *		a)重定向：response.encodeRedirectURL("/day08/ShowBookServlet");
 *		b)表单action或超连接<a>：response.encodeURL(url);
 *	7)如果让新会话共享原会话的内容，可以更新原JSESSIONID的值即可
 *
 *
 *什么样的场景下选用不同的域对象
	  1)context
		每个用户共享的信息，例如用户在线人数
		产生：部署web应用时由web服务器产生
		销毁：重新部署web应用或停止web服务器
		对于转发和重定向共享context	
	
		
	  2)request(转发)
	        一次性的信息，例如错误消息
		产生：每次请求都会由web服务器产生
		销毁：每次请求结束		
		对于转发共享request
		重定向不共享request
	
	  3)session
		每个用户独享的信息，例如购物车
		产生：request.getSession()	
		销毁：
			a)30分钟后，自动销毁，销毁不等于null
			b)手工销毁：session.invalidate()
		对于转发和重定向共享session	
 */

public class G01_Session extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		//取得该浏览器对应的HttpSession
		HttpSession session = request.getSession();		// 第一次就是创建，其他是取出;
		String sessionID = session.getId();				// 会话ID: 会自动放到cookie里面去
		System.out.println(sessionID);
		
		//将该用户个人信息绑定到session中
		session.setAttribute("NAME",name);
		session.setAttribute("PASS",pass);
		
		//转发到其他servlet显示该用户的个人信息
		request.getRequestDispatcher("/D37").forward(request,response);
	}
}




