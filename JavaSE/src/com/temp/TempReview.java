package com.temp;

import org.omg.CORBA.INTERNAL;

/**
 * @author LTMAX
 * @version 1.0
 * @className: TempReview
 * @package: com.temp
 * @description: TODO
 * @date 2024/10/24 17:20
 */
public class TempReview {
    public static void main(String[] arg){
        //System.out.println("懒惰小李写代码");
        DateType dateType = new DateType();
        System.out.println(dateType.aBoolean);
    }


    /**
     * 变量的基本类型
     */
    static class DateType{
        //基本数据类型
        //1.整形
        public byte aByte;
        public short aShort;
        public int anInt;
        public long aLong;
        //2.浮点型
        public float aFloat;
        public double aDouble;
        //3.布尔型
        public boolean aBoolean;
        //4.字符型
        public char aChar;


        //引用数据类型
        //类
        //接口
        //枚举(特殊定制化的类)
        //注解
        //记录
    }
}
