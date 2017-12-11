package com.rxx.thinkinjavamycode.concurrency;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/5 11:05
 */
public class InnerRunnable {

    private int countDown = 5;
    public InnerRunnable(String name){
        new Thread(new Inner(), name).start();
    }

    private class Inner implements Runnable {
        public Inner() {
        }


        @Override
        public void run() {
            while (countDown-- > 0){
                System.out.println(this);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println("Sleep() interrupt!");
                }
            }
        }

        @Override
        public String toString() {
            return Thread.currentThread().getName() + ":" + countDown;
        }
    }

    public static void main(String[] args) {
        new InnerRunnable("InnerRunnable");
    }
}
