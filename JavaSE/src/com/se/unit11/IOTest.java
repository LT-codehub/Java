package com.se.unit11;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author LTMAX
 * @version 1.0
 * @className: IOTest
 * @package: com.se.unit11
 * @description: IO流
 * @date 2024/1/21 21:46
 */
public class IOTest {
    /**
     *字节流：
     *  字节输入流：以字节的形式读取数据
     *  字节输出流：以字节的形式写入数据
     */
    @Test
    public void test1(){
        try (FileInputStream stream = new FileInputStream("src/com/se/unit11/file.txt")) {
            int data;
            byte[] bytes = new byte[1024];
            // 读取数据
            while ((data = stream.read(bytes)) != -1) {
                System.out.println(new String(bytes,0,data, Charset.defaultCharset()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *字符流
     */

    /**
     *缓冲流
     */

    /**
     *转换流
     */

    /**
     *对象流
     */



}