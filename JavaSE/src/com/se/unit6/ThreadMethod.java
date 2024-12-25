package com.se.unit6;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 线程的常用方法
 * @date 2024/1/17 0:45
 */
public class ThreadMethod {
    /**
     *线程的常用方法
     *
     * 熟悉常用的构造器和方法：
     * 1. 线程中的构造器
     * - public Thread() :分配一个新的线程对象。
     * - public Thread(String name) :分配一个指定名字的新的线程对象。
     * - public Thread(Runnable target) :指定创建线程的目标对象，它实现了Runnable接口中的run方法
     * - public Thread(Runnable target,String name) :分配一个带有指定目标新的线程对象并指定名字。
     *
     * 2.线程中的常用方法：
     * > start():①启动线程 ②调用线程的run()
     * > run():将线程要执行的操作，声明在run()中。
     * > currentThread():获取当前执行代码对应的线程
     * > getName(): 获取线程名
     * > setName(): 设置线程名
     * > sleep(long millis):静态方法，调用时，可以使得当前线程睡眠指定的毫秒数
     * > yield():静态方法，一旦执行此方法，就释放CPU的执行权
     * > join(): 在线程a中通过线程b调用join()，意味着线程a进入阻塞状态，直到线程b执行结束，线程a才结束阻塞状态，继续执行。
     * > isAlive():判断当前线程是否存活
     *
     * 3. 线程的优先级：
     * getPriority():获取线程的优先级
     * setPriority():设置线程的优先级。范围[1,10]
     *
     *
     * Thread类内部声明的三个常量：
     * - MAX_PRIORITY（10）：最高优先级
     * - MIN _PRIORITY （1）：最低优先级
     * - NORM_PRIORITY （5）：普通优先级，默认情况下main线程具有普通优先级。
     */

    int anInt = 1;


}
