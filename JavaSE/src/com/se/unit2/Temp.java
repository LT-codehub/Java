package com.se.unit2;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 临时
 * @date 2023/12/29 23:00
 */
public class Temp {

    // 代码块局部变量
    int x = 30;

    static int x1 = 50;

    static {
        int y1 = 30;
        System.out.println(y1);
        // 静态代码块
        System.out.println(x1 + y1);
    }

    // 进入代码块
    {
        int y = 50;
        System.out.println("Inside the block: x + y = " + (x + y));
    }
    public static void main(String[] args) {
        System.out.println(Math.abs(Integer.MIN_VALUE));

        //Temp temp = new Temp();
        // 代码块局部变量
        int x = 10;

        // 进入代码块
        {
            int y = 20;
            System.out.println("Inside the block: x + y = " + (x + y));
        }

        // 无法访问代码块内的局部变量 y
        // System.out.println("Outside the block: x + y = " + (x + y)); // 编译错误

        // 仍然可以访问代码块外的局部变量 x
        System.out.println("Outside the block: x = " + x);
    }


    class C{


    }

    interface A{

    }

    interface B extends A{

    }

    /**
     * 被final修饰的类不能被继承
     * 被final修饰的方法不能被重写
     * 被final修饰的变量不能被重新赋值
     */
}
