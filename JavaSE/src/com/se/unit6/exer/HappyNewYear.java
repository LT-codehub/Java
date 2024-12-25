package com.se.unit6.exer;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2024/1/17 0:32
 */
public class HappyNewYear {

    //模拟新年倒计时，每隔1秒输出一个数字，依次输出10,9,8......1，最后输出：新年快乐！
    public static void main(String[] args) {
        int i = 10;
        while (i >= 1) {
            System.out.println(i);
            i--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("新年快乐！");
    }
}
