package com.rxx.designpattern.iterator;
/**
 * @Title      :Iterator
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午10:13:41
 */
public interface Iterator {
	//前移  
    public Object previous();  
      
    //后移  
    public Object next();  
    
    // 是否存在下一个
    public boolean hasNext();  
      
    //取得第一个元素  
    public Object first();  
}
