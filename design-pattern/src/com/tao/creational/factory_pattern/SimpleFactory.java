package com.tao.creational.factory_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: SimpleFactory
 * @package: com.tao.creational.factory_pattern
 * @description: TODO
 * @date 2024/2/17 21:46
 */
public class SimpleFactory {
    public SimpleFactory() {
    }

    public static Food createOperate(String foodName) {
        switch (foodName.toLowerCase()){
            case "apple":
                return new Apple();
            case "banana":
                return new Banana();
            case "pizza":
                return new Pizza();
            default:
                return null;
        }
    }
}
