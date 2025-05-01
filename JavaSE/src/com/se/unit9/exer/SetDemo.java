package com.se.unit9.exer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author LTMAX
 * @version 1.0
 * @className: SetDemo
 * @package: com.se.unit9.exer
 * @description: TODO
 * @date 2024/1/20 21:30
 */
public class SetDemo {
    public static void main(String[] args) {
        sort();
    }

    /**
     *练习1：在一个List集合中存储了多个无大小顺序并且有重复的字符串，定义一个方法，让其有序(从小到大排序)，并且不能去除重复元素。
     */
    private static void sort(){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("def");
        list.add("jkl");
        list.add("mno");
        list.add("pqr");
        list.add("mno");
        list.add("stu");
        list.add("vwx");
        list.add("yza");

        System.out.println(list);

        list.sort((new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o1.compareTo(o2);
                return i==0?1:i;
            }
        }));

        System.out.println(list);
    }
}
