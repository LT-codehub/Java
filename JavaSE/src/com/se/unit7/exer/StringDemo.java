package com.se.unit7.exer;

/**
 * @author LTMAX
 * @version 1.0
 * @className: StringDemo
 * @package: com.se.unit7.exer
 * @description: TODO
 * @date 2024/1/18 19:14
 */
public class StringDemo {
    //算法练习：

    //题目1：模拟一个trim方法，去除字符串两端的空格。
    private static String myTrim(String str) {
        //1.定义两个索引，分别指向字符串的第一个字符和最后一个字符

        int start = 0;
        int end = str.length() - 1;
        //2.遍历字符串，找到第一个非空格字符，记录其索引
        while (str.charAt(start) == ' ') {
            start++;
        }
        while (str.charAt(end) == ' ') {
            end--;
        }
        return str.substring(start, end + 1);
    }

    //题目2：将一个字符串进行反转。将字符串中指定部分进行反转。
    //比如"abcdefg"反转为"abfedcg"
    private static String reverse(String str, int start, int end) {

        char[] chars = str.toCharArray();
        for (int i = start-1; i < end-1; i++) {
            chars[i]^=chars[end-1];
            chars[end-1]^=chars[i];
            chars[i]^=chars[end-1];
            end--;
        }
        return new String(chars);
    }

    //题目3：获取一个字符串在另一个字符串中出现的次数。
    //比如：获取"ab"在 "abkkcadkabkebfkabkskab" 中出现的次数


    //题目4：获取两个字符串中最大相同子串。比如：
    //str1 = "abcwerthelloyuiodef";
    //str2 = "cvhellobnm"
    //提示：将短的那个串进行长度依次递减的子串与较长的串比较。

    //题目5：对字符串中字符进行自然顺序排序。
    //提示：
    //        1）字符串变成字符数组。
    //        2）对数组排序，选择，冒泡，Arrays.sort();
    //  3）将排序后的数组变成字符串。

    public static void main(String[] args) {
        System.out.println(myTrim("      dsadsadsadsad        "));
        System.out.println(reverse("abecdfg",3,6));
    }
}
