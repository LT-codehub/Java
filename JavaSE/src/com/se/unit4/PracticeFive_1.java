package com.se.unit4;

import org.junit.Test;

import java.util.Arrays;

/**
 * 本章练习
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/9 8:12
 */
public class PracticeFive_1 {
    public static void main(String[] args) {
        show(0);
        show(1);
    }
    public static void show(int i){
            switch(i){
                default:
                    i+=2;
                case 1:
                    i+=1;
                case 4:
                    i+=8;
                case 2:
                    i+=4;
            }
            System.out.println("i="+i);
        }

    int i ;
    void change(int i){
        i++;
        System.out.println(i);
    }
    void change1(PracticeFive_1 t){
        t.i++;
        System.out.println(t.i);
    }
    class Value{
        int i = 15;
    }
    class Test1{

        public void first() {
            int i = 5;
            Value v = new Value();
            v.i = 25;
            second(v, i);
            System.out.println(v.i);
        }

        public void second(Value v, int i) {
            i = 0;
            v.i = 20;
            Value val = new Value();
            v = val;
            System.out.print(v.i + " " + i);
        }

    }

    static class Test2 {
        int x= 12;
        public void method(int x) {
            x+=x;
            System.out.println(x);
        }
    }



    @Test
    public void test(){
        PracticeFive_1 ta = new PracticeFive_1();
        System.out.println(ta.i); //0
        ta.change(ta.i);//1
        System.out.println(ta.i); //0
        ta.change1(ta);  //1
        System.out.println(ta.i);//1
    }
    @Test
    public void test1(){
        Test1 t = new Test1();
        t.first();

    }

    @Test
    public void test2(){
        Test2 test2 = new Test2();
        test2.method(5);
    }

    @Test
    public void test3(){
        Integer[] integers = {3,2,5,1,7};
        sort(integers);
        System.out.println("Arrays.toString(integers) = " + Arrays.toString(integers));

    }

    public static void sort(Integer[] integers){
        for (int i = 0; i <integers.length-1; i++) {
            for (int j = i+1; j < integers.length; j++) {
                if (integers[i] > integers[j]) {
                    integers[i] = integers[i] ^ integers[j];
                    integers[j] = integers[i] ^ integers[j];
                    integers[i] = integers[i] ^ integers[j];
                }
            }
        }
    }




}
