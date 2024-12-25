package com.tao.creational.prototype_pattern;

import java.io.*;

/**
 * @author LTMAX
 * @version 1.0
 * @className: Person
 * @package: com.tao.creational.prototype_pattern
 * @description: TODO
 * @date 2024/2/18 12:22
 */
public class Person implements Cloneable, Serializable {

    private static final long serialVersionUID = 15615641891615L;

    private String name;
    private int age;
    private Dog dog;
    private  Cat cat;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                ", cat=" + cat +
                '}';
    }


    protected Person deepClone() throws CloneNotSupportedException {
        //使用序列化的方式实现深拷贝
        Person person = null;

        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            person = (Person)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if(bos != null){
                    bos.close();
                }
                if(oos != null){
                    oos.close();
                }
                if(bis != null){
                    bis.close();
                }
                if(ois != null){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return person;
    }

    /**
     * 这种方式实现深拷贝，每个引用类型的成员都需要实现Cloneable接口并重写clone方法，并且在clone方法单独调用
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.setDog((Dog) dog.clone());
        person.setCat((Cat) cat.clone());
        return person;
    }



    public Person(String name, int age, Dog dog, Cat cat) {
        this.name = name;
        this.age = age;
        this.dog = dog;
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
