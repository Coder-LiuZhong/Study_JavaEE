package javaee01_JDBC.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import javaee01_JDBC.util.JDBCUtil;

public class transaction {

	@Test
	public void testTransaction(){
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = JDBCUtil.getConn();

	        //连接，事务默认就是自动提交的。 关闭自动提交。
	        conn.setAutoCommit(false);

	        String sql = "update account set money = money - ? where id = ?";
	        ps = conn.prepareStatement(sql);

	        //扣钱， 扣ID为1 的100块钱
	        ps.setInt(1, 100);
	        ps.setInt(2, 1);
	        ps.executeUpdate();

	        int a = 10 /0 ;

	        //加钱， 给ID为2 加100块钱
	        ps.setInt(1, -100);
	        ps.setInt(2, 2);
	        ps.executeUpdate();

	        //成功： 提交事务。
	        conn.commit();

	    } catch (SQLException e) {
	        try {
	            //事变： 回滚事务
	            conn.rollback();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	        e.printStackTrace();
	    }finally {
	        JDBCUtil.release(conn, ps, rs);
	    }
	}
}