package com.mjscode.jvm;

/**
 * @author binarySigh
 */
public class OverRide {
    public static class Human {
        public void show(){
            System.out.println("Human!");
        }
    }

    public static class Man extends Human{
       /* @Override
        public void show(){
            System.out.println("Man!");
        }*/
    }

    public static class Woman extends Human{
        @Override
        public void show() {
            System.out.println("Woman!");
        }
    }

    public static void main(String[] args){
        Human man = new Man();
        Human woman = new Woman();
        man.show();
        woman.show();
    }
}
