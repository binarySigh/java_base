package com.mjscode.base;

import com.mjscode.base.object.Creature;
import org.junit.Test;

public class objectTest {

    @Test
    public void test(){
        Creature cre = new Creature();
        cre.setAge(16);
        cre.setSex("male");
        cre.setName("Antonny");
        Creature cre2 = new Creature(17,"Caroline","female");

        System.out.println(cre);
        cre.sex = "female";
        cre.setName("Brown");
        System.out.println(cre);
    }
}
