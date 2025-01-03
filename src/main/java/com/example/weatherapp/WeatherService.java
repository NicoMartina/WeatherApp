package com.example.weatherapp;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;  // Import URLEncoder

public class WeatherService {
    private static final String API_KEY = "75e424d574b816689e51d030213d3a50";  // Replace with your actual API key

    public static WeatherData getWeather(String cityName) {
        try {
            String encodedCityName = URLEncoder.encode(cityName, "UTF-8");
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + encodedCityName + "&appid=" + API_KEY + "&units=metric";
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode != 200) {
                System.out.println("Error: API returned response code " + responseCode);
                return null;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            return gson.fromJson(response.toString(), WeatherData.class);
        } catch (Exception e) {
            System.out.println("Error occurred while fetching weather data: " + e.getMessage());
            return null;
        }
    }


}
