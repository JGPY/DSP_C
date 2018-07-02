package cn.itcast.spring3.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean的作用范围
 * 
 * @author 姜涛
 * 
 */
public class SpringTest3 {

	@Test
	// 测试Scope
	public void demo1() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Customer c1 = (Customer) applicationContext.getBean("customer");
		System.out.println(c1);
		
		Customer c2 = (Customer) applicationContext.getBean("customer");
		System.out.println(c2);
	}
	
	@Test
	// 测试初始化和销毁的方法
	public void demo2(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Product p1 = (Product) applicationContext.getBean("product");
		System.out.println(p1);
		applicationContext.close();
	}
}
