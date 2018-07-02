package cn.itcast.spring3.demo4;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest4 {

	@Test
	// Bean完整的生命周期
	public void demo1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		CustomerService customerService = (CustomerService) applicationContext.getBean("customerService");
		customerService.add();
		customerService.find();
		
		applicationContext.close();
	}
}
