package com.tao.decorator_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Decorator
 * @package: com.tao.decorator_pattern
 * @description: TODO
 * @date 2024/2/18 21:18
 */
public class Decorator extends Drink{
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }


    @Override
    public double cost() {
        return super.getPrice()+ drink.cost();
    }

    @Override
    public String getDes() {
        return des +""+getPrice()+"&&"+drink.getDes();
    }
}
