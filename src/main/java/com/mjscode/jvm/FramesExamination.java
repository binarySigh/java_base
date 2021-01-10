package com.mjscode.jvm;

/**
 * 栈帧结构 部分要点校验
 * @author binarySigh
 */
public class FramesExamination {
    public static void main(String[] args) throws InterruptedException {
        //testLocalVariables();
        int i = sharedFrames(12);
    }

    /**
     * 验证两个栈桢之间的数据共享，验证 main方法栈桢-sharedFrames方法栈桢之间的数据共享
     * @param a
     * @return
     */
    public static int sharedFrames(int a) throws InterruptedException {
        int t = a + 1;
        Thread.sleep(Integer.MAX_VALUE);
        return t;
    }

    /**
     * JVM启动参数： -verbose:gc   查看垃圾收集过程
     */
    public static void testLocalVariables(){
        // 定义一个64M的字节数组
        int b = 1;
        String str = "str";
        {
            byte[] variables = new byte[64 * 1024 * 1024];
        }
        //以下 部分代码会对局部变量表产生读写操作，也就是说会导致v的变量槽被重用
        //int a = 0;
        //boolean a = false;
        //short a = 1;
        //char a = 'a';
        //float a = 1f;
        //byte a = 1;
        //Object a = new Object();
        //double a = 1.0d;
        //long a = 1L;

        //以下代码不会对局部变量表产生读写操作，也就是说不会导致v的变量槽被回收
        /*b++;
        b = 7;
        str = "123";*/
        b = add(b);
        System.gc();
    }

    public static int add(int i){
        return i++;
    }
}
