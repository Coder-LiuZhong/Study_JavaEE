<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%-- 
	jsp:useBean 
		拿到JavaBean对象，通过反射javaee05_Jsp.temp.Student生成实例赋值给id(student)；并存入scope指定的作用域
	jsp:setProperty 
		给JavaBean属性赋值：给对象student的属性name值value设置为jack，相当于setName("jack")
		也可以是Map；参考/javaee05_jsp/06_El/01_getdata.jsp
		
	 JavaBean
		特定的java类；必须具有一个无参数的构造函数；
		属性必须私有化；
		私有化的属性必须通过public方法暴露给其他的程序；方法名也有规范；
--%>

<html>
  <body>
  	<jsp:useBean id="student" class="javaee05_Jsp.temp.Student" scope="page">
  		查看jsp翻译成servlet后的work里面的代码								<br/>
	  		Student s = Class.forName("jsp.javabean.Student").newInstance;	<br/>
	  			容器根据class类名进行反射处理，生成实例，得到s作为id			<br/>
	  		pageContext.setAttrubite("student",s);							<br/>
	  			把实例对象加入到当前域										<br/>
	  			id两个意思，一个只域里的名称，一个代表javabean对象				<br/>
	  			
	  	如果在域对象中有对应的JavaBean，那么这段代码就是找到JavaBean对象，而不会创建	<br/>
  	</jsp:useBean> 
  	
  	<hr/>

<%-- 	
	给JavaBean设置属性：给对象student的属性name值value设置为jack，相当于setName("jack")
	<jsp:setProperty name="student" property="name" value="jack"/>
  	<jsp:setProperty name="student" property="age" value="30"/>
  	<jsp:setProperty name="student" property="salary" value="5000"/>
  		该标签可以将String到8种基本类型的转换：上面salary是double类型，这里虽然是String也可以;
  	<hr/> 
--%>
  	
<%--   	
	<jsp:setProperty name="student" property="name" param="n"/>
  	<jsp:setProperty name="student" property="age" param="a"/>
  	<jsp:setProperty name="student" property="salary" param="s"/>
  		第二种方式：链接后面接上参数
  		访问：	http://www.liuzhong.com:8081/CZBK_WEB/jsp/04_BiaoQian/19_javabean.jsp?n=liu&a=27&s=8000
  		相当于：student.setName(request.getParams(n));
  	<hr/> 
--%>

<!--  
  	<jsp:setProperty name="student" property="*"/>
  		第三种方式：链接后面的变量名字正好都是progerty名字一样的；
  		http://www.liuzhong.com:8081/CZBK_WEB/jsp/04_BiaoQian/19_javabean.jsp?name=liu&age=27&salary=8000
  	
  	用户名： <jsp:getProperty property="name" name="student"/>		<br/>
  	年龄：	<jsp:getProperty property="age" name="student"/>		<br/>
  	薪水：	<jsp:getProperty property="salary" name="student"/>		<br/> 
  	<hr/>
-->
  	
  </body>
</html>