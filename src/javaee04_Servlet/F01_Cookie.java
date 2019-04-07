package javaee04_Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 会话
 * 	    用户开一个浏览器，点击多个超链接，访问服务器多个web资源，然后关闭浏览器，整个过程称之为一个会话。
 *    不同浏览器不同的网站都不是一个会话
 * 		例如，用户A在超市购买的任何商品都应该放在A的购物车内，不论是用户A什么时间购买的，这都是属于同一个会话的；
 * 			   不能放入用户B或用户C的购物车内，这不属于同一个会话。
 * 		Web应用程序是使用HTTP协议传输数据的。HTTP协议是无状态的协议(“连接-请求-应答-关闭连接”)。
 * 		一旦数据交换完毕，客户端与服务器端的连接就会关闭，再次交换数据需要建立新的连接。这就意味着服务器无法从连接上跟踪会话。
 * 		即用户A购买了一件商品放入购物车内，当再次购买商品时服务器已经无法判断该购买行为是属于用户A的会话还是用户B的会话了。要跟踪该会话，必须引入一种机制。
 * 
 * Cookie
 * 		服务器发送给客户端的一份小数据，让它成为服务器的通行证
 * 		客户端请求服务器，如果服务器需要记录该用户状态，就使用response向客户端浏览器颁发一个Cookie。
 * 		客户端浏览器会把Cookie保存起来。当浏览器再请求该网站时，浏览器把请求的网址连同该Cookie一同提交给服务器。
 * 		服务器检查该Cookie，以此来辨认用户状态。服务器还可以根据需要修改Cookie的内容。
 *   
 * Session
 * 		基于cookie，客户端数据存放在服务端
 * 		如果说Cookie机制是通过检查客户身上的“通行证”来确定客户身份的话，
 *		那么Session机制就是通过检查服务器上的“客户明细表”来确认客户身份。
 *		Session相当于程序在服务器上建立的一份客户档案，客户来访的时候只需要查询客户档案表就可以了。   
 *   
 * CZBK  
 *		多个用户点击超链接通过一个servlet各自购买了一个商品，服务器应该想办法把每一个用户购买的商品保存在各自的地方，
 *  	以便于这些用户点结帐servlet时，结帐servlet可以得到用户各自购买的商品为用户结帐。
 *		这就说明服务器需要有个域对象，让所有servlet共享一些信息；前面我们学了ServletContext、HttpServletRequest两个域对象；
 *			request,  如果是访问重新进行了那就不行了；
 *			context,  tomcat运行在JVM中，JVM运行在内存中是有大小限制的，所以，context不能在数量大的情况下使用；每个用户存点信息，那大网站不崩溃了；
 *		所以，我们用新的域对象；
 *  	服务器把每个用户的数据以cookie的形式写给用户各自的浏览器。
 *  	当用户使用浏览器再去访问服务器中的web资源时，就会带着各自的数据去。这样，web资源处理的就是用户各自的数据了。
 *		Session是服务器端技术，利用这个技术，服务器在运行时可以为每一个用户的浏览器创建一个其独享的session对象；
 *		由于session为用户浏览器独享，所以用户在访问服务器的web资源时，可以把各自的数据放在各自的session中，
 *		当用户再去访问服务器中的其它web资源时，其它web资源再从用户各自的session中取出数据为用户服务。
 *
 * Cookie
 *   1)Cookie是客户端的技术;
 *   2)每次发送请求时，客户端都会带上各自已的不同Cookie到服务端，服务端一解析Cookie，就知道是哪个客户端发送过来的信息;
 *   3)一个Cookie只能存储一种类型的信息
 *   4)更新某个Cookie，即向浏览器写一个相同名的Cookie
 *   5)Cookie一定要设置一个有效时间，如果不设置的话，默认该请求访问结束后，该Cookie自动销毁，用专业名词来讲，Cookie的默认有效期时一个有效会话结束
 *  
 * Cookie细节
 *	  1)Cookie只能封装一种类型的信息，而且该信息的值只能是String类型
 *	  2)Cookie由服务端产生，存放在客户端
 *	  3)Cookie存储某个网点的数量有限
 *	  4)在默认情况下，Cookie是会话级别，一般来讲，都要对Cookie设置最大的存活时间，以秒为单位
 *	  5)如果向浏览器发送名字一样的Cookie，表示更新原Cookie
 *	  6)如果要删除Cookie,可以设置该Cookie的存活时间为0   
 *
 * 附加：Cookie有什么缺点？
 *		安全性不高;放在客户端，能被操作；工作种cookie都是存的加密数据;
 *      cookie存多少个有限制的
 *		某些操作系统平台上运行的浏览器可以阻止服务端写入Cookie
 *
 * 商品浏览记录案例
 * 		商品页面点击图片，进入商品详情：  进入详情页访问详情servlet：
		详情servlet取到链接里带过来的商品ID，如果第一次访问这商品，cookie==null;  new Cookie("history",ID1)
		如果cookie!=null，取出以前的cookie，把商品ID用符号拼接再放入cookie；
		跳转到jsp详情页面，取出cookie值，分割字符，得到已经访问过的商品id，遍历显示；
 * */
public class F01_Cookie extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		// 第一次访问：给客户端一个cookie
		Cookie cookie = new Cookie("username","haha");			//构造Cookie，传入两个String，键值对；
		cookie.setMaxAge(1*24*60*60);							//设置Cookie存活时间；设置为-1,浏览器关了就失效；如果不写，那请求接收，Cookie就没了；
		//cookie.setDomain(".itheima.com");						//设置只有请求.itheima.com这个域名才允许带上cookie
		//cookie.setPath("/cookie");							//设置只有访问/cookie这个路径才能上cookie；  综合：访问www.itheima.com/cookied才允许带cookie
		response.addCookie(cookie);								//服务端将Cookie写到客户端暂存
		
		// 第二次访问，去除客户端的所有cookie
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
				System.out.println("Cookie的名字：" + usernameCookie.getName());			// 键
				System.out.println("Cookie的值：" + usernameCookie.getValue());			// 值
				usernameCookie.setValue("SB"); 											// 设置新的值
				System.out.println("Cookie的生命：" + usernameCookie.getMaxAge());		// 返回-1，代表Cooki是有生命的
				System.out.println("Cookie的路径：" + usernameCookie.getPath());			// 返回null，默认代表当前应用StudyJavaEE/；
			}
		}	// HttpWatch 可以看到
	}
}

