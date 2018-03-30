package vip.iotworld.mybatis.mapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import vip.iotworld.mybatis.po.User;
import vip.iotworld.mybatis.po.UserCustom;
import vip.iotworld.mybatis.po.UserQueryVo;

public class UserMapperTest {

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
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象,mybatis自动生成mapper代理对象
		UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
		//调用usermapper对象方法
		User user = usermapper.findUserById(25);
		System.out.println(user);
	}
	
	@Test
	public void testfindUserByName() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象,mybatis自动生成mapper代理对象
		UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
		//调用usermapper对象方法
		List<User> list = usermapper.findUserByName("小明");
		System.out.println(list);
	}
	//用户信息综合查询
	@Test
	public void testfindUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象,mybatis自动生成mapper代理对象
		UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();	
		//由于这里使用动态sql，如果不设置某个值，条件不会拼接在sql中
		userCustom.setSex("1");
		userCustom.setUsername("张三丰");
		//传入多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(10);
		ids.add(16);
		//ids通过userQueryVo传入statement
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		//调用usermapper对象方法
		List<UserCustom> list = usermapper.findUserList(userQueryVo);
		System.out.println(list);
		int count = usermapper.findUserCount(userQueryVo);
		System.out.println(count);
	}
	
	@Test
	public void testfindUserByIdResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象,mybatis自动生成mapper代理对象
		UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
		
		User user = usermapper.findUserByIdResultMap(1);
		System.out.println(user);
	}

}
