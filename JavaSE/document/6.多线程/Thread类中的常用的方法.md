# 线程的生命周期
![image.png](https://cdn.nlark.com/yuque/0/2022/png/28932072/1655989848775-dc232eda-df89-4112-83b6-b28d68188a6b.png#averageHue=%23f7f5f5&clientId=ue91496bd-e732-4&from=paste&height=363&id=ucb1f248d&originHeight=363&originWidth=814&originalType=binary&ratio=1&rotation=0&showTitle=false&size=27067&status=done&style=none&taskId=u821ba9e3-948f-465f-a119-3f6e0c4c3ba&title=&width=814)
## 生命周期的五个状态

1. 新建：线程被创建
2. 就绪：线程等待被CPU执行
3. 运行：CPU正在执行
4. 阻塞：临时状态，被挂起
5. 死亡：运行完毕

**生命周期关注两个概念：**`**状态**`**、以及**`**改变状态的相应的方法**`
## 线程的优先级
线程的优先级是一个就绪状态的概念，等级从`1-10`分为：
`MAX_PRIORITY`：`10`
`MIN _PRIORITY`：`1`
`NORM_PRIORITY`：`5`  --> **默认优先级**
### 改变线程优先级的方法
`getPriority()`:`**获取**`线程的优先级
`setPriority(int p)`:`**设置**`线程的优先级
说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下被执行。并不意味着只当高优先级的线程执行完以后，低优先级的线程才执行。
# 常用的方法

1. `start()`:启动当前线程；调用当前线程的`run()`
2. `run()`: 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
3. `currentThread()`:静态方法，返回执行当前代码的线程
4. `getName()`:获取当前线程的名字
5. `setName()`:设置当前线程的名字
6. `yield()`:释放当前cpu的执行权
7. `join()`:在线程a中调用线程b的join(),此时线程a就进入阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态。
8. `stop()`:~~已过时。当执行此方法时，强制结束当前线程。~~
9. `sleep`(long millitime):让当前线程“睡眠”指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。
10. `isAlive()`:判断当前线程是否存活



