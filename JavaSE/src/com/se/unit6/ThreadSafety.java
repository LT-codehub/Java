package com.se.unit6;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author LTMAX
 * @version 1.0
 * @className: ThreadSafety
 * @package: com.se.unit6
 * @description: 有线程安全的几种情况
 * @date 2024/1/17 17:06
 */
public class ThreadSafety {

    public static void main(String[] args) {
        ThreadSafety safety = new ThreadSafety();
        //线程不安全
        //safety.execute(new MyThread(),"Thread实现线程");
        //safety.execute(new MyRunnable(),"Runnable实现线程");
        //safety.execute(new MyCallable(),"Callable实现线程");
        //使用同步关键字synchronized
        //当实例唯一是不会出现线程不安全的情况
        //safety.execute(new MyThreadSafety(),"同步关键字实现线程");
        //当实例不唯一时使用对象作为锁会出现线程不安全的情况
        safety.execute();


    }

    static class  MyThread extends Thread{
        //造成线程不安全最主要的原因是因为操作共享变量
        private int count = 100;

        @Override
        public void run() {
            super.run();
            //sleep延长了每个线程的执行时间，
            //导致count的值被多次读取，放大了线程安全问题
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0){
                System.out.println(Thread.currentThread().getName()+" count = "+count);
                count--;
            }
                      }
    }

    static class MyRunnable implements Runnable{
        private int count = 100;

        @Override
        public void run(){

            //sleep延长了每个线程的执行时间，
            //导致count的值被多次读取，放大了线程安全问题
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + " count = " + count);
                    count--;
                }
            }
        }
    }

    static class MyCallable implements Callable<String> {
        private int count = 100;

        @Override
        public String call() throws Exception {
            //sleep延长了每个线程的执行时间，
            //导致count的值被多次读取，放大了线程安全问题
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0){
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + " count = " + count);
                    count--;
                }
            }

            return null;
        }
    }

    static class MyThreadSafety extends Thread {
        //static化保证count的值在多个线程中是共享的
        private static int count = 100;

        @Override
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //method();
            method1();
            //method2();
            //method3();

        }

        private void method(){
            //使用synchronized同步代码块
            //此时的同步监视器是：当前实例化的对象
            Thread.currentThread().setName("使用同步代码块+同步监视器是：当前实例化的对象的线程"+Thread.currentThread().getName());
            //当有多个实例时，锁也会出现多个，同一时间可能有多个线程同时获得锁，从而获得操作共享数据的权限，造成线程安全问题
            synchronized (this) {
                if(count > 0) {
                    System.out.println(Thread.currentThread().getName() + " count = " + count);
                    count--;
                }
            }
        }

        private void method1(){
            Thread.currentThread().setName("使用同步代码块+同步监视器是：当前类的线程"+Thread.currentThread().getName());
            //使用synchronized同步代码块
            //此时的同步监视器是：MyThreadSafety.class
            //锁是唯一的，不论如何都只有一个线程能够获得锁，从而获得操作共享数据的权限，不会造成线程安全问题
            synchronized (MyThreadSafety.class) {
                if(count > 0) {
                    System.out.println(Thread.currentThread().getName() + " count = " + count);
                    count--;
                }
            }
        }

        /**
         *使用synchronized同步方法
         *此时的同步监视器是：当前实例化的对象
         *
         */
        //当有多个实例时，锁也会出现多个，同一时间可能有多个线程同时获得锁，从而获得操作共享数据的权限，造成线程安全问题
        private synchronized void method2(){
            Thread.currentThread().setName("使用同步方法+同步监视器是：当前实例化的对象的线程"+Thread.currentThread().getName());
            if(count > 0) {
                System.out.println(Thread.currentThread().getName() + " count = " + count);
                count--;
            }
        }

        /**
         *使用synchronized的静态同步方法
         *此时的同步监视器是当类MyThreadSafety.class
         */
        //锁是唯一的，不论如何都只有一个线程能够获得锁，从而获得操作共享数据的权限，不会造成线程安全问题
        private static synchronized void method3(){
            Thread.currentThread().setName("使用静态同步方法+同步监视器是：当前当前类的线程"+Thread.currentThread().getName());
            if(count > 0) {
                System.out.println(Thread.currentThread().getName() + " count = " + count);
                count--;
            }
        }
    }

    static class MyRunnableSafety implements  Runnable{
        //static化保证count的值在多个线程中是共享的
        private static int count = 100;

        @Override
        public void run() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //method();
            method1();
            //method2();
            //method3();

        }

        private void method(){
            //使用synchronized同步代码块
            //此时的同步监视器是：当前实例化的对象
            Thread.currentThread().setName("使用同步代码块+同步监视器是：当前实例化的对象的线程"+Thread.currentThread().getName());
            //当有多个实例时，锁也会出现多个，同一时间可能有多个线程同时获得锁，从而获得操作共享数据的权限，造成线程安全问题
            synchronized (this) {
                if(count > 0) {
                    System.out.println(Thread.currentThread().getName() + " count = " + count);
                    count--;
                }
            }
        }

        private void method1(){
            Thread.currentThread().setName("使用同步代码块+同步监视器是：当前类的线程"+Thread.currentThread().getName());
            //使用synchronized同步代码块
            //此时的同步监视器是：MyThreadSafety.class
            //锁是唯一的，不论如何都只有一个线程能够获得锁，从而获得操作共享数据的权限，不会造成线程安全问题
            synchronized (MyThreadSafety.class) {
                if(count > 0) {
                    System.out.println(Thread.currentThread().getName() + " count = " + count);
                    count--;
                }
            }
        }

        /**
         *使用synchronized同步方法
         *此时的同步监视器是：当前实例化的对象
         *
         */
        //当有多个实例时，锁也会出现多个，同一时间可能有多个线程同时获得锁，从而获得操作共享数据的权限，造成线程安全问题
        private synchronized void method2(){
            Thread.currentThread().setName("使用同步方法+同步监视器是：当前实例化的对象的线程"+Thread.currentThread().getName());
            if(count > 0) {
                System.out.println(Thread.currentThread().getName() + " count = " + count);
                count--;
            }
        }

        /**
         *使用synchronized的静态同步方法
         *此时的同步监视器是当类MyThreadSafety.class
         */
        //锁是唯一的，不论如何都只有一个线程能够获得锁，从而获得操作共享数据的权限，不会造成线程安全问题
        private static synchronized void method3(){
            Thread.currentThread().setName("使用静态同步方法+同步监视器是：当前当前类的线程"+Thread.currentThread().getName());
            if(count > 0) {
                System.out.println(Thread.currentThread().getName() + " count = " + count);
                count--;
            }
        }
    }

    /**
     * 会出现线程安全问题
     */
    private void execute(){
        MyThreadSafety thread = new MyThreadSafety();
        MyThreadSafety thread1 = new MyThreadSafety();
        MyThreadSafety thread2 = new MyThreadSafety();

        new Thread(thread,"1").start();
        new Thread(thread1,"2").start();
        new Thread(thread2,"3").start();


    }

    private void execute(Object t,String name){

        Thread t1 = null;
        Thread t2 = null;
        Thread t3 = null;
        if (t instanceof MyThread){
            MyThread thread = (MyThread) t;
            t1 = new Thread(thread,name+1);
            t2 = new Thread(thread,name+2);
            t3 = new Thread(thread,name+3);
        }else if (t instanceof MyRunnable){
            MyRunnable runnable = (MyRunnable) t;
            t1 = new Thread(runnable,name+1);
            t2 = new Thread(runnable,name+2);
            t3 = new Thread(runnable,name+3);
        }else if (t instanceof MyCallable){
            MyCallable callable = (MyCallable) t;
            FutureTask<String> futureTask = new FutureTask<String>(callable);
            t1 = new Thread(futureTask,name+1);
            t2 = new Thread(futureTask,name+2);
            t3 = new Thread(futureTask,name+3);
        }else {
            MyThreadSafety safety = (MyThreadSafety) t;
            t1 = new Thread(safety,name+1);
            t2 = new Thread(safety,name+2);
            t3 = new Thread(safety,name+3);
        }

        //此时的t1、t2、t3本质都是指向同一个类实例
        t1.start();
        t2.start();
        t3.start();


    }





}
