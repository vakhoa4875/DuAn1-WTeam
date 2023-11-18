/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testAPI;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AccuWeatherAPIExample {

    public static void main(String[] args) {
        // Replace 'YOUR_API_KEY' with your AccuWeather API key
        String apiKey = "GFFSqm7xLdgLmwvDuUKUpkWMirB6yP65";

        // The location you want to get weather information for (e.g., New York)
        String location = "New York";

        try {
            // Create a URL for the API endpoint
            String endpoint = "http://dataservice.accuweather.com/locations/v1/cities/search?q=" + location + "&apikey=" + apiKey;
            URL url = new URL(endpoint);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response from the API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the JSON response
            JsonArray locationArray = JsonParser.parseString(response.toString()).getAsJsonArray();
            if (locationArray.size() > 0) {
                JsonObject locationObject = locationArray.get(0).getAsJsonObject();
                String locationKey = locationObject.get("Key").getAsString();

                // Now, make another API call to get the current conditions using locationKey
                String conditionsEndpoint = "http://dataservice.accuweather.com/currentconditions/v1/" + locationKey + "?apikey=" + apiKey;
                URL conditionsUrl = new URL(conditionsEndpoint);

                HttpURLConnection conditionsConnection = (HttpURLConnection) conditionsUrl.openConnection();
                conditionsConnection.setRequestMethod("GET");

                BufferedReader conditionsIn = new BufferedReader(new InputStreamReader(conditionsConnection.getInputStream()));
                StringBuilder conditionsResponse = new StringBuilder();
                while ((inputLine = conditionsIn.readLine()) != null) {
                    conditionsResponse.append(inputLine);
                }
                conditionsIn.close();

                JsonArray conditionsArray = JsonParser.parseString(conditionsResponse.toString()).getAsJsonArray();
                if (conditionsArray.size() > 0) {
                    JsonObject conditionsObject = conditionsArray.get(0).getAsJsonObject();

                    // Extract temperature, location, and humidity
                    JsonObject temperatureObj = conditionsObject.getAsJsonObject("Temperature").getAsJsonObject("Metric");
                    double temperature = temperatureObj.get("Value").getAsDouble();
                    String locationName = locationObject.get("LocalizedName").getAsString();
                    int humidity = 0;
                    if (conditionsObject.get("RelativeHumidity") != null) {
                        humidity = conditionsObject.get("RelativeHumidity").getAsInt();
                    }

                    System.out.println("Location: " + locationName);
                    System.out.println("Temperature (Celsius): " + temperature);
                    System.out.println("Humidity (%): " + humidity);
                }

                conditionsConnection.disconnect();
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
