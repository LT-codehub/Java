package com.se.unit2.review;


import org.junit.Test;
import sun.reflect.generics.scope.ClassScope;

import java.io.ObjectInputStream;
import java.util.HashMap;

/**
 * @author Administrator
 * @version 1.0
 * @className: UntilTwoReview
 * @package: com.se.unit2.review
 * @description: TODO
 * @date 2025/1/12 8:32
 */
public class UntilTwoReview {



    //{
    //    int n;
    //    System.out.println("n = " + n); //编译报错，没有初始值
    //}


    public static void main(String[] args) {

        Integer integer = 0;
        integer+=10;

        //语法

        //关键字
        //标识符：包名(全小写)、类名/接口(大驼峰)、变量名/方法名(小驼峰)、常量名(全大写)

        //1.变量

        //Variable v = new Variable();
        //v.getEvery();

        //Variable1 v1 = new Variable1();
        //v1.getEvery();

        //Variable2 v2 = new Variable2();
        //v2.test();
        //v2.test1();
        //2.运算
        Operator operator = new Operator();
        operator.test();
        operator.test1();
        operator.test3(60);
        //3.流程
    }


    private static class Variable {
        //变量的声明

        //基本数据类型
        private byte aByte;
        private int anInt;//整形默认类型
        private short aShort;
        private long aLong;

        private float aFloat;
        private double aDouble;//浮点默认类型

        private char aChar;

        private boolean aBoolean;

        public void getEvery(){
            System.out.println("aByte的默认值 ="+aByte);
            System.out.println("anInt的默认值 ="+anInt);
            System.out.println("aShort的默认值 ="+aShort);
            System.out.println("aLong的默认值 ="+aLong);
            System.out.println("aFloat的默认值 ="+aFloat);
            System.out.println("aDouble的默认值 ="+aDouble);
            System.out.println("aChar的默认值 ="+aChar+'\t'+"char的默认值的Unicode码'\\u0000'表示空字节符，无法输出");
            System.out.println("aChar的默认值 ="+(aChar+1));
            System.out.println("aBoolean的默认值 ="+aBoolean);
        }


    }


    private static class Variable1 {
        /**
         * 显示赋值
         */

        private byte aByte = 1;
        private int anInt = 4;//整形默认类型
        private short aShort = 2;
        private long aLong = 8L;

        private float aFloat = 4.0F;
        private double aDouble = 8.0;//浮点默认类型

        private char aChar = 'A';
        private boolean aBoolean = true;

        private Variable1() {
        }

        public void getEvery(){

            System.out.println("aByte ="+aByte);
            System.out.println("anInt ="+anInt);
            System.out.println("aShort ="+aShort);
            System.out.println("aLong ="+aLong);
            System.out.println("aFloat ="+aFloat);
            System.out.println("aDouble ="+aDouble);
            System.out.println("aChar ="+aChar);
            System.out.println("aChar ="+(aChar));
            System.out.println("aBoolean ="+ aBoolean);
        }

    }

    private static class Variable2 {

        //        * 变量都定义在其作用域内。在作用域内，它是有效的。换句话说，出了作用域，就失效了
        //        * 类级别的作用域
        static int a;
        //        * 实例级别的作用域
        int b;
        //        * 方法级别的作用域
        public void test(){
            int c = 0; //局部变量必须手动赋初值
            System.out.println("变量a可以被类和实例的所有成员使用："+a);
            System.out.println("变量b可以被所有实例成员使用："+b);
            System.out.println("变量c可以在当前方法内使用："+c);
        }
        //        * 代码块级别的作用域
        {
            int d = 0;//局部变量必须手动赋初值
            System.out.println("变量d只能在当前代码块内使用："+ d);
        }
        //        * 流程控制级别的作用域
        public void getEvery(){
            for (int i = 0; i < 5; i++) {
                System.out.println("i = " + i);
            }
            //System.out.println(i); 局部变量i只作用于流程内部
        }
        //* 同一个作用域内，不可以声明两个同名的变量
        //int b;

        Integer integer = 0;

        public void test1(){
            //取值越界问题
            System.out.println(Integer.MIN_VALUE);
            System.out.println(Math.abs(Integer.MIN_VALUE));
            //按照我们的设想来说应该输出2147483648结果确输出了-2147483648
            System.out.println(Integer.MIN_VALUE+1);
            System.out.println(-Integer.MIN_VALUE);
            //同上

        }
    }


    private static class Operator{

        private byte aByte = 1;
        private int anInt = 4;//整形默认类型
        private short aShort = 2;
        private long aLong = 8L;

        private float aFloat = 4.0F;
        private double aDouble = 8.0;//浮点默认类型

        private char aChar = 'A';
        private boolean aBoolean = true;

        public void test(){
            //自动类型转换
            //强制类型转换(大转小可能会丢失精度)
            aDouble = 87.156165156115618569418145616;
            System.out.println("aDouble = " + aDouble);
            float temp = (float) aDouble;
            System.out.println("temp = " + temp);
            //temp = 87.156166 精度丢失了
        }


        public void test1(){
            //算术运算符 +、-、*、/、%、++、--
            //1.+号除了加法运算外，也有连接字符串的作用
            System.out.println("加法：5+6 =" + (5+6));
            System.out.println("连接字符串："+"aDouble = " + aDouble);
            //2.-号做减法运算
            System.out.println("减法：5-6 =" + (5-6));
            //3.*号做乘法运算
            System.out.println("乘法法：5*6 =" + (5*6));
            //4./号做除法运算，0不能做除数，小数会直接忽略
            System.out.println("除法小数会直接忽略：5/6 =" + (5/6));
            System.out.println("除法：-30/6 =" + (-30/6));
            //System.out.println("除法：5/0 =" + (5/0)); ArithmeticException 除0错误
            //5.%号做取余(模)运算，模数的负号可以忽略，但被模数是负数则不可忽略。此外，取模运算的结果不一定总是整数
            System.out.println("取模：5%6 =" + (5%6));
            System.out.println("取模：5.5%6 =" + (5.5%6));
            System.out.println("取模：5%6.5 =" + (5%6.5));
        }



        public void test2(){
            //位运算符 < << > >> & | ^ ~
            System.out.println("位运算符");
            //1.<<、右移
            //2.>>、左移
            //3.>>>、无符号、左移
            //4.&、与
            //5.|、或
            //6.^、异或
            //7.~、取反

        }

        //### 实现60的二进制到十六进制的转换
        /**
         * 1.利用四位二进制数就是一个十六进制数
         * 2.使用与运算的取值特性
         */
        public void test3(int value){

            HashMap<Integer, String> map = new HashMap<>(15);
            map.put(10,"A");
            map.put(11,"B");
            map.put(12,"C");
            map.put(13,"D");
            map.put(14,"E");
            map.put(15,"F");

            int temp = 15;
            StringBuffer HEXValue = new StringBuffer("");
            if (value <= 0) {
                System.out.println("输入错误");
            }else {

                do {
                    int i = value & temp;
                    String str = "";
                    if (i > 10){
                        str = map.get(i);
                    }else {
                        str = str+i;
                    }
                    HEXValue.append(str);
                    value = value >> 4;
                }while (value > 0);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = HEXValue.length() - 1; i >= 0; i--) {  // 从字符串的最后一个字符开始，向前遍历
                sb.append(HEXValue.charAt(i));  // 将当前字符添加到 StringBuilder 中
            }

            System.out.println(sb);
        }



    }





}
