package com.rxx.designpattern.iterator;


/**
 * @Title      :Collection
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午10:12:34
 */
public interface Collection {
	public Iterator iterator();  
    
    /*取得集合元素*/  
    public Object get(int i);  
      
    /*取得集合大小*/  
    public int size();  
}
