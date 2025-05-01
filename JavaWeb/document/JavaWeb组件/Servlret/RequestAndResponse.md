#Http协议
Http协议是的实现形式的请求和响应

##Request-请求
Java中对于Http协议请求的实现形式是HttpServletRequest

###结构
请求包含三个部分： 
1. 请求行：
   *  请求的方式
   *  请求的URL
   *  请求的协议（一般都是HTTP1.1）
2. 请求消息头
   *  请求消息头中包含了很多客户端需要告诉服务器的信息，比如：我的浏览器型号、版本、我能接收的内容的类型、
   *  内容的长度等等(键值对)
3. 请求主体
   * get方式，没有请求体，但是有一个queryString
   * post方式，有请求体，form data
   * json格式，有请求体，request payload
```

```
###常用方法
1. **获取请求参数：**
   - `getParameter(String name)`: 根据参数名获取单个请求参数的值。
   - `getParameterValues(String name)`: 根据参数名获取多个请求参数的值（适用于多选框等情况）。
   - `getParameterMap()`: 获取所有请求参数的 Map 集合。

2. **获取请求头信息：**
   - `getHeader(String name)`: 根据头部名称获取请求头的值。
   - `getHeaders(String name)`: 根据头部名称获取请求头的所有值。
   - `getHeaderNames()`: 获取所有请求头的名称。

3. **获取请求方法和路径：**
   - `getMethod()`: 获取请求使用的 HTTP 方法（GET、POST 等）。
   - `getRequestURI()`: 获取请求的 URI（不包括主机名和端口号）。
   - `getRequestURL()`: 获取请求的完整 URL（包括主机名、端口号和 URI）。

4. **获取会话信息：**
   - `getSession()`: 获取与请求关联的会话对象。
   - `getSession(boolean create)`: 获取与请求关联的会话对象，可选择是否创建新的会话。

5. **获取客户端信息：**
   - `getRemoteAddr()`: 获取客户端的 IP 地址。
   - `getRemotePort()`: 获取客户端的端口号。

6. **获取请求参数编码：**
   - `getCharacterEncoding()`: 获取请求参数的字符编码。

7. **获取请求体输入流：**
   - `getInputStream()`: 获取请求体的输入流，用于读取请求体内容。

8. **其他常用方法：**
   - `getLocale()`: 获取客户端的首选语言环境。
   - `getAttribute(String name)`: 获取请求属性的值。
   - `setAttribute(String name, Object value)`: 设置请求属性的值。
   - `removeAttribute(String name)`: 移除请求属性。
   - `getContentLength()`: 获取请求体的内容长度。
   - `getContentType()`: 获取请求体的内容类型。
   - `getContextPath()`: 获取上下文路径。
   - `getLocalAddr()`: 获取服务器的 IP 地址。

##Response-响应
Java中对于Http协议响应的实现形式是HttpServletResponse
响应也包含三部分： 
1. 响应行
   * 协议 
   * 响应状态码(200)
   * 响应状态(ok)
2. 响应头
   * 包含了服务器的信息；服务器发送给浏览器的信息（内容的媒体类型、编码、内容长度等）
3. 响应体
   * 响应的实际内容（比如请求add.html页面时，响应的内容就是<html><head><body><form....）
###常用方法
1. **设置响应状态和类型：**
   - `setStatus(int sc)`: 设置响应的状态码。
   - `sendError(int sc)`: 发送一个错误状态码到客户端。
   - `sendRedirect(String location)`: 重定向到指定的 URL。
   - `setContentType(String type)`: 设置响应的内容类型（MIME 类型）。

2. **设置响应头信息：**
   - `setHeader(String name, String value)`: 设置指定名称的响应头的值。
   - `addHeader(String name, String value)`: 添加指定名称的响应头的值（可添加多个相同名称的响应头）。
   - `setIntHeader(String name, int value)`: 设置指定名称的整数值响应头。
   - `addIntHeader(String name, int value)`: 添加指定名称的整数值响应头。

3. **设置缓存控制：**
   - `setDateHeader(String name, long date)`: 设置响应头中的日期值。
   - `addDateHeader(String name, long date)`: 添加响应头中的日期值。
   - `setExpires(long expires)`: 设置响应的到期时间。
   - `setCacheControl(String control)`: 设置缓存控制策略。
   - `setLastModified(long date)`: 设置响应的最后修改时间。

4. **获取输出流和写入响应体：**
   - `getOutputStream()`: 获取输出流，用于向客户端写入二进制数据。
   - `getWriter()`: 获取字符输出流，用于向客户端写入文本数据。
   - `print(String s)`: 向响应体输出文本数据。
   - `write(byte[] b)`: 向响应体输出二进制数据。

5. **其他常用方法：**
   - `setCharacterEncoding(String charset)`: 设置响应字符编码。
   - `setLocale(Locale loc)`: 设置响应的地区。
   - `setBufferSize(int size)`: 设置响应缓冲区大小。
   - `setContentLength(int len)`: 设置响应体的长度。
