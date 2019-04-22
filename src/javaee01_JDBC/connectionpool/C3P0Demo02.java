package javaee01_JDBC.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javaee01_JDBC.util.JDBCUtil;

/*
 * 读取配置文件
 * */
public class C3P0Demo02 {

	@Test
	public void testC3P0(){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			//就new了一个对象。 源码中会用类加载器加载xml文件，所以名字c3p0-config.xml不能变。路径也是要在src下
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			
			//2. 得到连接对象
			conn = dataSource.getConnection();
			String sql = "insert into account values(null , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "wangwu2");
			ps.setInt(2, 2600);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
