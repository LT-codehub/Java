package com.se.unit2;

import java.util.Random;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 分支
 * @date 2023/9/23 23:03
 */
public class Branch {

    public static void main(String[] args) {
        ifDemo();
        ifElseIfDemo();
        switchCaseExample();
    }

    /**
     * if示例代码
     */
    public static void ifDemo() {
        System.out.println("if示例代码");
        int a = 10;
        int b = 20;
        int c = 30;
        if (a > b) {
            if (a > c) {
                System.out.println("a is the largest");
            }
        }
    }

    /**
     * if else if else示例
     */
    public static void ifElseIfDemo() {
        System.out.println("if else if else示例代码");
        //获取0-100的随机数
        int i = new Random().nextInt(100);
        if (i < 30)
            System.out.println("i大于30");
        else if (i > 30 && i < 70 )
            System.out.println("i大于30小于70");
        else if (i > 70 && i < 90 )
            System.out.println("i大于70小于90");
        else
            System.out.println("i大于90小于100");
    }

    /**
     *switch case示例方法
     */
    public static void switchCaseExample(){
        int i = 1;
        switch (i) {
            case 1:
                System.out.println("i = 1");
                break;
            case 2:
                System.out.println("i = 2");
                break;
            case 3:
                System.out.println("i = 3");
                break;
            default:
                System.out.println("i is not 1,2,3");
                break;
        }
    }

}
