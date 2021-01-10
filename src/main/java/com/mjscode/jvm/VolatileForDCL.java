package com.mjscode.jvm;

/**
 *
 * 双重检查单例中 volatile的应用
 * @author binarySigh
 */
public class VolatileForDCL {
    private static /*volatile*/ VolatileForDCL instance = null;
    private static Object obj = new Object();
    private int local = 12;

    private VolatileForDCL(){local = 15;}
    public static VolatileForDCL getInstance(){
        if(instance == null){  // line A
            synchronized (obj){
                if(instance == null){
                    instance = new VolatileForDCL(); // line B
                }
            }
        }
        return instance;
    }

    public int getLocal(){
        return local;
    }
}
