package com.tao.creational.factory_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Banana
 * @package: com.tao.creational.factory_pattern
 * @description: TODO
 * @date 2024/2/17 21:53
 */
public class Banana implements Food {
    @Override
    public void printName(String foodName) {
        System.out.println("这是香蕉" );
    }
}
