//: enumerated/menu/TypeOfFood.java
package thinkinjava.enumerated.menu;

import thinkinjava.enumerated.menu.Food.*;

public class TypeOfFood {
  public static void main(String[] args) {
    @SuppressWarnings("unused")
    Food food = Appetizer.SALAD;
    food = MainCourse.LASAGNE;
    food = Dessert.GELATO;
    food = Coffee.CAPPUCCINO;
  }
} ///:~
