# jQuery 介绍

什么是 jQuery ? 

jQuery，顾名思义，也就是 JavaScript 和查询（Query），它就是辅助 JavaScript 开发的 js 类库。 jQuery 核心思想！！！ 它的核心思想是 write less,do more(写得更少,做得更多)，所以它实现了很多浏览器的兼容问题。 

jQuery 好处！！！ j

Query 是免费、开源的，jQuery 的语法设计可以使开发更加便捷，例如操作文档对象、选择 DOM 元素、 制作动画效果、事件处理、使用 Ajax 以及其他功能

```
常见问题？ 
1、使用 jQuery 一定要引入 jQuery 库吗？ 
答案： 是，必须 
2、jQuery 中的$到底是什么？ 
答案： 它是一个函数 
3、怎么为按钮添加点击响应函数的？ 
答案： 
1、使用 jQuery 查询到标签对象 
2、使用标签对象.click( function(){} );
```

## $的使用

```javascript
//使用$()代替window.onload
	$(function(){
		//使用选择器获取按钮对象，随后绑定单击响应函数
		$("#btnId").click(function(){ 
			//弹出Hello
			alert('Hello');
		});
	});
```

## jQuery的核心函数

```javascript
$ 是 jQuery 的核心函数，能完成 jQuery 的很多功能。$()就是调用$这个函数
1、传入参数为 [ 函数 ] 时： 
表示页面加载完成之后。相当于 window.onload = function(){} 


//使用$()代替window.onload
	$(function(){
		//使用选择器获取按钮对象，随后绑定单击响应函数
		$("#btnId").click(function(){
			//弹出Hello
			alert('Hello');
		});
	});


2、传入参数为 [ HTML 字符串 ] 时： 
会对我们创建这个 html 标签对象 

//原生js代码
window.onload = function () {
            // 现在需要我们使用js代码来创建html标签，并显示在页面上
            // 标签的内容就是：<div>国哥，我爱你</div>
            var divObj = document.createElement("div"); // 在内存中 <div></div>

            var textNodeObj = document.createTextNode("国哥，我爱你"); // 有一个文本节点对象 #国哥，我爱你

            divObj.appendChild(textNodeObj); // <div>国哥，我爱你</div>

            // divObj.innerHTML = "国哥，我爱你"; // <div>国哥，我爱你</div>,但，还只是在内存中
            // 添加子元素
            document.body.appendChild(divObj);
        }

//jQuery方式
 $(function () {
        $("<div>\n" +
            "    <span>js</span>\n" +
            "    <span>jQuery</span>\n" +
            "</div>").appendTo("body");

    })

3、传入参数为 [ 选择器字符串 ] 时： 
$(“#id 属性值”); id 选择器，根据 id 查询标签对象 
$(“标签名”); 标签名选择器，根据指定的标签名查询标签对象 
$(“.class 属性值”); 类型选择器，可以根据 class 属性查询标签对象 

4、传入参数为 [ DOM 对象 ] 时： 
会把这个 dom 对象转换为 jQuery 对象
```

### jQuery 对象和dom 对象区分

**Dom 对象**

```javascript
1.通过getElementById()查询出来的标签对象是Dom 对象
2.通过getElementsByName()查询出来的标签对象是Dom 对象
3.通过getElementsByTagName()查询出来的标签对象是Dom 对象
4.通过createElement() 方法创建的对象，是Dom 对象
DOM 对象Alert 出来的效果是：[object HTML 标签名Element]
```

**jQuery 对象**

```javascript
5.通过JQuery 提供的API 创建的对象，是JQuery 对象
6.通过JQuery 包装的Dom 对象，也是JQuery 对象
7.通过JQuery 提供的API 查询到的对象，是JQuery 对象
jQuery 对象Alert 出来的效果是：[object Object]
```

**jQuery 对象的本质是什么？**

```javascript
jQuery 对象是dom 对象的数组+ jQuery 提供的一系列功能函数。
```

**jQuery 对象和Dom 对象使用区别**

```javascript
jQuery 对象不能使用DOM 对象的属性和方法
DOM 对象也不能使用jQuery 对象的属性和方法
```

#### Dom 对象和jQuery 对象互转

```javascript
/**dom 对象转化为jQuery 对象*/
1、先有DOM 对象
2、$( DOM 对象) 就可以转换成为jQuery 对象
/**jQuery 对象转为dom 对象*/
1、先有jQuery 对象
2、jQuery 对象[下标]取出相应的DOM 对象
```

#  jQuery选择器

选择器执行的顺序或者返回结果的顺序是基于Html页面的

## 基本选择器

```
#ID 选择器：根据id 查找标签对象

.class 选择器：根据class 查找标签对象

element 选择器：根据标签名查找标签对象

* 选择器：表示任意的，所有的元素

selector1，selector2 组合选择器：合并选择器1，选择器2 的结果并返回

p.myClass
表示标签名必须是p 标签，而且class 类型还要是myClass


```

## 层级选择器

```javascript
ancestor descendant：    后代选择器：在给定的祖先元素下匹配所有的后代元素
$("父元素 子元素") 
parent > child          子元素选择器：在给定的父元素下匹配所有的子元素
$("父元素>子元素") 
prev + next             相邻元素选择器：匹配所有紧接在prev 元素后的next 元素
$("x元素+所需元素")
prev ~ sibings          之后的兄弟元素选择器：匹配prev 元素之后的所有siblings 元素
$("起始元素 ~ 所需元素")
/**选择同级的元素**/
```

### 过滤选择器

```javascript
/*:first 获取匹配的第一个元素*/
$("元素：f：irst")
/*:last 获取匹配的最后个元素*/
:not(selector) 去除所有与给定选择器匹配的元素
:even 匹配所有索引值为偶数的元素，从0 开始计数
:odd 匹配所有索引值为奇数的元素，从0 开始计数
/*:eq(index) 匹配一个给定索引值的元素*/
:gt(index) 匹配所有大于给定索引值的元素
:lt(index) 匹配所有小于给定索引值的元素
:header 匹配如h1, h2, h3 之类的标题元素
:animated 匹配所有正在执行动画效果的元素
```

### 内容过滤器

```javascript
:contains(text) 匹配包含给定文本的元素
:empty 匹配所有不包含子元素或者文本的空元素
:parent 匹配含有子元素或者文本的元素
:has(selector) 匹配含有选择器所匹配的元素的元素
/**匹配带有某个子元素的父元素**/
```

## 属性过滤器：

```javascript
[attribute] 匹配包含给定属性的元素。
[attribute=value] 匹配给定的属性是某个特定值的元素
[attribute!=value] 匹配所有不含有指定的属性，或者属性不等于特定值的元素。
[attribute^=value] 匹配给定的属性是以某些值开始的元素
[attribute$=value] 匹配给定的属性是以某些值结尾的元素
[attribute*=value] 匹配给定的属性是以包含某些值的元素
[attrSel1][attrSel2][attrSelN] 复合属性选择器，需要同时满足多个条件时使用。
```

## 表单过滤器:

```javascript
:input 匹配所有input, textarea, select 和button 元素
:text 匹配所有文本输入框
:password 匹配所有的密码输入框
:radio 匹配所有的单选框
:checkbox 匹配所有的复选框
:submit 匹配所有提交按钮
:image 匹配所有img 标签
:reset 匹配所有重置按钮
:button 匹配所有input type=button <button>按钮
:file 匹配所有input type=file 文件上传
:hidden 匹配所有不可见元素display:none 或input type=hidden

/*jQuery对象.each(functuin(){
//遍历jQuery对象,以dom对象的方式
this表示当前正在遍历的dom对象
})*/
```

### 表单对象属性过滤器：

```javascript
:enabled 匹配所有可用元素
:disabled 匹配所有不可用元素
:checked 匹配所有选中的单选，复选，和下拉列表中选中的option 标签对象
:selected 匹配所有选中的option
```

## jQuery 元素筛选

元素的筛选都是方法

```
格式：
$(参数).某个方法
```

```
eq() 获取给定索引的元素                                                        功能跟:eq() 一样
first() 获取第一个元素                                                         功能跟:first 一样
last() 获取最后一个元素                                                        功能跟:last 一样
filter(exp) 留下匹配的元素
is(exp) 判断是否匹配给定的选择器，只要有一个匹配就返回，true
has(exp) 返回包含有匹配选择器的元素的元素                                      功能跟:has 一样
not(exp) 删除匹配选择器的元素                                                  功能跟:not 一样
children(exp) 返回匹配给定选择器的子元素                                       功能跟parent>child 一样
find(exp) 返回匹配给定选择器的后代元素                                         功能跟ancestor descendant 一样
next() 返回当前元素的下一个兄弟元素                                            功能跟prev + next 功能一样
nextAll() 返回当前元素后面所有的兄弟元素                                       功能跟prev ~ siblings 功能一样
nextUntil() 返回当前元素到指定匹配的元素为止的后面元素
parent() 返回父元素
prev(exp) 返回当前元素的上一个兄弟元素
prevAll() 返回当前元素前面所有的兄弟元素
prevUnit(exp) 返回当前元素到指定匹配的元素为止的前面元素
siblings(exp) 返回所有兄弟元素
add() 把add 匹配的选择器的元素添加到当前jquery 对象中
```

## jQuery 的属性操作

```javascript
html() 它可以设置和获取起始标签和结束标签中的内容。跟dom 属性innerHTML 一样。
text() 它可以设置和获取起始标签和结束标签中的文本。跟dom 属性innerText 一样。
val() 它可以设置和获取表单项的value 属性值。跟dom 属性value 一样
attr() 可以设置和获取属性的值，不推荐操作checked、readOnly、selected、disabled 等等
        attr 方法还可以操作非标准的属性。比如自定义属性：abc,bbj
prop() 可以设置和获取属性的值,只推荐操作checked、readOnly、selected、disabled 等等

/**
HTML代码/文本/值
html([val|fn])    a.html()取出a的html值    a.html(val)  让a的html值变为val
text([val|fn]) 	  a.text()取出a的text值    a.text(val)  让a的文本值变为val
val([val|fn|arr]) a.val()  取出a的val值（input）   a.val(v)  设置a的value值为v 

属性
attr(name|pro|key,val|fn)  
 1、a.attr('name')取出a的name值   2、a.attr("name","username")把a的name值设置为username
 
 
removeAttr(name) 
a.removeAttr('class')    移除a的class属性


prop(name|pro|key,val|fn)1.6+ 
1、a.prop('id')  取出a的id值   2、a.prop('id',"bj")  设置a的id值为bj
removeProp(name)1.6+
a.removeProp('class') 移除a的class属性


 
 */
```

**val 方法同时设置多个表单项的选中状态：**

```javascript
/*
// 批量操作单选
$(":radio").val(["radio2"]);//获取单选列表jQuery对象
// 批量操作筛选框的选中状态
$(":checkbox").val(["checkbox3","checkbox2"]);//获取多选列表jQuery对象
// 批量操作多选的下拉框选中状态
$("#multiple").val(["mul2","mul3","mul4"]);//获取下拉列表jQuery对象
// 操作单选的下拉框选中状态
$("#single").val(["sin2"]);

//综合操作,将上述操作批量执行
	$(":radio",":checkbox","#multiple","#single").//前面元素的顺序与后面要设置的值的顺序可以不对应
	val(["radio2","checkbox3","checkbox2","mul2","mul3","mul4","sin2"])

*/
在一个事件的function函数中，有一个this对象，这个this对象就是当前正在响应事件的dom对象（事件绑定的元素）
当前this对象只指向当前响应函数
```

### DOM（节点元素）的增删改

```
appendTo() a.appendTo(b) 把a 插入到b 子元素末尾，成为最后一个子元素
prependTo() a.prependTo(b) 把a 插到b 所有子元素前面，成为第一个子元素
外部插入：
insertAfter() a.insertAfter(b) 得到ba
insertBefore() a.insertBefore(b) 得到ab
替换:
replaceWith() a.replaceWith(b) 用b 替换掉a
replaceAll() a.replaceAll(b) 用a 替换掉所有b
删除：
remove() a.remove(); 删除a 标签
empty() a.empty(); 清空a 标签里的内容
```

## CSS 样式操作

```
addClass() 添加样式
removeClass() 删除样式
toggleClass() 有就删除，没有就添加样式。
offset() 获取和设置元素的坐标。
```

## jQuery 动画

```
基本动画
show() 将隐藏的元素显示
hide() 将可见的元素隐藏。
toggle() 可见就隐藏，不可见就显示。
以上动画方法都可以添加参数。
1、第一个参数是动画执行的时长，以毫秒为单位
2、第二个参数是动画的回调函数(动画完成后自动调用的函数)

淡入淡出动画
fadeIn() 淡入（慢慢可见）
fadeOut() 淡出（慢慢消失）
fadeTo() 在指定时长内慢慢的将透明度修改到指定的值。0 透明，1 完成可见，0.5 半透明
fadeToggle() 淡入/淡出切换
```

## jQuery 事件操作

$( function(){} );
和
window.onload = function(){}
的区别？
**他们分别是在什么时候触发？**

```
1、jQuery 的页面加载完成之后是浏览器的内核解析完页面的标签创建好DOM 对象之后就会马上执行。
2、原生js 的页面加载完成之后，除了要等浏览器内核解析完标签创建好DOM 对象，还要等标签显示时需要的内容加载完成。
```

**他们触发的顺序？**

```
1、jQuery 页面加载完成之后先执行
2、原生js 的页面加载完成之后
```

**他们执行的次数？**

```
1、原生js 的页面加载完成之后，只会执行最后一次的赋值函数。
2、jQuery 的页面加载完成之后是全部把注册的function 函数，依次顺序全部执行。
```

**jQuery 中其他的事件处理方法：**

```
click() 它可以绑定单击事件，以及触发单击事件   注：视频p87
mouseover() 鼠标移入事件
mouseout() 鼠标移出事件
bind() 可以给元素一次性绑定一个或多个事件。
one() 使用上跟bind 一样。但是one 方法绑定的事件只会响应一次。
unbind() 跟bind 方法相反的操作，解除事件的绑定//（参数是解除的事件，空参代表全部解除）
live() 也是用来绑定事件。它可以用来绑定选择器匹配的所有元素的事件。哪怕这个元素是后面动态创建出来的也有效
```

**事件的冒泡**

```
什么是事件的冒泡？
事件的冒泡是指，父子元素同时监听同一个事件。当触发子元素的事件的时候，同一个事件也被传递到了父元素的事件里去响应。
那么如何阻止事件冒泡呢？
在子元素事件函数体内，return false; 可以阻止事件的冒泡传递。
```

**javaScript 事件对象**

```
事件对象，是封装有触发的事件信息的一个javascript 对象。
我们重点关心的是怎么拿到这个javascript 的事件对象。以及使用。
如何获取呢javascript 事件对象呢？
在给元素绑定事件的时候，在事件的function(event) 参数列表中添加一个参数，这个参数名，我们习惯取名为event。
这个event 就是javascript 传递参事件处理函数的事件对象。
```

```
//1.原生javascript 获取事件对象
window.onload = function () {
document.getElementById("areaDiv").onclick = function (event) {
console.log(event);
}
}
//2.jQuery 代码获取事件对象
$(function () {
$("#areaDiv").click(function (event) {
console.log(event);
});
});
//3.使用bind 同时对多个事件绑定同一个函数。怎么获取当前操作是什么事件。
$("#areaDiv").bind("mouseover mouseout",function (event) {
if (event.type == "mouseover") {
console.log("鼠标移入");
} else if (event.type == "mouseout") {
console.log("鼠标移出");
}
});
```
