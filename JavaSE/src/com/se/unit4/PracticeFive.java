package com.se.unit4;

import java.util.Objects;

/**
 * 本章练习
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/9 8:12
 */
public class PracticeFive {
    public static void main(String[] args) {
    }


    /**
     * 人类
     */
    static class BasePerson{
        private Long id;
        private Long age;
        private String name;
        private String gender;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getAge() {
            return age;
        }

        public void setAge(Long age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BasePerson that = (BasePerson) o;
            return Objects.equals(id, that.id) && Objects.equals(age, that.age) && Objects.equals(name, that.name) && Objects.equals(gender, that.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, age, name, gender);
        }
    }

    /**
     *编写一个Student类，包含name、gender、age、id、score属性，分别为String、String、int、int、double类型。
     * 类中声明一个say方法，返回String类型，方法返回信息中包含所有属性值。
     * 在另一个StudentTest类中的main方法中，创建Student对象，并访问say方法和所有属性，并将调用结果打印输出。
     */

    static class Student extends BasePerson{

        public Student() {
        }

        private static final Student STUDENT = new Student();

        private Double score;

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        public static Student getInstance() {
            return STUDENT;
        }

    }

    /**
     *定义一个丈夫Husband类，有姓名、年龄、妻子属性
     * 定义一个妻子Wife类，有姓名、年龄、丈夫属性
     * 丈夫类中有一个getInfo方法，其中，能显示自己的姓名，年龄，和他的妻子的姓名，年龄
     * 妻子类中有一个getInfo方法，其中，能显示自己的姓名，年龄，和她的丈夫的姓名，年龄
     * 定义一个测试类，创建妻子和丈夫对象，然后测试
     */

    static class Husband extends BasePerson{
        private Wife wife;

        public Wife getWife() {
            if (wife == null) {
                wife = new Wife();
            }
            return wife;
        }

    }

    static class Wife extends BasePerson{
        private Husband husband;

        public Husband getHusband() {
            if (husband == null) {
                husband = new Husband();
            }
            return husband;
        }
    }


}
