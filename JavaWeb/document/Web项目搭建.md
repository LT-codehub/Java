#项目结构
##后端
* lib
* src
    * com...jdbc
    * com...service
    * com...util
##前端
* web
    * WEB-INF
        * web.xml
    * static
        * css
        * js
        * img
    * ...html
##目录结构详解
* lib：项目依赖的jar包
* src：后端项目源码
* jdbc：数据库操作类
* service：业务逻辑处理类
* util：工具类
---
* web：前端页面
* WEB-INF：web.xml配置文件
* static：静态资源文件
* index.html：首页
###lib目录中基本的jar包
数据库驱动包：mysql-connector-java-5.1.45-bin.jar
servlet包：servlet-api.jar
jsp包：jsp-api.jar
jstl包：jstl-1.2.jar
log4j包：log4j-1.2.17.jar