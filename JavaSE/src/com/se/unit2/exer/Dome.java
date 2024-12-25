package com.se.unit2.exer;

import java.util.Random;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2024/1/16 21:45
 */
public class Dome {

    public static void main(String[] args) {


        long start = System.currentTimeMillis();
        Random random = new Random();
        for (int i = 0; i <10000; i++) {
            int num = random.nextInt(100000);
            int n = random.nextInt(Integer.valueOf(num).toString().length())+1;
            System.out.println(num+"的第"+n+"位是："+get(num,n)+"\t");
            System.out.println(num+"的第"+n+"位是："+getV1(num,n)+"\t");
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"毫秒");


        start = System.currentTimeMillis();
        for (int i = 0; i <10000; i++) {
            int num = random.nextInt(100000);
            int n = random.nextInt(Integer.valueOf(num).toString().length())+1;
            System.out.println(num+"的第"+n+"位是："+getV1(num,n)+"\t");
        }
        end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"毫秒");

    }

    /**
     * 随意给出一个整数，打印显示它的个位数，十位数，百位数的值。
     * @param: num：表示原值
     * @param: n：表示第n位
     * @return: Byte：表示第n位的值
     * @throws:
     *
     */
    public static Integer get(int num,int n){
        String string = Integer.valueOf(num).toString();
        if (string.length()<n){
            throw new RuntimeException("第n位不存在");
        }else {
            char c = string.charAt(string.length() - n);
            return Integer.valueOf(String.valueOf(c));
        }

    }

    public static Integer getV1(int num,int n) {
        String string = Integer.valueOf(num).toString();
        if (string.length()<n){
            throw new RuntimeException("第n位不存在");
        }
        switch (n){
            case 1:
                return num % 10;
            case 2:
                return (num / 10) % 10;
            default:
                return num / Double.valueOf(Math.pow(10, n - 1)).intValue();
        }

    }


}
