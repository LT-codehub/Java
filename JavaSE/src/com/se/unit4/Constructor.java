package com.se.unit4;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2024/1/15 0:18
 */
public class Constructor {

    int a;
    static int b;
    int c = 4;

    {
        int s = 10;
    }


    public Constructor() {
        System.out.println("默认构造函数");
    }

    public Constructor(int num) {
        System.out.println("带参构造函数，参数为：" + num);
    }

    public static void main(String[] args) {
        Constructor constructor = new Constructor(10);
        Inner inner = new Inner();
    }


    static class Inner {

        private int d;

        {
            int x;
            System.out.println("内部类的初始化块");
        }

        public Inner() {

            d = 6;
            System.out.println("内部类的构造函数");
        }

        private void aVoid(){
            this.aVoid();

        }
    }
    class a extends Inner{
        public a() {
        }
    }
}
