#Vue
Vue是一款用于构建用户界面的JavaScript框架。
它基于标准HTML、CSS和JavaScript构建，并提供了一套`声明式`的、`组件化`的编程模型，帮助你高效地开发用户界面。
官网为：https://cn.vuejs.org

##Vue的两个核心功能
###声明式渲染
基于标准HTML拓展了一套模板语法，使得我们可以声明式地描述最终输出的
* 编程式渲染：通过DOM编程的方式来实现页面的更新
  1. 当数据更新时
  2. 获取DOM节点
  3. 更新DOM节点  
* 声明式渲染：通过建立数据和DOM之间的映射关系，当数据更新时，自动更新DOM
  1. 建立数据和DOM之间的映射关系(数据绑定)
  2. 数据更新时，自动更新DOM
    

###响应性
ue会自动跟踪JavaScript:状态并在其发生变化时响应式地更新DOM;
```

Vue
简化了对dom对象的操作
1.标签中文本的操作
    1) {{}} - 相当于innerText
2.标签属性的操作
    2) v-bind:attr 绑定属性值。例如，v-bind:value - 绑定value值
       简写：    :value
    3) v-model 双向绑定
       v-model:value   , 简写  v-model
2.标签的显示与隐藏       
    4) v-if , v-else , v-show
       v-if和v-else之间不能有其他的节点（真隐藏）
       v-show是通过样式表display来控制节点是否显示（“假”隐藏）
    5) v-for 迭代
       v-for={fruit in fruitList}
    6) v-on 绑定事件
    7) 其他：
       - trim:去除首尾空格 , split() , join()
       - watch表示侦听属性
       - 生命周期

```

<br/>

```javascript
var vue = new Vue({
                "el":"#div0",
                属性
                data:{
                    msg:"hello!!!",
                    uname:"鸠摩智"
                },
                函数
                methods:{
                    myReverse:function(){
                        this.msg = this.msg.split("").reverse().join("");
                    }
                },
                watch:{
                    //侦听属性num1和num2
                    //当num1的值有改动时，那么需要调用后面定义的方法 , newValue指的是num1的新值
                    num1:function(newValue){
                        this.num3 = parseInt(newValue) + parseInt(this.num2);
                    },
                    num2:function(newValue){
                        this.num3 = parseInt(this.num1) + parseInt(newValue) ;
                    }
                }
                
            });
```

![01.Axios示例.png](47dc2446736dda4d0518496d2b674ba7.png)
