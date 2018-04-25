package vip.iotworld.mybatis.mapper;


import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import vip.iotworld.mybatis.mapper.ItemsMapper;
import vip.iotworld.mybatis.po.Items;
import vip.iotworld.mybatis.po.ItemsExample;
import vip.iotworld.mybatis.po.ItemsExample.Criteria;

public class ItemsMapperTest {
	
	SqlSessionFactory sqlSessionFactory=null;
	
	@Before
	public void setUp() throws Exception {
		//mybatis 配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//根据主键查询
	@Test
	public void testSelectByPrimaryKey() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建ItemsMapper对象,mybatis自动生成Mapper代理对象
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
		Items items = itemsMapper.selectByPrimaryKey(1);
		
		System.out.println(items);
	}
	
	//自定义条件查询
	@Test
	public void testSelectByExample() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建ItemsMapper对象,mybatis自动生成Mapper代理对象
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
		
		ItemsExample itemsExample = new ItemsExample();
		Criteria criteria = itemsExample.createCriteria();
		criteria.andNameEqualTo("笔记本");
		List<Items> list= itemsMapper.selectByExample(itemsExample);
		
		System.out.println(list);
	}
	
	//更行数据
	@Test
	public void testUpdateByPrimaryKey() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建ItemsMapper对象,mybatis自动生成Mapper代理对象
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
		//将传入的数据所有字段进行更新
		Items items = itemsMapper.selectByPrimaryKey(8);
		items.setName("水杯");
		//将传入的数据所有字段进行更新
		itemsMapper.updateByPrimaryKey(items);
		//如果传入的字段非空再更行,在批量更新中使用此方法，不需要先查询再更新
//		itemsMapper.updateByPrimaryKeySelective(record);
		sqlSession.commit();
		
	}
	
	//插入
	@Test
	public void testInsert() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建ItemsMapper对象,mybatis自动生成Mapper代理对象
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
		//构建Items对象名
		Items items = new Items();
		items.setName("手机2");
		items.setPrice(999f);		
		Date date = new Date();		
		items.setCreatetime(date);
		itemsMapper.insert(items);
		sqlSession.commit();
		System.out.println(items);	
	}
	
	//删除
	@Test
	public void testDeleteByPrimaryKey() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建ItemsMapper对象,mybatis自动生成Mapper代理对象
		ItemsMapper itemsMapper = sqlSession.getMapper(ItemsMapper.class);
	
		itemsMapper.deleteByPrimaryKey(7);
		sqlSession.commit();	
	}

}
