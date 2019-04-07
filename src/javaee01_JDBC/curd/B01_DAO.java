package javaee01_JDBC.curd;

import org.junit.Test;

import javaee01_JDBC.dao.CollegeDao;
import javaee01_JDBC.dao.impl.CollegeDaoImpl;

/* DAOģʽ
 * 		�ڹ����У�һ��������ʵ�ֶ�����һ���˸ɵģ����Էֿ�д��������ͬ�İ�����
 *    	�鳤������ù��ܽӿ�dao���������ȥʵ�־���Ĺ���daoimpl
 * */
public class B01_DAO {
	
	@Test
	public void testFindAll(){							// ��
		CollegeDao dao = new CollegeDaoImpl();
		dao.findAll();
	}
	
	@Test
	public void testFindByName(){						// �飺Ԥ����ʽ PreparedStatement
		CollegeDao dao = new CollegeDaoImpl();
		String collegeName = "���ϴ�ѧ";
		dao.findByName(collegeName);
	}
	
	@Test
	public void testInsert(){							// ��
		CollegeDao dao = new CollegeDaoImpl();
		String collegeName = "���ȴ�ѧ";
		Integer division = 2;
		dao.insert(collegeName,division);
	}
	
	@Test
	public void testDelete(){							// ɾ
		CollegeDao dao = new CollegeDaoImpl();
		String collegeName = "���ȴ�ѧ";
		dao.delete(collegeName);
	}
	
	@Test
	public void testUpdate(){							// ��
		CollegeDao dao = new CollegeDaoImpl();
		String collegeName = "���ȴ�ѧ";
		String remark = "�˹���";
		dao.update(collegeName,remark);
	}

}
