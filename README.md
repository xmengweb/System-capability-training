# System-capability-training
# 二次压降检定系统Api

## 接口描述

该接口用于模拟二次压降检测仪检定系统相机拍照功能，输出的为模拟相机拍照图像。

## 请求URL

http://47.99.88.166:8000/img

## 请求方式

Get方法

## 请求参数

| 参数名 | 类型 | 必需 | 描述     |
| ------ | ---- | ---- | -------- |
| `id`   | int  | 否   | 图片序号 |

## 返回值

| 参数名 | 类型 | 说明                                 |
| ------ | ---- | ------------------------------------ |
| image  | 图片 | 拍照后的图像文件，支持 jpg,png等格式 |

## 请求示例

| 请求地址                          | 参数 | 说明                                           |
| --------------------------------- | ---- | ---------------------------------------------- |
| http://47.99.88.166:8000/img?id=1 | 是   | 参数id可在1-6中任意修改,返回的为指定序号的图片 |
| http://47.99.88.166:8000/img      | 否   | 返回的为随机序号图片                           |

Java详细请求代码:

​	复制完整代码并且修改文件名与java类名一致即可运行

```java
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        // 创建URL对象
        URL url = new URL("http://47.99.88.166:8000/img");
        // 建立连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // 得到接口响应
        InputStream in = connection.getInputStream();
        // 创建文件输出流
        FileOutputStream out = new FileOutputStream("./image.jpg");
        // 将得到的响应数据复制到输出流中
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        // 关闭流
        in.close();
        out.close();
    }
}
```

C#

```` c#
namespace c.biancheng.net
{
  class Program
  {
    static async Task Main(string[] args)
    {
      HttpClient client = new HttpClient();
      Task<byte[]> imageBytes = client.GetByteArrayAsync("http://47.99.88.166:8000/img");
      File.WriteAllBytes("image.jpg", await imageBytes);
    }
  }
}
````

## 响应示例

![image-20230301164908054](https://cugdemo.oss-cn-hangzhou.aliyuncs.com/image-20230301164908054.png)

备注:本接口仅用于模拟实现，不提供真实的拍照服务。
