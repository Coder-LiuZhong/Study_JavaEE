package javaee01_JDBC.curd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import oracle.jdbc.OracleTypes;

/*
 * ����Oracle�Ĵ洢����
 *     1. ������������D:\Installation Package\Oracle\JDBC������
 *     2. ע��������Class.forName("oracle.jdbc.driver.OracleDriver"); �����jar�����ҵ�oracle.jdbc.driver�����и�OracleDriver�ࣻ
 *     3. ��ȡ���ӣ�Connection conn = DriverManager.getConnection('jdbc:oracle:thin:@192.168.32.131:1521:orcl','scott','tiger');
 *     4. ��ȡִ��SQL��statement��CallableStatement state = conn.prepareCall('{call proc_gettotalsal(?,?)}');
 *     5. ��װ����:state.registerOutParameter(2, OracleTypes.NUMBER);
 *     6. ִ��SQL:state.execute();
 *     7. ��ȡ���:int totalsal = state.getInt(2);
 *     8. �ͷ���Դ
 * */
public class C01_Oracle {

	// ���ô洢����
	@Test
	public void test1() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@192.168.32.131:1521:orcl";
		String username = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url,username,password);
		
		String sql = "{call proc_gettotalsal(?,?)}";
		CallableStatement state = conn.prepareCall(sql);    // JDK �ĵ�������Բ鿴��
		state.setInt(1, 7788);								// ��һ���ʺţ������������
		state.registerOutParameter(2, OracleTypes.NUMBER);  // �ڶ����ʺţ�ע��������������ò�������
		
		state.execute();
		
		int totalsal = state.getInt(2);    					//  ���������2
		System.out.println("���ʣ�"+totalsal);
		
		state.close();
		conn.close();
	}
	
	// ���ô洢����
	@Test
	public void test2() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@192.168.32.131:1521:orcl";
		String username = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url,username,password);
		
		String sql = "{?=call func_getsal(?)}";
		CallableStatement state = conn.prepareCall(sql);   
		
		state.registerOutParameter(1, OracleTypes.NUMBER);  // ��1���ʺţ�ע�᷵�ز�������
		state.setInt(2, 7788);								// ��2���ʺţ������������
		
		state.execute();
		
		int totalsal = state.getInt(1);    					// ���������1
		System.out.println("���ʣ�"+totalsal);
		
		state.close();
		conn.close();
	}

}
