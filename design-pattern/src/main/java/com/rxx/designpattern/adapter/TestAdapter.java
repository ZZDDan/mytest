package com.rxx.designpattern.adapter;

/**
 * @Title      :TestAdapter
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月6日 下午3:45:05
 */
public class TestAdapter {
	public static void main(String[] args) {
		/*Targetable target = new Adapter();  
        target.method1();  
        target.method2(); */
        
        /*Source source = new Source();  
        Targetable target = new Wrapper(source);  
        target.method1();  
        target.method2(); */
		
		Sourceable source1 = new SourceSub1();  
        Sourceable source2 = new SourceSub2();  
          
        source1.method1();  
        source1.method2();  
        source2.method1();  
        source2.method2();  
	}
}
