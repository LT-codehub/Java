package com.tao.decorator_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Chocolate
 * @package: com.tao.decorator_pattern
 * @description: TODO
 * @date 2024/2/18 21:17
 */
public class Chocolate extends Decorator{

   public Chocolate(Drink obj) {
        super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0);
    }

}
