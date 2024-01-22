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
