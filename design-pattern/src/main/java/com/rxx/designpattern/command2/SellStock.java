package com.rxx.designpattern.command2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 13:55
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
