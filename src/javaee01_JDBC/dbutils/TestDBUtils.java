package javaee01_JDBC.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javaee01_JDBC.domain.Account;

/*
 * dbutils 只是帮我们简化了CRUD 的代码， 但是连接的创建以及获取工作。 不在他的考虑范围
 * */
public class TestDBUtils {

	@Test
	public void testInsert() throws SQLException, InstantiationException, IllegalAccessException{
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		QueryRunner queryRunner = new QueryRunner(dataSource);

		//增加
		//queryRunner.update("insert into account values (null , ? , ? )", "aa" ,1000);
		//update(String sql, Object... params) 	...表示可变参数，params参数可以是0个也可以是多个：这里是有两个"aa" ,1000
		
		//删除
		//queryRunner.update("delete from account where id = ?", 5);
		
		//更新
		//queryRunner.update("update account set money = ? where id = ?", 10000000 , 6);
		
		/*
		 * 查询单个对象
		 *	     查单个元素返回，由我们在接口里面重写handle方法自己包装。
		 *	     去执行查询，查询到的数据还是在哪个result里面。 然后调用下面的handle方法，由用户手动去封装成对象返回。
		 */
		Account account = queryRunner.query("select * from account where id = ?", new ResultSetHandler<Account>(){
			@Override
			public Account handle(ResultSet rs) throws SQLException {
				Account account = new Account();
				while(rs.next()){
					String name = rs.getString("name");
					int money = rs.getInt("money");
					account.setName02(name);
					account.setMoney(money);
				}
				return account;
			}
		 }, 6);
		
		System.out.println(account.toString());
		
		
		/*
		 * 查询单个对象。	
		 * BeanHandler是ResultSetHandler接口的实现类
		 * 底层通过类的字节码得到类的实例Account.class.newInstance()，自动帮我们封装到对象
		 * */
		Account account2 = queryRunner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), 8);
		System.out.println(account2.toString());
		
		
		//查询多个对象
		List<Account> list = queryRunner.query("select * from account ",new BeanListHandler<Account>(Account.class));
		for (Account a : list) {
			System.out.println(a.toString());
		}
	}
}
