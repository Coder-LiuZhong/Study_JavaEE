package javaee01_JDBC.curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* JAVA Database Connectivity   Java数据链接
 * 		数据库的种类很多，Java语言使用广泛，所以SUN公司提供的一种访问数据库的规范(JDBC)；
 * 		让MySQL、Oracle等其他数据库厂商去实现它的底层访问，Java程序就直接找JDBC接口就可以去操作各个数据库了，不用管各个数据库分别怎么去增删改查；
 * 		Java应用程序-->JDBC（接口）-->驱动（厂商对JDBC规范做实现，类的集合）-->数据库(MySql、Oracle)；
 * 
 * 		java.sql（基本）、javax.sql（高级） 
 * 
 *  1.  需要有MySQL实现的JDBC的驱动jar包：
 *  	D:\WorkingTools\Installation Package\MySql\JDBC驱动\mysql-jdbc-517\mysql-connector-java-5.1.7\mysql-connector-java-5.1.7-bin.jar；
 *  	各数据库官网可下载，源文件src文件夹也可导入eclipse  
 *  2.  MyEclipse里，新建一个跟src平级的目录lib，把jar包拖进去；   
 *  	然后右键Build Path -- Add to Build Path，加到外部引用库里面
 *  
 *  JDBC使用步骤参考C01_Oracle
 *  	1，注册数据库驱动
 *  	2，取得数据库连接对象Connection
 * 		3，创建SQL对象statement
 * 		4，执行SQL命令，并返回结果集
 * 		5，处理结果集
 * 		6，依次关闭结果集
 */

public class A01_Base {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// 1.注册驱动；
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());		

			/*
			 * DriverManager.registerDriver 需要的参数是java.sql.Driver；它是个接口
			 * java.sql.Driver driver = null;
			 * Driver上ctrl+t可以看到这个接口的层次结构，com.mysql.jdbc.Driver()实现了它，所以接口的子类可以作为registerDriver参数
			 * java.sql.Driver(接口)----com.mysql.jdbc.Driver(实现类)
			 * */
			
			// 2.建立连接
			conn = DriverManager.getConnection("jdbc:mysql://192.168.32.131/cuba", "root", "root");    // 数据库地址和数据库；用户名和密码
			
			// 3.建立statement
			st = conn.createStatement();		//跟数据库打交道，一定需要这个对象; 封装sql，向数据库发送；
			
			// 4.执行查询，得到结果集ResultSet
			String sql = "select * from college";
			rs = st.executeQuery(sql);
			
			// 5.遍历查询每一条记录
			while(rs.next()){                   //是否有数据，有就返回true(),并往下移一位；初始化的时候，位于第一条记录之上；
				int id = rs.getInt("id");       
				String college_name = rs.getString("college_name");
				System.out.println("id="+id+";college_name="+college_name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			// 6.释放资源；  先用的后关闭；
			try {
				if (rs != null) {
					rs.close();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
			
			try {
				if (st != null) {
					st.close();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				st = null;
			}
			
			try {
				if (conn != null) {
					conn.close();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn = null;
			}

		}
		
	}

}
