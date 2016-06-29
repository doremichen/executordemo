/**
 * This is for thread pool 
 */

package com.adam.app.threadpool.demo;

import java.util.concurrent.ThreadPoolExecutor;

public class MonitorThread implements Runnable {

    private ThreadPoolExecutor executor;
    
    private int seconds;
    
    private boolean run = true;
    
    
    public MonitorThread(ThreadPoolExecutor ex, int delay) {
        
        this.executor = ex;
        this.seconds = delay;
    }
    
    public void stopMonitor() {
        this.run = false;
    }
    
    
    @Override
    public void run() {
        
        while (run) {
            
            System.out.println(
                    String.format("[monitor] [%d/%d] Active: %d, Completed: %d, Task: %d, isShutdown: %s, isTerminated: %s",
                        this.executor.getPoolSize(),
                        this.executor.getCorePoolSize(),
                        this.executor.getActiveCount(),
                        this.executor.getCompletedTaskCount(),
                        this.executor.getTaskCount(),
                        this.executor.isShutdown(),
                        this.executor.isTerminated()));
            
            try
            {
                Thread.sleep(seconds);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            
        }
        
    }

}

