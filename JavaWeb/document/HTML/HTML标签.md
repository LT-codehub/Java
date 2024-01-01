##标题标签
`h1-h6`一共六级标题
```html
<h1>一级标题</h1>
<h2>二级标题</h2>
<h3>三级标题</h3>
<h4>四级标题</h4>
<h5>五级标题</h5>
<h6>六级标题</h6>
```
* 注意：标题标签前后有换行。

##段落标签
```html
<p>段落标签</p>
```
* 注意：标题标签前后有换行。
###换行
```html
<br>
```
###分割线
```html
<hr>
```
##文本格式化
文本格式化是指通过标签来直接格式化文本，比如加粗、倾斜、下划线等。
```html
<b>这个文本是加粗的</b>
<strong>这个文本是加粗的</strong>
<big>这个文本字体放大</big>
<em>这个文本是斜体的</em>
<i>这个文本是斜体的</i>
<small>这个文本是缩小的</small>
这个文本包含
<sub>下标</sub>
这个文本包含
<sup>上标</sup>

```
##超链接
```html
<a href="https://www.baidu.com">点我跳转到下一个页面</a>
```
* `href`：指定链接目标的URL，这是链接的最重要属性。可以是另一个网页的URL、文件的URL或其他资源的URL。
* `target`（可选）：指定链接如何在浏览器中打开。
  * _blank（在新标签或窗口中打开链接）
  * _self（在当前标签或窗口中打开链接）
  * _parent（在父窗口中打开链接）
* `title`（可选）：提供链接的额外信息，通常在鼠标悬停在链接上时显示为工具提示。
* `rel`（可选）：指定与链接目标的关系，如 nofollow、noopener 等。
###超链接实例
* 文本链接：最常见的链接类型是文本链接，它使用`<a>元素`将一段文本转化为可点击的链接，例如：
```html
<a href="https://www.example.com">访问示例网站</a>
```
* 图像链接：您还可以使用图像作为链接。在这种情况下，`<a>元素`包围着 `<img>元素`。例如：
```html
<a href="https://www.example.com">
  <img decoding="async" src="example.jpg" alt="示例图片">
</a>
```
* 锚点链接：除了链接到其他网页外，您还可以在同一页面内创建内部链接，这称为锚点链接。
  要创建锚点链接，需要在目标位置使用`<a>元素`定义一个标记，并使用#符号引用该标记。例如：
```html
<a href="#section2">跳转到第二部分</a>
<!-- 在页面中的某个位置 -->
<a name="section2"></a>
```
* 下载链接：如果您希望链接用于下载文件而不是导航到另一个网页，可以使用 download 属性。 例如：
```html
<a href="document.pdf" download>下载文档</a>
```
###路径
* 相对路径
    * 相对路径都是以`当前位置`为基准来表示的
    * 相对路径的写法：
        * 同级：`./`
        * 下一级：`../`
        * 上一级：`../`
绝对路径
    * 绝对路径是以`根目录`为基准来表示的
    * 在Web项目中根目录是webapp目录|web目录
##列表    
###无序列表
```html
<ul>
    <li>列表项1</li>
    <li>列表项2</li>
    <li>列表项3</li>
</ul>
```
###有序列表
```html
<ol>
    <li>列表项1</li>
    <li>列表项2</li>
    <li>列表项3</li>
</ol>
```        
##图片
```html
<img src="图片地址"
     alt="图片描述(当图片无法加载时显示)"
     width="图片宽度"
     height="图片高度"
     title="鼠标悬停时显示的提示信息"
     border="图片边框"
     align="图片对齐方式"
     name="图片名称"/>
```
##表格
* HTML 表格由 `<table> 标签`来定义。
* tr：`<tr> 标签`是 table row 的缩写，表示表格的一行。
* td：`<td> 标签`是 table data 的缩写，表示表格的数据单元格。
* th：`<th> 标签`是 table header的缩写，表示表格的表头单元格。

* `<caption> 标签`用于为表格定义标题：
* `<thead> 标签`用于定义表格的标题部分: 在 `<thead>` 中，使用`<th>`元素定义列的标题
* `<tbody> 标签`用于定义表格的主体部分: 在 `<tbody>` 中，使用`<tr>`元素定义行，并在每行中使用`<td>`元素定义单元格数据--**(可以省略)**
```html
<table border="1">
    <caption>表格标题</caption>
    <thead>
    <tr>
        <th>列标题1</th>
        <th>列标题2</th>
        <th>列标题3</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>行1，列1</td>
        <td>行1，列2</td>
        <td>行1，列3</td>
    </tr>
    <tr>
        <td>行2，列1</td>
        <td>行2，列2</td>
        <td>行2，列3</td>
    </tr>
    </tbody>
</table>
```
###跨行和跨列
```html
<table>
    <tr> <td colspan="跨列数">…</td> </tr>
    <tr> <td rowspan="跨行数">…</td> </tr>
</table>
```

##块
`块`并不是为了显示文章内容的，而是为了方便结合CSS对页面`进行布局`  
* 块有两种
  * div是块级元素`前后有换行`,，它可用于组合其他 HTML 元素的容器
  * span是内联元素`前后没有换行`，可用作文本的容器

```html
<div style="border: 1px solid black;width: 100px;height: 100px;">This is a div block</div>
<div style="border: 1px solid black;width: 100px;height: 100px;">This is a div block</div>

<span style="border: 1px solid black;width: 100px;height: 100px;">This is a span block</span>
<span style="border: 1px solid black;width: 100px;height: 100px;">This is a span block</span>
```
* HTML区块元素：块级元素在浏览器显示时，通常会以新行来开始（和结束）
    * `<h1>`, `<p>`, `<ul>`, `<table>`
* HTML内联元素：内联元素在显示时通常不会以新行开始。
    * `<b>`, `<td>`, `<a>`, `<img>`
##HTML实体
在HTML文件中，<、>等等这样的符号已经被赋予了特定含义，不会作为符号本身显示到页面上，此时如果我们想使用符号本身怎么办呢？
**那就是使用HTML实体来转义。**

