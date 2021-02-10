package com.mjscode.jvm;

/**
 * @author binarySigh
 */
public class TestString {
    private String lf = "Good";
    private char[] c = {'a','b','c'};

    private void exchange(String lf, char[] c){
        lf = "hello world";
        c[0] = 'd';
    }

    public static void main(String[] args){
        TestString ts = new TestString();
        String s = new String();
       /* ts.exchange(ts.lf, ts.c);
        System.out.println(ts.lf + " and " + ts.c[0] + ts.c[1] + ts.c[2]);*/
        ts.exchange(s, ts.c);
        System.out.println(ts.lf + " and " + ts.c[0] + ts.c[1] + ts.c[2]);
        System.out.println(s);
    }
}
