package com.se.unit2;

import java.util.Arrays;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 运算符
 * @date 2023/8/20 21:25
 */
public class Operator {


    public static void main(String[] args) {

        System.out.println('A'+1);
        //arithmeticOperator();
        bitOperator();
        compareOperator();
        inc();
        dec();
    }

    /**
     *算数运算符
     */
    public static void arithmeticOperator(){
        System.out.println("算数运算符");
        add();
        System.out.println("加减乘除逻辑都差不多");
        sub();
        mul();
        div();
    }

    /**
     *位运算
     */
    public static void bitOperator(){
        System.out.println("位运算");
        System.out.println("Integer.bitCount(16) = " + Integer.bitCount(16));
        System.out.println("(1 << 2) = " + (1 << 2));
        System.out.println("(16 >> 2) = " + (16 >> 2));
        System.out.println("(16 >>> 2) = " + (16 >>> 2));
        System.out.println("(16 & 3) = " + (16 & 3));
        System.out.println("(16 | 3) = " + (16 | 3));
        System.out.println("(16 ^ 3) = " + (16 ^ 3));
        System.out.println("(~6) = " + (~6));
    }

    /**
     *比较运算符
     */
    public static void compareOperator(){
        byte A = 65;
        System.out.println("比较运算符");
        System.out.println("1.== 比较两个对象是否相等:"+('A'==65));
        //隐式转换
        System.out.println("A == 65"+(A==65));
        System.out.println("A == 字符A"+(A=='A'));

        System.out.println("2.!= 比较两个对象是否不相等"+('A'!=65));
        System.out.println("3.< 比较一个对象是否小于另一个对象"+(65<'A'));
        System.out.println("4.<= 比较一个对象是否小于等于另一个对象"+(65<='A'));
        System.out.println("5.> 比较一个对象是否大于另一个对象"+(65>'A'));
        System.out.println("6.>= 比较一个对象是否大于等于另一个对象"+(65>='A'));

        Integer integer = new Integer(1);
        System.out.println(integer instanceof Integer);
        System.out.println(integer instanceof Number);
        System.out.println(integer instanceof Object);
        System.out.println(integer instanceof Comparable);
    }

    /**
     *逻辑运算
     */
    public static void logicalOperator(){}

    /**
     *三目运算符
     */
    public  static void ternaryOperator(){}

    /**
     *赋值运算符
     */
    public  static void assignmentOperator(){}


    /**
     *加法
     */
    public static void add(){

        byte aByte = 1;
        byte bByte = 2;
        short aShort  = 1;
        short bShort  = 2;
        System.out.println("---------------------------------");
        //char、byte、short 类型参与运算时，会自动转换成 int 类型
        System.out.println("字符a+字符b = "+ ('a' + 'b'));
        System.out.println("aByte+bByte = " + (aByte + bByte));
        System.out.println("aShort+bShort = " + (aShort + bShort));
        //分割线
        System.out.println("---------------------------------");

        //在进行算数运算时，表达式会自动进行隐式转换
        //表达式中低位的数据类型会转换成高位的数据类型
        System.out.println("字符a+10L = "+ ('a' + 10L));

        System.out.println("aByte+10.0 = " + (aByte + 10.0));

        System.out.println("aShort+10.0F = " + aShort + 10.0F);
        System.out.println("---------------------------------");


    }
    /**
     *减法
     */
    public static void sub(){
    }
    /**
     *乘法
     */
    public static void mul(){}
    /**
     *除法
     */
    public static void div(){
        System.out.println("整数相除会舍去小数：5/2 = " + (5 / 2));
        System.out.println("表达式中有负数，结果为负数：-5/2 = " + (-5 / 2));
        System.out.println("浮点数相除会保留小数：5.0/2 = " + (5.0 / 2));
        System.out.println("浮点数相除会保留小数：5.0/2.0 = " + (5.0 / 2.0));
        System.out.println("---------------------------------");

    }
    /**
     *取模
     */
    public static void mod(){
        System.out.println("取模运算：5%2 = " + (5 % 2));
        System.out.println("取模运算：5.0%2 = " + (5.0 % 2));
        System.out.println("取模运算：5.0%2.0 = " + (5.0 % 2.0));
        //模数的符号可以忽略
        System.out.println("模数的符号可以忽略：-5%2 = " + (5 % 2));
        System.out.println("---------------------------------");
    }
    /**
     *自增
     */
    public static void inc(){
        int a = 1;
        System.out.println("a = " + a);
        System.out.println("a++ = " + (a++));
        System.out.println("a = " + a);
        System.out.println("++a = " + (++a));
        System.out.println("a = " + a);
        System.out.println("---------------------------------");
    }
    /**
     *自减
     */
    public static void dec(){

        int a = 1;
        System.out.println("a = " + a);
        System.out.println("a-- = " + (a--));
        System.out.println("a = " + a);
        System.out.println("--a = " + (--a));
        System.out.println("a = " + a);
    }






}
