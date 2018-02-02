package com.rxx.designpattern.builder2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 15:41
 */
public class BuilderTest {
    public static void main(String[] args) {

        Meal vegMeal = new Meal.MealBuilder()
                .withItem(new VegBurger())
                .withItem(new Coke())
                .withCost()
                .build();
        System.out.println("Veg Meal");
        System.out.println(vegMeal.toString());
        System.out.println("Total Cost: " +vegMeal.getCost());

        Meal nonVegMeal = new Meal.MealBuilder()
                .withItem(new ChickenBurger())
                .withItem(new Pepsi())
                .withCost()
                .build();
        System.out.println("\n\nNon-Veg Meal");
        System.out.println(nonVegMeal.toString());
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }

}
