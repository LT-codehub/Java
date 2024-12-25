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
public class  Cyclic {
    public static void main(String[] args) {


        printDiamond();
        printMultiplicationTable(11);
        //whileDemo();
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



    /**
     *gpt菱形代码
     */
    public static void printDiamond() {
        Scanner scanner = new Scanner(System.in);

        // 获取菱形的行数
        System.out.print("Enter the number of rows for the diamond: ");
        int rows = scanner.nextInt();

        // 打印上半部分的菱形
        for (int i = 1; i <= rows; i++) {
            // 打印空格
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // 打印星号
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 打印下半部分的菱形
        for (int i = rows - 1; i >= 1; i--) {
            // 打印空格
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            // 打印星号
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }

    /**
     *输出n*n乘法表
     *
     */
    public static void printMultiplicationTable(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + (i * j));
                System.out.print("\t");
            }
            System.out.println();
        }
    }

}
