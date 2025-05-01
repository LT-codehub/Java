package com.tao.decorator_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Soy
 * @package: com.tao.decorator_pattern
 * @description: TODO
 * @date 2024/2/18 21:25
 */
public class Soy extends Decorator {

    public Soy(Drink drink) {
        super(drink);
        setDes("豆浆");
        setPrice(1.5);
    }
}
