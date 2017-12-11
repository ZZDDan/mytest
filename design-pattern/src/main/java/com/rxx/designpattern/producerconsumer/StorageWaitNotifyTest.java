package com.rxx.designpattern.producerconsumer;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author :zhangdan
 * @Description:
 * @Company :
 * @date :2017/12/7 10:07
 */
public class StorageWaitNotifyTest {

    public static void main(String[] args) {
        int corePoolSize = 5;
        int maxPoolSize = 40;
        long keepAliveTime = 0;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        BlockingQueue workQueue = new LinkedBlockingDeque(corePoolSize);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, unit, workQueue);

        int len = 2;

        for (int i = 0; i < len; i++) {
            Consumer consumer = new Consumer();
            consumer.setStorage(StorageWaitNotify.getStorage());
            executor.execute(consumer);
        }

        for (int i = 0; i < len; i++){
            Producer producer = new Producer();
            producer.setStorage(StorageWaitNotify.getStorage());
            executor.execute(producer);
        }

        executor.shutdown();
    }
}
