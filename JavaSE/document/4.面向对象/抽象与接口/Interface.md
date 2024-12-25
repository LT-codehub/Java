# interface:接口
## 1.使用说明：

1. 接口使用interface来定义
2. Java中，接口和类是并列的两个结构
3. 如何定义接口：定义接口中的成员
   1. JDK7及以前：只能定义全局常量和抽象方法
      1. 全局常量：`public static final`的。但是书写时，可以省略不写
      2. 抽象方法：`public abstract`的，但是书写时，可以省略不写
   2. JDK8：除了定义全局常量和抽象方法之外，还可以定义**静态方法**、**默认方法**
      1. 接口可以包含实现方法，需要使用`default修饰`，此类方法称为默认方法。默认方法`必须提供实现`，在实现类中可以按需重写。
4. 接口中不能定义构造器的！意味着接口不可以实例化 
5. Java开发中，接口通过让类去实现(implements)的方式来使用.
如果实现类覆盖了接口中的所抽象方法，则此实现类就可以实例化
如果实现类没覆盖接口中所的抽象方法，则此实现类仍为一个抽象类 
6. Java类可以实现多个接口 ---> **弥补了Java单继承性的局限性**
格式：class AA extends BB implements CC,DD,EE 
7. 接口与接口之间可以继承，而且可以多继承 
8. 接口的具体使用，体现多态性
9. 接口，实际上可以看做是一种规范
## 2.举例：
```java
class Computer{

    public void transferData(USB usb){//USB usb = new Flash();
        usb.start();

        System.out.println("具体传输数据的细节");

        usb.stop();
    }


}

interface USB{
    //常量：定义了长、宽、最大最小的传输速度等
    //反编译其实际是由public static final修饰的
    int  USB_MAX_DATA_RATE = 10000;
    
    //反编译其本质：public abstract void start();
    void start();

    void stop();
    
    //默认方法，可以由实现类对其进行重写
    //反编译其本质：public default void hello(){
    default void hello(){
        System.out.println("hello");
    }
    
    //静态方法
    
    static void staticHello(){
        System.out.println("static hello");
    }

}

class Flash implements USB{

    @Override
    public void start() {
        System.out.println("U盘开启工作");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作");
    }

}

class Printer implements USB{
    @Override
    public void start() {
        System.out.println("打印机开启工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }

}
```
## 体会：

1. 接口使用上也满足多态性
2. 接口，实际上就是定义了一种规范
3. 开发中，体会面向接口编程！	

面向接口编程：我们在应用程序中，调用的结构都是JDBC中定义的接口，不会出现具体某一个
数据库厂商的API。
### Java8中关于接口的新规范

1. **接口中定义的静态方法，只能通过接口来调用**。**静态方法属于接口本身**
2. **通过实现类的对象，可以调用接口中的默认方法**。如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
3. 如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的默认方法，那么子类在没重写此方法的情况下，默认调用的是父类中的同名同参数的方法。-->**类优先原则**
4. 如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类没重写此方法的情况下，报错。-->**接口冲突**。**这就需要我们必须在实现类中重写此方法**
5. 如何在子类(或实现类)的方法中调用父类、接口中被重写的方法
```java
	public void myMethod(){
		method3();//调用自己定义的重写的方法
		super.method3();//调用的是父类中声明的
		//调用接口中的默认方法
		CompareA.super.method3();
		CompareB.super.method3();
	}
```
###面试题：
* 抽象类和接口的异同？
   * 相同点：不能实例化；都可以包含抽象方法的。
   * 不同点：抽象类可以有抽象方法和其他方法，接口只能包含抽象方法
      1. 把抽象类和接口(java7,java8,java9)的定义、内部结构解释说明
      2. 类：单继承性 接口：多继承 类与接口：多实现


