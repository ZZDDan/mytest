package com.rxx.designpattern.command2;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2018/4/25 13:52
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
