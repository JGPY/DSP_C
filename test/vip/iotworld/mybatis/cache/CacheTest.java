package vip.iotworld.mybatis.cache;


import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import vip.iotworld.mybatis.mapper.UserMapper;
import vip.iotworld.mybatis.po.User;

public class CacheTest {

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
	public void testCache1() throws Exception  {
		SqlSession sqlSession = sqlSessionFactory.openSession();//创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//下边查询使用一个SqlSession
		//第一次发起请求，查询id为1的用户
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);
		
//		如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。
		
		//更新user1的信息
		user1.setUsername("测试用户");
		userMapper.updateUser(user1);
		//执行commit操作去清空缓存
		sqlSession.commit();
		
		//第二次发起请求，查询id为1的用户
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);
		
		sqlSession.close();
	}
	
	
/*	为了将缓存数据取出执行反序列化操作，需要User类标记序列化接口，二级缓存数据存储介质多种多样，不一定在内存。
*/	@Test
	public void testCache2() throws Exception  {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		// 创建代理对象
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		// 第一次发起请求，查询id为1的用户
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);
		
		//这里执行关闭操作，将sqlsession中的数据写到二级缓存区域
		sqlSession1.close();
			
		//使用sqlSession3执行commit()操作
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		User user  = userMapper3.findUserById(1);
		user.setUsername("张明明");
		userMapper3.updateUser(user);
		//执行提交，清空UserMapper下边的二级缓存
		sqlSession3.commit();
		sqlSession3.close();

		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		// 第二次发起请求，查询id为1的用户
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);

		sqlSession2.close();
	}

/* useCache配置
 * 在statement中设置useCache=false可以禁用当前select语句的二级缓存，即每次查询都会发出sql去查询，默认情况是true，即该sql使用二级缓存。
 * <select id="findOrderListResultMap" resultMap="ordersUserMap" useCache="false">
 * 总结：针对每次查询都需要最新的数据sql，要设置成useCache=false，禁用二级缓存。
	
 * 刷新缓存（就是清空缓存）
 * 在mapper的同一个namespace中，如果有其它insert、update、delete操作数据后需要刷新缓存，如果不执行刷新缓存会出现脏读。
 * 设置statement配置中的flushCache="true" 属性，默认情况下为true即刷新缓存，如果改成false则不会刷新。使用缓存时如果手动修改数据库表中的查询数据会出现脏读。
 * 如下：
 * insert id="insertUser" parameterType="cn.itcast.mybatis.po.User" flushCache="true">
 * 总结：一般下执行完commit操作都需要刷新缓存，flushCache=true表示刷新缓存，这样可以避免数据库脏读。
 * */
}
