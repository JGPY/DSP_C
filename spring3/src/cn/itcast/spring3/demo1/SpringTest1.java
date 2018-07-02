package cn.itcast.spring3.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class SpringTest1 {

	@Test
	// 传统方式
	public void demo1() {
		// 造成程序紧密耦合.
		HelloService helloService = new HelloServiceImpl();
		helloService.sayHello();
	}

	@Test
	// Spring开发
	public void demo2() {
		// 创建一个工厂类.
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		HelloService helloService = (HelloService) applicationContext
				.getBean("userService");
		helloService.sayHello();
		applicationContext.close();
	}

	@Test
	// 加载磁盘路径下的配置文件:
	public void demo3() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"classpath:applicationContext.xml");
		HelloService helloService = (HelloService) applicationContext
				.getBean("userService");
		helloService.sayHello();
	}
	
	@Test
	public void demo4(){
		// ClassPathResource  FileSystemResource
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("D:\\Program Files\\Java\\eclipse-workspace\\spring3_01\\config/applicationContext.xml"));
		HelloService helloService = (HelloService) beanFactory.getBean("userService");
		helloService.sayHello();
	}
}
