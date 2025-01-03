# Weather Information App
Overview The Weather Information App is a simple JavaFX-based application that retrieves real-time weather data using the OpenWeatherMap API. Users can input a city name to get the current weather details, including temperature, humidity, wind speed, and weather conditions. The app also displays an appropriate weather icon based on the current conditions, and it tracks the last 5 cities that the user has searched for.

# Features
City Search: Allows users to enter a city name and get real-time weather information. Weather Data: Displays key weather data such as temperature (°C), humidity (%), wind speed (m/s), and weather conditions (e.g., clear sky, rain). Weather Icons: Shows corresponding weather icons for different weather conditions (e.g., sunny, cloudy, rainy, snowy). Search History: Tracks and displays the last 5 cities searched by the user. User-Friendly Interface: The app features an intuitive and responsive graphical user interface (GUI) built using JavaFX. Setup and Installation Prerequisites Before running the app, make sure you have the following installed:

# JDK 11 or later (Java Development Kit)
Maven or Gradle for dependency management (optional if you're using an IDE like IntelliJ IDEA or Eclipse) OpenWeatherMap API Key (sign up for a free key at OpenWeatherMap) Installation Steps Clone or Download the Repository:

# Clone this repository using Git:
git clone https://github.com/NicoMartina/WeatherApp.git Alternatively, download the repository as a ZIP file from GitHub. Set up the API Key:

Open the WeatherService.java file in your IDE. Replace the placeholder API key in the WeatherService class with your actual OpenWeatherMap API key:

private static final String API_KEY = "YOUR_API_KEY_HERE"; Build and Run the Application:

If using Maven or Gradle, run the application by following the respective build commands. If using an IDE like IntelliJ IDEA or Eclipse, open the project and run the Main.java class. This will launch the JavaFX application. How It Works Core Components: WeatherService.java: Handles the API request to OpenWeatherMap. It retrieves the weather data for a given city and parses the JSON response using the Gson library. WeatherData.java: Represents the weather data structure, including temperature, humidity, wind speed, and weather condition. WeatherHistory.java: Stores and manages the last 5 cities that the user has searched for. It keeps track of the search history and ensures that only the 5 most recent cities are stored. WeatherAppGUI.java: The JavaFX-based graphical user interface where users can input the name of a city, view the weather data, and see the corresponding weather icon. Main.java: The entry point of the application, launching the JavaFX interface and connecting all components together. Application Flow: The user enters the name of a city in the input field and clicks the "Get Weather" button. The application fetches the weather data for the entered city using the OpenWeatherMap API. The weather data (temperature, humidity, wind speed, and conditions) is displayed in the GUI, along with an appropriate weather icon. The city is added to the search history (displayed in a list) and can be reused for further searches. Usage

# Launch the App:
Run the Main.java class in your IDE. Enter City Name:

Type the name of a city in the input field labeled "Enter City Name". View Weather Information:

Click the "Get Weather" button.
The current temperature, humidity, wind speed, and weather conditions will be displayed. A weather icon corresponding to the conditions will be shown. History of Searches:

The app tracks the last 5 cities searched and displays them in a list view. You can easily see the most recent cities you’ve searched for. Screenshots

# Troubleshooting
Common Issues: Invalid City Name: If you enter an invalid city name, the app will show an error message informing you that the city was not found. Make sure the city name is correct and check your internet connection. API Key Issues: If the app is unable to fetch data, ensure that your OpenWeatherMap API key is valid and correctly inserted in the WeatherService.java file. Dependencies JavaFX: For building the graphical user interface. Gson: For parsing the JSON data returned by the OpenWeatherMap API. Maven/Gradle (optional): For dependency management and building the project.

# License
This project is licensed under the MIT License - see the LICENSE file for details.

# Conclusion
This Weather Information App is a simple yet powerful tool to fetch real-time weather data. It demonstrates how to use JavaFX for GUI development and how to interact with external APIs (OpenWeatherMap) to retrieve and display weather information. Feel free to explore the code and make improvements or additions.
