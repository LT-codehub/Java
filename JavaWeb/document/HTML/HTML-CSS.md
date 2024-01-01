#CSS
CSS 指层叠样式表 (Cascading Style Sheets),又称为风格样式表 (Style Sheet)
* 表现HTML或XHTML文件样式的计算机语言
* 包括对`字体`、`颜色`、`边距`、`高度`、`宽度`、`背景图片`、`网页定位`等设定  
CSS是在HTML4开始使用的,是为了更好的渲染HTML元素而引入的.
##CSS使用
CSS 可以通过以下方式添加到HTML中:

* 内联样式- 在HTML元素中使用`style`属性
```html
<h1 style="color:red;font-size:14px;">这是一个标题</h1>
```
* 内部样式表 -在HTML文档头部`<head>`区域使用`<style>元素`来包含CSS
```html
内部样式表
<style>
h1 {color:red;font-size:14px;}
</style>

<h1>这是一个标题</h1>
```
* 外部引用 - 使用`外部CSS文件`
  
mystyle.css文件：
```css
h1 {color:red;font-size:14px;}
```

```html
<link rel="stylesheet" type="text/css" href="mystyle.css">
<h1>这是一个标题</h1>
```
<font color="red">**最好的方式是通过外部引用CSS文件.**</font>