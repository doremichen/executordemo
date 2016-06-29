/**
 * This is for executor demo
 */
package com.adam.app.executor.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < 10; ++i) {
            
            Runnable task = new WorkThread("" + i);
            executor.execute(task);
            
        }
        executor.shutdown();
        
        while (!executor.isTerminated());
        
        System.out.println("All thread finish!!!");
        

    }

}

