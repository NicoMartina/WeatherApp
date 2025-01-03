package com.example.weatherapp;

import java.util.LinkedList;

public class WeatherHistory {
    private LinkedList<String> history = new LinkedList<>();

    public void addSearch(String city) {
        history.addFirst(city);
        if (history.size() > 5) {  // Limit history to 5 items
            history.removeLast();
        }
    }

    public LinkedList<String> getHistory() {
        return history;
    }
}

