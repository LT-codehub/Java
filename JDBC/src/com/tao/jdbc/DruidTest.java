package com.tao.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/10/23 8:13
 */
public class DruidTest {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        pro.load(DruidTest.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
