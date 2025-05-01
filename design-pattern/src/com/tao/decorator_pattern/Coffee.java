package com.tao.decorator_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Coffee
 * @package: com.tao.decorator_pattern
 * @description: TODO
 * @date 2024/2/18 21:13
 */
public class Coffee extends Drink{

    @Override
    public double cost() {
        return getPrice();
    }
}
