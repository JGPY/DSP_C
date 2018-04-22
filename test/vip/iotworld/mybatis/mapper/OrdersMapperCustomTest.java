package vip.iotworld.mybatis.mapper;


import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import vip.iotworld.mybatis.po.Orders;
import vip.iotworld.mybatis.po.OrdersCustom;
import vip.iotworld.mybatis.po.User;

public class OrdersMapperCustomTest {

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
	public void testFindOrdesrUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象,mybatis自动生成mapper代理对象
		OrdersMapperCustom  ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象,mybatis自动生成mapper代理对象
		OrdersMapperCustom  ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersAndOrderUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象,mybatis自动生成mapper代理对象
		OrdersMapperCustom  ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersAndOrderUserResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testFindUserAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象,mybatis自动生成mapper代理对象
		OrdersMapperCustom  ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<User> list = ordersMapperCustom.findUserAndItemsResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建UserMapper对象,mybatis自动生成mapper代理对象
		OrdersMapperCustom  ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();
		System.out.println(list);
		// 遍历上边的订单列表
		for (Orders orders : list) {
			// 执行getUser()去查询用户信息，这里实现按需加载
			User user = orders.getUser();
			System.out.println(user);
		}
		sqlSession.close();
	}
}
