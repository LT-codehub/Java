package com.se.unit9;

import org.junit.Test;

import java.util.*;

/**
 * @author LTMAX
 * @version 1.0
 * @className: MapTest
 * @package: com.se.unit9
 * @description: TODO
 * @date 2024/1/19 21:06
 */
public class MapTest {
    /**
     *map接口常用方法：
     * 添加：`put(Object key,Object value)`
     * 删除：`remove(Object key)`
     * 修改：`put(Object key,Object value)`
     * 查询：`get(Object key)`
     * 长度：`size()`
     * 遍历：`keySet()` / `values()` / `entrySet()`
     */

    /**
     *HashMap：线程不安全，效率高；允许null键和null值
     *LinkedHashMap：遍历其内部数据时，可以按照添加的顺序实现遍历
     *TreeMap：可以按照添加的key-value对进行排序，实现排序遍历
     *HashTable：线程安全，效率低；不允许null键和null值
     *Properties：常用来处理配置文件
     */

    /**
     *测试HashMap：key是无序且不重复的，value是无序且可以重复的
     */
    @Test
    public void testHashMap(){
        System.out.println("HashMap：key是无序且不重复的，value是无序且可以重复的");
        Map<Integer, String> map = new HashMap<>();
        map.put(4, "d");
        map.put(2, "b");
        map.put(1, "a");
        map.put(3, "c");
        map.put(4, "e");
        map.put(3, "c");
        System.out.println(map);

        System.out.println("HashMap遍历：keySet()");
        for (Integer key : map.keySet()) {
            System.out.println(key + "=" + map.get(key));
        }

        System.out.println("HashMap遍历：entrySet()");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        System.out.println("HashMap遍历：values()");
        for (String str:map.values()) {
            System.out.println(str);
        }
    }

    /**
     *测试LinkedHashMap：key是无序且不重复的，value是有序且可以重复的
     */
    @Test
    public void testLinkedHashMap(){
        System.out.println("LinkedHashMap：key是无序且不重复的，value可以重复的,并跟随key的顺序");
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(4, "d");
        map.put(2, "b");
        map.put(1, "a");
        map.put(3, "c");
        map.put(4, "e");
        map.put(3, "c");
        System.out.println(map);
        System.out.println("LinkedHashMap遍历：keySet()");
        for (Integer key : map.keySet()) {
            System.out.println(key + "=" + map.get(key));
        }
        System.out.println("LinkedHashMap遍历：entrySet()");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("LinkedHashMap遍历：values()");

        for (String str:map.values()) {
            System.out.println(str);
        }
    }

    /**
     *测试TreeMap：key不重复的，并能根据指定的比较器进行排序，value的值可以重复
     */
    @Test
    public void testTreeMap(){
        System.out.println("TreeMap：key不重复的，并能根据指定的比较器进行排序，value的值可以重复");
        Map<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(4, "d");
        map.put(2, "b");
        map.put(1, "a");
        map.put(3, "c");
        map.put(4, "e");
        map.put(3, "c");
        System.out.println(map);

        System.out.println("TreeMap遍历：keySet()");
        for (Integer key : map.keySet()) {
            System.out.println(key + "=" + map.get(key));
        }
        System.out.println("TreeMap遍历：entrySet()");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("TreeMap遍历：values()");
        for (String str:map.values()) {
            System.out.println(str);
        }
    }


 }
