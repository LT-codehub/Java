package com.se.unit9;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author LTMAX
 * @version 1.0
 * @className: ListTest
 * @package: com.se.unit9
 * @description: List测试：List存储的元素是有序可重复的的
 * @date 2024/1/19 21:06
 */
public class ListTest {
    public static void main(String[] args) {
        arrayListTest();
        linkedListTest();
    }

    /**
     *ArrayList测试
     * 常用方法
     * add(E e)：新增元素
     * add(int index, E e)：在index位置新增元素
     * remove(int index)：删除index位置元素
     * remove(E e)：删除第一个匹配的元素
     * set(int index, E e)：设置index位置的元素
     * get(int index)：获取index位置的元素
     * indexOf(E e)：返回第一个匹配的元素的索引
     * lastIndexOf(E e)：返回最后一个匹配的元素的索引
     * size()：返回ArrayList的元素个数
     * toArray()：返回包含所有元素的数组
     * contains(E e)：查询ArrayList是否包含元素e
     * clear()：清空ArrayList
     * isEmpty()：查询ArrayList是否为空
     * 注意：ArrayList不是线程安全的，如果需要使用多线程，需要自己实现同步控制
     *
     */


    /**
     *ArrayListList存储的元素是有序可重复的的，底层就是一个数组
     */
    private static void arrayListTest(){
        System.out.println("ArrayListList存储的元素是有序可重复的的，底层就是一个数组");
        ArrayList<Object> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("5");
        list.add("4");
        list.add("3");
        list.add("2");
        list.add("1");
        System.out.println("list.size() = " + list.size());
        //遍历list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     *LinkedList存储的元素是有序可重复的的，底层就是一个链表
     */
    private static void linkedListTest(){
        System.out.println("LinkedList存储的元素是有序可重复的的，底层就是一个链表");
        LinkedList<Object> list = new LinkedList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("5");
        list.add("4");
        list.add("3");
        list.add("2");
        list.add("1");
        System.out.println("list.size() = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

