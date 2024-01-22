# JavaScript

```javascript
Javascript 语言诞生主要是完成页面的数据验证。因此它运行在客户端，需要运行浏览器来解析执行JavaScript 代码。
```

JS 是Netscape 网景公司的产品，最早取名为LiveScript;为了吸引更多java 程序员。更名为JavaScript。

**JS 是弱类型，Java 是强类型。**

1. 交互性（它可以做的就是信息的动态交互）
2. 安全性（不允许直接访问本地硬盘）
3. 跨平台性（只要是可以解释JS 的浏览器都可以执行，和平台无关）

### 与HTML结合的两种方式

```
使用script标签，在标签中书写js代码
```

```
使用script标签中的src属性，引入js文件
```

## 变量

```
数字类型：number
字符串类型：string
对象类型：object
布尔类型：boolean
函数类型：function


特殊值
undefined：未定义，所有js变量为赋值前的默认值都是undefined
null：空值
NAN：全称是： Not a Number 非数字，非数值
```

### 变量的定义

```
var 变量名;
var 变量名 = 值;
```

## 运算符

### 关系运算

```
等于： == 等于是简单的做字面值的比较
全等于： === 除了做字面值的比较之外，还会比较两个变量的数据类型
```

### 逻辑运算

```javascript
且运算： &&
或运算： ||
取反运算： !

/*在JavaScript 语言中，所有的变量，都可以做为一个boolean 类型的变量去使用。
0 、null、undefined、””(空串) 都认为是false；*/

/*
&& 且运算。
有两种情况：
第一种：当表达式全为真的时候。返回最后一个表达式的值。
第二种：当表达式中，有一个为假的时候。返回第一个为假的表达式的值
|| 或运算
第一种情况：当表达式全为假时，返回最后一个表达式的值
第二种情况：只要有一个表达式为真。就会把回第一个为真的表达式的值
并且&& 与运算和||或运算有短路。
短路就是说，当这个&&或||运算有结果了之后。后面的表达式不再执行
*/
```

## 数组

### 数组的定义

```javascript
var arr = [];/*定义一个空数组，此时length = 0*/
/*js语言中的数组可以自动扩容，当我们对空数组赋值时它就会自动扩容，
无论是使用下标赋值还是统一赋值都会改变数组的长度
arr[0] = 1;arr.length = 1;数组在赋值时被扩容了
```

## 函数

### 函数的定义

```javascript
//第一种方式
function 函数名(){函数体}
function 函数名(形参名){函数体}
function 函数名(形参名){函数体 return 返回值}

//第二种方式
var 函数名= function(形参列表) { 函数体}


// 定义一个无参函数
function fun(){
alert("无参函数fun()被调用了");
}
// 函数调用===才会执行
// fun();
function fun2(a ,b) {
alert("有参函数fun2()被调用了a=>" + a + ",b=>"+b);
}
// fun2(12,"abc");
// 定义带有返回值的函数
function sum(num1,num2) {
var result = num1 + num2;
return result;
}
/***注：在Java 中函数允许重载。但是在JS 中函数的重载会直接覆盖掉上一次的定义*/
```

#### 函数的隐形参数

```javascript
就是在function 函数中不需要定义，但却可以直接用来获取所有参数的变量。我们管它叫隐形参数。
隐形参数特别像java 基础的可变长参数一样。
public void fun( Object ... args );
可变长参数其他是一个数组。
那么js 中的隐形参数也跟java 的可变长参数一样。操作类似数组。
/**arguments会接收函数调用时传递过来的所有参数，无论函数定义是否为有形参
 * 例如：
 * function f(a,b){};
 * f(1,2,3,4,5,6);
 * 形参a会接收1：a = 1;
 * 形参b会接受2：b = 2;
 * arguments会接收 1,2,3,4,5,6：arguments = [1,2,3,4,5,6];*/


function fun(a) {
alert( arguments.length );//可看参数个数
alert( arguments[0] );
alert( arguments[1] );
alert( arguments[2] );
alert("a = " + a);
for (var i = 0; i < arguments.length; i++){
alert( arguments[i] );
}
alert("无参函数fun()");
}
// fun(1,"ad",true);
// 需求：要求编写一个函数。用于计算所有参数相加的和并返回
function sum(num1,num2) {
var result = 0;
for (var i = 0; i < arguments.length; i++) {
if (typeof(arguments[i]) == "number") {
result += arguments[i];
}
}
return result;
}
alert( sum(1,2,3,4,"abc",5,6,7,8,9) );
```

## 自定义对象

```javascript
对象的定义：
var 变量名= new Object();    // 对象实例（空对象）
变量名.属性名= 值;           // 定义一个属性
变量名.函数名= function(){}  // 定义一个函数

var obj = new objec();
obj.name = "张三";
obj.sex = "男";
obj.get = function(){
alert("姓名：" + this.name +"性别："+ this.sex);
}


对象的访问：
变量名.属性/ 函数名();
```

```javascript
对象的定义：
var 变量名= { // 空对象
属性名：值, // 定义一个属性
属性名：值, // 定义一个属性
函数名：function(){} // 定义一个函数
};
对象的访问：
变量名.属性/ 函数名();
```

## 事件

**什么是事件？事件是电脑输入设备与页面之间的交互的响应，被称为事件**

#### 常见的事件

```javascript
onload 加载完成事件：       //页面加载完成之后，常用于做页面js 代码初始化操作
onclick 单击事件：          //常用于按钮的点击响应操作。
onblur 失去焦点事件：       //常用用于输入框失去焦点后验证其输入内容是否合法。
onchange 内容发生改变事件： //常用于下拉列表和输入框内容发生改变后操作
onsubmit 表单提交事件：     //常用于表单提交前，验证所有表单项是否合法。
```

### 事件的注册

```
①静态注册事件：通过html 标签的事件属性直接赋于事件响应后的代码，这种方式我们叫静态注册。
②动态注册事件：是指先通过js 代码得到标签的dom 对象，然后再通过dom 对象.事件名= function(){} 这种形式赋于事件
响应后的代码，叫动态注册。
动态注册基本步骤：
1、获取标签对象
2、标签对象.事件名= fucntion(){}
```

#### onload

```html
<script type="text/javascript">
// onload 事件的方法
function onloadFun() {
alert('静态注册onload 事件，所有代码');
}
}
</script>

<!--静态注册onload 事件
onload 事件是浏览器解析完页面之后就会自动触发的事件
<body onload="onloadFun();">
-->



<script type="text/javascript">
// onload 事件动态注册。是固定写法
window.onload = function () {
alert("动态注册的onload 事件");
}
</script>

```

### onclick

```javascript
<head>
<meta charset="UTF-8">
<title>Title</title>
<script type="text/javascript">
function onclickFun() {
alert("静态注册onclick 事件");
}
// 动态注册onclick 事件
window.onload = function () {
// 1 获取标签对象
/*
* document 是JavaScript 语言提供的一个对象（文档）<br/>
* get 获取
* Element 元素（就是标签）
* By 通过。。由。。经。。。
* Id id 属性
*
* getElementById 通过id 属性获取标签对象
**/
var btnObj = document.getElementById("btn01");
// alert( btnObj );
// 2 通过标签对象.事件名= function(){}
btnObj.onclick = function () {
alert("动态注册的onclick 事件");
}
}
</script>
</head>
<body>
<!--静态注册onClick 事件-->
<button onclick="onclickFun();">按钮1</button>
<button id="btn01">按钮2</button>
</body>
```

### onblur

```javascript
// 静态注册失去焦点事件
function onblurFun() {
// console 是控制台对象，是由JavaScript 语言提供，专门用来向浏览器的控制器打印输出， 用于测试使用
// log() 是打印的方法
console.log("静态注册失去焦点事件");
}

body>
用户名:<input type="text" onblur="onblurFun();"><br/>
密码:<input id="password" type="text" ><br/>


// 动态注册onblur 事件
window.onload = function () {
//1 获取标签对象
var passwordObj = document.getElementById("password");
// alert(passwordObj);
//2 通过标签对象.事件名= function(){};
passwordObj.onblur = function () {
console.log("动态注册失去焦点事件");
}
}
```

### onchange

```javascript
function onchangeFun() {
alert("女神已经改变了");
}

<!--静态注册onchange 事件-->
<select onchange="onchangeFun();">
<option>--女神--</option>
<option>芳芳</option>
<option>佳佳</option>
<option>娘娘</option>
</select>


window.onload = function () {
//1 获取标签对象
var selObj = document.getElementById("sel01");
// alert( selObj );
//2 通过标签对象.事件名= function(){}
selObj.onchange = function () {
alert("男神已经改变了");
}
}
```

### onsubmit

```javascript
// 静态注册表单提交事务
function onsubmitFun(){
// 要验证所有表单项是否合法，如果，有一个不合法就阻止表单提交
alert("静态注册表单提交事件----发现不合法");
return flase;
}

<!--return false 可以阻止表单提交-->
<form action="http://localhost:8080" method="get" onsubmit="return onsubmitFun();">
<input type="submit" value="静态注册"/>
</form>



window.onload = function () {
//1 获取标签对象
var formObj = document.getElementById("form01");
//2 通过标签对象.事件名= function(){}
formObj.onsubmit = function () {
// 要验证所有表单项是否合法，如果，有一个不合法就阻止表单提交
alert("动态注册表单提交事件----发现不合法");
return false;
}
}
```

## DOM

DOM 全称是Document Object Model 文档对象模型
大白话，就是把文档中的标签，属性，文本，转换成为对象来管理。
那么它们是如何实现把标签，属性，文本转换成为对象来管理呢。这就是我们马上要学习的重点。

### Document 对象

```
Document 对象的理解：
第一点：Document 它管理了所有的HTML 文档内容。
第二点：document 它是一种树结构的文档。有层级关系。
第三点：它让我们把所有的标签都对象化
第四点：我们可以通过document 访问所有的标签对象。
```

![截图](695a47fdf64a0e7be09bbe467135cf4e.png)

### Document 对象中的方法介绍

```javascript
document.getElementById(elementId)
通过标签的id 属性查找标签dom 对象，elementId 是标签的id 属性值

document.getElementsByName(elementName)
通过标签的name 属性查找标签dom 对象，elementName 标签的name 属性值

document.getElementsByTagName(tagname)
通过标签名查找标签dom 对象。tagname 是标签名

document.createElement( tagName)
方法，通过给定的标签名，创建一个标签对象。tagName 是要创建的标签名

/***注：
document 对象的三个查询方法，如果有id 属性，优先使用getElementById 方法来进行查询
如果没有id 属性，则优先使用getElementsByName 方法来进行查询
如果id 属性和name 属性都没有最后再按标签名查getElementsByTagName
以上三个方法，一定要在页面加载完成之后执行，才能查询到标签对象。
*/
```

### 节点的常用属性和方法

```
方法：
通过具体的元素节点调用
getElementsByTagName()
方法，获取当前节点的指定标签名孩子节点
appendChild( oChildNode )
方法，可以添加一个子节点，oChildNode 是要添加的孩子节点
```

```
属性：
childNodes
属性，获取当前节点的所有子节点
firstChild
属性，获取当前节点的第一个子节点
lastChild
属性，获取当前节点的最后一个子节点
parentNode
属性，获取当前节点的父节点
nextSibling
属性，获取当前节点的下一个节点
previousSibling
属性，获取当前节点的上一个节点
className
用于获取或设置标签的class 属性值
innerHTML
属性，表示获取/设置起始标签和结束标签中的内容
innerText
属性，表示获取/设置起始标签和结束标签中的文本 
```