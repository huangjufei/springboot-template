package com.hjf.utils.springLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

	public static void main(String[] args) {

		System.out.println("0,现在开始初始化容器");

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("16,容器初始化成功");

		// 得到Preson，并使用
		Person person = ctx.getBean("person", Person.class);
		System.out.println("17,"+person);

		System.out.println("18,现在开始关闭容器！");
		((ClassPathXmlApplicationContext) ctx).registerShutdownHook();
	}
}