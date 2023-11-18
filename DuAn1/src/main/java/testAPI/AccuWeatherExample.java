/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package testAPI;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class AccuWeatherExample {
    public static void main(String[] args) {
        // Thay thế 'YOUR_API_KEY' bằng API key của bạn từ AccuWeather
        String apiKey = "GFFSqm7xLdgLmwvDuUKUpkWMirB6yP65";
        
        // Địa điểm bạn muốn lấy thông tin thời tiết (ví dụ: New York)
        String location = "New York";
        
        try {
            OkHttpClient client = new OkHttpClient();
            
            // Tạo một cuộc gọi API để lấy thông tin thời tiết theo địa điểm
            Request request = new Request.Builder()
                    .url("http://dataservice.accuweather.com/locations/v1/cities/search?q=" + location + "&apikey=" + apiKey)
                    .build();
            
            Response response = client.newCall(request).execute();
            String jsonData = response.body().string();
            
            // Phân tích dữ liệu JSON
            JSONArray locationArray = new JSONArray(jsonData);
            if (locationArray.length() > 0) {
                JSONObject locationObject = locationArray.getJSONObject(0);
                String locationKey = locationObject.getString("Key");
                
                // Tạo một cuộc gọi API khác để lấy thông tin thời tiết hiện tại
                request = new Request.Builder()
                        .url("http://dataservice.accuweather.com/currentconditions/v1/" + locationKey + "?apikey=" + apiKey)
                        .build();
                
                response = client.newCall(request).execute();
                jsonData = response.body().string();
                
                // Phân tích thông tin thời tiết hiện tại
                JSONArray conditionsArray = new JSONArray(jsonData);
                if (conditionsArray.length() > 0) {
                    JSONObject conditionsObject = conditionsArray.getJSONObject(0);
                    double temperature = conditionsObject.getJSONObject("Temperature").getJSONObject("Metric").getDouble("Value");
                    String weatherText = conditionsObject.getString("WeatherText");
//                    int humidity = conditionsObject.getInt("RelativeHumidity");
                    
                    // Hiển thị thông tin thời tiết
                    System.out.println("Location: " + location);
                    System.out.println("Temperature: " + temperature + "°C");
                    System.out.println("Weather: " + weatherText);
//                    System.out.println("Humidity: " + humidity + "%");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
