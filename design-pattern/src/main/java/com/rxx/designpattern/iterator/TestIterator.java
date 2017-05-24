package com.rxx.designpattern.iterator;
/**
 * @Title      :TestIterator
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午10:15:25
 */
public class TestIterator {
	public static void main(String[] args) {  
        Collection collection = new MyCollection();  
        Iterator it = collection.iterator();  
          
        while(it.hasNext()){  
            System.out.println(it.next());  
        }  
    }  
}
