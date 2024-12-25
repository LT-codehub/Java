###比较器更直观的叫法应该叫做`排序规则`
# 自然排序：使用Comparable接口
**自然排序准确的用该叫类的`默认排序规则`，是指当类`调用排序方法`时，默认使用的排序规则**
如：使用`Arrays.sort()`、`集合的sort方法`时
## 使用方式

1. **子类<font color="#006e54">实现Comparable接口</font>**
2. 重写`compareTo()方法`
   1. **重写规则**
      1. **如果当前对象this`大于`形参对象obj，则`返回正整数`
      2. **如果当前对象this`小于`形参对象obj，则`返回负整数`
      3. **如果当前对象this`等于`形参对象obj，则`返回零`
```java
public class Goods implements  Comparable{

    private String name;
    private double price;

    //指明商品比较大小的方式:照价格从低到高排序,再照产品名称从高到低排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods goods = (Goods)o;
            //方式一：
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
               return -this.name.compareTo(goods.name);
            }
            //方式二：
//           return Double.compare(this.price,goods.price);
        }
//        return 0;
        throw new RuntimeException("传入的数据类型不一致！");
    }
// getter、setter、toString()、构造器：省略
}
```
# 排序：使用Comparator接口
**定制排序是应该叫做`临时排序规则`更为准确**
##使用方式

1. **直接<font color="#006e54">实现Comparator接口</font>**
2. 重写`compare()方法`
   1. **重写规则**
      1. 如果对象1`大于`对象2，则`返回正整数`
      2. 如果对象1`小于`对象2，则`返回负整数`
      3. 如果对象1`等于`对象2，则`返回零`
```java
Comparator com = new Comparator() {
    //指明商品比较大小的方式:照产品名称从低到高排序,再照价格从高到低排序
    @Override
    public int compare(Object o1, Object o2) {
        if(o1 instanceof Goods && o2 instanceof Goods){
            Goods g1 = (Goods)o1;
            Goods g2 = (Goods)o2;
            if(g1.getName().equals(g2.getName())){
                return -Double.compare(g1.getPrice(),g2.getPrice());
            }else{
                return g1.getName().compareTo(g2.getName());
            }
        }
        throw new RuntimeException("输入的数据类型不一致");
    }
}
```

#使用说明
自然排序作为类的默认排序规则，一般由排序类直接实现
定制排序作为临时排序规则，一般临时作为匿名类使用
