package com.rxx.spring.container;

import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.rxx.spring.bean.Book;

/**
 * @Title      :ContainerTest
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年2月8日 下午1:54:18
 */
public class ContainerTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void test(){
		
		System.out.println(null + "");// null
		//System.out.println(null);// 编译不通过
		//System.out.println(Integer.parseInt(null + ""));
		/*
		// 空指针异常
		String[] strs = null;
		for (Object obj : strs) {
			System.out.println("1");
		}*/
		
		System.out.println(null instanceof String);
	}

	
	@SuppressWarnings("resource")
	@Test
	public void testExternalConfiguration() {		

		// BeanFactory container1 = new XmlBeanFactory(new ClassPathResource("配置文件路径"));
		// ApplicationContext container2 = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		// ApplicationContext container3 = new FileSystemXmlApplicationContext("配置文件路径");
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = (BeanFactory)bindViaXMLFile(beanRegistry);
		Book book = (Book) container.getBean("book");
		System.out.println(book.toString());
	}

	private BeanFactory bindViaXMLFile(DefaultListableBeanFactory registry) {
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
		reader.loadBeanDefinitions("classpath:applicationContext.xml");
		return (BeanFactory)registry;
		// 或者直接
		//return new XmlBeanFactory(new ClassPathResource("../news-config.xml"));
	}

	@Test
	public void testDirectEncoding() {
		
		DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
		BeanFactory container = (BeanFactory)bindViaCode(beanRegistry);
		FXNewsProvider newsProvider = (FXNewsProvider)container.getBean("djNewsProvider");
		newsProvider.getAndPersistNews();
	}

	private BeanFactory bindViaCode(DefaultListableBeanFactory registry) {
		AbstractBeanDefinition newsProvider = new RootBeanDefinition(FXNewsProvider.class,2, true);
		AbstractBeanDefinition newsListener = new RootBeanDefinition(DowJonesNewsListener.class,2, true);
		AbstractBeanDefinition newsPersister = new RootBeanDefinition(DowJonesNewsPersister.class,2, true);
		// 将bean定义注册到容器中
		registry.registerBeanDefinition("djNewsProvider", newsProvider);
		registry.registerBeanDefinition("djListener", newsListener);
		registry.registerBeanDefinition("djPersister", newsPersister);
		// 指定依赖关系
		// 1. 可以通过构造方法注入方式
		ConstructorArgumentValues argValues = new ConstructorArgumentValues();
		argValues.addIndexedArgumentValue(0, newsListener);
		argValues.addIndexedArgumentValue(1, newsPersister);
		newsProvider.setConstructorArgumentValues(argValues);
		// 2. 或者通过setter方法注入方式
		/*MutablePropertyValues propertyValues = new MutablePropertyValues();
		propertyValues.addPropertyValue(new ropertyValue("newsListener",newsListener));
		propertyValues.addPropertyValue(new PropertyValue("newPersistener",newsPersister));
		newsProvider.setPropertyValues(propertyValues);*/
		// 绑定完成
		return (BeanFactory)registry;
	}

}
