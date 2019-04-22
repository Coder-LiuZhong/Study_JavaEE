package javaee01_JDBC.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import javaee01_JDBC.util.JDBCUtil;

public class A03_TestPool {

	@Test
	public void testPool(){
		Connection conn = null;
		PreparedStatement ps = null;
		A01_MyDataSource dataSource = new A01_MyDataSource();
		try {
			conn =  dataSource.getConnection();		// 获得连接池连接
			String sql = "insert into account values (null , 'xilali' , 10)";
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//conn.close()							// 不用关闭了，直接还给连接池即可
			
			//dataSource.addBack(conn);				// 归还连接
			
			JDBCUtil.release(conn, ps);				// 用包装类修饰过的ConnectionWrap的close方法会自动归还连接
		}
	}
}
