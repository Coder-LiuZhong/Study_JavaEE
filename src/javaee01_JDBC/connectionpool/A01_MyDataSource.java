package javaee01_JDBC.connectionpool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javaee01_JDBC.util.JDBCUtil;

/**
 * 这是一个数据库连接池
 * 继承MyDataSource接口规范
 * 一开始先往池子里面放10个连接
 * 		1. 开始创建10个连接。
 * 		2. 来的程序通过getConnection()获取连接
 * 		3. 用完之后，使用addBack()归还连接。
 * 		4. 扩容。 
 */
public class A01_MyDataSource implements DataSource {
	
	List <Connection> list = new ArrayList<Connection>();	// 用来装连接
	
	public A01_MyDataSource() {
		for (int i = 0; i < 10; i++) {
			Connection conn = JDBCUtil.getConn();			// 一开始就创建10个连接放到list
			list.add(conn);
		}
	}
	
	/**
	 * 外界获取该连接池连接的方法
	 * 返回一个连接
	 * */
	@Override
	public Connection getConnection() throws SQLException {
		if(list.size() == 0 ){								// 来拿连接的时候，先看看，池子里面还有没有。
			for (int i = 0; i < 5; i++) {
				Connection conn = JDBCUtil.getConn();
				list.add(conn);
			}
		}
		
		/*
		 * 外接获取连接池，返回值就得返回一个连接池过去。
		 * 既然被人用了，就得移除出连接池，移除第一个，集合中的第一个， 移除的是开始的那个元素。
		 * */ 
		//Connection conn = list.remove(0);
		//return conn;
		
		// 返回一个Connection的包装类实现ConnectionWrap，用它里面的改写过的close()来归还对象
		Connection conn = list.remove(0);
		Connection connection = new A02_ConnectionWrap(conn, list);
		return connection;
	}

	/**
	 * Java程序用完连接之后，记得归还。
	 * @param conn
	 */
	public void addBack(Connection conn){
		list.add(conn);
	}

	//---------------------------以下都是实现接口里面的方法重写

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
