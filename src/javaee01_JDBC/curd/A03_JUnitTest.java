package javaee01_JDBC.curd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import javaee01_JDBC.util.JDBCUtil;

/*
 * ��JUnit��Ԫ���������Դ���
 * 		1. ����һ���࣬TestXXX�����涨�巽����testXXX(); ��Ŀ�����ֲ�����һ�����test�����棻
 * 		2. ���jar; ��Ŀ�Ҽ�������·������ӿ⣬ѡ��MyEclipse�Դ�JUnit�Ŀ�
 * 		3. testXXX()�������@Test
 * 		4. ������Ҽ������У�JUnit������Outline����ѡ�з����Ҽ�Ҳ���ԣ�
 * 
 *  ��ɫ�����֣�������������û���⡣���ǽ���Ƿ�Բ���ȷ����
 *  ��ɫ�����֣�˵�����������⡣
 */

public class A03_JUnitTest {

	@Test
	public void testQuery(){			//��ѯ
		Connection conn  = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			
			String sql = "select * from college";
			rs= st.executeQuery(sql);  //executeQuery(sql)
			
			while(rs.next()){
				String collegeName = rs.getString("college_name");
				System.out.println(collegeName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st, rs);
		}
	}

	@Test
	public void testInsert(){		//����
		Connection conn  = null;
		Statement st = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			
			String sql = "insert into college values(null,'���Ŵ�ѧ','�ô�',2,0,'׼����ҫ��');";
			int result = st.executeUpdate(sql);    //executeUpdate(sql)
			
			if(result>0){
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st);
		}
	}
	
	@Test
	public void testDelete(){
		Connection conn = null;
		Statement st = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			
			String sql = "delete from college where id='111111'";
			int result = st.executeUpdate(sql);
			
			if(result >0 ){
				System.out.println("ɾ���ɹ�");
			}else{
				System.out.println("ɾ��ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, st);
		}

	}
	
	@Test
	public void testUpdate(){
		Connection conn = null;
		Statement st = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			
			String sql = "update college set remark = '��������' where id =3";
			int result = st.executeUpdate(sql);
			
			if(result >0 ){
				System.out.println("���³ɹ�");
			}else{
				System.out.println("����ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, st);
		}
		
	}
	
}
