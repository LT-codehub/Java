package com.tao.creational.prototype_pattern;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Test
 * @package: com.tao.creational.prototype_pattern
 * @description: TODO
 * @date 2024/2/18 12:08
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {


        Dog dog = new Dog("老黄", 1);
        System.out.println(dog.toString());

        Dog dog1 = (Dog)dog.clone();
        dog1.setAge(4);
        System.out.println(dog1.toString());
        System.out.println(dog.toString());

        Dog dog2 = (Dog)dog.clone();
        System.out.println(dog2.toString());


        Person person = new Person("张三", 1, dog, new Cat("小黄"));
        System.out.println(person.toString());

        Person person1 = (Person)person.clone();
        System.out.println(person1.toString());
        person1.getDog().setName("小黑");
        System.out.println(person1.toString());
        System.out.println(person.toString());


    }

}
