package com.rxx.designpattern.producerconsumer;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/7 9:59
 */
public class Producer implements Runnable {

    private Storage storage;

    @Override
    public void run() {
        storage.produce();
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
