package com.se.unit7;

/**
 * @author LTMAX
 * @version 1.0
 * @description: String字符串
 * @date 2023/9/24 21:46
 */
public class StringTest {

    public static void main(String[] args) {
        stringTest();
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



}
