package javaee01_JDBC.dao;


/**
 * ����������ݿ�college��ķ���
 * @author Liuzhong
 * 2018-03-19
 * */
public interface CollegeDao {
	
	/**
	 * ��ѯ���м�¼
	 * */
	void findAll();								// �ӿڷ���Ĭ�϶���public����дҲ��public
	
	/**
	 * ����������ѯ��¼
	 * */
	void findByName(String collegeName);

	/**
	 * �����¼
	 * @param collegeName
	 * @param division
	 */
	void insert(String collegeName, Integer division);
	
	/**
	 * ɾ����¼
	 * @param id
	 * */
	void delete(String collegeName);
	
	/**
	 * ���¼�¼
	 * @param collegeName
	 * @param remark
	 */
	void update(String collegeName, String remark);
}
