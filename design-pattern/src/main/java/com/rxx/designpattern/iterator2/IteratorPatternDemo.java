package com.rxx.designpattern.iterator2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 10:53
 */
public class IteratorPatternDemo {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
