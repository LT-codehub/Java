package com.se.unit9.exer;

import com.tao.demo.util.Tools;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LTMAX
 * @version 1.0
 * @className: ListDemo
 * @package: com.se.unit9.exer
 * @description: TODO
 * @date 2024/1/19 23:57
 */
public class ListDemo {

    public static void main(String[] args) {
        freeSort();

        //ArrayList<Person> people = new ArrayList<>();
        //people.add(new Person(1,"张三",10));
        //people.add(new Person(2,"李四",9));
        //people.get(0).setSortNum(5);
        //System.out.println(people);
    }



    /**
     *更改对象排序实现方法
     *
     */
    private static void freeSort(){
        //获取数据库数据
        List<Person> list = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(new Person(i, Tools.generateRandomName(),10-i+1));
        }

        getList(list);


        Person oldPerson = new Person(8, null, 3);
        Person newPerson = new Person(8, null, 8);
        //1.查询该对象是否存在

        //2.通过排序号重新排序
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.sortNum.compareTo(o2.sortNum);
            }
        });

            //0  1
            //1  5
            //2  2
            //3  3
            //4  4
            //5  6
        getList(list);


        //3.分两种情况，前移或者后移
        Person person = list.get(oldPerson.sortNum - 1);
        person.setSortNum(newPerson.sortNum);
        list.remove(oldPerson.sortNum-1);
        list.add(person.sortNum-1,person);
        //如果数据量不大最简单的方法时重新赋一遍排序号，因为现在list是有序的

        if (list.size()<20){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setSortNum(i+1);
            }
        }else {
            if (oldPerson.sortNum > newPerson.sortNum){
                //3.1.前移
                for (int i = newPerson.sortNum; i <oldPerson.sortNum; i++) {
                    list.get(i).setSortNum(list.get(i).sortNum+1);
                }
            }else {
                //3.2.后移
                for (int i = oldPerson.sortNum-1; i < newPerson.sortNum-1; i++) {
                    list.get(i).setSortNum(list.get(i).sortNum-1);
                }
            }
        }



        getList(list);

    }


        //6.将移动对象排序号设置为新排序号

        //写入数据库
    private static void getList(List<Person> list){
        for (Person person:list){
            System.out.println(person);
        }

        System.out.println("...............分割线..................");
    }
}




class Person{
    Integer id;
    String name;
    //排序号
    Integer sortNum;



    public Person() {
    }

    public Person(Integer id,String name ,Integer sortNum) {
        this.id = id;
        this.name = name;
        this.sortNum = sortNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sortNum=" + sortNum +
                '}';
    }
}
