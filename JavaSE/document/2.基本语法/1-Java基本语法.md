## 关键字
###用于定义数据类型的关键字

|class|interface|enum|byte|char|boolean|void|
|:----:|:----:|:----:|:----:|:----:|:----:|:----:|
|类|接口|枚举|字节|字符|布尔|空|
|short|int|long|float|double|
|短整型|整型|长整型|单精度浮点|双精度浮点|

### 用于定义流程控制的关键字
|分支|分支|循环|循环|退出|
|:----:|:----:|:----:|:----:|:----:|
|if|switch|while|for|break|布尔|空|
|else|case|do|float|continue|
| || | |return|

### 用于定义访问权限修饰符的关键字
|私有|受保护|默认|公共|
|:----:|:----:|:----:|:----:|
|private|protected|~~(default)~~|public|

### 用于定义类，函数，变量修饰符的关键字
|抽象|最终的|静态|自动锁|
|:----:|:----:|:----:|:----:|
|abstract|final|static|synchronized|

### 用于定义类与类之间关系的关键字
|继承|实现|
|:----:|:----:|
|extends|implements|


### 用于定义建立实例及引用实例，判断实例的关键字
|实例化|当前对象|父类|类是否相同|
|:----:|:----:|:----:|:----:|
|new|this|super|instanceof|

### 用于异常处理的关键字
|捕获异常|处理异常|默认行为|抛给调用者|手动抛出|
|:----:|:----:|:----:|:----:|:----:|
|try|catch|finally|throw|throws|

### 用于包的关键字
|所有属包|引入类|
|:----:|:----:|
|package|import|

### 其他修饰符关键字
|外部(本地)方法| |不可序列化|阻止指令重排|断言|
|:----:|:----:|:----:|:----:|:----:|
|native|strictfp|transient|volatile|assert|

保留字：**goto** 、**const**
## 标识符
标识符： 

- Java 对各种**`变量`**、**`方法`**和**`类`**等要素命名时使用的字符序列称为`标识符` 
- **技巧：凡是自己可以起名字的地方都叫标识符**。 

定义合法标识符规则： 

- **由26个英文字母大小写，0-9 ，_或 $ 组成**
- **数字不可以开头。**
- **不可以使用关键字和保留字，但能包含关键字和保留字。**
- **Java中严格区分大小写，长度无限制。**
- **标识符不能包含空格。**

命名规则：

- **包名**：多单词组成时所有字母都小写：xxxyyyzzz 
- **类名、接口名**：多单词组成时，所有单词的首字母大写：XxxYyyZzz 
- **变量名、方法名**：多单词组成时，第一个单词首字母小写，第二个单词开始每个单词首字母大写：xxxYyyZzz 
- **常量名**：所有字母都大写。多单词时每个单词用下划线连接：XXX_YYY_ZZZ
## 变量
内存中的一个存储区域 
该区域的数据可以在同一类型范围内不断变化 
变量是程序中最基本的存储单元。包含变量类型、变量名和存储的值

### 数据类型
* 基本数据类型
  * 数值
    * 整型：`byte`、`short`、`int`、`long`
    * 浮点：`float`、`double`
  * 字符：`char`
  * 布尔：`boolean`
* 引用数据类型
    * 类：`class`
    * 数组：`[]`
    * 接口：`interface`
    
char的三种表现形式：
* 单引号括起来
* 转义字符
* Unicode 值表示：‘\uXXXX’，XXXX为16进制数

### 基本数据类型变量间转换
隐式转换：`(byte、char、short)`->`int`->`long`->`float`->`double`

### 基本数据类型与String间转换
基本数据类型 -> String ：String.valueOf()
```java
public class Test {
    public static void main(String[] args) {
        String s = String.valueOf();
    }
}
```

String -> 基本数据类型: 通过包装类.parseXxx方法

```java
public class Test {
  public static void main(String[] args) {
    String str = "1";
    int i = Integer.parseInt(str);
  }
}
```
### 进制与进制间的转换

