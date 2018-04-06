package vip.iotworld.mybatis.mapper;

import java.util.List;

import vip.iotworld.mybatis.po.User;
import vip.iotworld.mybatis.po.UserCustom;
import vip.iotworld.mybatis.po.UserQueryVo;

public interface UserMapper {
	
	//用户综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo ) throws Exception;
	//用户综合总数
	public int findUserCount(UserQueryVo userQueryVo ) throws Exception;
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	//根据id查询用户信息,使用resultMap输出
	public User findUserByIdResultMap(int id) throws Exception;
	//根据用户名查询用户列表
	public List<User> findUserByName(String name) throws Exception;
	//插入用户
	public void  insertUser(User user) throws Exception;
	//删除用户
	public void deleteUser(int id) throws Exception;
	//更新用户
	public void updateUser(User user) throws Exception;

	
	
}
