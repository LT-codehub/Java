package com.tao.jdbc;

import java.sql.*;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/10/21 11:58
 */
public class JDBCUtils {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            //1.数据库连接的4个基本要素：
            String url = "jdbc:mysql://localhost:3306/test";
            String user = "root";
            String password = "123456";
            String driverName = "com.mysql.jdbc.Driver";

            //2.加载驱动 （①实例化Driver ②注册驱动）
            Class.forName(driverName);


            //Driver driver = (Driver) clazz.newInstance();
            //3.注册驱动
            //DriverManager.registerDriver(driver);
            /*
            可以注释掉上述代码的原因，是因为在mysql的Driver类中声明有：
            static {
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }

             */


            //3.获取连接
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;

    }

    /**
     * 关闭数据库资源
     * @param conn
     * @param ps
     * @date 2023/10/21 11:58
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if (rs != null) {
            try {
                rs.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}
