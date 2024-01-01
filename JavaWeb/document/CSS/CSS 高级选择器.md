
#高级选择器

##关系选择器
关系选择器用于选择与指定元素有某种特定`关系`的元素。

| 选择器类型 | 名称|示例 | 描述 |
| :---: | :---: | :---: | :--- |
| E F |包含选择器 | `p > strong`  | 选择匹配的strong元素，且匹配的strong元素被包含在匹配的p元素内 |
| E > F| 子选择器 | `ul li > a` | 选择匹配的a元素，且匹配的a元素是匹配的li元素的子元素 |
| E + F |相邻选择器 | `p + strong` | 选择匹配的strong元素，且匹配的strong元素紧位于匹配的p元素后面 |
| E ~ F |兄弟选择器 | `li ~ li` | 选择匹配的li元素，且位于匹配的li元素后的所有匹配的li元素 |

```css
/* E F 包含选择器 */
p > strong {
  color: red;
}

/* E > F 子选择器 */
ul li > a {
  font-size: 14px;
}

/* E + F 相邻选择器 */
p + strong {
  margin-top: 10px;
}

/* E ~ F 兄弟选择器 */
li ~ li {
  margin-top: 10px;
}

```
##属性选择器
属性选择器可以`根据元素的属性及属性值`来选择元素。

| CSS选择器 | 解释 |
| --- | --- |
| E[attr] | 选择所有具有名为`attr`的属性值的元素。 |
| E[attr=val] | 选择所有具有名为`attr`的属性值等于`val`的元素。注意，`val`区分大小写。 |
| E[attr*=val] | 选择所有具有名为`attr`的属性值，并且该属性值包含字符串`val`的元素。换句话说，字符串`val`与属性值中的任意位置相匹配。 |
| E[attr^=val] | 选择所有具有名为`attr`的属性值，并且该属性值是以`val`开头的元素。 |
| E[attr$=val] | 选择所有具有名为`attr`的属性值，并且该属性值是以`val`结尾的元素。 |

**属性选择器可以设置多个属性，只要都能匹配到可以选择到想要的元素**

```css
/* 选择所有具有名为"class"的属性值的元素，并且该属性值等于"example"的元素 */
select.example {
  /* 样式 */
}

/* 选择所有具有名为"id"的属性值的元素，并且该属性值等于"my-element"的元素 */
div#my-element {
    /* 样式 */
}

/* 选择所有具有名为"href"的属性值的元素，并且该属性值以"https://example.com"开头的元素 */
a[href^="https://example.com"] {
    /* 样式 */
}

/* 选择所有具有名为"data-*"的属性值的元素，并且该属性值等于"true"的元素 */
div[data-my-attribute="true"] {
    /* 样式 */
}

/* 选择具有名为"class"的属性值的元素，并且该属性值等于"example"或"other-example"的元素 */
select.example, select.other-example {
    /* 样式 */
}

/* 选择所有具有名为"id"的属性值的元素，并且该属性值等于"my-element"或"other-element"的元素 */
div#my-element, div#other-element {
    /* 样式 */
}

/* 选择所有具有名为"href"的属性值的元素，并且该属性值以"https://example.com"或"https://other-example.com"开头的元素 */
a[href^="https://example.com"], a[href^="https://other-example.com"] {
    /* 样式 */
}

/* 选择所有具有名为"data-*"的属性值的元素，并且该属性值等于"true"或"false"的元素 */
div[data-my-attribute="true"], div[data-my-attribute="false"] {
    /* 样式 */
}

```
##伪类选择器

| 选择器           | 描述                                                                                   |
| ---------------- | -------------------------------------------------------------------------------------- |
| `:before`        | **在对应元素前方插入一个伪元素，通常用于添加装饰性元素或样式。**                          |
| `:after`         | **在对应元素后方插入一个伪元素，通常用于添加装饰性元素或样式。**                          |
| `:first-child`   | 选择属于父元素的第一个指定的子元素，与指定的选择器匹配。                               |
| `:last-child`    | 选择属于父元素的最后一个指定的子元素，与指定的选择器匹配。                               |
| `:nth-child(n)`  | 选择属于父元素的指定位置的指定的子元素，与指定的选择器匹配。                             |
| `:nth-of-type(n)` | 选择属其父元素指定的元素指定位置的子元素，与指定的选择器匹配。                            |

```css
/* 鼠标悬停时改变链接颜色 */
a:hover {
  color: red;
}

/* 按钮被点击时改变背景颜色 */
button:active {
  background-color: green;
}

/* 输入框获取焦点时改变边框颜色 */
input:focus {
  border-color: blue;
}

/* 第一个列表项加粗 */
ul li:first-child {
  font-weight: bold;
}

/* 最后一个段落文字颜色设置为紫色 */
div p:last-child {
  color: purple;
}

/* 第二个列表项字体样式设置为斜体 */
ul li:nth-child(2) {
  font-style: italic;
}

/* 奇数位置的列表项背景色设置为淡灰色 */
ul li:nth-of-type(odd) {
  background-color: lightgray;
}

/* 不带类名 ".special" 的段落字体大小设置为16像素 */
p:not(.special) {
  font-size: 16px;
}

```
##组合选择器
组合选择器是多个选择器通过不同的方式组合起来，以达到更加精确的选择目标。
组合选择器包括：


| 选择器        | 描述|
| ------------- |:-------------:|
| `.container .item:nth-child(2)` | **选择属于父元素 `.container` 下的第2个元素，且属于 `.item` 元素。** |
| `.container .item:nth-child(3)` | **选择属于父元素 `.container` 下的第3个元素，且属于 `.item` 元素。** |
| `.container .item:nth-child(n)` | **选择属于父元素 `.container` 下的第n个元素，且属于 `.item` 元素。** |
| `.container .item:nth-of-type(n)` | **选择属于父元素 `.container` 下的第n个 `.item` 元素，且属于 `.item` 元素。** |
| `.container .item:first-child` | **选择属于父元素 `.container` 下的第一个 `.item` 元素。** |
| `.container .item:last-child` | **选择属于父元素 `.container` 下的最后一个 `.item` 元素。** |
| `.container .item:only-child` | **选择属于父元素 `.container` 下的仅一个的 `.item` 元素。** |
| `.container .item:nth-last-child(n)` | **选择属于父元素 `.container` 下的第n个 `.item` 元素，且属于 `.item` 元素。** |
| `.container .item:nth-of-type(n)` | **选择属于父元素 `.container` 下的第n个 `.item` 元素，且属于 `.item` 元素。** |
| `.container .item:first-of-type` | **选择属于父元素 `.container` 下的第一个 `.item` 元素。** |
| `.container .item:last-of-type` | **选择属于父元素 `.container` 下的最后一个 `.item` 元素。** |
| `.container .item:only-of-type` | **选择属于父元素 `.container` 下的仅一个的 `.item` 元素。** |
| `.container .item:empty` | **选择属于父元素 `.container` 下的所有为空的 `.item` 元素。** |
| `.container .item:target` | **选择所有被点击的元素。** |
| `.container .item:not(.item)` | **选择所有不是 `.item` 元素的元素。** |
| `.container .item:enabled` | **选择所有可用元素。** |
| `.container .item:disabled` | **选择所有不可用元素。** |
| `.container .item:checked` | **选择所有被选中的元素。** |
| `.container .item:default` | **选择所有元素默认值。** |
| `.container .item:lang(en)` | **选择所有语言为 `en` 的元素。** |
| `.container .item:nth-child(2n)` | **选择所有偶数位置的元素。** |
| `.container .item:nth-child(2n+1)` | **选择所有奇数位置的元素。** |

```html
<div class="container">
  <div class="item">1</div>
  <div class="item">2</div>
  <div class="item">3</div>
  <div class="item">4</div>
  <div class="item">5</div>
</div>
```

```css
/* 组合选择器 */
.container .item:nth-child(2) {
  color: red;
}

.container .item:nth-child(3) {
  color: blue;
}

.container .item:nth-child(4) {
  color: green;
}

.container .item:nth-child(5) {
  color: yellow;
}
```



##选择器的权重

| 类型                          | 千位数 | 百位数 | 十位数 | 个位数 |
| ----------------------------- | :------: | :------: | :------: | :------: |
| 行内样式（内联样式）        | 1      | 0      | 0      | 0      |
| ID选择器                     | 0      | 1      | 0      | 0      |
| 类选择器                     | 0      | 0      | 1      | 0      |
| 元素和伪元素选择器           | 0      | 0      | 0      | 1      |
| 通配符、子选择器、相邻选择器 | 0      | 0      | 0      | 0      |
| 关系选择器                   | 0      | 0      | 0      | 0      |

###权重生效规则
* 对于一个选择器序列，从左到右将其权重相加，得到总权重。
* 如果有多个选择器序列具有相同的总权重，那么后面定义的规则将覆盖先前定义的规则。
###权重比较规则
* 第一等：代表内联样式，如: style=””，权值为1000
* 第二等：代表ID选择器，如：#content，权值为0100
* 第三等：代表类，伪类和属性选择器，如.content，权值 为0010
* 第四等：代表元素和伪元素选择器如div p，权值为0001
* 通配符、子选择器、相邻选择器等如`*`、`>`、`+`,权值为 0000

继承的样式没有权值
```css
/* 基本选择器示例 - 元素选择器 */
div {
  color: red; /* 权重：1 (D) */
}

/* 类选择器和元素选择器的组合 */
.myClass p {
  font-weight: bold; /* 权重：10 (C) + 10 (C) = 20 */
}

/* ID选择器示例 */
#myElement {
  background-color: yellow; /* 权重：100 (B) */
}

/* 组合选择器示例 - 包含元素选择器、ID选择器和类选择器 */
div#myElement.myClass p {
  color: blue; /* 权重：1 (D) + 100 (B) + 10 (C) = 111 */
}

/* 行内样式示例 - 具有最高权重 */
<div style="font-size: 18px;">This is a div with inline style.</div>

```