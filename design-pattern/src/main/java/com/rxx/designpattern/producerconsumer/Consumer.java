package com.rxx.designpattern.producerconsumer;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/7 10:02
 */
public class Consumer implements Runnable {

    private Storage storage;

    @Override
    public void run() {
        storage.consume();
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
