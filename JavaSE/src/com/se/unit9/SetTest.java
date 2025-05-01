package com.se.unit9;

import org.junit.Test;

import java.util.*;

/**
 * @author LTMAX
 * @version 1.0
 * @className: SetTest
 * @package: com.se.unit9
 * @description: TODO
 * @date 2024/1/19 21:06
 */
public class SetTest {
    public static void main(String[] args) {

    }

    /**
     * Hashset存储的是无序不重复的数据
     */
    @Test
    public void test1() {
        System.out.println("Hashset存储的是无序不重复的数据");
        HashSet<Integer> integers = new HashSet<>();
        //添加元素
        Integer[] arr = {1, 1, 2, 2, 3, 4, 5, 6, 9, 8, 7};
        for (Integer integer : arr) {
            System.out.print(integer + "\t");
            integers.add(integer);
        }
        System.out.print("\n");
        //遍历set
        for (Integer integer : integers) {
            System.out.print(integer + "\t");
        }
        System.out.print("\n");

    }

    /**
     * LinkedHashSet存储的也是无序不重复的数据，但是他用到了链表，保证元素的插入顺序
     */
    @Test
    public void test2() {
        System.out.println("LinkedHashSet存储的也是无序不重复的数据，但是他用到了链表，保证元素的插入顺序");
        Set<Integer> integers = new LinkedHashSet<>();
        //添加元素
        Integer[] arr = {1, 1, 2, 2, 3, 4, 5, 6, 9, 8, 7};
        for (Integer integer : arr) {
            System.out.print(integer + "\t");
            integers.add(integer);
        }
        System.out.print("\n");
        //遍历set
        for (Integer integer : integers) {
            System.out.print(integer + "\t");
        }
        System.out.print("\n");
    }


    /**
     * TreeSet数据不重复并按照一定的规则进行排序
     */
    @Test
    public void test3() {
        System.out.println("TreeSet数据不重复并按照一定的规则进行排序");
        //自定义排序规则，倒序
        Set<Integer> integers = new TreeSet<>((o1, o2) -> -(o1.compareTo(o2)));
        //添加元素
        Integer[] arr = {1, 1, 2, 2, 3, 4, 5, 6, 9, 8, 7};
        for (Integer integer : arr) {
            System.out.print(integer + "\t");
            integers.add(integer);
        }

        System.out.print("\n");
        //遍历set
        for (Integer integer : integers) {
            System.out.print(integer + "\t");
        }

        System.out.print("\n");
    }
}


