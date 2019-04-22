package javaee01_JDBC.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javaee01_JDBC.util.JDBCUtil;

/*
 * 不使用配置文件dbcpconfig.properties的方式
 * */
public class DBCPDemo {
	
	@Test
	public void testDBCP01(){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1. 构建数据源对象
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost/bank");			// 主协议：子协议 ://本地/数据库
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			
			//2. 得到连接对象
			conn = dataSource.getConnection();
			String sql = "insert into account values(null , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "admin");
			ps.setInt(2, 1000);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
