package com.se.unit7;

/**
 * @author LTMAX
 * @version 1.0
 * @className: SystemTest
 * @package: com.se.unit7
 * @description: TODO
 * @date 2024/1/18 22:04
 */
public class SystemTest {

    /**
     *java.version------Java运行时环境版本
     * java.home-----------Java安装目录
     * os.name------------ 操作系统的名称
     * os.version---------操作系统的版本
     * user.name----------用户的账户名称
     * user.home-----------用户的主目录
     * user.dir----------用户的当前工作目录
     */
    public static void main(String[] args) {
        //输出
        System.out.println("java.version------Java运行时环境版本");
        System.out.println(System.getProperty("java.version"));
        System.out.println("java.home-----------Java安装目录");
        System.out.println(System.getProperty("java.home"));
        System.out.println("os.name------------ 操作系统的名称");
        System.out.println(System.getProperty("os.name"));
        System.out.println("os.version---------操作系统的版本");
        System.out.println(System.getProperty("os.version"));
        System.out.println("user.name----------用户的账户名称");
        System.out.println(System.getProperty("user.name"));
        System.out.println("user.home-----------用户的主目录");
        System.out.println(System.getProperty("user.home"));
        System.out.println("user.dir----------用户的当前工作目录");
        System.out.println(System.getProperty("user.dir"));
    }
}
