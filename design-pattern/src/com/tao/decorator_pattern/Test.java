package com.tao.decorator_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Test
 * @package: com.tao.decorator_pattern
 * @description: TODO
 * @date 2024/2/18 21:26
 */
public class Test {
    public static void main(String[] args) {
        //生成一个被装饰者对象
        Drink drink = new LongBlack();
        System.out.println("drink.cost() = " + drink.cost());
        System.out.println("drink.getDes() = " + drink.getDes());
        //将被装饰者对象，赋给装饰者对象，装饰者对象持有被装饰者，即完成装饰
        Drink dec = new Milk(drink);
        System.out.println("dec.cost() = " + dec.cost());
        System.out.println("dec.getDes() = " + dec.getDes());
        //上面返回的是装饰者对象但是因为它和被装饰者对象有相同的接口，所以可以看做一个新的被装饰者
        //既然是一个被装饰者对象，那么就可以继续装饰
        Drink dec2 = new Chocolate(dec);
        System.out.println("dec2.cost() = " + dec2.cost());
        System.out.println("dec2.getDes() = " + dec2.getDes());
        //和上面同理
        //被装饰者对象，赋给装饰者对象，装饰者对象持有被装饰者，即完成装饰
        Drink dec3 = new Chocolate(dec2);
        System.out.println("dec3.cost() = " + dec3.cost());
        System.out.println("dec3.getDes() = " + dec3.getDes());

        //装饰器模式通过对装饰器的扩展完成了对被装饰者功能的扩展
    }
}
