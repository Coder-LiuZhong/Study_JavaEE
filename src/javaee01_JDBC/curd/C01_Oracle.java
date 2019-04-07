package javaee01_JDBC.curd;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import oracle.jdbc.OracleTypes;

/*
 * 调用Oracle的存储过程
 *     1. 导入驱动包：D:\Installation Package\Oracle\JDBC驱动包
 *     2. 注册驱动：Class.forName("oracle.jdbc.driver.OracleDriver"); 导入的jar包下找到oracle.jdbc.driver下面有个OracleDriver类；
 *     3. 获取连接：Connection conn = DriverManager.getConnection('jdbc:oracle:thin:@192.168.32.131:1521:orcl','scott','tiger');
 *     4. 获取执行SQL的statement：CallableStatement state = conn.prepareCall('{call proc_gettotalsal(?,?)}');
 *     5. 封装参数:state.registerOutParameter(2, OracleTypes.NUMBER);
 *     6. 执行SQL:state.execute();
 *     7. 获取结果:int totalsal = state.getInt(2);
 *     8. 释放资源
 * */
public class C01_Oracle {

	// 调用存储过程
	@Test
	public void test1() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@192.168.32.131:1521:orcl";
		String username = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url,username,password);
		
		String sql = "{call proc_gettotalsal(?,?)}";
		CallableStatement state = conn.prepareCall(sql);    // JDK 文档里面可以查看到
		state.setInt(1, 7788);								// 第一个问号：设置输入参数
		state.registerOutParameter(2, OracleTypes.NUMBER);  // 第二个问号；注册输出参数，设置参数类型
		
		state.execute();
		
		int totalsal = state.getInt(2);    					//  输出参数是2
		System.out.println("工资："+totalsal);
		
		state.close();
		conn.close();
	}
	
	// 调用存储函数
	@Test
	public void test2() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String url = "jdbc:oracle:thin:@192.168.32.131:1521:orcl";
		String username = "scott";
		String password = "tiger";
		Connection conn = DriverManager.getConnection(url,username,password);
		
		String sql = "{?=call func_getsal(?)}";
		CallableStatement state = conn.prepareCall(sql);   
		
		state.registerOutParameter(1, OracleTypes.NUMBER);  // 第1个问号；注册返回参数类型
		state.setInt(2, 7788);								// 第2个问号：设置输入参数
		
		state.execute();
		
		int totalsal = state.getInt(1);    					// 输出参数是1
		System.out.println("工资："+totalsal);
		
		state.close();
		conn.close();
	}

}
