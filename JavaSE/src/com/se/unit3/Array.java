package com.se.unit3;

/**
 * @ClassName: ArraysDemo
 * @Description:
 * @Author: LTMAX
 * @Date: 2022/9/1817:19
 * @Version:
 */
public class Array {
    public static void main(String[] args) {


        //声明+动态初始化
        int[] arr = new int[10];
        System.out.println("动态初始化中数组元素的默认值为其类型的默认值");
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);

        }

        //声明+静态初始化
        long[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        for (int i = 0; i < 10; i++) {
            System.out.println(arr1[i]);
        }



        String[] names = new String[5];
        System.out.println(names.length);//5
        names[0] = "Tom";



    }
}
