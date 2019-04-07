package javaee01_JDBC.curd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javaee01_JDBC.util.JDBCUtil;

/*
 * ע����������ȡ���ӡ��ͷ���Դ�⼸�����������ȡ�����ŵ�һ����������
 * �������ֹ����Ĳ��־��ܸ�������ͬ��������ȥ����
 * */
public class A02_JDBCUtil {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConn();			//ע������������������������Ŀ����Ϊ�˵õ�conn��������Ҳ�Ѵ����װ��JDBCUtil���ķ�������ȥ

			// 3.����statement
			st = conn.createStatement();		//�����ݿ�򽻵���һ����Ҫ�������;
			
			// 4.ִ�в�ѯ���õ������ResultSet
			String sql = "select * from college";
			rs = st.executeQuery(sql);
			
			// 5.������ѯÿһ����¼
			while(rs.next()){
				int id = rs.getInt("id");
				String college_name = rs.getString("college_name");
				System.out.println("id="+id+";college_name="+college_name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 6.�ͷ���Դ
			JDBCUtil.release(conn, st, rs);		//  �ر���Դ��������finally����ֱ��дclose�ģ�Ϊ�˴��븴�ã�����ȡ�ŵ�JDBCUtil����������ȥ��
		}
		
	}

}
