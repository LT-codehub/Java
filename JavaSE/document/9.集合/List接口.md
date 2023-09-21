# 存储的数据特点：有序的、可重复的数据
List集合类中元素有序、且可重复，集合中的每个元素都有其对应的**顺序索引**。`**储存顺序**`  
**List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据序号存取容器中的元素。**  
# 常用方法

- 增：`add(Object obj)`
- 删：`remove(int index)` / `remove(Object obj)`
- 改：`set(int index, Object ele)`
- 查：`get(int index)`
- 插：`add(int index, Object ele)`
- 长度：`size()`
- 遍历方式
   - Iterator迭代器方式
   - 增强for循环
   - 普通的循环
# 常用实现类

- Collection接口：单列集合，用来存储一个一个的对象
   - List接口：存储有序的、可重复的数据。  -->“动态”数组,替换原的数组
      - ArrayList：作为List接口的主要实现类；线程不安全的，效率高；
         - `底层`使用**数组**存储
      - LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；
         - `底层`使用**双向链表**存储
      - Vector：作为List接口的古老实现类；线程安全的，效率低；
         - `底层`使用**数组**存储
# ArrayList
## 源码分析
### JDK 7情况下

1. 默认会创建长度为10的数组
2. 扩容倍数为原来的容量的1.5倍
```java
     ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
     list.add(123);//elementData[0] = new Integer(123);
     ...
     list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
     默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。

     结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
```
###  JDK 8中ArrayList的变化

1. 默认不会创建长度为10的数组，第一次调用add()时，底层才创建长度10的数组
2. 扩容倍数为原来的容量的1.5倍
```java
ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}.并没创建长度为10的数组
list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
...
后续的添加和扩容操作与jdk 7 无异。
```
**JDK7中的ArrayList的对象的创建类似于单例的**`**饿汉式**`
**JDK8中的ArrayList的对象的创建类似于单例的**`**懒汉式**`**，延迟了数组的创建，节省内存。**

# LinkedList
## 源码分析

1. Node类的成员`item`、`next`、`prev`表明了其`双向链表`的结构
```java
 LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 list.add(123);//将123封装到Node中，创建了Node对象。
 其中，Node定义为：体现了LinkedList的双向链表的说法
 private static class Node<E> {
      E item;
      Node<E> next;
      Node<E> prev;      
     Node(Node<E> prev, E element, Node<E> next) {
      this.item = element;
      this.next = next;
      this.prev = prev;
      }
  }
```
# Vector
## 源码分析

1. 底层都创建了长度为10的数组。
2. 在扩容方面，默认扩容为原来的数组长度的2倍。
# 存储的元素的要求
**添加的对象，所在的类要重写equals()方法**
# 面试题
ArrayList、LinkedList、Vector者的异同？
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28932072/1694874701728-7bc48396-1cd7-4b64-93bd-8d8e121a30f6.png#averageHue=%23d0d079&clientId=u03b8abc1-283c-4&from=paste&height=395&id=u1b1101f6&originHeight=395&originWidth=861&originalType=binary&ratio=1&rotation=0&showTitle=false&size=189927&status=done&style=none&taskId=ue424c86a-b5ea-4037-a01c-4f5e608419e&title=&width=861)
同：三个类都是实现了List接口，存储数据的特点相同：存储序的、可重复的数据
不同：见上（第3部分+第4部分）





