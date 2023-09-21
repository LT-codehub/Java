# File类的理解
1. File类的一个对象，代表`一个文件`或一个`文件目录`(俗称：文件夹)
2. File类声明在java.io包下
3. File类中涉及到关于文件或文件目录的`创建`、`删除`、`重命名`、`修改时间`、`文件大小`等方法，
   1. 并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".

![image.png](https://cdn.nlark.com/yuque/0/2023/png/28932072/1694948490792-aad39698-b6b2-4630-bfaf-6d2abfb45a3a.png#averageHue=%23f5f3f3&clientId=u0ec967e1-e0e1-4&from=paste&height=437&id=uada72517&originHeight=437&originWidth=953&originalType=binary&ratio=1&rotation=0&showTitle=false&size=113503&status=done&style=none&taskId=u405f2a15-1e1c-47c9-b2ac-1e91200ca70&title=&width=953)
**File对象并不是文件本身，当实例化一个文件对象时，文件本身并不会被读到内存中**
# File对象的实例化
## 常用构造器
`File(File parent, String child)`
从父抽象路径名和子路径名字符串创建新的 File实例。
`File(String pathname)`
通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
`File(String parent, String child)`
从父路径名字符串和子路径名字符串创建新的 File实例。
`File(URI uri)`
通过将给定的file: URI转换为抽象路径名来创建新的 File实例
## 路径的分类

- 相对路径：相较于某个路径下，指明的路径。
   - 相对路径名必须根据从其他路径名获取的信息进行解释
   - **File对象会默认以当前项目的项目目录，作为相对路径的参考或者说前缀**
- 绝对路径：包含盘符在内的文件或文件目录的路径
   - 绝对路径名是完整的，因为不需要其他信息来定位其表示的文件

默认情况下，java.io包中的类始终会**根据当前用户目录**解析相对路径名。 该目录由系统属性`user.dir` ，通常是调用Java虚拟机的目录，也就是**当前的项目目录。**
```java
@Test
    public void test(){
        File file = new File("file_demo");
        if (!file.exists()) {
            file.mkdirs();
        }
        System.out.println("file.getPath() = " + file.getPath());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
    }
```

### 说明
#### IDEA中的相对路径
如果大家开发使用JUnit中的单元测试方法测试，相对路径即为当前Module下。
如果大家使用main()测试，相对路径即为当前的Project下。
#### Eclipse中的相对路径
不管使用单元测试方法还是使用main()测试，相对路径都是当前的Project下。
#### 路径分隔符
`**Windows**`和`**DOS**`系统默认使用`“\”`来表示，但是实际在字符串中必须使用`"\\"`
`**UNIX**`和`**URL**`使用`“/”`来表示
# 常用方法
## 获取
`public String getAbsolutePath()`：获取绝对路径
`public String getPath()`：获取路径
`public String getName()`：获取名称
`public String getParent()`：获取上层文件目录路径。若无，返回null
`public long length()`：获取文件长度（即：字节数）。不能获取目录的长度。
`public long lastModified()`：获取最后一次的修改时间，毫秒值
`public String[] list()`：获取指定目录下的所有文件或者文件目录的名称数组
`public File[] listFiles()`：获取指定目录下的所有文件或者文件目录的File数组
## 修改
`public boolean renameTo(File dest)`：把文件重命名为指定的文件路径
## 判断
`public boolean isDirectory()`：判断是否是文件目录
`public boolean isFile()`：判断是否是文件
`public boolean exists()`：判断是否存在
`public boolean canRead()`：判断是否可读
`public boolean canWrite()`：判断是否可写
`public boolean isHidden()`：判断是否隐藏
## 创建
`public boolean createNewFile()`：创建文件。若文件存在，则不创建，返回false
`public boolean mkdir()`：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
`public boolean mkdirs()`：创建文件目录。如果上层文件目录不存在，一并创建
**注意：如果没有写绝对路径，那么会按照相对路径创建(相对路径=本项目目录)**
## 删除
`public boolean delete()`：删除文件或者文件夹
删除注意事项：
Java中的删除不走回收站。
要删除一个文件目录，请注意该文件目录内不能包含文件或者文件目录
# 实践
 







