package javaee01_JDBC.curd;

import org.junit.Test;

import javaee01_JDBC.dao.CollegeDao;
import javaee01_JDBC.dao.impl.CollegeDaoImpl;

/* DAO模式
 * 		在工作中，一般声明和实现都不是一个人干的，所以分开写在两个不同的包里面
 *    	组长负责定义好功能接口dao，下面的人去实现具体的功能daoimpl
 * */
public class B01_DAO {
	
	@Test
	public void testFindAll(){							// 查
		CollegeDao dao = new CollegeDaoImpl();
		dao.findAll();
	}
	
	@Test
	public void testFindByName(){						// 查：预处理方式 PreparedStatement
		CollegeDao dao = new CollegeDaoImpl();
		String collegeName = "中南大学";
		dao.findByName(collegeName);
	}
	
	@Test
	public void testInsert(){							// 增
		CollegeDao dao = new CollegeDaoImpl();
		String collegeName = "华侨大学";
		Integer division = 2;
		dao.insert(collegeName,division);
	}
	
	@Test
	public void testDelete(){							// 删
		CollegeDao dao = new CollegeDaoImpl();
		String collegeName = "华侨大学";
		dao.delete(collegeName);
	}
	
	@Test
	public void testUpdate(){							// 改
		CollegeDao dao = new CollegeDaoImpl();
		String collegeName = "华侨大学";
		String remark = "八冠王";
		dao.update(collegeName,remark);
	}

}
