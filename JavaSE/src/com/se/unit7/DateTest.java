package com.se.unit7;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/15 20:58
 */
public class DateTest {
    @Test
    public void test(){
        Date date = new Date();
        System.out.println("date = " + date);
        System.out.println("date = " + date.getTime());
        System.out.println("date = " + date.toString());
    }
    @Test
    public void test1(){
        Date date = new java.sql.Date(System.currentTimeMillis());
        System.out.println("date = " + date);
        System.out.println("date = " + date.getTime());
        System.out.println("date = " + date.toString());
    }
    @Test
    public void test2(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println("format = " + format);
    }

    @Test
    public void test3(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        String format = sdf.format(date);
        String format1 = sdf1.format(date);
        System.out.println("format = " + format);
        System.out.println("format1 = " + format1);
    }
    @Test
    public void test4() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date parse = sdf.parse("2025年09月15日 09:23:53");
        Date parse1 = sdf1.parse("2024-09-15 09:23:53");
        System.out.println("parse.getTime() = " + parse.getTime());
        System.out.println("parse1.getTime() = " + parse1.getTime());
    }
    @Test
    public void test5() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar calendar = new GregorianCalendar();
        Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.YEAR);
        calendar.set(Calendar.DAY_OF_MONTH, 8);
        System.out.println("当前时间日设置为8后,时间是:" + sdf.format(calendar.getTime()));
        calendar.add(Calendar.HOUR, 2);
        System.out.println("当前时间加2小时后,时间是:" + sdf.format(calendar.getTime()));
        calendar.add(Calendar.MONTH, -2);
        System.out.println("当前日期减2个月后,时间是:" + sdf.format(calendar.getTime()));

    }
}
