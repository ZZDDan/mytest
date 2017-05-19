package com.rxx.designpattern.memento;
/**
 * @Title      :Original
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年3月10日 上午11:22:42
 */
public class Original {
	private String value;  
    
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }  
  
    public Original(String value) {  
        this.value = value;  
    }  
  
    public Memento createMemento(){  
        return new Memento(value);  
    }  
      
    public void restoreMemento(Memento memento){  
        this.value = memento.getValue();  
    }  
}
