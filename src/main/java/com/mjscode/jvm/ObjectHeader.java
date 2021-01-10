package com.mjscode.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author binarySigh
 */
public class ObjectHeader {
    public static void main(String[] args){
        Object[] arr = new Object[10];
        double[] d = new double[10];
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
        System.out.println(ClassLayout.parseInstance(d).toPrintable());
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}
