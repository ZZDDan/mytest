package com.rxx.socketdemo.concurrent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Title      :ThreadPoolTaskExecutor
 * @Description:
 * @Company    :
 * @author     :zhangdan
 * @date       :2017年5月10日 上午10:55:43
 */
public class ThreadPoolTaskExecutor {
    /** 最小线程数量 */
    private int corePoolSize = 1;
    /** 最大线程数量 */
    private int maxPoolSize = Integer.MAX_VALUE;
    /** 线程最大空闲时间 */
    private int keepAliveSeconds = 60;
    /** 缓存队列  */
    private int queueCapacity = Integer.MAX_VALUE;
    private ThreadPoolExecutor threadPoolExecutor;
    private static ThreadPoolTaskExecutor threadPoolTaskExecutor; 
    
    private ThreadPoolTaskExecutor() {
        Properties properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("D:\\rundata\\idea_workspace\\mytest\\socketdemo\\src\\main\\resources\\socket-demo.properties"));
            properties.load(fis);
            corePoolSize = Integer.parseInt(properties.get("corePoolSize") + "");         
            maxPoolSize = Integer.parseInt(properties.get("maxPoolSize") + "");           
            keepAliveSeconds = Integer.parseInt(properties.get("keepAliveSeconds") + "");     
            queueCapacity = Integer.parseInt(properties.get("queueCapacity") + "");          
            
            BlockingQueue<Runnable> queue = createQueue(this.queueCapacity);
            threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveSeconds, TimeUnit.SECONDS, queue);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static ThreadPoolTaskExecutor getInstance(){
        if(threadPoolTaskExecutor == null){
            threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        }
        return threadPoolTaskExecutor;
    }
    
    protected BlockingQueue<Runnable> createQueue(int queueCapacity) {
        if (queueCapacity > 0) {
            return new LinkedBlockingQueue<Runnable>(queueCapacity);
        }
        else {
            return new SynchronousQueue<Runnable>();
        }
    }
    
    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }
    
    public void execute(Runnable runnable){
        threadPoolExecutor.execute(runnable);
    }
    
    public Future<?> submit(Runnable runnable){
        return threadPoolExecutor.submit(runnable);
    }
    
    public <T> Future<T> submit(Callable<T> callable){
        return threadPoolExecutor.submit(callable);
    }
}
