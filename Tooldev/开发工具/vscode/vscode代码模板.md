#vscode快捷开发

##快捷键配置
1. 选择菜单里的 `文件` > `首选项` > `键盘快捷方式`
2. 搜索 `editor.action.formatDocument` 并修改快捷键
3. 搜索 `editor.action.formatSelection` 并修改快捷键
##快捷键触发
##vscode代码片段
###代码模板
1. 选择菜单里的 `文件` > `首选项` > `用户代码片段
2. 选择你需要自定义模板的文件(实际上就是配置相应的.json文件,在搜索栏搜索相应的.json文件就行)，例如html.json
```json
"Print to console": {
		 	"prefix": "html",//在新建立的页面中输入html就会有智能提示，Tab就自动生成好了
		 	"body": [
				"<!DOCTYPE html>",
				"<html lang="en">",
				"<head>",
					"<meta charset="UTF-8">",
					"<title>Document</title>",
				"</head>",
				"<body>",
				"", //空行
				"   $0",    //最终光标会在这里等待输入
				"", //空行
				"</body>",
				"</html>",
		 	],
		 	"description": "生成html模板" //用户输入后智能提示的内容（你可以用中文写“生成html模板”）
		 }
```
3. 保存，重启vscode，输入html，Tab键，自动生成html模板
###代码片段库
1. 选择菜单里的 `文件` > `首选项` > `用户代码片段库`
2. 找到对应的.json文件，修改里面的内容，保存
#参靠
1. [vscode官方文档](https://code.visualstudio.com/docs)
1. [vscode 快速打出console.log()](https://blog.csdn.net/ABB_818/article/details/124005658)