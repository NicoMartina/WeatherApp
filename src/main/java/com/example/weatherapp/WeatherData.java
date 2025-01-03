package com.example.weatherapp;

public class WeatherData {
    public Main main;
    public Wind wind;
    public Weather[] weather;

    public double getTemperature() {
        return main.temp;
    }

    public double getHumidity() {
        return main.humidity;
    }

    public double getWindSpeed() {
        return wind.speed;
    }

    public String getCondition() {
        return weather[0].description;
    }

    // Inner classes to match the structure of the API response
    class Main {
        double temp;
        double humidity;
    }

    class Wind {
        double speed;
    }

    class Weather {
        String description;
    }
}