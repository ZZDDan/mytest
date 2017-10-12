package com.rxx.designpattern.singleton;
/**
 * @Title      :TestSingleton
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午2:57:24
 */
public class TestSingleton {
	public static void main(String[] args) {
		Singleton sing = Singleton.getInstance();
		Singleton sing2 = Singleton.getInstance();
		System.out.println(sing);
		System.out.println(sing2);

		System.out.println("1. ===================================");
		Singleton1 sing11 = Singleton1.getInstance();
		Singleton1 sing12 = Singleton1.getInstance();
		System.out.println(sing);
		System.out.println(sing2);

		System.out.println("2. ===================================");
		Singleton2 sing21 = Singleton2.getInstance();
		Singleton2 sing22 = Singleton2.getInstance();
		System.out.println(sing21);
		System.out.println(sing22);

		System.out.println("3. ===================================");
		Singleton3 sing31 = Singleton3.getInstance();
		Singleton3 sing32 = Singleton3.getInstance();
		System.out.println(sing31);
		System.out.println(sing32);

		System.out.println("4. ===================================");
		Singleton4 sing41 = Singleton4.getInstance();
		Singleton4 sing42 = Singleton4.getInstance();
		System.out.println(sing41);
		System.out.println(sing42);

		System.out.println("5. ===================================");
		Singleton5 sing51 = Singleton5.getInstance();
		Singleton5 sing52 = Singleton5.getInstance();
		System.out.println(sing51);
		System.out.println(sing52);

		System.out.println("6. ===================================");
		System.out.println(Singleton6.INSTANCE);
		System.out.println(Singleton6.INSTANCE);

		System.out.println("7. ===================================");
		Singleton7 sing71 = Singleton7.getInstance();
		Singleton7 sing72 = Singleton7.getInstance();
		System.out.println(sing71);
		System.out.println(sing72);
	}
}
