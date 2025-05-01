# 知识点

### 数据的持久化

数据库

## JDBC

Java Database Connectivity - java数据库连接

**一种独立于特定数据库管理系统、通用的SQL数据库存取和操作的公共接口**

以类的角度就是一组API

### web

B/S  Browser/Server

浏览器/服务器的设计模式

C/S Client/Server

客户端/服务器的设计模式

## 获取JDBC连接

**获取JDBC连接的几种方式**

```
- MySQL的连接URL编写方式：

  - jdbc:mysql://主机名称:mysql服务端口号/数据库名称?参数=值&参数=值
  - jdbc:mysql://localhost:3306/atguigu
  - jdbc:mysql://localhost:3306/atguigu**?useUnicode=true&characterEncoding=utf8
  （如果JDBC程序与服务器端的字符集不一致，会导致乱码，那么可以通过参数指定服务器端的字符集）
  - jdbc:mysql://localhost:3306/atguigu?user=root&password=123456

- Oracle 9i的连接URL编写方式：

  - jdbc:oracle:thin:@主机名称:oracle服务端口号:数据库名称
  - jdbc:oracle:thin:@localhost:1521:atguigu

- SQLServer的连接URL编写方式：

  - jdbc:sqlserver://主机名称:sqlserver服务端口号:DatabaseName=数据库名称
  - jdbc:sqlserver://localhost:1433:DatabaseName=atguigu
```

#### 方式一

```java
com.mysql.jdbc.Driver类获取
connect方法

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
        info.setProperty("password","@ltmysql");
        Connection connect = driver.connect(url, info);

        System.out.println(connect);
    }
```

#### 方式二：对方式一的迭代

```java
迭代的原因：源代码中不出现在不出现第三方的api,使得程序具有更好的可移植性
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
		info.setProperty("password", "@ltmysql");

		// 4.获取连接
		Connection conn = driver.connect(url, info);
		System.out.println(conn);

	}

```

#### 方式三：使用DriverManager替换Driver

```java
@Test
	public void testConnection3() throws Exception {
		// 1.获取Driver实现类的对象
		Class clazz = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();

		// 2.提供另外三个连接的基本信息：
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "@ltmysql";

		// 注册驱动
		DriverManager.registerDriver(driver);

		// 获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
	}
```

#### 方式四：可以只是加载驱动，不用显示的注册驱动过了（mysql连加载驱动都可以省略）

```java
@Test
	public void testConnection4() throws Exception {
		// 1.提供三个连接的基本信息：
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "@ltmysql";
		
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
```

#### 方式五(final版)：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接

```java
/*
	 * 此种方式的好处？
	 * 1.实现了数据与代码的分离。实现了解耦
	 * 2.如果需要修改配置文件信息，可以避免程序重新打包。
	 */
@Test
	public void getConnection5() throws Exception{
		
		//1.读取配置文件中的4个基本信息
		InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
```

```properties
#jdbc配置文件
user=root
password=@ltmysql
url=jdbc:mysql://localhost:3306/test
driverClass=com.mysql.jdbc.Driver
```

## 操作和访问数据库

- Statement：用于执行静态 SQL 语句并返回它所生成结果的对象。 
```java
  // 使用Statement的弊端：需要拼写sql语句，并且存在SQL注入的问题
  	@Test
  	public void testLogin() {
  //		Scanner scan = new Scanner(System.in);
  //
  //		System.out.print("用户名：");
  		String userName = "AA";
  //		System.out.print("密   码：");
  		String password = "654321";
  
  		// SELECT user,password FROM user_table WHERE USER = '1' or ' AND PASSWORD = '
  		// ='1' or '1' = '1';
  		String sql = "SELECT user,password FROM user_table WHERE user = '" + userName + "' AND password = '" + password
  				+ "'";
  		com.jdbc.statement.User user = get(sql, com.jdbc.statement.User.class);
  		if (user != null) {
  			System.out.println("登陆成功!");
  		} else {
  			System.out.println("用户名或密码错误！");
  		}
  	}
  /**	
  	- 使用Statement操作数据表存在弊端：
  
    - **问题一：存在拼串操作，繁琐**
    - **问题二：存在SQL注入问题**
  
  - SQL 注入是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的 SQL 语句段或命令
  (如：SELECT user, password FROM user_table WHERE user='a' OR 1 = ' AND password = ' OR '1' = '1') ，
  从而利用系统的 SQL 引擎完成恶意行为的做法。
  - 对于 Java 而言，要防范 SQL 注入，只要用 PreparedStatement(从Statement扩展而来) 取代 Statement 就可以了。
```
- PrepatedStatement：**SQL语句被预编译并存储在此对象中，可以使用此对象多次高效地执行该语句**。
```java
  通过调用 Connection 对象的 **preparedStatement(String sql)** 方法获取 PreparedStatement 对象
  它表示一条预编译过的 SQL 语句
  /**
  PreparedStatement 对象所代表的 SQL 语句中的参数用问号(?)来表示，
  调用 PreparedStatement 对象的 setXxx() 方法来设置这些参数. 
  setXxx() 方法有两个参数，第一个参数是要设置的 SQL 语句中的参数的索引(从 1 开始)，
  第二个是设置的 SQL 语句中的参数的值*/
  //通用的增、删、改操作（体现一：增、删、改 ； 体现二：针对于不同的表）
  	public void update(String sql,Object ... args){
  		Connection conn = null;
  		PreparedStatement ps = null;
  		try {
  			//1.获取数据库的连接
  			conn = JDBCUtils.getConnection();
  			
  			//2.获取PreparedStatement的实例 (或：预编译sql语句)
  			ps = conn.prepareStatement(sql);
  			//3.填充占位符
  			for(int i = 0;i < args.length;i++){
  				ps.setObject(i + 1, args[i]);
  			}
  			
  			//4.执行sql语句
  			ps.execute();
  		} catch (Exception e) {
  			
  			e.printStackTrace();
  		}finally{
  			//5.关闭资源
  			JDBCUtils.closeResource(conn, ps);
  			
  		}
  	}
```

```java
  	/*针对于表的字段名与类的属性名不相同的情况：
  	 * 1. 必须声明sql时，使用类的属性名来命名字段的别名
  	 * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
  	 *    获取列的别名。
  	 *  说明：如果sql中没有给字段其别名，getColumnLabel()获取的就是列名
  	*/
  	
  	// 通用的针对于不同表的查询:返回一个对象 (version 1.0)
  	public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
  
  		Connection conn = null;
  		PreparedStatement ps = null;
  		ResultSet rs = null;
  		try {
  			// 1.获取数据库连接
  			conn = JDBCUtils.getConnection();
  
  			// 2.预编译sql语句，得到PreparedStatement对象
  			ps = conn.prepareStatement(sql);
  
  			// 3.填充占位符
  			for (int i = 0; i < args.length; i++) {
  				ps.setObject(i + 1, args[i]);
  			}
  
  			// 4.执行executeQuery(),得到结果集：ResultSet
  			rs = ps.executeQuery();
  
  			// 5.得到结果集的元数据：ResultSetMetaData
  			ResultSetMetaData rsmd = rs.getMetaData();
  
  			// 6.1通过ResultSetMetaData得到columnCount,columnLabel；通过ResultSet得到列值
  			int columnCount = rsmd.getColumnCount();
  			if (rs.next()) {
  				T t = clazz.newInstance();
  				for (int i = 0; i < columnCount; i++) {// 遍历每一个列
  
  					// 获取列值
  					Object columnVal = rs.getObject(i + 1);
  					// 获取列的别名:列的别名，使用类的属性名充当
  					String columnLabel = rsmd.getColumnLabel(i + 1);
  					// 6.2使用反射，给对象的相应属性赋值
  					Field field = clazz.getDe+ claredField(columnLabel);
  					field.setAccessible(true);
  					field.set(t, columnVal);
  
  				}
  
  				return t;
  
  			}
  		} catch (Exception e) {
  
  			e.printStackTrace();
  		} finally {
  			// 7.关闭资源
  			JDBCUtils.closeResource(conn, ps, rs);
  		}
  
  		return null;
  
  	}
```
  
  Preparedstatement VS Statement
  - DBServer会对**预编译**语句提供性能优化。因为预编译语句有可能被重复调用，所以<u>语句在被DBServer的编译器编译后的执行代码被缓存下来，那么下次调用时只要是相同的预编译语句就不需要编译，只要将参数直接传入编译过的语句执行代码中就会得到执行。</u>
  - 在statement语句中,即使是相同操作但因为数据内容不一样,所以整个语句本身不能匹配,没有缓存语句的意义.事实是没有数据库会对普通语句编译后的执行代码缓存。这样<u>每执行一次都要对传入的语句编译一次。</u>

ResultSet与ResultSetMetaData


####ResultSet

- 查询需要调用PreparedStatement 的 executeQuery() 方法，查询结果是一个ResultSet 对象
- ResultSet 对象以逻辑表格的形式封装了执行数据库操作的结果集，ResultSet 接口由数据库厂商提供实现
- ResultSet 返回的实际上就是一张数据表。有一个指针指向数据表的第一条记录的前面。
- ResultSet 对象维护了一个指向当前数据行的**游标**，初始的时候，游标在第一行之前，可以通过 ResultSet 对象的 next() 方法移动到下一行。调用 next()方法检测下一行是否有效。若有效，该方法返回 true，且指针下移。相当于Iterator对象的 hasNext() 和 next() 方法的结合体。
- 当指针指向一行时, 可以通过调用 getXxx(int index) 或 getXxx(int columnName) 获取每一列的值。
  - 例如: getInt(1), getString("name")
  - **注意：Java与数据库交互涉及到的相关Java API中的索引都从1开始。**
- ResultSet 接口的常用方法：
  - boolean next()
  - getString()
  - …
  
####ResultSetMetaData

- 可用于获取关于 ResultSet 对象中列的类型和属性信息的对象

- ResultSetMetaData meta = rs.getMetaData();
  - **getColumnName**(int column)：获取指定列的名称
  - **getColumnLabel**(int column)：获取指定列的别名
  - **getColumnCount**()：返回当前 ResultSet 对象中的列数。 
  - getColumnTypeName(int column)：检索指定列的数据库特定的类型名称。 
  - getColumnDisplaySize(int column)：指示指定列的最大标准宽度，以字符为单位。 
  - **isNullable**(int column)：指示指定列中的值是否可以为 null。 
  - isAutoIncrement(int column)：指示是否自动为指定列进行编号，这样这些列仍然是只读的。 


### 批量插入

```java

/*
 * 使用PreparedStatement实现批量数据的操作
 * 
 * update、delete本身就具有批量操作的效果。
 * 此时的批量操作，主要指的是批量插入。使用PreparedStatement如何实现更高效的批量插入？
 * 
 * 题目：向goods表中插入20000条数据
 * CREATE TABLE goods(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(25)
   );
 * 方式一：使用Statement
 * Connection conn = JDBCUtils.getConnection();
 * Statement st = conn.createStatement();
 * for(int i = 1;i <= 20000;i++){
 * 		String sql = "insert into goods(name)values('name_" + i + "')";
 * 		st.execute(sql);
 * }
 * 
 */
 public class InsertTest {
    public static void main(String[] args) {

    }
    @Test
    //方式一：常规批量插入
    public void test(){
        Connection conn = null;
        PreparedStatement ps = null;
        long start = System.currentTimeMillis();
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement("insert into goods(name)values(?) ");
            for (int i = 0; i < 20000; i++) {
                ps.setObject(1,"name_"+i);
                //后端程序每次都要提交
                //数据库端也是每次都要进行commit
                ps.execute();
            }

            long end = System.currentTimeMillis();
            System.out.println("程序运行的时间为:"+(end-start)/1000+"s");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }

    }

    @Test
    //方式二：使用Batch缓存
    public void test1(){
        Connection conn = null;
        PreparedStatement ps = null;
        long start = System.currentTimeMillis();
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement("insert into goods(name)values(?) ");
            for (int i = 0; i < 20000; i++) {
                ps.setObject(1,"name_"+i);

                //本地缓存sql语句
                ps.addBatch();
                if (i%500 == 0) {
                    //提交sql语句
                    ps.executeBatch();

                    //清空缓存
                    ps.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("程序运行的时间为:"+(end-start)/1000+"s");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }

    }

    @Test
    //方式三：使用Batch缓存加commit
    public void test2(){
        Connection conn = null;
        PreparedStatement ps = null;
        long start = System.currentTimeMillis();
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("insert into goods(name)values(?) ");
            for (int i = 0; i < 20000; i++) {
                ps.setObject(1,"name_"+i);
                ps.addBatch();
                if (i%1000 == 0) {
                    ps.executeBatch();

                    ps.clearBatch();

                }
            }
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("程序运行的时间为:"+(end-start)/1000+"s");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,ps);
        }

    }
}
```
