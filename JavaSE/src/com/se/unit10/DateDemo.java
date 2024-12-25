package com.se.unit10;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DateDemo
 * @Description:
 * @Author: LTMAX
 * @Date: 2022/11/411:57
 * @Version:
 */
public class DateDemo {
    public static void main(String[] args) {
        String string = new Date().toString();
        System.out.println("date = " + string);

        String sql= "update third_huawei_person set fd_login_name = #{fdLoginName},fd_user_name = #{fdUserName}," +
                    "fd_huawei_org_id = #{fdHuaweiOrgId},fd_modified_time = #{fdModifiedTime},fd_status = #{fdStatus} where fd_id = #{fdId}";
        Map<String, Object> map = new HashMap<>();
        map.put("fdLoginName", "测试");
        map.put("fdUserName", "测试");
        map.put("fdHuaweiOrgId","测试");
        map.put("fd_modified_time", SqlUtils.FormatTime(new Date()));
        map.put("fdStatus","测试");
        map.put("fdId", "1");
        sql = SqlUtils.getSql(sql, map);
        System.out.println(sql);

    }
}
