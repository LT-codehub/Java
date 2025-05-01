package com.se.unit10;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: SqlUtils
 * @Description:
 * @Author: LTMAX
 * @Date: 2022/11/412:13
 * @Version:
 */
public  class SqlUtils{

    /**   \\s是\s，因为java里需要转义：匹配任何空白字符，包括空格、制表符、换页符等等
     *   *：匹配前面的子表达式零次或多次
     *   |：或者
     *   {0,1}：有0个或者1个
     *   \"是"，java需要转义：匹配单引号
     *   \\{和\\}：分别是{和}，2个斜杠是转义符
     *   [a-z_A-Z.0-9]：匹配大/小写的字符、还可以包含0-9的数字和“.”【一般用于多表联查时，如A1.name等】
     *   [|%']：匹配“|”、“%”、“'”【一般用于like的参数时，如name like '%'||#{name}||'%'等】
     *   [a-zA-Z]：匹配大/小写开头的字符都可以
     *   [a-z_A-Z]：匹配字符，中间可有“_”下划线
     **/
    private static  String rgex = "\\s*(where|and|or|WHERE|AND|OR){0,1}\\s*\"{0,1}([a-z_A-Z.0-9])+\"{0,1}\\s*(=|>=|<=|>|!=|<|like)\\s*[|%']*#\\{\\s*([a-z_A-Z])+\\s*\\}[|%']*";

    private static  String rge = "#\\{\\s*([a-z_A-Z])+\\s*\\}";


    public static String getSql(String sql, Map<String, Object> map) {
        StringBuffer rsql = new StringBuffer(); //接口对应的sql
        Pattern p= Pattern.compile(rgex); //把规则编译成模式对象
        Matcher m=p.matcher(sql); //通过模式对象得到匹配器对象,进行匹配
        boolean flag=false;
        int index=0;
        int length=sql.length();
        while(m.find()) {//find():查找有没有满足条件的字符串
            int start=m.start(); //满足条件的字符串，开始的位置（下标）
            if(index<start) {
                rsql.append(sql.substring(index,start));
            }
            String text=m.group(); //获取值/字符串
            System.out.println("****************************************************\n满足条件的字符串:"+text); //一定要先find()，然后才能group()
            String[] arrey=text.trim().split("\\s+"); //根据空格将每一个字符串进行分割开，并添加到数组中
            for (int i = 0; i < arrey.length; i++) {
                System.out.println("分割后的字符串数组内容:"+arrey[i]);
            }
            System.out.println("map中的参数对应的值："+map.get(arrey[3].substring(arrey[3].indexOf("#{")+2,arrey[3].indexOf("}")).trim()));
            if(map.get(arrey[3].substring(arrey[3].indexOf("#{")+2,arrey[3].indexOf("}")).trim())==null) { //获取参数，且判断参数有传非空值进来
                if(arrey[0].indexOf("WHERE")!=-1||arrey[0].indexOf("where")!=-1) {
                    flag=true; //连接条件是where
                }
            }else { //参数没有传值or没有传入该参数
                if(flag) { //第一个满足的条件查询连接词应是where，所以直接拼接where，且查询条件从第二个字符开始拼接
                    System.out.println("查询条件与where拼接"+" WHERE "+arrey[1]+" "+arrey[2]+" "+arrey[3].replace(arrey[3].substring(arrey[3].indexOf("#{"),arrey[3].indexOf("}")+1).trim(),"'"+map.get(arrey[3].substring(arrey[3].indexOf("#{")+2,arrey[3].indexOf("}")).trim()).toString()+"'"));
                    rsql.append(" WHERE "+arrey[1]+" "+arrey[2]+" "+arrey[3].replace(arrey[3].substring(arrey[3].indexOf("#{"),arrey[3].indexOf("}")+1).trim(),"'"+map.get(arrey[3].substring(arrey[3].indexOf("#{")+2,arrey[3].indexOf("}")).trim()).toString()+"'"));
                    flag=false; //where加上后改成false，避免重复拼接导致语法错误
                }else { //直接拼接
                    System.out.println("满足条件的查询条件语句："+text.replace(arrey[3].substring(arrey[3].indexOf("#{"),arrey[3].indexOf("}")+1).trim(),"'"+map.get(arrey[3].substring(arrey[3].indexOf("#{")+2,arrey[3].indexOf("}")).trim()).toString()+"'"));
                    rsql.append(text.replace(arrey[3].substring(arrey[3].indexOf("#{"),arrey[3].indexOf("}")+1).trim(),"'"+map.get(arrey[3].substring(arrey[3].indexOf("#{")+2,arrey[3].indexOf("}")).trim()).toString()+"'"));
                }
            }
            index=m.end(); //满足条件的结束位置
        };
        if(index<length) { //如果满足条件的下标小于整体的SQL长度，说明存在满足条件查询的字符串，应追加到rsql中
            rsql.append(sql.substring(index,length));
        }
        System.out.println("————————————————————————————————————————————————————————————\n最终的SQL语句："+rsql.toString());
        return rsql.toString();
    }

    public static String FormatTime(Date date){
        DateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

}
