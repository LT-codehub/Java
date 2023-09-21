1.Lambda表达式使用前后的对比：
举例一：
@Test
public void test1(){

    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println("我爱北京天安门");
        }
    };

    r1.run();

    System.out.println("***********************");

    Runnable r2 = () -> System.out.println("我爱北京故宫");

    r2.run();
}

举例二：
@Test
public void test2(){

    Comparator<Integer> com1 = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1,o2);
        }
    };

    int compare1 = com1.compare(12,21);
    System.out.println(compare1);

    System.out.println("***********************");
    //Lambda表达式的写法
    Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);

    int compare2 = com2.compare(32,21);
    System.out.println(compare2);


    System.out.println("***********************");
    //方法引用
    Comparator<Integer> com3 = Integer :: compare;

    int compare3 = com3.compare(32,21);
    System.out.println(compare3);
}
2.Lambda表达式的基本语法：
* 1.举例： (o1,o2) -> Integer.compare(o1,o2);
* 2.格式：
*      -> :lambda操作符 或 箭头操作符
*      ->左边：lambda形参列表 （其实就是接口中的抽象方法的形参列表
*      ->右边：lambda体 （其实就是重写的抽象方法的方法体

3.如何使用：分为六种情况
![image.png](https://cdn.nlark.com/yuque/0/2022/png/28932072/1655996545615-05b17bcc-8345-47a6-8672-b23dcaacce5f.png#clientId=u62afb866-52fe-4&from=paste&height=352&id=u4a469d6e&originHeight=352&originWidth=717&originalType=binary&ratio=1&rotation=0&showTitle=false&size=50979&status=done&style=none&taskId=ufa85ab82-a6a5-43d5-a357-7f04ecaf2cb&title=&width=717)![image.png](https://cdn.nlark.com/yuque/0/2022/png/28932072/1655996553149-f915ceaf-9786-428f-9ce8-70de25778aca.png#clientId=u62afb866-52fe-4&from=paste&height=355&id=u7a133cda&originHeight=355&originWidth=727&originalType=binary&ratio=1&rotation=0&showTitle=false&size=74887&status=done&style=none&taskId=ud80428b6-a3f4-418d-b63f-23ff7e3452c&title=&width=727)


总结六种情况：
->左边：lambda形参列表的参数类型可以省略(类型推断)；如果lambda形参列表只一个参数，其一对()也可以省略
->右边：lambda体应该使用一对{}包裹；如果lambda体只一条执行语句（可能是return语句，省略这一对{}和return关键字












