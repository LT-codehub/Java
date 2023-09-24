# 存储的数据特点：无序的、不可重复的元素
**无序性**：不等于随机性。存储的数据在底层数组中并非照数组索引的顺序添加，而是根据数据的哈希值决定的。
**不可重复性**：保证添加的元素照`equals()`和判断时，不能返回true.即：相同的元素只能添加一个。
## 常用方法
Set接口中没额外定义新的方法，使用的都是Collection中声明过的方法。
## 常用实现类

- Collection接口：单列集合，用来存储一个一个的对象
   - Set接口：存储无序的、不可重复的数据 -->高中讲的“集合”
      - HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null值
      - LinkedHashSet：作为HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
         - 在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据。 对于频繁的遍历操作，LinkedHashSet效率高于HashSet.
      - TreeSet：可以照添加对象的指定属性，进行排序。
# HashSet
HashSet底层：数组+链表的结构
### 元素的添加

1. `计算哈希值`：调用元素的`hashCode()`计算哈希值
2. `计算位置`：根据哈希值计算在数组中存放的位置(**不同的哈希值也可能计算出同一位置**)
3. `添加元素`：四种情况
   1. 该位置`没有元素`，添加**成功**
   2. 该位置`有元素`，比较哈希值，`哈希值不同`则添加**成功**
   3. 该位置`有元素`，比较哈希值，`哈希值相同`，再用equals()比较内容，`内容不同`则添加**成功**
   4. 该位置`有元素`，比较哈希值，`哈希值相同`，再用equals()比较内容，`内容相同`则添加**失败**
```java
我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置（即为：索引位置，判断
数组此位置上是否已经元素：
    如果此位置上没其他元素，则元素a添加成功。 --->情况1
    如果此位置上其他元素b(或以链表形式存在的多个元素，则比较元素a与元素b的hash值：
        如果hash值不相同，则元素a添加成功。--->情况2
        如果hash值相同，进而需要调用元素a所在类的equals()方法：
               equals()返回true,元素a添加失败
               equals()返回false,则元素a添加成功。--->情况2

对于添加成功的情况2和情况3而言：元素a 与已经存在指定索引位置上数据以链表的方式存储。
jdk 7 :元素a放到数组中，指向原来的元素。
jdk 8 :原来的元素在数组中，指向元素a
总结：七上八下
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28932072/1694877106352-b6bd54e8-aafe-40a2-a1d8-61bf5fed4aa5.png#averageHue=%23f8ebd0&clientId=u093771ce-cbac-4&from=paste&height=445&id=uf208ca85&originHeight=445&originWidth=840&originalType=binary&ratio=1&rotation=0&showTitle=false&size=114297&status=done&style=none&taskId=ua4ed779d-d317-4e8e-8911-9350fbec129&title=&width=840)
**jdk 7 :新元素放到数组中，指向原来的元素**
**jdk 8 :原来的元素在数组中，指向新元素**
# LinkedHashSet
 LinkedHashSet和HashSet基本相同， 但它同时使用**双向链表维护元素的次序**
 LinkedHashSet插入性能略低于HashSet，但在**迭代访问Set里的全部元素时有很好的性能**  
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28932072/1694877245817-fdca5076-8d99-4332-bbee-4a5a59e63adc.png#averageHue=%23faf8f7&clientId=u093771ce-cbac-4&from=paste&height=465&id=ub2deeed9&originHeight=465&originWidth=819&originalType=binary&ratio=1&rotation=0&showTitle=false&size=56786&status=done&style=none&taskId=u3efeef17-7d69-4662-8198-c6952ffa8ca&title=&width=819)
# HashSet&LinkedHashSet存储对象所在类的要求
重写equals()方法：判断对象是否相等

- `引用是否相等(是否同一个对象)`
- `所属类是否相同`
- `实际内容是否相同`

重写hashCode()方法：相等的对象必须具有相等的散列码

- 直接使用Object类的hash方法传入所有成员变量
- 重写两个方法的小技巧：对象中用作 equals() 方法比较的 Field，都应该用来计算hashCode 值。
```java
@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntryTest entryTest = (EntryTest) o;

        if (id != null ? !id.equals(entryTest.id) : entryTest.id != null) return false;
        return name != null ? name.equals(entryTest.name) : entryTest.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
```
```java
public class EntryTest {
    private Integer id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntryTest entryTest = (EntryTest) o;
        return Objects.equals(id, entryTest.id) && Objects.equals(name, entryTest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public EntryTest() {
    }

    public EntryTest(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28932072/1694876361913-4ae3dc00-6026-4c23-8cda-7e5c58f27e0d.png#averageHue=%236d8b80&clientId=u093771ce-cbac-4&from=paste&height=381&id=uc564e385&originHeight=381&originWidth=888&originalType=binary&ratio=1&rotation=0&showTitle=false&size=138534&status=done&style=none&taskId=u2068d77a-cfca-42f9-8f19-69bbb930166&title=&width=888)
# TreeSet
 TreeSet底层使用`红黑树`结构存储数据 
![image.png](https://cdn.nlark.com/yuque/0/2023/png/28932072/1694877489106-38e52e0c-6a1c-49f6-ab52-c260d6ff14f6.png#averageHue=%23f3efef&clientId=u093771ce-cbac-4&from=paste&height=395&id=ufa91561d&originHeight=395&originWidth=923&originalType=binary&ratio=1&rotation=0&showTitle=false&size=116639&status=done&style=none&taskId=uc02d30bf-e758-4721-a612-bb40986ea44&title=&width=923)
红黑树是一种自平衡的查找树

## 使用说明

1. 向TreeSet中添加的数据，要求是相同类的对象
2. **如果试图把一个对象添加到 TreeSet时有两种方式：**
   - **该对象的类本身实现比较器，实现Comparable接口**
   - **在声明TreeSet时手动传入一个比较器,实现Comparator接口**
```java
//方式一：自然排序
@Test
    public void test1(){
        TreeSet set = new TreeSet();

        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Tom",12));

            //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
```
```java
//方式二：定制排序
    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Mary",33));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
```











