package com.example.weatherapp;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class WeatherAppGUI {
    private TextField cityInput;
    private Label temperatureLabel;
    private Label humidityLabel;
    private Label windSpeedLabel;
    private ImageView weatherIcon;
    private ListView<String> historyListView;
    private WeatherHistory weatherHistory;

    public WeatherAppGUI() {
        weatherHistory = new WeatherHistory();
    }

    public VBox createWeatherAppUI() {
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        cityInput = new TextField();
        cityInput.setPromptText("Enter City Name");
        cityInput.setMaxWidth(200);

        Button getWeatherButton = new Button("Get Weather");
        getWeatherButton.setOnAction(e -> fetchWeatherData());

        temperatureLabel = new Label("Temperature: ");
        humidityLabel = new Label("Humidity: ");
        windSpeedLabel = new Label("Wind Speed: ");

        weatherIcon = new ImageView();
        weatherIcon.setFitWidth(100);
        weatherIcon.setFitHeight(100);

        historyListView = new ListView<>();
        historyListView.setMaxHeight(150);

        // Adding some spacing
        layout.getChildren().addAll(cityInput, getWeatherButton, temperatureLabel, humidityLabel, windSpeedLabel, weatherIcon, historyListView);
        return layout;
    }

    private void fetchWeatherData() {
        String cityName = cityInput.getText().trim();
        if (cityName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a city name.", ButtonType.OK);
            alert.show();
            return;
        }

        WeatherData data = WeatherService.getWeather(cityName);

        if (data != null) {
            temperatureLabel.setText("Temperature: " + data.getTemperature() + "°C");
            humidityLabel.setText("Humidity: " + data.getHumidity() + "%");
            windSpeedLabel.setText("Wind Speed: " + data.getWindSpeed() + " m/s");
            weatherIcon.setImage(new Image("weather_icons/" + getWeatherIcon(data.getCondition()) + ".png"));

            // Update weather history
            weatherHistory.addSearch(cityName);
            updateHistoryList();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Could not retrieve weather data. Please check the city name.", ButtonType.OK);
            alert.show();
        }
    }

    private String getWeatherIcon(String condition) {
        switch (condition.toLowerCase()) {
            case "clear sky":
                return "sun";
            case "clouds":
                return "cloud";
            case "rain":
                return "rain";
            case "snow":
                return "snow";
            default:
                return "default";
        }
    }

    private void updateHistoryList() {
        historyListView.getItems().clear();
        for (String city : weatherHistory.getHistory()) {
            historyListView.getItems().add(city);
        }
    }
}
