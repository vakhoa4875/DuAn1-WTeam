/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package testAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class ThoiTietAPI {
    
    public static void main(String[] args) {
//        entity obj = new entity();
        try {
            // API key từ OpenWeatherMap (cần đăng ký và nhận key từ trang web của OpenWeatherMap)
            String apiKey = "63645a89022495eb2e5447a06df5e9db";

            // Địa điểm bạn muốn lấy thông tin thời tiết
            String city = "Dong+Nai";

            // URL của API
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + ",VN&appid=" + apiKey + "&units=metric";

            // Tạo kết nối HTTP
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Gửi yêu cầu GET
            connection.setRequestMethod("GET");

            // Đọc dữ liệu từ API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Chuyển dữ liệu JSON thành đối tượng JSONObject
            JSONObject jsonObject = new JSONObject(response.toString());

            // Trích xuất thông tin thời tiết
            String mainWeather = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
            double doAm = jsonObject.getJSONObject("main").getDouble("humidity");
            double temperature = jsonObject.getJSONObject("main").getDouble("temp");

            // Đóng kết nối
            connection.disconnect();

            // In thông tin thời tiết
            System.out.println("Thời tiết tại " + city + ":");
            System.out.println("Trạng thái thời tiết: " + mainWeather);
            System.out.println("Độ ẩm không khí: "+doAm+"%");
            System.out.println("Mô tả: " + description);
            System.out.println("Nhiệt độ: " + temperature + "°C");
            

        } catch (Exception e) {
            System.out.println("Không thể lấy thông tin thời tiết: " + e.getMessage());
        }
    }
}
