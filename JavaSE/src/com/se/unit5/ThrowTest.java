package com.se.unit5;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/14 15:07
 */
public class ThrowTest {
    @Test
    public void test(){
        try (BufferedReader br = new BufferedReader(new FileReader("d:\\ hollischuang.xml"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // handle exception
        }
    }

    @Test
    public void test1(){
        System.out.println(get());
    }

    public static int get() {
        int i = 0;
        try {

            return i+1;
        } finally {
            i = i +2;
            return i;
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i <10; i++) {
            //ThreadTest threadTest = new ThreadTest();
            //threadTest.start();
            // threadTest.run();
        }

    }
}
