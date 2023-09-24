package com.se.unit4;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/11 0:35
 */
public class SingleSchema {
    /**
     * 单例模式：饿汉式
     *
     */
    static class Order{

        //1.私化类的构造器
        private Order(){

        }

        //2.声明当前类对象，没初始化
        //4.此对象也必须声明为static的
        private static Order instance = null;

        //3.声明public、static的返回当前类对象的方法
        public static Order getInstance(){
            if(instance == null){
                instance = new Order();
            }
            return instance;
        }

    }

    /**
     * 单例模式：饿汉式
     *
     */
    static class Order1{

        //1.私化类的构造器
        private Order1(){

        }

        //2.声明当前类对象，没初始化
        //4.此对象也必须声明为static的
        private static Order1 instance = null;

        //3.声明public、static的返回当前类对象的方法
        public static Order1 getInstance(){
            if(instance == null){
                instance = new Order1();
            }
            return instance;
        }

    }
}
