package com.se.unit7.exer;

import java.util.Calendar;

/**
 * @author LTMAX
 * @version 1.0
 * @className: DateDemo
 * @package: com.se.unit7.exer
 * @description: TODO
 * @date 2024/1/18 21:15
 */
public class DateDemo {

    static Calendar c = Calendar.getInstance();

    public static void main(String[] args) {
        System.out.println(c.getTime().toString());
    }


    /**
     *输入年份和月份，输出该月日历。
     * 闰年计算公式：年份可以被4整除但不能被100整除，或者可以被400整除
     */
    public static void printCalendar(int year, int month) {
        //星期几的算法

        //初始化每个月的天数
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            daysOfMonth[1]+=1;
        }
    }

    /**
     *计算今天是周几
     */
    public static int calculateDayOfWeek(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }

        int K = year % 100;
        int J = year / 100;

        int h = (day + (13 * (month + 1)) / 5 + K + K / 4 + J / 4 - 2 * J) % 7;

        // Adjust the result to be in the range 0 to 6
        h = (h + 5) % 7;

        return h;
    }

}
