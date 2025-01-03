package com.example.weatherapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);  // Launch JavaFX application
    }

    @Override
    public void start(Stage primaryStage) {
        WeatherAppGUI gui = new WeatherAppGUI();
        Scene scene = new Scene(gui.createWeatherAppUI(), 800, 600);

        primaryStage.setTitle("Weather Information App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
