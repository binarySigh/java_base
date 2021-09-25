package com.mjscode.base;

import com.mjscode.base.Thread.threadPrac.MyCallable;
import com.mjscode.base.Thread.threadPrac.MyRunnable;
import com.mjscode.base.Thread.threadPrac.MyThread;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 线程创建5种方式
 * @author binarySigh
 * @date 2021/2/28 9:35
 */
public class ThreadTest {

    /**
     * 方式 1：
     * 通过实现Runnable接口
     */
    @Test
    public void runnableTest(){
        Thread t = new Thread(new MyRunnable());
        t.start();
    }

    /**
     * 方式 2：
     * 通过继承线程类
     */
    @Test
    public void threadTest(){
        Thread t = new Thread(new MyThread());
        t.start();
    }

    /**
     * 方式 3：
     * 通过 Future + Callable
     */
    @Test
    public void callableTest(){
        Thread t = new Thread(new FutureTask<String>(new MyCallable()));
        t.start();
    }

    /**
     * 尝试获取 Future 的执行返回值
     */
    @Test
    public void callableTest02(){
        FutureTask<String> future = new FutureTask<String>(new MyCallable());
        try {
            Thread t = new Thread(future);
            t.start();
            t.join();
            String s = future.get();

            System.out.println("get : " + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 Lambda 表达式
     */
    @Test
    public void lambdaTest(){
        Thread t = new Thread(() -> {
            System.out.println("Created by Lambda!");
        });
        t.start();
    }

    /**
     * 通过线程池
     */
    @Test
    public void ThreadPoolTest(){
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(() -> {
            System.out.println("Created by ThreadPool !");
        });
        es.shutdown();
    }
}
