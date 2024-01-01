#文档流
##标准文档流

###什么是标准文档流

标准文档流指的是浏览器根据元素在html中的位置，自动计算元素的位置，并且元素之间不需要手动设置margin、padding、border等属性，就可以实现元素之间的水平垂直居中。

###标准文档流的分类

1. 块级元素
2. 行内元素

###块级元素

块级元素在页面中以块的形式展现，会独占一行，可以设置width、height、margin、padding、border等属性，并且可以设置margin和padding的左右值，但是不能设置margin和padding的上下值，否则上下值会失效。
```html
<div>行级元素默认从左到右流动排列</div>
<p>不能设置宽高；可以并排</p>
```
1. 块级元素独占一行，从上向下排列
2. 块级元素可以设置width、height、margin、padding、border等属性
3. 块级元素可以设置margin和padding的左右值，但是不能设置margin和padding的上下值，否则上下值会失效
###行内元素

行内元素在页面中以行内形式展现，不会独占一行，不可以设置width、height、margin、padding、border等属性，并且可以设置margin和padding的上下左右值。
```html
<span>块级元素独占一行，并按照从上到下的方式排列</span>
<a>能够设置宽高；不能并排；不设置宽高的情况下默认为父级的宽高</a>
```
1. 行内元素在一行中，从左向右排列
2. 行内元素不可以设置width、height、margin、padding、border等属性
3. 行内元素可以设置margin和padding的上下左右值
###块级元素和行内元素的区别

   块级元素会独占一行，可以设置width、height、margin、padding、border等属性，并且可以设置margin和padding的左右值，但是不能设置margin和padding的上下值，否则上下值会失效。

   行内元素在页面中以行内形式展现，不会独占一行，不可以设置width、height、margin、padding、border等属性，并且可以设置margin和padding的上下左右值。

###行内块元素
```html
<div style="display: inline-block;">div元素</div>
<p style="display: inline-block;">p元素</p>
```

   行内块元素在页面中以行内块的形式展现，会独占一行，不可以设置width、height、margin、padding、border等属性，并且可以设置margin和padding的上下左右值。


###标准文档流布局的缺点

1. 块级元素独占一行，从上向下排列，如果块级元素之间没有设置margin值，则块级元素之间会重叠在一起。
2. 行内元素在一行中，从左向右排列，如果行内元素之间没有设置margin值，则行内元素之间会重叠在一起。
3. 行内块元素在一行中，从左向右排列，但是可以设置width、height、margin、padding、border等属性，并且可以设置margin和padding的上下左右值。
##脱离文档流
* float属性：设置元素浮动，脱离文档流，浮动在标准文档流的上方。
* clear属性：设置元素清除浮动，清除浮动元素上面的浮动元素。
* overflow属性：设置元素超出内容部分是否显示，设置为hidden时，超出内容部分不显示。
* display属性：
  * none：隐藏元素，不显示元素，并且不占据标准文档流的位置。
  * block：将元素设置为块级元素，独占一行，可以设置width、height、margin、padding、border等属性，并且可以设置margin和padding的左右值，但是不能设置margin和padding的上下值，否则上下值会失效。
  * inline：将元素设置为行内元素，在页面中以行内形式展现，不可以设置width、height、margin、padding、border等属性，并且可以设置margin和padding的上下左右值。
  * inline-block：将元素设置为行内块元素，在页面中以行内块的形式展现，会独占一行，不可以设置width、height、margin、padding、border等属性，并且可以设置margin和padding的上下左右值。
* position属性

###浮动流布局
通过设置float的值，可以改变元素的浮动流布局，float的值有left、right、none。

1. 浮动元素会脱离标准文档流，浮动在标准文档流的上方。
2. 浮动元素根据父容器的长度自动换行，从左向右排列，如果浮动元素之间没有设置margin值，则浮动元素之间会重叠在一起。
3. 浮动元素设置width、height、margin、padding、border等属性，并且可以设置margin和padding的上下左右值。
4. **浮动元素会覆盖后面的元素，但不会影响前面元素的布局。浮动主要用于文字环绕图片或者创建多列布局等场景**
```html
<div style="float: left;">div元素</div>
<p style="float: left;">p元素</p>
```
###定位流布局
通过设置position的值，可以改变元素的定位流布局，position的值有三种：
**定位元素会覆盖前面的元素，但不会影响后面元素的布局**

1. static：默认值，元素在标准文档流中，不脱离标准文档流。
2. relative：相对定位流布局，元素在标准文档流中，不脱离标准文档流，并且可以设置top、left、right、bottom等属性，设置top、left、right、bottom等属性后，元素会根据设置的值进行偏移。
3. absolute：绝对定位流布局，元素会脱离标准文档流，并且可以设置top、left、right、bottom等属性，设置top、left、right、bottom等属性后，元素会根据设置的值进行偏移。
4. fixed：固定定位，元素会相对于视口进行定位，无论页面滚动如何，元素都保持在相同的位置，也会覆盖前面的元素但不会影响其他元素的布局
5. sticky：粘性定位，元素在特定的滚动位置变为固定定位，之前会相对于正常文档流进行布局，但在滚动到某个位置后会固定在指定位置。

###定位流布局的原理
* 元素脱离文档流：

1. 定位元素脱离了正常文档流，不再影响其他元素的位置和布局。
2. 定位元素不为其兄弟元素留下空间，这可能导致元素重叠或覆盖。
* 精确定位：

1. 定位元素可以使用top、right、bottom、left属性来精确确定其位置，无论包含块或其他元素的位置如何。
2. 这允许开发人员精确控制元素的放置，从而实现特定的设计效果。
* 层叠顺序：

1. 定位元素的层叠顺序（z-index）可以控制元素的叠放顺序，允许某些元素覆盖其他元素。
2. 这对于创建浮动窗口、模态框、弹出菜单等非常有用。
* 不影响周围元素：

1. 定位元素不会对周围元素的布局产生影响，这使得页面布局的局部修改变得相对容易。
2. 但需要小心确保不会引起元素重叠或遮挡问题。
```html
<div style="position: absolute;">div元素</div>
<p style="position: absolute;">p元素</p>
```

##相对定位流布局
通过设置position属性为relative，可以实现相对定位流布局。

* 元素的位置是相对于元素在文档流中的初始位置来确定的。
* 相对定位的元素仍然占据着文档流中的位置，但可以通过使用top、right、bottom、left属性来微调其位置，不会影响其他元素的布局。
* 使用属性position: relative;来定义元素的相对定位。

相对定位的特点
1. 相对定位的元素仍然会占据原来的位置，但可以通过使用top、right、bottom、left属性来微调其位置，不会影响其他元素的布局。
```html
<div style="position: relative;">div元素</div>
<p style="position: relative;">p元素</p>
```


##绝对定位流布局
通过设置元素的position属性为absolute，可以实现绝对定位流布局。

* 元素的位置是相对于最接近的已定位（非static）祖先元素来确定的。如果没有已定位的祖先元素，则相对于文档的初始包含块（viewport）来确定位置。
* 绝对定位的元素脱离了文档流，不会影响其他元素的位置，其他元素也不会影响它。 
* 使用属性position: absolute;来定义元素的绝对定位，通常还需要使用top、right、bottom、left属性来具体指定元素在参考点上的偏移值。
```html
<div style="position: absolute;">div元素</div>
<p style="position: absolute;">p元素</p>
```

###相对定位和绝对定位的区别
主要区别在于绝对定位的元素脱离了文档流，不影响其他元素的位置，而相对定位的元素仍然占据文档流中的位置，可以通过微调位置来影响自身的布局，但不会影响其他元素。选择使用哪种定位方式通常取决于具体的设计需求和布局效果。

1. 相对定位的元素不会脱离标准文档流，而绝对定位的元素会脱离标准文档流。
2. 相对定位的元素仍然会占据标准文档流中的位置，而绝对定位的元素不会占据标准文档流中的位置。
3. 相对定位的元素可以通过设置margin、padding、border等属性来调整位置，而绝对定位的元素只能通过设置top、left、right、bottom等属性来调整位置。
4. 相对定位的元素可以通过设置z-index属性来调整元素在标准文档流中的层次，而绝对定位的元素不能通过设置z-index属性来调整元素在标准文档流中的层次。
5. 相对定位的元素可以通过设置float属性来调整元素在标准文档流中的层次，而绝对定位的元素不能通过设置float属性来调整元素在标准文档流中的层次。

#总结：

* 浮动用于创建多列布局和文字环绕效果，影响文档流中的其他元素的位置。
* 相对定位用于微调元素的位置，不会影响其他元素的位置。
* 绝对定位用于精确定位元素，脱离文档流，不影响其他元素的位置。选择使用哪种方法通常取决于具体的设计需求和布局效果。