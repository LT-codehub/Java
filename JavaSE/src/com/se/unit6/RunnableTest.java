package com.se.unit6;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/15 11:16
 */
public class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println("实现Runnable接口的线程："+Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();
    }
}
