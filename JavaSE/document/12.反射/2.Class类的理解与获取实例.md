1.Class类的理解

1.类的加载过程：
程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
接着我们使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件
加载到内存中。此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此
运行时类，就作为Class的一个实例。
2.换句话说，Class的实例就对应着一个运行时类。
3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们可以通过不同的方式
来获取此运行时类。




2.获取Class实例的几种方式：（前三种方式需要掌握）
		//方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.atguigu.java.Person");
//        clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);

        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz1 == clazz4);


3.总结：创建类的对象的方式?
方式一：new + 构造器
方式二：要创建Xxx类的对象，可以考虑：Xxx、Xxxs、XxxFactory、XxxBuilder类中查看是否有
静态方法的存在。可以调用其静态方法，创建Xxx对象。
方式三：通过反射

4.Class实例可以是哪些结构的说明
![image.png](https://cdn.nlark.com/yuque/0/2022/png/28932072/1655991799366-3f191ef3-c44f-4e70-84c8-afea8a851a0e.png#clientId=ue7a5ecd3-1133-4&from=paste&height=291&id=u23d8e328&originHeight=291&originWidth=763&originalType=binary&ratio=1&rotation=0&showTitle=false&size=40561&status=done&style=none&taskId=u3ac0d19a-06e6-4d78-9b46-daef4fd5380&title=&width=763)




