package javaee01_JDBC.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

import javaee01_JDBC.util.JDBCUtil02;

public class C3P0Test {

	public static void main(String[] args) {
		
		try {
			Connection conn = JDBCUtil02.getConn();
			conn.prepareStatement(null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
