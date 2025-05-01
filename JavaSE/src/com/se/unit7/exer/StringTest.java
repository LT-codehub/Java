package com.se.unit7.exer;

/**
 * @author LTMAX
 * @version 1.0
 * @className: StringTest
 * @package: com.se.unit7.exer
 * @description: TODO
 * @date 2024/1/18 18:53
 */
public class StringTest {
    private String str = "good";

    private char[]  ch = {'b','o','o','k'};

    private  void change(String str,char[] ch){
         str = "great";
         ch[ch.length-1] = 's';
    }
    public static void main(String[] args) {
        StringTest test = new StringTest();

        test.change(test.str,test.ch);

        System.out.println(test.str);//输出
        System.out.println(test.ch);//输出

    }
}

