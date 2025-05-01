package com.tao.creational.prototype_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Dog
 * @package: com.tao.creational.prototype_pattern
 * @description: TODO
 * @date 2024/2/18 12:06
 */
public class Dog implements Cloneable{

    private String name;
    private Integer age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
