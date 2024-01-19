package com.se.unit7;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/16 15:38
 */
public class TimeAPI {
    @Test
    public void test(){
        // now()/now(ZoneId zone)： 静态方法，根据当前时间创建对象 / 指定时区的对象
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("LocalDateTime的默认输出 = " + dateTime);
        LocalDate date = LocalDate.now();
        System.out.println("LocalDate的默认输出 = " + date);
        LocalTime time = LocalTime.now();
        System.out.println("LocalTime的默认输出 = " + time);
        // of()： 静态方法，根据指定日期 / 时间创建对象
        LocalDateTime of = LocalDateTime.of(2023, 12, 12, 19, 50);
        System.out.println("of = " + of);
        // getDayOfMonth()/getDayOfYear() ：获得月份天数(1-31) / 获得年份天数(1-366)
        int dayOfMonth = dateTime.getDayOfMonth();
        int dayOfYear = dateTime.getDayOfYear();
        System.out.println("今天是本年的第 " + dayOfYear+"天");
        System.out.println("今天是本月的第 "  + dayOfMonth+"天");
        // getDayOfWeek() ：获得星期几(返回一个 DayOfWeek 枚举值)
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        // getMonth()： 获得月份, 返回一个 Month 枚举值
        // getMonthValue()/getYear()： 获得月份(1-12) / 获得年份
        // getHour()/getMinute()/getSecond() ：获得当前对象对应的小时、分钟、秒
        // withDayOfMonth()/withDayOfYear()/ withMonth()/withYear() ：将月份天数、年份天数、月份、年份修改为指定的值并返回新的对象
        // plusDays()/plusWeeks()/plusMonths()/ plusYears()/plusHours() ：向当前对象添加几天、几周、几个月、几年、几小时
        // minusMonths()/minusWeeks()/minusDays()/minusYears()/minusHours()： 从当前对象减去几月、几周、几天、几年、几小时
    }

    @Test
    public void test2(){
        //测试Instant
        //now()静态方法，返回本地默认UTC时区的Instant类的对象
        Instant instant = Instant.now();
        //常用方法
        System.out.println("instant = " + instant);
        //1.ofEpochMilli(long epochMilli)
        //静态方法，返回在1970-01-01 00:00:00基础上加上指定毫秒数之后的Instant类的对象
        //2.atOffset(ZoneOffset offset)
        //结合即时的偏移来创建一个 OffsetDateTime
        //3. toEpochMilli()
        //返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳
        instant.atOffset(ZoneOffset.ofHours(8));
        //中国大陆、中国香港、中国澳门、中国台湾、蒙古国、新加坡、马来西亚、菲律宾、西澳大利亚州的时间与UTC的时差均为+8，也就是UTC+8(东八区)。
        System.out.println(instant);

    }

    @Test
    public  void test3(){
        //日期时间格式化：
        //1.ofPattern(String pattern)
        //静态方法，返回一个指定字符串格式的DateTimeFormatter
        //2.format(TemporalAccessor t)
        //格式化一个日期、时间，返回字符串
        //3.parse(CharSequence text)
        //将指定格式的字符序列解析为一个日期、时间

        //测试DateTimeFormatter
        //常用方法
        System.out.println(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(LocalDateTime.now()));
        formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH点mm分ss秒");
        System.out.println(formatter.format(LocalDateTime.now()));
    }
}
