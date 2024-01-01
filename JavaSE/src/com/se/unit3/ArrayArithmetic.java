package com.se.unit3;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 数组相关算法
 * @date 2023/12/31 20:35
 */
public class ArrayArithmetic {
    public static void main(String[] args) {
        //随机数组
        Integer[] arr = {1,2,3,4,5,6,7,8,9,10};
        //反转
        //reverse(arr);

        //冒泡排序
        int[] arr1 = new int[]{43,32,76,-98,0,64,33,-21,32,99};
        bubbleSort(arr1);
    }

    /**
     *反转
     */
    public  static <T> void reverse(T[] arr){
        for(int i = 0,j = arr.length - 1;i < j;i++,j--){
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for (T t : arr) {
            System.out.println(t);
        }
    }

    /**
     * 线性查找
     */
    public  static <T> int linearSearch(T[] arr,T value){
        int count = 0;
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(value)){
                count++;
            }
        }
            return count;
        }

    /**
     *二分查找,适用有序的数值数组
     * 在有序的情况下将数组均分为A和B:
     * 1.当目标值小于A的最大值,则将A视为新的目标数组,(同时大于A的最小值)
     * 2.当目标值大于B的最小值,则将A视为新的目标数组，(同时小于B的最大值)
     * 重复上述步骤
     */
    public static int binarySearch(int[] arr, int target) {

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


    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-2; i++) {
            //1.0：记录当前轮次是否发生交换
            boolean flag = false;
            for (int j = i+1; j < arr.length -1; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    //1.0：如果发生交换，则将flag设置为true
                    flag = true;
                }
            }
            //1.0：如果当前轮次没有发生交换，说明数组已经有序，直接退出
            if (flag == true) {
                break;
            }
        }
    }

    /**
     *选择排序
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 重复第二步，直到所有元素均排序完毕。
     */
    public static void selectSort(int[] arr) {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
    }
    /**
     *插入排序
     * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
     * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
     */
    public  static void insertSort(int[] arr) {
        
    }




}
