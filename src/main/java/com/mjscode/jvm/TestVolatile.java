package com.mjscode.jvm;

/**
 * @author binarySigh
 */
public class TestVolatile {
    public static volatile int path = 0;
    public static void increase(){
        path++;
    }

    /*public static synchronized void increase(){
        path++;
    }*/

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for(int i = 0; i < 20; i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 10000; j++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        for(int i = 0; i < 20; i++){
            threads[i].join();
        }
        System.out.println(path);
    }
}
