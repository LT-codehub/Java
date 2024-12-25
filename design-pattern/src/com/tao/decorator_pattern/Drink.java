package com.tao.decorator_pattern;

/**
 * @author LTMAX
 * @date 2024/2/18 21:10
 * @description: TODO
 */
public abstract class Drink {

    public String des;
    private  double price = 0.0;


    public abstract double cost();

    public Drink(String des, double price) {
        this.des = des;
        this.price = price;
    }

    public Drink() {
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
