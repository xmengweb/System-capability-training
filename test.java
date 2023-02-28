 import java.io.*;
 import java.net.HttpURLConnection;
 import java.net.URL;
 ​
 public class data {
     public static void main(String[] args) throws Exception {
         // Create a URL object
         URL url = new URL("http://47.99.88.166:8000/img");
 ​
         // Create a connection
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
 ​
         // Get the response
         InputStream in = connection.getInputStream();
 ​
         // Create a file output stream
         FileOutputStream out = new FileOutputStream("./image.jpg");
 ​
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
