package com.tao.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author LTMAX
 * @version 1.0
 * @description: JDBC最佳实践-mysql
 * @date 2023/10/21 5:44
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件中的4个基本信息
        InputStream is = JDBCDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //默认的读取路径在src下

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);

    }

    @Test
    public void test() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();

        //数据库连接
        //jdbc：mysql -协议
        //localhost -IP地址
        //3306 -端口号
        //test -数据库名
        String url = "jdbc:mysql://localhost:3306/test";

        //配置文件：用户名-密码 key-value
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }

    //迭代的原因：源代码中不出现在不出现第三方的api,使得程序具有更好的可移植性
    @Test
    public void testConnection2() throws Exception {
        // 1.获取Driver实现类对象：使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";

        // 3.提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        // 4.获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);

    }

    @Test
    public void testConnection3() throws Exception {
        // 1.获取Driver实现类的对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供另外三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    @Test
    public void testConnection4() throws Exception {
        // 1.提供三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "123456";

        // 2.加载Driver
        Class.forName("com.mysql.jdbc.Driver");
        //相较于方式三，可以省略如下的操作：
//		Driver driver = (Driver) clazz.newInstance();
//		// 注册驱动
//		DriverManager.registerDriver(driver);
        //为什么可以省略上述操作呢？
        //在代码中声明的静态代码块中已经注册过了驱动
		/*
		 * 在mysql的Driver实现类中，声明了如下的操作：
		 * static {
				try {
					java.sql.DriverManager.registerDriver(new Driver());
				} catch (SQLException E) {
					throw new RuntimeException("Can't register driver!");
				}
			}
		 */

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

    /**
     * 此种方式的好处？
     * 1.实现了数据与代码的分离。实现了解耦
     * 2.如果需要修改配置文件信息，可以避免程序重新打包。
     */
    @Test
    public void getConnection5() throws Exception{

        //1.读取配置文件中的4个基本信息
        InputStream is = JDBCDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
        //默认的读取路径在src下

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("jdbc.username");
        String password = pros.getProperty("jdbc.password");
        String url = pros.getProperty("jdbc.url");
        String driverClass = pros.getProperty("jdbc.driver");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);


    }


}
