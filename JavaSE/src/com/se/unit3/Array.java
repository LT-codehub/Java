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
        Array.test();
        Array.test1();

    }

    /**
     *一维数组
     */
    private static void test(){
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
        for ( String name:names){
            System.out.println("name = " + name);
        }
        names[0] = "Tom";
    }

    /**
     *二维数组
     */
    private static void test1(){
        //静态初始化
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};

        //int[][] arr2 = new int[][3]; 报错
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"] = " + arr[i]);
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("arr["+i+"]["+j+"] = " + arr[i][j]);
            }
        }

        //分割线
        System.out.println("-------------------------------------");

        int[][] arr1 = new int[3][3];
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("arr1["+i+"] = " + arr1[i]);
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.println("arr1["+i+"]["+j+"] = " + arr1[i][j]);
            }
        }

        //分割线
        System.out.println("-------------------------------------");

        int[][] arr3 = new int[3][];

        try {
            for (int i = 0; i < arr3.length; i++) {
                System.out.println("arr3["+i+"] = " + arr3[i]);
                for (int j = 0; j < arr3[i].length; j++) {
                    System.out.println("arr3["+i+"]["+j+"] = " + arr3[i][j]);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();//程序结束后将异常的细节信息输出到控制台
        }

        //分割线
        System.out.println("-------------------------------------");

        //动态初始化
        int[][] arr2 = new int[3][];
        arr2[0] = new int[3];
        arr2[1] = new int[4];
        arr2[2] = new int[6];

        //二维数组的第一层元素都地址值
        String[][] arr4 = new String[3][3];
        int[][] ints = new int[3][3];
        //第二层元素为空
        String[][] arr5 = new String[3][];
        int[][] ints1 = new int[3][];



    }
}
