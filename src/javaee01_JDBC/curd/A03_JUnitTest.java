package javaee01_JDBC.curd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import javaee01_JDBC.util.JDBCUtil;

/*
 * 用JUnit单元测试来测试代码
 * 		1. 定义一个类，TestXXX，里面定义方法，testXXX(); 项目中这种测试类一般放在test包下面；
 * 		2. 添加jar; 项目右键，构建路径，添加库，选中MyEclipse自带JUnit的库
 * 		3. testXXX()上面加上@Test
 * 		4. 代码框，右键，运行，JUnit；或者Outline窗口选中方法右键也可以；
 * 
 *  绿色条出现，表明代码运行没问题。但是结果是否对不能确定。
 *  红色条出现，说明代码有问题。
 */

public class A03_JUnitTest {

	@Test
	public void testQuery(){			//查询
		Connection conn  = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			
			String sql = "select * from college";
			rs= st.executeQuery(sql);  //executeQuery(sql)
			
			while(rs.next()){
				String collegeName = rs.getString("college_name");
				System.out.println(collegeName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st, rs);
		}
	}

	@Test
	public void testInsert(){		//增加
		Connection conn  = null;
		Statement st = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			
			String sql = "insert into college values(null,'厦门大学','厦大',2,0,'准者林耀晨');";
			int result = st.executeUpdate(sql);    //executeUpdate(sql)
			
			if(result>0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(conn, st);
		}
	}
	
	@Test
	public void testDelete(){
		Connection conn = null;
		Statement st = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			
			String sql = "delete from college where id='111111'";
			int result = st.executeUpdate(sql);
			
			if(result >0 ){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, st);
		}

	}
	
	@Test
	public void testUpdate(){
		Connection conn = null;
		Statement st = null;
		try {
			conn = JDBCUtil.getConn();
			st = conn.createStatement();
			
			String sql = "update college set remark = '五年三冠' where id =3";
			int result = st.executeUpdate(sql);
			
			if(result >0 ){
				System.out.println("更新成功");
			}else{
				System.out.println("更新失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.release(conn, st);
		}
		
	}
	
}
