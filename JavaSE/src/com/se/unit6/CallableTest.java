package com.se.unit6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/15 11:22
 */
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("实现Callable接口的线程："+Thread.currentThread().getName());
        return "执行成功";
    }

    public static void main(String[] args) {

        Integer integer = 1;
        Integer i = new Integer(1);

        System.out.println(integer);
        System.out.println(i);

        CallableTest callableTest = new CallableTest();
        FutureTask<String> futureTask = new FutureTask<String>(callableTest);
        try {
            String value = futureTask.get();
            System.out.println(value);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
