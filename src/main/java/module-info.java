module com.example.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;




    opens com.example.weatherapp to javafx.fxml, com.google.gson;
    exports com.example.weatherapp;
}