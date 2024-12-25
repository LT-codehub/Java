package com.tao.creational.factory_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Pizza
 * @package: com.tao.creational.factory_pattern
 * @description: TODO
 * @date 2024/2/17 21:48
 */
public class Pizza implements Food{

    @Override
    public void printName(String foodName) {
        System.out.println("这是披萨");
    }
}
