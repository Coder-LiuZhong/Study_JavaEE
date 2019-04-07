package javaee01_JDBC.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javaee01_JDBC.dao.CollegeDao;
import javaee01_JDBC.util.JDBCUtil;

/*
 * CollegeDaoImpl����ķ�����ʵ���������������ݿ��
 * ���������ݿ�֮��Ľ����ʵҲӦ�÷��ظ����������Ǹ��ࡢ�Ǹ�����
 * ��������Ϊ��ѧϰ����ֱ����CollegeDaoImpl��������д�ӡ�ˣ�ʵ�ʹ����в�������Ҫ���ظ��˼ң�
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
		PreparedStatement ps = null;		//Ԥ����
		ResultSet rs = null;
		
		/* Ϊʲô��PreparedStatementԤ���������֮ǰѧ��Statement
		 * 		��ΪStatementʵ���Ͼ���д��sql���ƴ�Ӻò���ȥִ��
		 * 		��������㴫ʲô���ᱻƴ�ӵ�sql�����ȥִ�У���������������������sql�Ĺؼ��֣���"or 1=1"���־ͻ�Ӱ��ʵ�ʵĲ�ѯ���
		 * 		select * from college c where c.college_name='�����ڵ�name' or 1=1     
		 * 		����Ҳ�ܲ�����ݣ�������û������¼�Ļ������Եò���ȫ�����˴�"or 1=1"�Ϳ��Է��ش����û������룬Ȼ����ʾ��¼�ɹ�
		 *      ������Ԥ�������������������˹ؼ���Ҳ�ᵱ�����ַ�������sql�����
		 * */
		
		try {
			conn = JDBCUtil.getConn();
			
			String sql = "select * from college c where c.college_name=?";
			ps = conn.prepareStatement(sql);    
			ps.setString(1, collegeName);		// �ж���ʺã��ʹ�1��ʼ����˳������1�����һ���ʺ�
			rs = ps.executeQuery();
			
			if(rs.next()){
				System.out.println(collegeName+":����");
			}else{
				System.out.println(collegeName+":������");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, ps, rs);		//PreparedStatement�ӿڼ̳���Statement�ӿ�
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
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
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
				System.out.println("ɾ���ɹ�");
			}else{
				System.out.println("ɾ��ʧ��");
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
				System.out.println("���³ɹ�");
			}else{
				System.out.println("����ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, ps);			
		}
	}

}
