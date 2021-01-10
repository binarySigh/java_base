package com.mjscode.base;

import com.mjscode.base.object.Creature;
import org.junit.Test;

public class reflectTest {

    @Test
    public void test01() {
        try {
            Class<?> bean = Class.forName("com.mjscode.base.object.Creature");
            Creature cre = (Creature) bean.newInstance();

            System.out.println("Instance is : " + cre);
            System.out.println("ClassLoader is : " + bean.getClassLoader());
        } catch(ClassNotFoundException cfe){
            cfe.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
