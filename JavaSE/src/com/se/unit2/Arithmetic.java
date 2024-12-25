package com.se.unit2;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 简单算法
 * @date 2023/12/30 22:27
 */
public class Arithmetic {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Arithmetic.primeNumber(1000);
        long end = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (end - start) + "ms");
    }
    //输出素数
    public static void primeNumber(int n){
        //素数：除了1之外只能被自身整除，不能被2整除就是素数
        for(int i = 2;i <= n;i++){
            boolean flag = true;
            for(int j = 2;j < i;j++){
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(i);
            }
        }

}
}
