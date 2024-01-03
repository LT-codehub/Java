package com.tao.demo.util;

import java.util.Random;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2024/1/2 22:39
 */
public class Tools {

    public static final String[] FIRST_NAMES = {
            "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈",
            "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
            "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏",
            "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章",
            "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦",
            "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
            "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺",
            "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬", "安", "常",
            "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余",
            "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹"
    };

    private static Random random = new Random();


   public static String generateRandomName() {

       String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];

       String lastName = ""+generateRandomChinese();
       if (random.nextInt(2) == 1) {
           lastName += generateRandomChinese();
       }

       return lastName + firstName;
   }

   /**
    *随机性别
    */
   public static String generateRandomGender() {
       return random.nextInt(2) == 0 ? "男" : "女";
   }

   /**
    * 随机生成汉字
    */
   public static char generateRandomChinese() {
       return (char) (0x4e00 + random.nextInt(20902));
   }

}
