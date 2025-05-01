package com.se.unit4;

import org.junit.Test;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/10 23:34
 */
public class InnerClass implements Cloneable {

    public String name = "government";

    public static void main(String[] args) {
        Student student = new Student();
        InnerClass innerClass = new InnerClass();
        Person person = innerClass.new Person();

    }

    @Test
    public void test() throws CloneNotSupportedException {
        InnerClass innerClass = new InnerClass();
        InnerClass clone = (InnerClass) innerClass.clone();
        clone.setName("sb");
        System.out.println("innerClass.getName() = " + innerClass.getName());
        System.out.println("clone.getName() = " + clone.getName());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static class Student{
        public Integer id;
    }

    class Person{
        String name = "小明";
        public void eat(){
        }

        //非静态成员内部类
        class Bird{
            String name = "杜鹃";
            public void display(String name){
                System.out.println(name);//方法的形参
                System.out.println(this.name);//内部类的属性
                System.out.println(Person.this.name);//外部类的属性
                //Person.this.eat();
            }
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return (InnerClass)super.clone();
    }

}
