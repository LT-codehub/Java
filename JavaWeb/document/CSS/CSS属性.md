
###CSS演示属性属性
####背景属性
背景属性用于定义HTML元素的背景
* `background`系列属性-背景色，背景图片，背景图片是否重复，背景图片位置
####字体属性
字体属性定义字体，加粗，大小，文字样式
* `font`系列属性-字体颜色，字体大小，字体加粗，字体倾斜
####文本属性
文本属性定义文本的外观，文本颜色，文本对齐方式，文本缩进，行高，文本装饰
* `color`-设置文本颜色
* `text-decoration`-设置文本下划线
* `text-align`-设置文本对齐方式
* `line-height`-设置文本行高
* `letter-spacing`-设置文本字符间距
* `word-spacing`-设置文本单词间距
* `text-indent`-设置文本首行缩进
* `vertical-align`-设置文本垂直对齐方式
####边框属性
* `border`系列属性-边框宽度，边框样式，边框颜色
* `outline`系列属性-设置边框轮廓
* `box-shadow`-设置边框阴影
####列表属性

* `list`系列属性-设置列表项标记类型
####尺寸属性
* `width`-设置宽度
* `height`-设置高度
* `margin`-设置外边距
* `padding`-设置内边距
* `box-sizing`-设置盒模型计算方式
* `box-shadow`-设置盒模型阴影
####伪类样式
CSS伪类是用来添加一些选择器的特殊效果
```css
/*伪类的语法：*/
selector:pseudo-class {property:value;}
/*CSS类也可以使用伪类：*/
selector.class:pseudo-class {property:value;}
```
#####连接的伪类样式
不同状态的链接可以有不同的样式
* `a`系列属性-设置超链接的样式
* `a:link` - 正常，未访问过的链接的样式
* `a:visited` - 用户已访问过的链接的样式
* `a:hover` - 当用户鼠标放在链接上时的样式
* `a:active` - 链接被点击的那一刻的样式
#####结构伪类样式
* `:first-child` - 选择第一个子元素
* `:last-child` - 选择最后一个子元素
* `:nth-child(n)` - 选择第n个子元素
* `:nth-last-child(n)` - 选择倒数第n个子元素
* `:only-child` - 选择只有一个子元素的元素
* `:first-of-type` - 选择某个类型的第一个元素
* `:last-of-type` - 选择某个类型的最后一个元素
* `:nth-of-type(n)` - 选择某个类型的第n个元素
####透明度
* `opacity`-设置透明度，(0~1，0为完全透明，1为完全显示)
###CSS单位
* `px`-像素，绝对单位，页面按精确像素展示，1px = 1/96in
* `em`-相对于父元素字体大小的单位，1em = 父元素字体大小
* `rem`-相对于根元素字体大小的单位，1rem = 根元素字体大小
* `%`-相对于父元素宽度的百分比
* `vw`-视口宽度的百分比，1vw = 1%
* `vh`-视口高度的百分比，1vh = 1%
