package com.tao.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/10/21 10:53
 */
public class  DBCPTest {
    public static Connection getConnection3() throws Exception {
        BasicDataSource source = new BasicDataSource();

        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setUsername("root");
        source.setPassword("123456");

        //
        source.setInitialSize(10);

        Connection conn = source.getConnection();
        return conn;
    }

    //使用dbcp数据库连接池的配置文件方式，获取数据库的连接：推荐
    private static DataSource source = null;
    static{
        try {
            Properties pros = new Properties();

            InputStream is = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");

            pros.load(is);
            //根据提供的BasicDataSourceFactory创建对应的DataSource对象
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection4() throws Exception {

        Connection conn = source.getConnection();

        return conn;
    }

}
