package vip.iotworld.mybatis.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import vip.iotworld.mybatis.po.User;

public class UserDaoImplTest {

	private SqlSessionFactory sqlSessionFactory =null;
	@Before
	public void setUp() throws Exception {
		//mybatis 配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);			
	}

	@Test
	public void testFindUserById() throws Exception {
		//创建UserDao的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//调用UserDao方法
		User user = userDao.findUserById(29);
		
		System.out.println(user);
	}

}
