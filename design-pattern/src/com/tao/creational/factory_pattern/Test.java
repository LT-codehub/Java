package com.tao.creational.factory_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Test
 * @package: com.tao.creational.factory_pattern
 * @description: TODO
 * @date 2024/2/17 19:55
 */
public class Test {
    public static void main(String[] args) {
        Food pizza = SimpleFactory.createOperate("pizza");
        pizza.printName("");
    }
}
