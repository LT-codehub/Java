#`<script> 标签`
`<script>` 标签用于定义客户端脚本，比如 JavaScript。
```html
<script type="text/javascript">
  document.write("Hello World!")
</script>
```
`<script>`元素既可包含脚本语句，也可通过 src 属性指向外部脚本文件。

script.js文件：
```js
document.write("Hello World!")
```

```html
<script src="script.js"></script>
```
JavaScript 最常用于图片操作、表单验证以及内容动态更新。

#`<noscript> 标签`
* `<noscript>标签`提供无法使用脚本时的替代内容，比方在浏览器禁用脚本时，或浏览器不支持客户端脚本时。
* `<noscript>元素`可包含普通 HTML 页面的 body 元素中能够找到的所有元素。
* 只有在浏览器不支持脚本或者禁用脚本时，才会显示 <noscript> 元素中的内容：

```html
<script>
    document.write("Hello World!")
</script>
<noscript>抱歉，你的浏览器不支持 JavaScript!</noscript>
```

##JavaScript实例代码
JavaScript可以直接在HTML输出:
```html
<script>
    document.write("<p>这是一个段落。</p>");
    alert("这是一个警告框。")
</script>
```
JavaScript事件响应:
```html
<script>
    function myFunction() {
        document.getElementById("demo").innerHTML = "这是一个点击事件";
    }
</script>
<button type="button" onclick="myFunction()">点我！</button>
```
JavaScript处理 HTML 样式:
```html
<script>
    document.getElementById("demo").style.color="#ff0000";
</script>
```