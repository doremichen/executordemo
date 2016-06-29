/**
 * This is for Thread pool example.
 */

package com.adam.app.threadpool.demo;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectExecutionHandlerImp implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
        
        System.out.println(arg0.toString() + "is reject...");
        
    }

}

