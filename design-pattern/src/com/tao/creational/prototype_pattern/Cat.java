package com.tao.creational.prototype_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Cat
 * @package: com.tao.creational.prototype_pattern
 * @description: TODO
 * @date 2024/2/18 18:41
 */
public class Cat implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
