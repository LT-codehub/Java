package com.se.unit2;

/**
 * @ClassName: Variable 变量
 * @Description:
 * @Author: LTMAX
 * @Date: 2022/9/1817:07
 * @Version:
 */
public class Variable {

    /**
     *定义一个成员变量
     */
    public int a;

    /**
     *定义一个静态成员变量
     */
    public static int b;

    //定义一个代码块的局部变量
    {
        int d;
        //局部变量默认不会初始化，当你使用时必须初始化，不然会报错
        //System.out.println("d = " + d); error

        //初始化d
        d = 10;
        //输出
        System.out.println("d = " + d);

    }

    /**main方法中的args是一个形参，也是一个局部变量*/
    public static void main(String[] args) {
        //这是一个被初始化的局部变量
        int c = 10;

    }
}
