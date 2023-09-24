package com.se.unit2;

import java.util.List;

/**
 *
 * @author LTMAX
 * @version 1.0
 * @description: 数据类型展示
 * @date 2023/9/21 17:20
 */
public class DataType {

    public int anInt;
    private short aShort;
    private long aLong;
    private boolean aBoolean;
    private float aFloat;
    private double aDouble;
    private byte aByte;
    private char aChar;

    private String string;
    private List list;
    private int[] array;



    public static void main(String[] args) {
        //输出
        System.out.println(DataType.getMaxAndMin());
        //调用
        DataType dataType = new DataType();
        dataType.getDefaultValue();

        //输出ascii码表
        dataType.getASCII();
    }

    /**
     * 一个可以输出所有基本数据类型最大值和最小值的方法
     * @return
     */
    public static String getMaxAndMin(){
        return "int的最大值 = " + Integer.MAX_VALUE + "\n" +
                "int的最小值 = " + Integer.MIN_VALUE + "\n" +
                "short的最大值 = " + Short.MAX_VALUE + "\n" +
                "short的最小值 = " + Short.MIN_VALUE + "\n" +
                "long的最大值 = " + Long.MAX_VALUE + "\n" +
                "long的最小值 = " + Long.MIN_VALUE + "\n" +
                "float的最大值 = " + Float.MAX_VALUE + "\n" +
                "float的最小值 = " + Float.MIN_VALUE + "\n" +
                "double的最大值 = " + Double.MAX_VALUE + "\n" +
                "double的最小值 = " + Double.MIN_VALUE + "\n" +
                "----------------------------------------------------------------------------------------------------";
    }

    /**
     * 一个可以输出类当前对象成员变量默认值的方法
     */
    private void getDefaultValue(){
        System.out.println("----------------------------------------------------------------------------------------------------");
        //输出数据类型默认值
        System.out.println("int的默认值 = " + anInt);
        System.out.println("short的默认值 = " + aShort);
        System.out.println("long的默认值 = " + aLong);
        System.out.println("boolean的默认值 = " + aBoolean);
        System.out.println("float的默认值 = " + aFloat);
        System.out.println("double的默认值 = " + aDouble);
        System.out.println("byte的默认值 = " + aByte);
        System.out.println("char的默认值 = " + aChar);
        System.out.println("string的默认值 = " + string);
        System.out.println("list接口的默认值 = " + list);
        System.out.println("array数组的默认值 = " + array);
        System.out.println("----------------------------------------------------------------------------------------------------");
        //char的默认值是'\u0000'，但是因为某些原因Unicode编码中，码值在20以下的值无法显示
        System.out.println("char的默认值 = " + aChar + "(" + (int)aChar + ")");
    }

    //输出一张ASCII码表
    private void getASCII() {
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (int i = 0; i < 128; i++) {
            System.out.println((char) i + " = " + (int) i);
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    /**
     * Java二进制探索
     */
    private void twoComplement() {

        System.out.println("Integer.bitCount(-126) = " + Integer.bitCount(-126));
        System.out.println("Integer.bitCount(128) = " + Long.bitCount(-1));
        System.out.println("Integer.bitCount(128) = " + Integer.bitCount(-127));

    }

}
