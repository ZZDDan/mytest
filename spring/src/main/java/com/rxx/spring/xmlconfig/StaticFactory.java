package com.rxx.spring.xmlconfig;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.rxx.spring.bean.Book;

/**
 * @Title      :StaticFactory
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月2日 上午11:25:16
 */
public class StaticFactory {

	private static Map<String, Book> map = null;
	static {
		map = new HashMap<String, Book>();
		map.put("book01", new Book("1001","bookName01","author01","200" ,new Date()));
		map.put("book02", new Book("1002","bookName02","author02","200" ,new Date()));
		map.put("book03", new Book("1003","bookName03","author03","200" ,new Date()));
		map.put("book04", new Book("1004","bookName04","author04","200" ,new Date()));
		map.put("book05", new Book("1005","bookName05","author05","200" ,new Date()));
	}
	public static Book getBookByKey(String key){
		return map.get(key);
	}
}
