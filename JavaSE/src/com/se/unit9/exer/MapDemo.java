package com.se.unit9.exer;

import java.util.HashMap;

/**
 * @author LTMAX
 * @version 1.0
 * @className: MapDemo
 * @package: com.se.unit9.exer
 * @description: TODO
 * @date 2024/1/20 21:43
 */
public class MapDemo {

    public static void main(String[] args) {

    }


    /**
     *统计字符串中每个字符出现的次数
     */
    public void countChar() {
        String str = "aabbbcccc";
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.put(c,count+1);
            } else {
                map.put(c,1);
            }
        }
        System.out.println(map);
    }



    /**
     *将省份和城市的名称保存在集合中，当用户选择省份以后，二级联动，显示对应省份的地级市供用户选择。
     */
    public void linkage() {
        HashMap<String,String[]> map = new HashMap<>();
        for (int i = 0; i < provinces.length - 1; i++) {
            map.put(provinces[i],new String[]{});
        }

    }

    // 省份数据
    String[] provinces = {
            "北京市", "天津市", "上海市", "重庆市",
            "河北省", "山西省", "内蒙古自治区",
            "辽宁省", "吉林省", "黑龙江省",
            "江苏省", "浙江省", "安徽省", "福建省", "江西省",
            "山东省", "河南省", "湖北省", "湖南省",
            "广东省", "广西壮族自治区", "海南省",
            "四川省", "贵州省", "云南省", "西藏自治区",
            "陕西省", "甘肃省", "青海省", "宁夏回族自治区", "新疆维吾尔自治区"
    };

}
