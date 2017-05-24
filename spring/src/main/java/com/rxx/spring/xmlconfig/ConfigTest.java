package com.rxx.spring.xmlconfig;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rxx.spring.bean.Book;

/**
 * @Title      :ConfigTest
 * @Description: 测试 XML配置文件
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月2日 上午10:45:58
 */
public class ConfigTest {

	@SuppressWarnings("resource")
	@Test
	public void testConstructFaction(){
		ApplicationContext configLocation = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Book bean = configLocation.getBean(Book.class);
		System.out.println(bean);
	}
}
