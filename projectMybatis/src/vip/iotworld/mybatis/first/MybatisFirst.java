package vip.iotworld.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import vip.iotworld.mybatis.po.User;

public class MybatisFirst {
	//根据id查询用户信息  得一条记录结果
	@Test
	public void findUserByIdTest() throws IOException {
		
		//mybatis 配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession =null;
		
		try {
			//通过工厂得到SqlSession
			sqlSession = sqlSessionFactory.openSession();
			
			//通过SqlSession操作数据库
			//第一个参数：映射文件中statement的id，等于=namespace+statement的id
			//第二个参数：指定和映射文件中所匹配的parameterType类型的参数
			//sqlSession.selectOne结果是与映射文件中所有匹配的resultType类型的对象
			User user = sqlSession.selectOne("test.findUserById", 1);
			
			System.out.println(user);
		} finally {
			//释放资源
			sqlSession.close();
		}
	}
		

	//根据用户信息模糊查询列表
	@Test
	public void findUserByName() throws IOException {
		
		//mybatis 配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession =null;
		
		try {
			//通过工厂得到SqlSession
			sqlSession = sqlSessionFactory.openSession();
			
			//lits中的user和映射文件中resultType所指的类型一致
			/*List list =  (List) sqlSession.selectList("test.findUserByName", "%小明%");*/
			List<User> list = sqlSession.selectList("test.findUserByName", "小明");
			
			System.out.println(list);			
			
			for (User user:list) {
                System.out.println(user);
            }
		} finally {
			//释放资源
			sqlSession.close();
		}			
	}
	
	//添加用户人信息
	@Test
	public void insertUser() throws IOException {
		
		//mybatis 配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession =null;
		
		try {
			//通过工厂得到SqlSession
			sqlSession = sqlSessionFactory.openSession();
			//插入用户对象
			User user = new User();
			user.setUsername("老王");
			user.setBirthday(new Date());
			user.setSex("1");
			user.setAddress("安徽舒城");
			sqlSession.insert("test.insertUser", user);
			//提交事务
			sqlSession.commit();
			//获取用户信息主键
			System.out.println();
		} finally {
			//释放资源
			sqlSession.close();
		}			
	}
	
	//删除用户人信息
	@Test
	public void deleteUser() throws IOException {
		
		//mybatis 配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession =null;
		
		try {
			//通过工厂得到SqlSession
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.delete("test.deleteUser", 26);
			//提交事务
			sqlSession.commit();
			//获取用户信息主键
			System.out.println();
		} finally {
			//释放资源
			sqlSession.close();
		}			
	}
	
	//删除用户人信息
	@Test
	public void updateUser() throws IOException {
		
		//mybatis 配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlSession =null;
		
		try {
			//通过工厂得到SqlSession
			sqlSession = sqlSessionFactory.openSession();
			//更新用户信息
			User user = new User();
			//必须设置ID
			user.setId(29);
			user.setUsername("老王");
			user.setBirthday(new Date());
			user.setSex("2");
			user.setAddress("安徽舒城");		
			sqlSession.update("test.updateUser", user);
			//提交事务
			sqlSession.commit();
			//获取用户信息主键
			System.out.println();
		} finally {
			//释放资源
			sqlSession.close();
		}			
	}
}
