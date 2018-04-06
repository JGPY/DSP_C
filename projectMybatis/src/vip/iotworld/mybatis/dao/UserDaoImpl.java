package vip.iotworld.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vip.iotworld.mybatis.po.User;

public class UserDaoImpl implements UserDao {
	
	//需要向dao实现类注入SqlSecssionFactory
	//这里通过构造函数注入
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl (SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession .selectOne("vip.iotworld.mybatis.mapper.UserMapper.findUserById", id);
		sqlSession.close();
		return user;
	}
	
	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("vip.iotworld.mybatis.mapper.UserMapper.findUserByName", name);
		sqlSession.close();
		return list;
	}
	
	@Override
	public void insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();	
	}

	@Override
	public void deleteUser(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser", id);
		sqlSession.commit();
		sqlSession.close();
	}

}
