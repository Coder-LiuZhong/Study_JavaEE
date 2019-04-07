package javaee01_JDBC.dao;


/**
 * 定义操作数据库college表的方法
 * @author Liuzhong
 * 2018-03-19
 * */
public interface CollegeDao {
	
	/**
	 * 查询所有记录
	 * */
	void findAll();								// 接口方法默认都是public，不写也是public
	
	/**
	 * 根据条件查询记录
	 * */
	void findByName(String collegeName);

	/**
	 * 插入记录
	 * @param collegeName
	 * @param division
	 */
	void insert(String collegeName, Integer division);
	
	/**
	 * 删除记录
	 * @param id
	 * */
	void delete(String collegeName);
	
	/**
	 * 更新记录
	 * @param collegeName
	 * @param remark
	 */
	void update(String collegeName, String remark);
}
