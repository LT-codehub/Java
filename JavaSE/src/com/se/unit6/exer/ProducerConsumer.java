package com.se.unit6.exer;

/**
 * ClassName: ProducerConsumerTest
 * Description:
 *      案例2：生产者&消费者
 *      生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一次只能持有
 *      固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品
 *      了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来
 *      取走产品。
 *
 *      分析：
 *      1. 是否是多线程问题？ 是，生产者、消费者
 *      2. 是否有共享数据？有！ 共享数据是：产品
 *      3. 是否有线程安全问题？ 有！因为有共享数据
 *      4. 是否需要处理线程安全问题？是！ 如何处理？使用同步机制
 *      5. 是否存在线程间的通信？ 存在。
 *
 *
 */


import java.util.function.Consumer;

/**
 * @author LTMAX
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Customer customer = new Customer(clerk);
        Customer customer1 = new Customer(clerk);

        Thread thread1 = new Thread(productor);
        Thread thread2 = new Thread(customer);
        Thread thread3 = new Thread(customer1);

        thread1.setName("生产者1");
        thread2.setName("消费者1");
        thread3.setName("消费者2");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Clerk{
    //产品
    private int productCount = 0;

    //生产
    public synchronized void produceProduct() {

        if(productCount >= 20){
            try {
                //当产品数量达到20时，生产者线程等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");
            //通知消费线程就绪
            notifyAll();
        }
    }

    //消费
    public synchronized void consumeProduct() {
        if (productCount == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
            productCount--;
            //通知生产者线程就绪
            notifyAll();
        }
    }

}

class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        //生产
        while (true) {
            System.out.println(Thread.currentThread().getName()+"开始生产");
            clerk.produceProduct();
        }
    }
}

class Customer implements Runnable{
    private Clerk clerk;


    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+"开始消费");
            //消费
            clerk.consumeProduct();
        }

    }
}
