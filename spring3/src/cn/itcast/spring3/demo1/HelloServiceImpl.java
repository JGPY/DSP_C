package cn.itcast.spring3.demo1;
/**
 * 入门案例的实现类
 * @author 姜涛
 *
 */
public class HelloServiceImpl implements HelloService {
	private String info;
	
	public void setInfo(String info) {
		this.info = info;
	}

	public void sayHello() {
		System.out.println("Hello Spring..."+info);
	}

}
