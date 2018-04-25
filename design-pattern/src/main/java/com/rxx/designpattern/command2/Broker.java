package com.rxx.designpattern.command2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 13:55
 */
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
