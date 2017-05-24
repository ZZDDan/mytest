package com.rxx.thinkinjava.enumerated;

//: enumerated/NonEnum.java

public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        System.out.println(intClass.getEnumConstants());
        try {
            for (Object en : intClass.getEnumConstants())
                System.out.println(en);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
} /*
   * Output: java.lang.NullPointerException
   */// :~