<br/>

#  Ajax

```
 Ajax : 异步的JavaScript and XML
 目的： 用来发送异步的请求，然后当服务器给我响应的时候再进行回调操作
 好处： 提高用户体验；局部刷新：降低服务器负担、减轻浏览器压力、减轻网络带宽压力
 开发步骤：
创建XMLHttpRequest
调用open进行设置："GET" , URL , true绑定状态改变时执行的回调函数 
- onreadystatechange发送请求 
- send()编写回调函数，在回调函数中，
我们只对XMLHttpRequest的readystate为4的时候感兴趣
我们只对XMLHttpRequest的status为200的时候感兴趣

```

<br/>

<br/>

```
//如果想要发送异步请求，我们需要一个关键的对象 XMLHttpRequest
var xmlHttpRequest ;

function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
        //符合DOM2标准的浏览器 ，xmlHttpRequest的创建方式
        xmlHttpRequest = new XMLHttpRequest() ;
    }else if(window.ActiveXObject){//IE浏览器
        try{
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP")
        }
    }
}

function ckUname(uname){
    createXMLHttpRequest();
    var url = "user.do?operate=ckUname&uname="+uname ;
    xmlHttpRequest.open("GET",url,true);
    //设置回调函数
    xmlHttpRequest.onreadystatechange = ckUnameCB ;
    //发送请求
    xmlHttpRequest.send();
}

//回调函数
function ckUnameCB(){
    if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
        //xmlHttpRequest.responseText 表示 服务器端响应给我的文本内容
        //alert(xmlHttpRequest.responseText);
        var responseText = xmlHttpRequest.responseText ;
        // {'uname':'1'}
        //alert(responseText);
        if(responseText=="{'uname':'1'}"){
            alert("用户名已经被注册！");
        }else{
            alert("用户名可以注册！");
        }
    }
}
```

<br/>

```
 0: (Uninitialized) the send( ) method has not yet been invoked.
 1: (Loading) the send( ) method has been invoked, request in progress.
 2: (Loaded) the send( ) method has completed, entire response received.
 3: (Interactive) the response is being parsed.
 4: (Completed) the response has been parsed, is ready for harvesting.
 0 － （未初始化）还没有调用send()方法
 1 － （载入）已调用send()方法，正在发送请求
 2 － （载入完成）send()方法执行完成，已经接收到全部响应内容
 3 － （交互）正在解析响应内容
 4 － （完成）响应内容解析完成，可以在客户端调用了

```

# Axios

```
Axios是Ajax的一个框架,简化Ajax操作
Axios执行Ajax操作的步骤：
添加并引入axios的js文件
2-1. 客户端向服务器端异步发送普通参数值
基本格式： axios().then().catch()示例：
axios({
  method:"POST",
  url:"....",
  params:{
  uname:"lina",
  pwd:"ok"
  }
})
.then(function(value){})          //成功响应时执行的回调        value.data可以获取到服务器响应内容
.catch(function(reason){});       //有异常时执行的回调          reason.response.data可以获取到响应的内容
                                                              reason.message / reason.stack 可以查看错误的信息

```

<br/>

# JSON

```
 2-2. 客户端向服务器发送JSON格式的数据
什么是JSON
JSON是一种数据格式
JSON其实就是js的自定义对象
XML也是一种数据格式
XML格式表示两个学员信息的代码如下：<students>
  <student sid="s001">
      <sname>jim</sname>
      <age>18</age>
  </student>
  <student sid="s002">
      <sname>tom</sname>
      <age>19</age>
  </student>
</students>
JSON格式表示两个学员信息的代码如下：
[{sid:"s001",age:18},{sid:"s002",age:19}]
JSON表达数据更简洁，更能够节约网络带宽客户端发送JSON格式的数据给服务器端
客户端中params需要修改成：  data:服务器获取参数值不再是 request.getParameter()...
而是：
StringBuffer stringBuffer = new StringBuffer("");
BufferedReader bufferedReader = request.getReader();
String str = null ;
while((str=bufferedReader.readLine())!=null){
stringBuffer.append(str);
}
str = stringBuffer.toString() ;我们会发现 str的内容如下：
{"uname":"lina","pwd":"ok"}

服务器端给客户端响应JSON格式的字符串，然后客户端需要将字符串转化成js Object


```

<br/>

```
在js中json的转化

JSON.stringify( json ); 此方法可以把一个json 对象转换成为json 字符串
JSON.parse( jsonString ); 此方法可以把一个json 字符串转换成为json 对象




在java中json字符串和类的转化
//1、java 对象和json 的转换

// json 操作，一定要先new 一个gson 对象。
Gson gson = new Gson();
// java 对象--json
Person person = new Person(12, "wzg168");
// 把对象转成为json 字符串
String personjson = gson.toJson(person);
// 把json 字符串转换成为java 对象
Person p = gson.fromJson(personjson, Person.class);


//2、java 对象list 集合和json 的转换
String jsonListString = gson.toJson(list);
System.out.println(jsonListString);
// 把json 数组转换成为List 对象
// List<Person> ps = gson.fromJson(jsonListString, new PersonType().getType());
// 我们也可以使用匿名内部类
List<Person> ps = gson.fromJson(jsonListString, new TypeToken<List<Person>>() {
}.getType());


// 3、map 对象和json 的转换
Map<String, Person> mapPerson = new HashMap<String, GsonTest.Person>();
// 添加person 到map 中
mapPerson.put("p1", new Person(1, "person-1"));
mapPerson.put("p2", new Person(2, "person-2"));
// 把map 转换成为json 对象
String jsonMapString = gson.toJson(mapPerson);
System.out.println(jsonMapString);
// 通过使用匿名内部类的方式
Map<String, Person> map = gson.fromJson(jsonMapString,
new TypeToken<HashMap<String, Person>>() {}.getType());
System.out.println(map);
```
