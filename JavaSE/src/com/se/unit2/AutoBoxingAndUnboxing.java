package com.se.unit2;

import java.util.ArrayList;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 自动装箱和拆箱场景
 * @date 2023/9/22 11:41
 */
public class AutoBoxingAndUnboxing {

    public static void  modeOne(){

        //将基本数据类型放入集合类
        ArrayList<Integer> list = new ArrayList<>();
        //真实代码：list.add(Integer.valueOf(1));
        list.add(1);
        //真实代码：list.add(Integer.valueOf(2));
        list.add(2);
    }

    public static void modeTwo(){
        //包装类型和基本类型的大小比较
        int a = 2;
        Integer b = 1;
        //真实代码：System.out.println(a>b.intValue());
        System.out.println(a>b);
    }

    public static void modeThree(){
        //包装类型的运算
        Integer a = 1;
        Integer b = 2;
        //真实代码：System.out.println(a.intValue()+b.intValue());
        System.out.println(a+b);
    }

    public static void modeFour(){
        //三目运算符的使用
        boolean flag = true;
        Integer i = 0;
        int j = 1;
        int k = flag ? i : j;
        System.out.println(k);
    }

    public static void modeFive(){
        //三目运算符的类型对齐
        Integer i = null;
        int j = 1;
        //类型对齐
        int m = false ? j : i;
        int k = true ? i : j;

    }

    public static void main(String[] args) {
        //modeOne();
        //modeTwo();
        //modeThree();
        //modeFour();
        modeFive();
    }
}
