package com.rxx.thinkinjavamycode.concurrency;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/5 10:41
 */
public class LiftOff implements Runnable {

    private int countDown = 10;
    private static int countTask = 1;
    private final int id = countTask++;

    @Override
    public void run() {
        while (countDown > 0){
            System.out.println(status());
        }
    }

    private String status() {
        // #0(9),
        return "#" + id + "(" + (--countDown > 0 ? countDown : "LiftOff") + ")";
    }
}
