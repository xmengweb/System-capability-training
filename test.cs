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
