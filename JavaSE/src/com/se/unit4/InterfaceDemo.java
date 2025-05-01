package com.se.unit4;

/**
 * 接口demo
 * @author LTMAX
 * @date 2023/9/13 12:36
 * @description: TODO
 */
public interface InterfaceDemo {

    /**
     * 默认是：public static final的
     */
    String TEST = "global constant";

    /**
     * 测试方法，默认是： private abstract的
     * @return String
     */
    String get();

    /**
     * 默认方法
     */
     static void defaultMethod(){
        System.out.println("jdk8中，接口可以包含实现方法，需要使用default修饰，此类方法称为默认方法");
    }
}
