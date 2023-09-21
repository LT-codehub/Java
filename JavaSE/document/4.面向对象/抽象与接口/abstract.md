# 可以用来修饰：类、方法
## abstract修饰类：抽象类

1. 此类**不能实例化**
2. 抽象类中一定有构造器，便于子类实例化时调用（涉及：子类对象实例化的全过程）
3. 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作 --->抽象的使用前提：继承性
## abstract修饰方法：抽象方法

1. 抽象方法只方法的声明，**没方法体**
2. **包含抽象方法的类，一定是一个抽象类**。但是，**抽象类中可以没有抽象方法的**。
3. 若子类**重写了父类中的所的抽象方法后**，此子类**方可实例化**
4. 若子类没重写父类中的所的抽象方法，则此子类也是一个抽象类，需要使用abstract修饰
## 注意点：

1. abstract不能用来修饰：属性、构造器等结构
2. abstract不能用来修饰私方法、静态方法、final的方法、final的类
## abstract的应用举例：
举例一：
举例二：
```java
abstract class GeometricObject{
public abstract double findArea();
}

class Circle extends GeometricObject{
private double radius;
public double findArea(){
		return 3.14 * radius * radius;
};
}
```
举例三：IO流中设计到的抽象类：InputStream/OutputStream / Reader /Writer。在其内部
定义了抽象的read()、write()方法。



