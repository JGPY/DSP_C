package vip.iotworld.mybatis.mapper;

import java.util.List;

import vip.iotworld.mybatis.po.Orders;
import vip.iotworld.mybatis.po.OrdersCustom;
import vip.iotworld.mybatis.po.User;

public interface OrdersMapperCustom {
	
	//查询订单关联查询用户
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	//查询订单关联查询用户使用resultMap
	public List<Orders> findOrdersUserResultMap()throws Exception;
	
	//查询订单关联查询用户使用resultMap
	public List<Orders> findOrdersAndOrderUserResultMap() throws Exception;

	public List<User> findUserAndItemsResultMap() throws Exception;

	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}
