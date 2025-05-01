package com.tao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author LTMAX
 * @version 1.0
 * @description: TODO
 * @date 2023/10/22 12:21
 */
public class BatchOperation {

    public static void main(String[] args) throws SQLException {
        batchOperation2();
        //batchOperation3();
        //batchOperation4();
    }


    /**
     * 1.0:Statement使用循环
     */
    public static void batchOperation1() throws SQLException {
        long start = System.currentTimeMillis();
        Connection conn = JDBCUtils.getConnection();
        Statement st = conn.createStatement();
        for(int i = 1;i <= 20000;i++){
            String sql = "insert into goods(name) values('name_' + "+ i +")";
            st.executeUpdate(sql);
        }
        JDBCUtils.closeResource(conn, st,null);
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));
    }

    /**
     *2.0：PreparedStatement使用循环
     */
    public static void batchOperation2() throws SQLException {
        long start = System.currentTimeMillis();

        Connection conn = JDBCUtils.getConnection();

        String sql = "insert into goods(name)values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        for(int i = 1;i <= 20000;i++){
            ps.setString(1, "name_" + i);
            ps.executeUpdate();
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));


        JDBCUtils.closeResource(conn, ps,null);
    }

    /**
     * 修改1： 使用 addBatch() / executeBatch() / clearBatch()
     * 修改2：mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
     *          ?rewriteBatchedStatements=true 写在配置文件的url后面
     * 修改3：使用更新的mysql 驱动：mysql-connector-java-5.1.37-bin.jar
     *
     */
    public static void batchOperation3() throws SQLException {
        long start = System.currentTimeMillis();

        Connection conn = JDBCUtils.getConnection();

        String sql = "insert into goods(name)values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        for(int i = 1;i <= 20000;i++){
            ps.setString(1, "name_" + i);

            //1.“攒”sql
            ps.addBatch();
            if(i % 500 == 0){
                //2.执行
                ps.executeBatch();
                //3.清空
                ps.clearBatch();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));
        JDBCUtils.closeResource(conn, ps,null);
    }

    /*
     * 层次四：在层次三的基础上操作
     * 使用Connection 的 setAutoCommit(false)  /  commit()
     */

    public static void batchOperation4() throws SQLException {
        long start = System.currentTimeMillis();

        Connection conn = JDBCUtils.getConnection();

        //1.设置为不自动提交数据
        conn.setAutoCommit(false);

        String sql = "insert into goods(name)values(?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        for(int i = 1;i <= 20000;i++){
            ps.setString(1, "name_" + i);

            //1.“攒”sql
            ps.addBatch();

            if(i % 500 == 0){
                //2.执行
                ps.executeBatch();
                //3.清空
                ps.clearBatch();
            }
        }

        //2.提交数据
        conn.commit();

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));

        JDBCUtils.closeResource(conn, ps,null);
    }

}
