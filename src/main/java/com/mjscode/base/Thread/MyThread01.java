package com.mjscode.base.Thread;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程练习 ： 生产者消费者模式
 * author ： mjs
 * @author binarySigh
 */
@Slf4j(topic = "c.MyThread01")
public class MyThread01 {

    public static void main(String[] args) {

       MessageQueue queue = new MessageQueue(2);

       for (int i = 0; i < 3; i++) {
           int id = i;
           String data = "By Thread-" + String.valueOf(i);
           new Thread(() -> {
               queue.produce(data);
               log.debug("produce message: [{}]", data);
           }, "producer-" + id).start();
       }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            while(true) {
                Message curNode = queue.consume();
                log.debug("consume message：[{}]", curNode);
            }
        },"consumer").start();

    }
}

@Slf4j(topic = "c.MessageQueue")
class MessageQueue {
    private LinkedList<Message> queue = new LinkedList();
    private final AtomicInteger messageId = new AtomicInteger();
    private int size;

    public MessageQueue(int size) {
        this.size = size;
    }

    public LinkedList getQueue() {
        return queue;
    }

    public int getSize() {
        return size;
    }

    public void produce(String data){
        synchronized(queue){
            while(queue.size() == this.size){
                try {
                    log.debug("队列已满，生产者线程进入等待");
                    queue.wait();
                } catch(InterruptedException e){

                } finally{

                }
            }
            Message msg = new Message(messageId.getAndIncrement(),data);
            log.debug("Produce Message [{}]",msg);
            queue.addLast(msg);
            queue.notifyAll();
        }
    }

    public Message consume(){
        synchronized(queue){
            while(queue.size() == 0){
                try {
                    log.debug("队列为空，消费者线程进入等待");
                    queue.wait();
                } catch(InterruptedException e){

                } finally{

                }
            }
            Message firstNode = queue.removeFirst();
            queue.notifyAll();
            log.debug("Consume Message [{}]",firstNode);
            return firstNode;
        }
    }
}

@Slf4j(topic = "c.Message")
final class Message{
    private int id;
    private String data;

    public Message(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return id == message.id &&
                data.equals(message.data);
    }

    @Override
    public int hashCode() {
        int result = Integer.valueOf(id).hashCode();
        return result * 31 + data.hashCode();
    }
}