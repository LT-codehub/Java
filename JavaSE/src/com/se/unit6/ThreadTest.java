package com.se.unit6;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/14 18:02
 */
public class ThreadTest extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
    }
}
