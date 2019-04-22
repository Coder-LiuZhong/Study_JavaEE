package javaee01_JDBC.connectionpool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javaee01_JDBC.util.JDBCUtil;

/*
 * 没有读取配置文件
 * */
public class C3P0Demo {

	@Test
	public void testC3P0 (){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			/*
			 * new ComboPooledDataSource("oracle")是指定连接c3p0-config。xml里的<named-config name="oracle">
			 * 默认配置是<default-config>里面配置的mysql
			 * */
			//ComboPooledDataSource dataSource = new ComboPooledDataSource("oracle");		// 创建datasource。
			
			ComboPooledDataSource dataSource = new ComboPooledDataSource();					// 默认会找 xml 中的 default-config 分支。 
			System.out.println(dataSource.hashCode() );
			ComboPooledDataSource dataSource2 = new ComboPooledDataSource();
			System.out.println(dataSource2.hashCode()+"-------");
			
			// 设置连接数据的信息
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost/bank");		//忘记了就去找以前的代码或者找jdbc的文档
			dataSource.setUser("root");
			dataSource.setPassword("root");
			
			//2. 得到连接对象
			conn = dataSource.getConnection();
			String sql = "insert into account values(null , ? , ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "admi234n");
			ps.setInt(2, 103200);
			System.out.println();
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps);
		}
	}
}
