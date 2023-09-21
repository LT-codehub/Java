# 遍历Collection的两种方式
# 使用迭代器Iterator
java.utils包下定义的迭代器接口：Iterator
**Iterator对象称为迭代器(设计模式的一种)，主要用于遍历Collection 集合中的元素**
GOF给迭代器模式的定义为：**提供一种方法访问一个容器(container)对象中各个元素，而又不需暴露该对象的内部细节**。迭代器模式，就是为容器而生。
## 使用方式

1. 获取迭代器对象
2. 调用`hasNext()`判断是否还有下一个元素
3. 调用`next()`获取元素，并将游标下移
```java
Collection coll = new ArrayList();
erator iterator = coll.iterator();
//hasNext():判断是否还下一个元素
while(iterator.hasNext()){
    //next():①指针下移 ②将下移以后集合位置上的元素返回
    System.out.println(iterator.next());
}
```
## 实现原理

2.5图示说明：
![image.png](https://cdn.nlark.com/yuque/0/2022/png/28932072/1655990489280-324a9d8c-7eb2-467f-9097-cae5e606e4f4.png#averageHue=%23e3e7f0&clientId=u5cc240b9-3703-4&from=paste&height=391&id=OR2O9&originHeight=391&originWidth=761&originalType=binary&ratio=1&rotation=0&showTitle=false&size=28163&status=done&style=none&taskId=u0536787d-1405-4c4a-998b-36cec9393b9&title=&width=761)
## remove()的使用
因为`next()`方法的原理连续调用`remove()`方法会报错(感觉是废话)
```java
//测试Iterator中的remove()
//如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
//再调用remove都会报IllegalStateException。
//内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        //删除集合中"Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
//            iterator.remove();
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
//                iterator.remove();
            }

        }
        //遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
```
# foreach循环-语法糖
JDK 5.0新特性--增强for循环
```java
   @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] integers = new Integer[100];
        for (int i = 0; i < 100; i++) {
            list.add(i);
            integers[i] = i;
        }

        for (Integer integer:list) {
            System.out.println("list.integer = " + integer);
        }

        for (Integer integer:integers) {
            System.out.println("array.integer = " + integer);
        }

    }
反编译代码
@Test
    public void test() {
        ArrayList<Integer> list = new ArrayList();
        Integer[] integers = new Integer[100];

        for(int i = 0; i < 100; ++i) {
            list.add(i);
            integers[i] = i;
        }

        Iterator var7 = list.iterator();

        while(var7.hasNext()) {
            Integer integer = (Integer)var7.next();
            System.out.println("list.integer = " + integer);
        }

        Integer[] var8 = integers;
        int var9 = integers.length;

        for(int var5 = 0; var5 < var9; ++var5) {
            Integer integer = var8[var5];
            System.out.println("array.integer = " + integer);
        }

    }

```
**foreach遍历集合实际调用了迭代器**
**foreach遍历数组则是常规方式**
