#IFRAME子窗口
iframes 标签规定一个内联框架，即一个内嵌的窗口。

## 语法

```html
<iframe src="demo_iframe.htm" width="200" height="200"></iframe>
```
## 属性

| 属性 | 值 | 描述 |
| :---: | :---: | :--- |
| src | URL | 规定在 iframe 中显示的文档的 URL。 |
| name | text | 规定 iframe 的名称。 |
| width | pixels | 规定 iframe 的宽度。 |
| height | pixels | 规定 iframe 的高度。 |
| frameborder | 0 或 1 | 规定是否显示 iframe 周围的边框。 |
| longdesc | URL | 规定一个 longer description for iframe 的 contents. |
| marginheight | pixels | 规定 iframe 周围的边框（上边框）的宽度。 |
| marginwidth | pixels | 规定 iframe 周围的边框（左边框）的宽度。 |
| scrolling | yes、no、auto | 规定是否在 iframe 中显示滚动条。 |
| allowtransparency | yes、no | 规定在 iframe 中是否允许透明。 |
| srcdoc | HTML | 规定作为 iframe 内容的 HTML 内容。 |
| sandbox | string | 规定一个 sandbox 属性，从而限制 iframe 的行为。 |

## 事件

| 事件类型 | 事件处理程序 | 描述 |
| :---: | :---: | :--- |
| load | `load()` | 当 iframe 内容加载时触发。 |
| error | `error()` | 当 iframe 加载失败时触发。 |
| abort | `abort()` | 当 iframe 加载中断时触发。 |
| scroll | `scroll()` | 当 iframe 滚动时触发。 |
| unload | `unload()` | 当 iframe 内容被卸载时触发。 |
| resize | `resize()` | 当 iframe 尺寸被调整时触发。 |

## 实例

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>菜鸟教程(runoob.com)</title>
</head>
<body>

<p>
<iframe src="demo_iframe.htm" name="iframe1" width="200" height="200"></iframe>
</p>

<p>
<iframe src="demo_iframe.htm" name="iframe2" width="200" height="200"></iframe>
</p>

<p>
<iframe src="demo_iframe.htm" name="iframe3" width="200" height="200"></iframe>
</p>

</body>
</html>
```