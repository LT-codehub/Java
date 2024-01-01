package com.se.unit3;

import com.se.util.Tools;

import java.util.Arrays;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/12/31 22:13
 */
public class Temp {
    public static void main(String[] args) {
        String str = "hello";

        //随机生成一个长度为15的int数组
        try {
            int[] ints = Tools.randomArray(100);
            System.out.println(binarySearch(ints, 900));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static int binarySearch(int[] arr, int target) {

        Arrays.sort(arr);

        if (arr[0] > target || target > arr[arr.length-1]){
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                // 找到目标元素，返回索引
                return mid;
            } else if (arr[mid] < target) {
                // 缩小查找范围
                low = mid + 1;
            } else{
                // 缩小查找范围
                high = mid - 1;
            }
        }
        // 目标元素不存在，返回 -1
        return -1;
    }
}
