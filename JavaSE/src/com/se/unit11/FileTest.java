package com.se.unit11;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author LTMAX
 * @version 1.0
 * @className: FileTest
 * @package: com.se.unit11
 * @description: File文件
 * @date 2024/1/21 22:18
 */
public class FileTest {
    /**
     * 文件类File是java.io.File类的对象，表示文件和目录，File类中涉及到关于文件或目录的属性，
     * # 常用方法
     * ## 获取
     * * `public String getAbsolutePath()`：获取绝对路径
     * * `public String getPath()`：获取路径
     * * `public String getName()`：获取名称
     * * `public String getParent()`：获取上层文件目录路径。若无，返回null
     * * `public long length()`：获取文件长度（即：字节数）。不能获取目录的长度。
     * * `public long lastModified()`：获取最后一次的修改时间，毫秒值
     * * `public String[] list()`：获取指定目录下的所有文件或者文件目录的名称数组
     * * `public File[] listFiles()`：获取指定目录下的所有文件或者文件目录的File数组
     * ## 修改
     * * `public boolean renameTo(File dest)`：把文件重命名为指定的文件路径
     * ## 判断
     * * `public boolean isDirectory()`：判断是否是文件目录
     * * `public boolean isFile()`：判断是否是文件
     * * `public boolean exists()`：判断是否存在
     * * `public boolean canRead()`：判断是否可读
     * * `public boolean canWrite()`：判断是否可写
     * * `public boolean isHidden()`：判断是否隐藏
     * ## 创建
     * * `public boolean createNewFile()`：创建文件。若文件存在，则不创建，返回false
     * * `public boolean mkdir()`：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     * * `public boolean mkdirs()`：创建文件目录。如果上层文件目录不存在，一并创建
     *
     * **注意：如果没有写绝对路径，那么会按照相对路径创建(相对路径=本项目目录)**
     * ## 删除
     * * `public boolean delete()`：删除文件或者文件夹
     */

    public  static void main(String[] args) {
        method1();
    }


    private static void method1() {
        // 创建File对象 创建File对象
        // 绝对路径：从盘符开始的路径
        File file = new File("D:\\Git-Space\\Gitee\\Java\\JavaSE\\src\\com\\se\\unit11\\file.txt");
        if (file.exists()&&file.isFile()) {
            System.out.println("file.txt 是一个文件");
        }
        // 相对路径：相对于当前module的路径
        file = new File("JavaSE/src/com/se/unit11/file.txt");
        System.out.println("文件/目录的绝对路径名：" + file.getAbsolutePath());
        if (file.exists()&&file.isFile()) {
            System.out.println("file.txt 是一个文件");
        }




    }
    private void method2() {
        // 文件路径名
        String pathname = "D:\\aaa.txt";
        File file1 = new File(pathname);
        // 文件路径名
        String pathname2 = "D:\\aaa\\bbb.txt";
        File file2 = new File(pathname2);
        // 通过父路径和子路径字符串
        String parent = "d:\\aaa";
        String child = "bbb.txt"; File file3 = new File(parent, child);
        // 通过父级File对象和子路径字符串
        File parentDir = new File("d:\\aaa");
        String childFile = "bbb.txt";
        File file4 = new File(parentDir, childFile);
    }


    @Test
    public void test02()throws IOException {
        File f2 = new File("D:\\Git-Space\\Gitee\\Java\\JavaSE\\src\\com\\se\\unit11\\file.txt");
        //绝对路径，从根路径开始
        System.out.println("文件/目录的名称：" + f2.getName());
        System.out.println("文件/目录的构造路径名：" + f2.getPath());
        System.out.println("文件/目录的绝对路径名：" + f2.getAbsolutePath());
        System.out.println("文件/目录的父目录名：" + f2.getParent()); }



    @Test
    public void test03() throws IOException {
        File f3 = new File("src/com/se/unit11/file.txt");
        if (f3.exists()&&f3.isFile()) {
            System.out.println("file.txt 是一个文件");
        }
        //相对路径
        System.out.println("user.dir =" + System.getProperty("user.dir"));
        System.out.println("文件/目录的名称：" + f3.getName());
        System.out.println("文件/目录的构造路径名：" + f3.getPath());
        System.out.println("文件/目录的绝对路径名：" + f3.getAbsolutePath());
        System.out.println("文件/目录的父目录名：" + f3.getParent()); }

}


