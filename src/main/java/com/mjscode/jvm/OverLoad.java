package com.mjscode.jvm;

import java.io.Serializable;

/**
 * @author binarySigh
 */
public class OverLoad {
    public static void show(int arg){
        System.out.println("type int");
    }
    public static void show(long arg){
        System.out.println("type long");
    }
    public static void show(char arg){
        System.out.println("type char");
    }
    public static void show(Character arg){
        System.out.println("type Character");
    }
    public static void show(Serializable arg){
        System.out.println("type Serializable");
    }
    public static void show(Object arg){
        System.out.println("type Object");
    }
    public static void show(char... arg){
        System.out.println("type char...");
    }

    public static void show(Integer arg){
        System.out.println("type Integer");
    }

    public static void main(String[] args){
        show('a');
    }
}
