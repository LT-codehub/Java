package com.tao.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author LTMAX
 * @version 1.0
 * @description: 操作BLOB类型的二进制数据(如，图片，音频，视频等)
 * @date 2023/10/22 6:29
 */
public class BLOBDemo {


    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Connection conn = JDBCUtils.getConnection();
        File file = new File("9f89c63aa0092cac657eac34c3fd28ae.png");
        addBlob(conn,file,"insert into blob_test(file_name,file) values(?,?)");
    }

    /**
     *存储文件
     */
    public static void addBlob(Connection conn,File file,String sql) throws SQLException, FileNotFoundException {

        InputStream resourceAsStream = BLOBDemo.class.getClassLoader().getResourceAsStream(file.getPath());
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setObject(1,file.getName());
        statement.setBlob(2,resourceAsStream);
        boolean execute = statement.execute();
        if (!execute){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }

}
