# URL(Uniform Resource Locator)
统一资源定位符，对应着互联网的某一资源地址
## URL的5个基本结构：
`协议` `://` `主机名` `:` `端口号` `资源地址` `?` `参数列表`

| [http://localhost:8080/examples/beauty.jpg?username=Tom](http://localhost:8080/examples/beauty.jpg?username=Tom) |  |  |  |  |
| :---: | :---: | :---: | :---: | :---: |
| `协议` | `主机名` | `端口号` | `资源地址` | `参数列表` |
| [http](http://localhost:8080/examples/beauty.jpg?username=Tom) | localhost | 8080 | /examples/beauty.jpg | username=Tom |

## 实例化
URL url = new URL("[http://localhost:8080/examples/beauty.jpg?username=Tom");](http://localhost:8080/examples/beauty.jpg?username=Tom");)
## 常用方法

- `openConnection()`:返回一个URLConnection实例，表示与URL引用的远程对象的URL
   - URLConnection可以用于从URL引用的资源中读取和写入
   - connect():打开与此URL引用的资源的通信链接，如果此类连接尚未建立
   - getInputStream():获取一个流
## 读取、下载对应的url资源
```java
public static void main(String[] args) {

    HttpURLConnection urlConnection = null;
    InputStream is = null;
    FileOutputStream fos = null;
    try {
        URL url = new URL("http://localhost:8080/examples/beauty.jpg");

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.connect();

        is = urlConnection.getInputStream();
        fos = new FileOutputStream("day10\\beauty3.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("下载完成");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        //关闭资源
        if(is != null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(fos != null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(urlConnection != null){
            urlConnection.disconnect();
        }
    }
}
```




