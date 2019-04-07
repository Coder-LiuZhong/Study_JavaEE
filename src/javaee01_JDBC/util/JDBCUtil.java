package javaee01_JDBC.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * StudyJDBC项目工具包
 * @author liuzhong
 * 2019.03.18
 * */
public final class JDBCUtil {            // final,不能被继承
	
	private static String url = null;
	private static String name = null;
	private static String password = null;
	private static String driverClass = null;
	
	/*
	 * 通过static静态代码块来初始化类：读取jdbc.properties配置文件里面事先设置好的参数；
	 * */
	static{
		try{
			//类加载器的作用是将bin目录下的class文件加载，还有个作用就是顺便将bin下面的资源也以流的方式加载。所以jdbc.properties要放在src目录下，才会存在于bin中，才会用下面的语句得到；
			InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("javaee01_JDBC/jdbc.properties") ;
			
			//如果jdbc.properties不是放在src下面，放在项目根目录下，那就用下面的方式直接读取；
			//InputStream is = new FileInputStream("jdbc.properties");  
			
			Properties properties = new Properties();
			properties.load(is);
			
			driverClass = properties.getProperty("driverClass");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得连接对象方式
	 * @return
	 * */
	public static Connection getConn(){
		Connection conn = null;
		
		try {
			/*
			 * Base01中是这么注册的：DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			 * 当我们进去Driver类源代码，有个static静态代码块，里面有上面同样的代码，而static代码块是在类加载的时候(new)执行一次(也只执行一次)，所以上面语句相当于注册了两次；
			 * 所以注册驱动其实用这个就行：Class.forName("com.mysql.jdbc.Driver");
			 * */
			Class.forName(driverClass);			//1.注册驱动；但其实JDBC4.0之后，已经不需要注册了，这个可以不需要写了；
			
			/*
			 * 但其实，JDBC 4.0只有的版本，已经不需要上面的代码来注册驱动了，写了也没干系；
			 * 在导入的jar库中展开，有个META-INF文件夹，进入services文件夹，有个java.sql.Driver文件已经配置好了驱动的类型；
			 * 不过，如果项目里面同时存在多个数据库的JDBC的jar包，那就得写上这个代码了；
			 * */
			
			conn = DriverManager.getConnection(url,name,password);	//2.获得连接
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param st
	 * @param rs
	 * */
	public static void release(Connection conn,Statement st,ResultSet rs){
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param st
	 * */
	public static void release(Connection conn,Statement st){
		closeSt(st);
		closeConn(conn);
	}
	
	private static void closeRs(ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			rs = null;
		}
	}
	
	private static void closeSt(Statement st){
		try {
			if (st != null) {
				st.close();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			st = null;
		}
	}
	
	private static void closeConn(Connection conn){
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
