package com.mjscode.base.Thread.threadPrac;

import java.util.concurrent.Callable;

/**
 * @author binarySigh
 * @date 2021/3/1 22:25
 */
public class MyCallable implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("Created by Callable!");
        return "Created by Callable!";
    }
}
