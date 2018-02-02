package com.rxx.designpattern.builder2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/2/2 15:40
 */
public class Meal {

    private List<Item> items;
    private float cost;

    Meal(MealBuilder builder){
        this.items = builder.items;
        this.cost = builder.cost;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append("Item : ").append(item.name())
                .append(", Packing : ").append(item.packing().pack())
                .append(", Price : ").append(item.price()).append(".");
        }
        return sb.toString();
    }


    public static class MealBuilder {

        private List<Item> items = new ArrayList<>();
        private float cost;


        public MealBuilder withItem(Item item) {
            items.add(item);
            return this;
        }

        public MealBuilder withCost(){
            float cost = 0.0f;
            for (Item item : items) {
                cost += item.price();
            }
            this.cost = cost;
            return this;
        }

        public Meal build(){
            return new Meal(this);
        }
    }
}
