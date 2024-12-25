##String、StringBuffer、StringBuilder三者的对比
* String:不可变的字符序列；底层使用final char[]存储
* StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储
* StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储
  
  >StringBuffer和StringBuilder  
  默认使用都是char[] value = new char[16]  
  如果存储的字符串长度超过了16，则扩容，每次扩容为原来容量的2倍+2，直到达到MAX_VALUE=1073741824
##StringBuffer、StringBuilder中的构造器
```java
public StringBuffer() {
        super(16);
        }

public StringBuffer(int capacity) {
        super(capacity);
        }

public StringBuffer(String str) {
        super(str.length() + 16);
        append(str);
        }


public StringBuilder() {
        super(16);
        }
        
public StringBuilder(int capacity) {
        super(capacity);
        }

public StringBuilder(String str) {
        super(str.length() + 16);
        append(str);
        }        
```
###StringBuffer与StringBuilder的append()方法
```java
public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();
        int len = str.length();
        ensureCapacityInternal(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }

private AbstractStringBuilder appendNull() {
        int c = count;
        ensureCapacityInternal(c + 4);
        final char[] value = this.value;
        value[c++] = 'n';
        value[c++] = 'u';
        value[c++] = 'l';
        value[c++] = 'l';
        count = c;
        return this;
        }
```
##StringBuffer与StringBuilder的内存解析
以StringBuffer为例：
```java
    String str = new String();//char[] value = new char[0];
    String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};
    StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组。
    System.out.println(sb1.length());//
    sb1.append('a');//value[0] = 'a';
    sb1.append('b');//value[1] = 'b';
    StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16];
    //问题1. System.out.println(sb2.length());//3
    //问题2. 扩容问题:如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
    //默认情况下，扩容为原来容量的2倍 + 2，同时将原数组中的元素复制到新的数组中。
```
* 指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)

##对比String、StringBuffer、StringBuilder三者的执行效率
* 从高到低排列：StringBuilder > StringBuffer > String

##StringBuffer、StringBuilder中的常用方法
* 增：append(xxx)
* 删：delete(int start,int end)
* 改：setCharAt(int n ,char ch) / replace(int start, int end, String str)
* 查：charAt(int n )
* 插：insert(int offset, xxx)
* 长度：length();
* 遍历：for() + charAt() / toString()

#注意
* 向StringBuffer、StringBuilder的添加空对象，相当于添加了一个`null`字符串
* 无法使用char创建StringBuffer、StringBuilder对象，只能使用append()方法添加
