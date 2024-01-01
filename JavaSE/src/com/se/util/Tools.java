package com.se.util;

import java.util.Random;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 工具类
 * @date 2024/1/1 19:06
 */
public class Tools {

    /**
     * @description: 随机数组
     * @param: T[] 随机数组
     * @param: code 数组类型
     * @return:  T[] 随机数组
     * @throws:
     *
     */
    public static int[] randomArray(int length) throws Exception {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(1000);
        }

        return arr;

    }
}
