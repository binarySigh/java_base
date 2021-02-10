package com.mjscode.jvm;

/**
 * @author binarySigh
 */
public class TestSynchronized {
    public Object obj = new Object();
    public synchronized void m(){
    }
    public void n(){
        synchronized (obj){
        }
    }
}
