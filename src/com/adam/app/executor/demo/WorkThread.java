/**
 * This is executor demo
 */
package com.adam.app.executor.demo;

public class WorkThread implements Runnable {

    private String command;
    
    
    public WorkThread(String s) {
        
        this.command = s;
    }
    
    
    @Override
    public void run() {
        
        System.out.println(Thread.currentThread().getName() + " start command  = " +  this.command);
        
        doProcess();
        
        System.out.println(Thread.currentThread().getName() + " end command");        
    }
    
    private void doProcess() {
        
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }


    @Override
    public String toString()
    {
        return this.command;
    }
    
    

}

