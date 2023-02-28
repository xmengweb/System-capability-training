# System-capability-training
# 二次压降检定系统Api

## 接口描述

该接口用于模拟二次压降检测仪检定系统相机拍照功能，输出的为模拟相机拍照图像。

## 请求URL

http://47.99.88.166:8000/img

## 请求方式

Get

## 请求参数

无

## 返回值

| 参数名 | 类型    | 说明                              |
| ------ | ------- | --------------------------------- |
| image  | jpg图片 | 拍照后的图像文件，仅支持 jpg 格式 |

## 请求示例

Java:

```java
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class data {
    public static void main(String[] args) throws Exception {
        // Create a URL object
        URL url = new URL("http://47.99.88.166:8000/img");

        // Create a connection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Get the response
        InputStream in = connection.getInputStream();

        // Create a file output stream
        FileOutputStream out = new FileOutputStream("./image.jpg");

        // Copy the contents of the response to the output stream
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        // Close the streams
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

运行完成后,会将从接口得到的图片保存到当前项目文件中,命名为image.jpg
