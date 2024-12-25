package com.se.unit6;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/15 11:59
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 1.调用Executors的newFixedThreadPool(),返回指定线程数量的ExecutorService
        ExecutorService pool = Executors.newFixedThreadPool(10);
        // 2.将Runnable实现类的对象作为形参传递给ExecutorService的submit()方法中，开启线程
        // 并执行相关的run()
        pool.execute(new ThreadTest());
        pool.execute(new RunnableTest());
        Future<String> submit = pool.submit(new CallableTest());
        // 3.结束线程的使用
        pool.shutdown();
    }

    @Test
    public void test(){
        /*
         * 各参数含义
         * corePoolSize    : 线程池中常驻的线程数量。核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会
         *                   受存活时间 keepAliveTime 的限制，除非将 allowCoreThreadTimeOut 设置为 true。
         * maximumPoolSize : 线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的
         *                   LinkedBlockingQueue时，这个值无效。
         * keepAliveTime   : 当线程数量多于 corePoolSize 时，空闲线程的存活时长，超过这个时间就会被回收
         * unit            : keepAliveTime 的时间单位
         * workQueue       : 存放待处理任务的队列
         * threadFactory   : 线程工厂
         * handler         : 拒绝策略，拒绝无法接收添加的任务
         */
        //创建线程工厂
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("xxx线程池"+r.hashCode());
                thread.setPriority(Thread.MAX_PRIORITY);
                System.out.println("线程工厂");
                return thread;
            }
        };

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100), factory, new RejectedExecutionHandler() {

            //拒绝策略
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("My rejectExecution");
            }
        });

        for (int i = 0; i < 100; i++) {
            int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"任务："+ finalI);
                    System.out.println("实际线程");
                }
            });
        }

    }

}
