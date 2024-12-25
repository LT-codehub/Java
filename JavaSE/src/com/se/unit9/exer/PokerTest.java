package com.se.unit9.exer;

import java.util.*;

/**
 * @author LTMAX
 * @version 1.0
 * @className: PokerTest
 * @package: com.se.unit9.exer
 * @description: TODO
 * @date 2024/1/21 21:15
 */
public class PokerTest {

    /**
     *模拟斗地主洗牌和发牌，牌没有排序
     */
    public static void poker() {
        String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] color = {"方片","梅花","红桃","黑桃"};
        List poker = new ArrayList();
        //1. 生成54张扑克牌
        for (String s1 : color){
            for (String s2 : num) {
                poker.add(s1.concat(" " + s2));
            }
        }
        poker.add("小王");
        poker.add("大王");
        //2. 洗牌
        Collections.shuffle(poker);
        //3. 发牌
        List tomCards = new ArrayList();
        List jerryCards = new ArrayList();
        List meCards = new ArrayList();
        List lastCards = new ArrayList();
        for (int i = 0; i < poker.size(); i++) {
            if(i >= poker.size() - 3){
                lastCards.add(poker.get(i));
            }else if(i % 3 == 0){
                tomCards.add(poker.get(i));
            }else if(i % 3 == 1){
                jerryCards.add(poker.get(i));
            }else {
                meCards.add(poker.get(i));
            }
        }
        //4. 看牌
        System.out.println("Tom:\n" + tomCards);
        System.out.println("Jerry:\n" + jerryCards);
        System.out.println("me:\n" + meCards);
        System.out.println("底牌:\n" + lastCards);
    }

    /**
     *模拟斗地主洗牌和发牌并对牌进行排序的代码实现
     */
    public static void pokerV1() {
        String[] num = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] color = {"方片", "梅花", "红桃", "黑桃"};
        HashMap map = new HashMap();
        // 存储索引和扑克牌
        ArrayList list = new ArrayList();
        // 存储索引
        int index = 0;
        // 索引的开始值
        for (String s1 : num) {
            for (String s2 : color) {
                map.put(index, s2.concat(s1));
                // 将索引和扑克牌添加到HashMap中
                list.add(index);
                // 将索引添加到ArrayList集合中
                index++; } }
        map.put(index, "小王");
        list.add(index); index++;
        map.put(index, "大王");
        list.add(index);
        // 洗牌
        Collections.shuffle(list);
        // 发牌
        TreeSet Tom = new TreeSet();
        TreeSet Jerry = new TreeSet();
        TreeSet me = new TreeSet();
        TreeSet lastCards = new TreeSet();
        for (int i = 0; i < list.size(); i++)
        {
            if (i >= list.size() - 3) {
                lastCards.add(list.get(i));
                // 将list集合中的索引添加到TreeSet集合中会自动排序
            } else if (i % 3 == 0) {
                Tom.add(list.get(i));
            } else if (i % 3 == 1) {
                Jerry.add(list.get(i));
            } else {
                me.add(list.get(i));
            }
        }
        // 看牌
        lookPoker("Tom", Tom, map);
        lookPoker("Jerry", Jerry, map);
        lookPoker("康师傅", me, map);
        lookPoker("底牌", lastCards, map);
    }

    public static void lookPoker(String name, TreeSet ts, HashMap map) {
        System.out.println(name + "的牌是:");
        for (Object index : ts) {
            System.out.print(map.get(index) + " ");
        }
        System.out.println();
    }

}
