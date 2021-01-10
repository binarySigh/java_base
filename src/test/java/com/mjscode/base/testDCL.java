package com.mjscode.base;

import com.mjscode.jvm.VolatileForDCL;
import org.junit.Test;

public class testDCL {

    @Test
    public void testDcl(){
        Thread[] threads = new Thread[1000];
        for(int i = 0; i < 1000; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    VolatileForDCL dcl = VolatileForDCL.getInstance();
                    if(dcl.getLocal() != 15){
                        System.out.println(dcl.getLocal());
                    }
                }
            });
            threads[i].start();
        }
    }
}
