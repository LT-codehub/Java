package com.se.unit10;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Generic
 * @package: com.se.unit10
 * @description: 泛型方法：当方法被调用时，才确定泛型类型
 * @date 2024/1/21 21:42
 */
public class Generic {
    //泛型方法：
    public static <T> void printArray(T[] inputArray){
        // 输出数组元素
        for(T element : inputArray){
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'A', 'B', 'C', 'D', 'E'};

        System.out.println("整型数组元素为:");
        printArray(intArray);

        System.out.println("\n双精度型数组元素为:");
        printArray(doubleArray);

        System.out.println("\n字符型数组元素为:");
        printArray(charArray);
    }
}
