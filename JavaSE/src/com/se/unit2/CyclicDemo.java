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
public class CyclicDemo {
    public static void main(String[] args) {

        Integer[] array = randomArray(10000);
        sort(array);
        System.out.println("-----------------------------------------------------------------------------");
        sortV1(array);

    }


    /**
     *实现对三个整数进行排序，输出时按照从小到大的顺序输出。
     */
    public static void sort(Integer... integers) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < integers.length-1; i++) {
            for (int j = i+1; j < integers.length; j++) {
                if (integers[i] > integers[j]) {
                    integers[i] = integers[i]^integers[j];
                    integers[j] = integers[i]^integers[j];
                    integers[i] = integers[i]^integers[j];
                }
            }
        }
        long end = System.currentTimeMillis();
        long time = end-start;

        // for (int i = 0; i < integers.length; i++) {
        //     System.out.println(integers[i]);
        // }
        System.out.println("花费的时间是"+time);

    }

    public static void sortV1(Integer... integers) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < integers.length-1; i++) {
            //统计交换的次数，每交换以及+1，当count=0表示初始有序，count为=1表示最后一次排序
            int count = 0;
            for (int j = i+1; j < integers.length; j++) {
                if (integers[i] < integers[j]) {
                    integers[i] = integers[i]^integers[j];
                    integers[j] = integers[i]^integers[j];
                    integers[i] = integers[i]^integers[j];
                    count++;
                }
            }
            if (count <= 0) {
                break;
            }
        }

        long end = System.currentTimeMillis();
        long time = end-start;

        // for (int i = 0; i < integers.length; i++) {
        //     System.out.println(integers[i]);
        // }
        System.out.println("花费的时间是"+time);
    }

    /**
     *从键盘分别输入年、月、日，判断这一天是当年的第几天
     */
    public static void method1() {
        Scanner scanner = new Scanner(System.in);
        Integer[] time = new Integer[2];
        System.out.println("请输入年份：");


    }

    private static Integer[] randomArray(Integer count){
        Random random = new Random();
        Integer[] integers = new Integer[count];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = random.nextInt();
        }
        return integers;
    }




}
