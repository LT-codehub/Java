package com.tao.decorator_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Milk
 * @package: com.tao.decorator_pattern
 * @description: TODO
 * @date 2024/2/18 21:24
 */
public class Milk extends Decorator {
   public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2.0);
    }
}
