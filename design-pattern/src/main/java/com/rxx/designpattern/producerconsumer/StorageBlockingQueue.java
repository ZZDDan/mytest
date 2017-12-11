package com.rxx.designpattern.producerconsumer;


import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/7 9:48
 */
public class StorageBlockingQueue extends Storage {


    private static Storage storage = new StorageBlockingQueue();
    private BlockingQueue queue = new LinkedBlockingDeque(getMaxLen());

    private StorageBlockingQueue() {
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
        if (list.size() >= getMaxLen()) {
                System.out.format("@@@ %s 被阻塞生成，仓库数据总量：%d\n", Thread.currentThread().getName(), queue.size());
        }


        try {
            // 放入产品自动阻塞
            queue.put(getObject());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.format("### %s 生成之后，仓库数据总量：%d\n", Thread.currentThread().getName(), queue.size());

    }

    @Override
    public void consume() {

        List<Object> list = getList();
        if (list.size() < getMinLen()) {
            System.out.format("@@@ %s 被阻塞消费，仓库数据总量：%d\n", Thread.currentThread().getName(), queue.size());
        }

        try {
            // 取数据自动阻塞
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.format("*** %s 消费之后，仓库数据总量：%d\n", Thread.currentThread().getName(), queue.size());

    }

}
