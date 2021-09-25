package com.mjscode.base;

import org.junit.Test;

/**
 * 线程常见方法测试类
 * @author binarySigh
 * @date 2021/3/7 22:36
 */
public class ThreadTest02 {

    /**
     * test sleep
     */
    @Test
    public void sleepTest(){
        Thread t = new Thread(() -> {
            try {
                System.out.println("Time before sleep : " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("Time after sleep :  " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * test yield
     */
    @Test
    public void yieldTest(){
        new Thread(() -> {
            for(int i = 0; i < 20; i++){
                System.out.println("A" + i);
                if(i % 4 == 0) Thread.yield();
            }
        }).start();
        new Thread(() -> {
            for(int i = 0; i < 20; i++){
                System.out.println("B" + i);
                if(i % 3 == 2) Thread.yield();
            }
        }).start();
    }
}
