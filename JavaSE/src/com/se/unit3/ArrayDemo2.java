package com.se.unit3;

/**
 * 二维数组
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/4 0:17
 */
public class ArrayDemo2 {
    public static void main(String[] args) {

        //声明+动态初始化
        int [][] arr = new int[10][10];
        //声明+静态初始化
        int[][] arr1 = new int[][]{{1,2,3},{4,5,9,10},{6,7,8}};
        //类型推断
        int[][] arr2 = {{1,2,3},{4,5},{6,7,8}};

        System.out.println("arr2[0][1] = " + arr2[0][1]);
        //输出为2
    }
}
