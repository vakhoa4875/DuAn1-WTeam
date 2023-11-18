/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package testAPI;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.util.Collection;

public class GoogleBooksApiExample {
    public static void main(String[] args) {
        // Thay thế 'YOUR_API_KEY' bằng khóa API của bạn từ Google Developers Console
        String apiKey = "AIzaSyDPDe8uFH3M3Sp8x-iW_s-D0o3dmqzMHQw";
        
        // Từ khóa tìm kiếm sách
        String query = "Java Programming";
        
        try {
            OkHttpClient client = new OkHttpClient();
            
            // Xây dựng URL để thực hiện yêu cầu tìm kiếm sách
            String url = "https://www.googleapis.com/books/v1/volumes?q=" + query + "&key=" + apiKey;
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            
            // Thực hiện yêu cầu HTTP GET
            Response response = client.newCall(request).execute();
            String jsonData = response.body().string();
            
            // Hiển thị thông tin sách từ phản hồi JSON
            System.out.println("Book Search Results:");
            System.out.println(jsonData);
            
            // (Optional) Phân tích và hiển thị thông tin chi tiết về sách từ JSON
            // (Bạn có thể sử dụng thư viện JSON như Gson để phân tích dữ liệu)
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
