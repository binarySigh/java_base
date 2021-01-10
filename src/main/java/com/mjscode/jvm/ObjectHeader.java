package com.mjscode.jvm;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author binarySigh
 */
public class ObjectHeader {
    public static void main(String[] args){
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Object[] arr = new Object[10];
        double[] d = new double[10];
        Object o = new Object();
        boolean i = false;
        Boolean t = false;
        /*System.out.println(ClassLayout.parseInstance(arr).toPrintable());
        System.out.println(ClassLayout.parseInstance(d).toPrintable());
        System.out.println(ClassLayout.parseInstance(o).toPrintable());*/
        System.out.println(ClassLayout.parseInstance(i).toPrintable());
        System.out.println(ClassLayout.parseInstance(t).toPrintable());
    }
}
