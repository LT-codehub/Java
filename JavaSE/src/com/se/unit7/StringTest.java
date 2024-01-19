package com.se.unit7;

/**
 * @author LTMAX
 * @version 1.0
 * @description: String字符串
 * @date 2023/9/24 21:46
 */
public class StringTest {

    public static void main(String[] args) {
        //stringTest();
        stringConcatTest();
    }

    /**
     * 字符串的声明
     */
    public static void stringTest() {
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        String str4 = new String("hello");
        String str5 = new String("hello");

        System.out.println(str1 == str2);
        //结果为true，因为字符串常量池中只有一个字符串对象
        System.out.println(str1 == str3);
        //结果为false，因为str3指向的是堆中的对象，而str1指向的是字符串常量池中的对象
        System.out.println(str1 == str4);
        //结果为false，因为str4指向的是堆中的对象，而str1指向的是字符串常量池中的对象
        System.out.println(str1 == str5);
        //结果为false，因为str5指向的是堆中的对象，而str1指向的是字符串常量池中的对象
        System.out.println(str1.equals(str2));
        //结果为true，因为字符串常量池中只有一个字符串对象
        System.out.println(str1.equals(str3));
        //结果为true，因为String的equals方法会比较具体的内容，虽然str1和str2的指向不同，但是两者的内容是相同的
    }

    /**
     *字符串的拼接
     */

    public static void stringConcatTest() {
        String s1 = "javaEE";//s1指向字符串常量池中的值
        String s2 = "hadoop";//s2指向字符串常量池中的值
        String s3 = "javaEEhadoop";//s3指向字符串常量池中的值
        String s4 = "javaEE" + "hadoop";//s4指向字符串常量池中的值
        String s5 = s1 + "hadoop";//s5指向堆中的对象
        String s6 = "javaEE" + s2;//s6指向堆中的对象
        String s7 = (s1 + s2).intern();//s7指向字符串常量池中的值，因为javaEEhadoop在常量池中已存在


        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//true
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        String s8 = s6.intern();//返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        System.out.println(s3 == s8);//true


        String s9 = (s1 + "world").intern();
        String s10 = "javaEEworld";
        System.out.println(s9 == s10);

    }



}
