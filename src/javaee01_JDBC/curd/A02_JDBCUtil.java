package javaee01_JDBC.curd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javaee01_JDBC.util.JDBCUtil;

/*
 * 注册驱动、获取连接、释放资源这几个步骤可以提取出来放到一个工具类中
 * 这样这种公共的部分就能给其他相同操作的类去复用
 * */
public class A02_JDBCUtil {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConn();			//注册驱动、建立连接两个步骤目的是为了得到conn对象，所以也把代码封装到JDBCUtil包的方法里面去

			// 3.建立statement
			st = conn.createStatement();		//跟数据库打交道，一定需要这个对象;
			
			// 4.执行查询，得到结果集ResultSet
			String sql = "select * from college";
			rs = st.executeQuery(sql);
			
			// 5.遍历查询每一条记录
			while(rs.next()){
				int id = rs.getInt("id");
				String college_name = rs.getString("college_name");
				System.out.println("id="+id+";college_name="+college_name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			// 6.释放资源
			JDBCUtil.release(conn, st, rs);		//  关闭资源本来是在finally里面直接写close的，为了代码复用，就提取放到JDBCUtil工具类里面去；
		}
		
	}

}
