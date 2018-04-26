package vip.iotworld.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vip.iotworld.pojo.Items;
//使用Controller标识，它是一个控制器
@Controller
public class ItemsController {
	
	//指定url到请求方法的映射
	//url中输入一个地址，找到这个方法。例如：http://localhost:8080/springMVC/list.action
	@RequestMapping("/list")
	public ModelAndView itmesList() throws Exception{
		List<Items>itemList = new ArrayList<>();
		
		//商品列表
		Items items_1 = new Items();
		items_1.setName("联想笔记本_3");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");
		
		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");
		
		itemList.add(items_1);
		itemList.add(items_2);
		//模型和视图
		//model模型：模型对象中存放了返回给页面的数据
		//view视图：视图对象中指定了返回页面的数据
		ModelAndView modelAndView = new ModelAndView();
		//将返回给页面的数据放入模型和视图对象中，相当于request的setAttribut,在jsp页面通过itemList取数据
		modelAndView.addObject("itemList", itemList);
		//指定视图，返回的页面位置
		modelAndView.setViewName("items/itemsList");		
		return modelAndView;
	}
	
	
}
