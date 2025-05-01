package com.se.unit7;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author LTMAX
 * @version 1.0
 * @className: TimeToDate
 * @package: com.se.unit7
 * @description: 日期类之间的转换
 * @date 2024/1/18 21:46
 */
public class TimeToDate {
    public static void main(String[] args) {

    }

    /**
     * Date类之间的互转
     */
    @Test
    public void test() {
        // 创建一个java.sql.Date对象
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
        System.out.println("sqlDate: " + sqlDate);

        // 创建一个java.util.Date对象
        java.util.Date utilDate = new java.util.Date();
        System.out.println("utilDate: " + utilDate);

        // 将java.sql.Date对象转换为java.util.Date对象
        java.util.Date utilDateFromSql = new Date(sqlDate.getTime());
        System.out.println("utilDateFromSql: " + utilDateFromSql);

        // 将java.util.Date对象转换为java.sql.Date对象
        java.sql.Date sqlDateFromUtil = new java.sql.Date(utilDate.getTime());
        System.out.println("sqlDateFromUtil: " + sqlDateFromUtil);
    }

    /**
     * Date类与java.time.LocalDate类之间的互转
     * java.time.Instant与java.util.Date
     * Date.from(instant)
     * date.toInstant()
     */
    @Test
    public void test2() {
        // 创建一个java.time.LocalDate对象
        java.time.LocalDate localDate = java.time.LocalDate.now();
        System.out.println("localDate: " + localDate);

        //通过Instant实现互转
        //将java.time.LocalDate对象转换为java.util.Date对象
        java.util.Date utilDate = java.util.Date.from(localDate.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
        System.out.println("utilDate: " + utilDate);

        //将java.util.Date对象转换为java.time.LocalDate对象
        java.time.LocalDate localDateFromUtil = java.time.LocalDate.from(utilDate.toInstant());
        System.out.println("localDateFromUtil: " + localDateFromUtil);


    }
}
