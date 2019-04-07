package javaee01_JDBC.curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* JAVA Database Connectivity   Java��������
 * 		���ݿ������ܶ࣬Java����ʹ�ù㷺������SUN��˾�ṩ��һ�ַ������ݿ�Ĺ淶(JDBC)��
 * 		��MySQL��Oracle���������ݿ⳧��ȥʵ�����ĵײ���ʣ�Java�����ֱ����JDBC�ӿھͿ���ȥ�����������ݿ��ˣ����ùܸ������ݿ�ֱ���ôȥ��ɾ�Ĳ飻
 * 		JavaӦ�ó���-->JDBC���ӿڣ�-->���������̶�JDBC�淶��ʵ�֣���ļ��ϣ�-->���ݿ�(MySql��Oracle)��
 * 
 * 		java.sql����������javax.sql���߼��� 
 * 
 *  1.  ��Ҫ��MySQLʵ�ֵ�JDBC������jar����
 *  	D:\WorkingTools\Installation Package\MySql\JDBC����\mysql-jdbc-517\mysql-connector-java-5.1.7\mysql-connector-java-5.1.7-bin.jar��
 *  	�����ݿ���������أ�Դ�ļ�src�ļ���Ҳ�ɵ���eclipse  
 *  2.  MyEclipse��½�һ����srcƽ����Ŀ¼lib����jar���Ͻ�ȥ��   
 *  	Ȼ���Ҽ�Build Path -- Add to Build Path���ӵ��ⲿ���ÿ�����
 *  
 *  JDBCʹ�ò���ο�C01_Oracle
 *  	1��ע�����ݿ�����
 *  	2��ȡ�����ݿ����Ӷ���Connection
 * 		3������SQL����statement
 * 		4��ִ��SQL��������ؽ����
 * 		5����������
 * 		6�����ιرս����
 */

public class A01_Base {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// 1.ע��������
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());		

			/*
			 * DriverManager.registerDriver ��Ҫ�Ĳ�����java.sql.Driver�����Ǹ��ӿ�
			 * java.sql.Driver driver = null;
			 * Driver��ctrl+t���Կ�������ӿڵĲ�νṹ��com.mysql.jdbc.Driver()ʵ�����������Խӿڵ����������ΪregisterDriver����
			 * java.sql.Driver(�ӿ�)----com.mysql.jdbc.Driver(ʵ����)
			 * */
			
			// 2.��������
			conn = DriverManager.getConnection("jdbc:mysql://192.168.32.131/cuba", "root", "root");    // ���ݿ��ַ�����ݿ⣻�û���������
			
			// 3.����statement
			st = conn.createStatement();		//�����ݿ�򽻵���һ����Ҫ�������; ��װsql�������ݿⷢ�ͣ�
			
			// 4.ִ�в�ѯ���õ������ResultSet
			String sql = "select * from college";
			rs = st.executeQuery(sql);
			
			// 5.������ѯÿһ����¼
			while(rs.next()){                   //�Ƿ������ݣ��оͷ���true(),��������һλ����ʼ����ʱ��λ�ڵ�һ����¼֮�ϣ�
				int id = rs.getInt("id");       
				String college_name = rs.getString("college_name");
				System.out.println("id="+id+";college_name="+college_name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			// 6.�ͷ���Դ��  ���õĺ�رգ�
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
