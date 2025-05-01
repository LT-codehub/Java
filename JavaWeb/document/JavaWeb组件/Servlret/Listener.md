
#监听器Listener
* 专门用于对域对象对象身上发生的事件或状态改变进行监听和相应处理的对象：
* 监听器是GOF设计模式中，观察者模式的典型案例；
* 监听器使用的感受类似JS中的事件，`被观察的对象发生某些情况时，自动触发代码的执行`：
* 监听器并不监听web项目中的所有组件，`仅仅是对三大域对象做相关的事件监听`；
##监听器的分类：
web中定义八个监听器接口作为监听器的规范，这八个接口按照不同的标准可以形成不同的分类；
* ServletContextListener - 监听ServletContext对象的创建和销毁的过程
* HttpSessionListener - 监听HttpSession对象的创建和销毁的过程
* ServletRequestListener - 监听ServletRequest对象的创建和销毁的过程


* ServletContextAttributeListener - 监听ServletContext的保存作用域的改动(add,remove,replace)
* HttpSessionAttributeListener - 监听HttpSession的保存作用域的改动(add,remove,replace)
* ServletRequestAttributeListener - 监听ServletRequest的保存作用域的改动(add,remove,replace)


* HttpSessionBindingListener - 监听某个对象在Session域中的创建与移除
* HttpSessionActivationListener - 监听某个对象在Session域中的序列化和反序列化

#监听器应用：

* ContextLoaderListener
* 当ServletContext对象创建时，就初始化IOC容器