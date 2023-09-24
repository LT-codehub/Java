package com.se.unit12;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/16 21:49
 */
public class CollectionTest {
    @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] integers = new Integer[100];
        for (int i = 0; i < 100; i++) {
            list.add(i);
            integers[i] = i;
        }

        for (Integer integer:list) {
            System.out.println("list.integer = " + integer);
        }

        for (Integer integer:integers) {
            System.out.println("array.integer = " + integer);
        }


    }
    @Test
    public void test1(){
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 100; i++) {
            hashMap.put(1,"NO."+i);
        }
    }

    @Test
    public void test2(){
        try (FileInputStream fis = new FileInputStream("jdbc.properties")){
            Properties pros = new Properties();


            pros.load(fis);

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name = " + name + ", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
