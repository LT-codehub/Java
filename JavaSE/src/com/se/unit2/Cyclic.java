package com.se.unit2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author LTMAX
 * @version 1.0
 * @description: 循环
 * @date 2023/8/26 17:09
 */
public class Cyclic {
    public static void main(String[] args) {

        whileDemo();
    }


    /**
     * while示例
     */
    public static void whileDemo() {
        System.out.println("while示例代码");
        int i = 0;
        while (i < 10) {
            System.out.println("i = " + i);
            i++;
        }
    }



}
