package com.rxx.designpattern.producerconsumer;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/7 9:48
 */
public class StorageAwaitSignal extends Storage {


    private static Storage storage = new StorageAwaitSignal();

    private final Lock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    private StorageAwaitSignal() {
    }

    public static Storage getStorage() {
        return storage;
    }

    /**
     * 生产
     */
    @Override
    public void produce() {
        // 获取锁
        lock.lock();

        List<Object> list = getList();
        while (list.size() >= getMaxLen()) {
            try {
                System.out.format("@@@ %s 被阻塞生成，仓库数据总量：%d\n", Thread.currentThread().getName(), list.size());
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(getObject());
        System.out.format("### %s 生成之后，仓库数据总量：%d\n", Thread.currentThread().getName(), list.size());

        empty.signalAll();
        full.signalAll();

        // 释放锁
        lock.unlock();
    }

    @Override
    public void consume() {
        // 获取锁
        lock.lock();

        List<Object> list = getList();
        while (list.size() < getMinLen()) {
            try {
                System.out.format("@@@ %s 被阻塞消费，仓库数据总量：%d\n", Thread.currentThread().getName(), list.size());
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.remove(getObject());
        System.out.format("*** %s 消费之后，仓库数据总量：%d\n", Thread.currentThread().getName(), list.size());

        empty.signalAll();
        full.signalAll();

        // 释放锁
        lock.unlock();
    }

}
