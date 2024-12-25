package com.se.unit5;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/9/14 13:05
 */
public class ExceptionTest {


    public static final String STRING = "运行时异常";

    /**
     *ArithmeticException 除0异常
     */
    @Test
    public void test6(){
        int a = 10;
        int b = 0;
        System.out.println(a / b);
        System.out.println(STRING);
    }


    /**
     *InputMismatchException
     */
    @Test
    public void test5(){
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        System.out.println(score);

        scanner.close();
        System.out.println(STRING);
    }

    /**
     *NumberFormatException
     */

    @Test
    public void test4(){

        String str = "123";
        str = "abc";
        int num = Integer.parseInt(str);
        System.out.println(STRING);

    }

    //ClassCastException
    @Test
    public void test3(){
        Object obj = new Date();
        String str = (String)obj;
        System.out.println(STRING);
    }

    //IndexOutOfBoundsException
    @Test
    public void test2(){
        //ArrayIndexOutOfBoundsException
//		int[] arr = new int[10];
//		System.out.println(arr[10]);
        //StringIndexOutOfBoundsException
        String str = "abc";
        System.out.println(str.charAt(3));
        System.out.println(STRING);
    }

    //NullPointerException
    @Test
    public void test1(){

//		int[] arr = null;
//		System.out.println(arr[3]);

        String str = "abc";
        str = null;
        System.out.println(str.charAt(0));
        System.out.println(STRING);

    }

    @Test
    public void test7() throws IOException {
        File file = new File("hello.txt");
        FileInputStream fis = new FileInputStream(file);


        int data = 0;
        try {
            data = fis.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (data != -1) {
            System.out.print((char) data);
            data = fis.read();
        }

        fis.close();
    }


}
