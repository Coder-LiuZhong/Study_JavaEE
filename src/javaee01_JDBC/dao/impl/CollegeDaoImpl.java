package javaee01_JDBC.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javaee01_JDBC.dao.CollegeDao;
import javaee01_JDBC.util.JDBCUtil;

/*
 * CollegeDaoImpl里面的方法其实就是用来操作数据库的
 * 操作完数据库之后的结果其实也应该返回给调用它的那个类、那个方法
 * 我们这里为了学习，就直接在CollegeDaoImpl类里面进行打印了，实际工作中不这样，要返回给人家；
 * */

public class CollegeDaoImpl implements CollegeDao{
	
	@Override
	public void findAll(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();     
			
			String sql = "select * from college";
			rs = st.executeQuery(sql);
			
			while(rs.next()){
				String college_name = rs.getString("college_name");
				System.out.println(college_name);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st, rs);
		}
	}
	
	@Override
	public void findByName(String collegeName){
		Connection conn = null;
		PreparedStatement ps = null;		//预处理
		ResultSet rs = null;
		
		/* 为什么用PreparedStatement预处理而不是之前学的Statement
		 * 		因为Statement实际上就是写好sql语句拼接好参数去执行
		 * 		而参数随便传什么都会被拼接到sql语句中去执行，这样如果参数里面包含了sql的关键字，如"or 1=1"这种就会影响实际的查询结果
		 * 		select * from college c where c.college_name='不存在的name' or 1=1     
		 * 		这样也能查出数据，如果是用户密码登录的话更加显得不安全，别人传"or 1=1"就可以返回存在用户名密码，然后显示登录成功
		 *      所以用预处理，就算参数里面包含了关键字也会当做是字符串放入sql语句中
		 * */
		
		try {
			conn = JDBCUtil.getConn();
			
			String sql = "select * from college c where c.college_name=?";
			ps = conn.prepareStatement(sql);    
			ps.setString(1, collegeName);		// 有多个问好，就从1开始，按顺序来，1代表第一个问号
			rs = ps.executeQuery();
			
			if(rs.next()){
				System.out.println(collegeName+":存在");
			}else{
				System.out.println(collegeName+":不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps, rs);		//PreparedStatement接口继承了Statement接口
		}
	}
	

	@Override
	public void insert(String collegeName, Integer division) {
		Connection conn = null;
		PreparedStatement ps = null;		 
		
		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into college values(null,?,null,?,0,null)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, collegeName);
			ps.setInt(2, division);
			int result = ps.executeUpdate();
			if(result>0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, ps);			
		}
	}

	@Override
	public void delete(String collegeName) {
		Connection conn = null;
		PreparedStatement ps = null;		 
		
		try {
			conn = JDBCUtil.getConn();
			String sql = "delete from college where college_name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, collegeName);
			int result = ps.executeUpdate();
			if(result>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, ps);			
		}
	}
	
	@Override
	public void update(String collegeName, String remark) {
		Connection conn = null;
		PreparedStatement ps = null;		 
		
		try {
			conn = JDBCUtil.getConn();
			String sql = "update college set remark=? where college_name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, remark);
			ps.setString(2, collegeName);
			int result = ps.executeUpdate();
			if(result>0){
				System.out.println("更新成功");
			}else{
				System.out.println("更新失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, ps);			
		}
	}

}
