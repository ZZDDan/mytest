package com.rxx.designpattern.producerconsumer;

import java.util.List;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/7 9:48
 */
public class StorageWaitNotify extends Storage {

    private static Storage storage = new StorageWaitNotify();

    private StorageWaitNotify() {
    }

    public static Storage getStorage() {
        return storage;
    }

    /**
     * 生产
     */
    @Override
    public void produce() {
        List<Object> list = getList();
        synchronized (list) {
            while (list.size() >= getMaxLen()) {
                try {
                    System.out.format("@@@ %s 被阻塞生成，仓库数据总量：%d\n", Thread.currentThread().getName(), list.size());
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.add(getObject());
            System.out.format("### %s 生成之后，仓库数据总量：%d\n", Thread.currentThread().getName(), list.size());

            list.notifyAll();
        }
    }

    @Override
    public void consume() {
        List<Object> list = getList();
        synchronized (list) {
            while (list.size() < getMinLen()) {
                try {
                    System.out.format("@@@ %s 被阻塞消费，仓库数据总量：%d\n", Thread.currentThread().getName(), list.size());
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.remove(getObject());
            System.out.format("*** %s 消费之后，仓库数据总量：%d\n", Thread.currentThread().getName(), list.size());
            list.notifyAll();
        }

    }
}
