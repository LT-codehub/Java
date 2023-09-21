编译完源程序以后，生成一个或多个字节码文件。
我们使用JVM中的类的加载器和解释器对生成的字节码文件进行解释运行。意味着，需要将字节码文件对应的类加载到内存中，涉及到内存解析。
![image.png](https://cdn.nlark.com/yuque/0/2022/png/28932072/1655979949895-e1cdcd8e-138d-4f69-876f-e4ba646206dd.png#averageHue=%23bcc5a5&clientId=ud6ce3033-a044-4&from=paste&height=389&id=uaf5866d5&originHeight=389&originWidth=527&originalType=binary&ratio=1&rotation=0&showTitle=false&size=130096&status=done&style=none&taskId=u55b229b3-12cf-4644-be29-edcebb3a567&title=&width=527)
《JVM规范》

`虚拟机栈`：即为平时提到的栈结构。我们将`局部变量`存储在栈结构中（**局部变量表**）
`堆`：我们将new出来的结构（比如：数组、对象）加载在对空间中。补充：对象的属性（非static的）加载在堆空间中。
`方法区`：`类的加载信息`、`常量池`、`静态域`











