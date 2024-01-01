package com.tao.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/10/23 7:55
 */
public class C3P0Demo {

    public static void main(String[] args) throws Exception {
        //getConnection1();
        getConnection2();
    }
    //使用C3P0数据库连接池的方式，获取数据库的连接：不推荐
    public static Connection getConnection1() throws Exception{
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3307/test");
        cpds.setUser("root");
        cpds.setPassword("123456");

        cpds.setMaxPoolSize(100);

        Connection conn = cpds.getConnection();
        return conn;
    }

    //使用C3P0数据库连接池的配置文件方式，获取数据库的连接：推荐
    private static DataSource cpds = new ComboPooledDataSource("c3p0-config.xml");
    public static Connection getConnection2() throws SQLException {
        Connection conn = cpds.getConnection();
        return conn;
    }
}
