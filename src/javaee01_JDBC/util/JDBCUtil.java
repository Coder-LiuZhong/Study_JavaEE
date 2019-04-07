package javaee01_JDBC.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * StudyJDBC��Ŀ���߰�
 * @author liuzhong
 * 2019.03.18
 * */
public final class JDBCUtil {            // final,���ܱ��̳�
	
	private static String url = null;
	private static String name = null;
	private static String password = null;
	private static String driverClass = null;
	
	/*
	 * ͨ��static��̬���������ʼ���ࣺ��ȡjdbc.properties�����ļ������������úõĲ�����
	 * */
	static{
		try{
			//��������������ǽ�binĿ¼�µ�class�ļ����أ����и����þ���˳�㽫bin�������ԴҲ�����ķ�ʽ���ء�����jdbc.propertiesҪ����srcĿ¼�£��Ż������bin�У��Ż�����������õ���
			InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("javaee01_JDBC/jdbc.properties") ;
			
			//���jdbc.properties���Ƿ���src���棬������Ŀ��Ŀ¼�£��Ǿ�������ķ�ʽֱ�Ӷ�ȡ��
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
	 * ������Ӷ���ʽ
	 * @return
	 * */
	public static Connection getConn(){
		Connection conn = null;
		
		try {
			/*
			 * Base01������ôע��ģ�DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			 * �����ǽ�ȥDriver��Դ���룬�и�static��̬����飬����������ͬ���Ĵ��룬��static�������������ص�ʱ��(new)ִ��һ��(Ҳִֻ��һ��)��������������൱��ע�������Σ�
			 * ����ע��������ʵ��������У�Class.forName("com.mysql.jdbc.Driver");
			 * */
			Class.forName(driverClass);			//1.ע������������ʵJDBC4.0֮���Ѿ�����Ҫע���ˣ�������Բ���Ҫд�ˣ�
			
			/*
			 * ����ʵ��JDBC 4.0ֻ�еİ汾���Ѿ�����Ҫ����Ĵ�����ע�������ˣ�д��Ҳû��ϵ��
			 * �ڵ����jar����չ�����и�META-INF�ļ��У�����services�ļ��У��и�java.sql.Driver�ļ��Ѿ����ú������������ͣ�
			 * �����������Ŀ����ͬʱ���ڶ�����ݿ��JDBC��jar�����Ǿ͵�д����������ˣ�
			 * */
			
			conn = DriverManager.getConnection(url,name,password);	//2.�������
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * �ͷ���Դ
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
	 * �ͷ���Դ
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
