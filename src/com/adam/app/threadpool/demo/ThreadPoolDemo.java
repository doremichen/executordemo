/**
 * This is for thread pool.
 */

package com.adam.app.threadpool.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.adam.app.executor.demo.WorkThread;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {

        RejectExecutionHandlerImp rejectHandler = new RejectExecutionHandlerImp();

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2),
                threadFactory, rejectHandler);
        
        MonitorThread monitorTask = new MonitorThread(threadPoolExecutor, 3);
        Thread monitorThread = new Thread(monitorTask);
        monitorThread.start();
        
        for (int i = 0; i < 10; ++i) {
            
            threadPoolExecutor.execute(new WorkThread("cmd: " + i));
            
        }
        
        Thread.sleep(1000);
        
        threadPoolExecutor.shutdown();
        
        Thread.sleep(500);
        
        monitorTask.stopMonitor();

    }

}
