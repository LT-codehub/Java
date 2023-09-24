package com.se.unit4;

/**
 * @ClassName: ParameterPassing
 * @Description: 参数传递：JAVA中的参数传递是值传递，因为基本数据库类型和引用数据类型保存的数据不同，基本数据类型中保存的是我们需要的真实值/引用数据类型中保存的是真实值的引用(当我们使用引用数据类型时实际使用的是其指向的真实值)
 * @Author: LTMAX
 * @Date: 2022/9/2721:45
 * @Version:
 */
public class ParameterPassing {
    public static void main(String[] args) {
        System.out.println("      不同数据类型的传递");
        System.out.println("----------------------------");
        System.out.println("基本数据类型的传递");

        int Source = 1;
        System.out.println("原值为-------》"+Source);
        Value(Source);
        System.out.println("处理过后的值为-------》"+Source);

        System.out.println("引用类型的传递");
        Integer source = 1;
        System.out.println("原值为-------》"+source);
        Quote(source);
        System.out.println("处理过后的值为-------》"+source);


    }

    public static void Value(int curr){
        curr+=Math.random()*10;
        System.out.println("传递进来的值-------》" + curr);

    }
    public static void Quote(Integer curr){
        curr+=(int)(Math.random()*10);
        System.out.println("传递进来的值-------》" + curr);

    }


}
