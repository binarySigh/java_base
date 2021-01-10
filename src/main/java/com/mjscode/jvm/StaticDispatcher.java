package com.mjscode.jvm;

public class StaticDispatcher {
    static abstract class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}

    public void say(Human human){
        System.out.println("hello, guy!");
    }
    public void say(Man man){
        System.out.println("hello, bro!");
    }
    public void say(Woman woman){
        System.out.println("hello, lady!");
    }

    public static void main(String[] args){
        //Human man = new Man();
        Man man = new Man();
        Human woman = new Woman();
        StaticDispatcher sd = new StaticDispatcher();
        sd.say(man);
        sd.say(woman);
    }
}
