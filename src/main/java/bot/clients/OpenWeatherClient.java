package bot.clients;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

public class OpenWeatherClient {
    private final String url = "https://api.openweathermap.org/data/2.5/weather";
    public String getResponse(String city) {

        HttpClient client = new HttpClientImpl();
        String response = client.get(url, new HashMap<>(), Map.of(
                "q", city,
                "appid", getToken(),
                "units", "metric",
                "lang", "ru"
        ));

        return parseResponse(response);
    }

    private String getToken() {
        return System.getenv("OPEN_WEATHER_API");
    }


    // Данный метод написан ИИ, так как мне неохота самому парсить это
    private String parseResponse (String response) {
        // Создаем объект JSON из строкового ответа
        JSONObject obj = new JSONObject(response);

        // Извлекаем название города
        String cityName = obj.getString("name");

        // Извлекаем объект "main" для получения температуры и влажности
        JSONObject main = obj.getJSONObject("main");
        double temp = main.getDouble("temp");
        int humidity = main.getInt("humidity");

        // Извлекаем массив "weather" и берем первое описание (индекс 0)
        JSONArray weatherArray = obj.getJSONArray("weather");
        String description = weatherArray.getJSONObject(0).getString("description");

        // Извлекаем объект "wind" для получения скорости ветра
        JSONObject wind = obj.getJSONObject("wind");
        double windSpeed = wind.getDouble("speed");

        // Формируем красивую строку вывода
        return String.format(
                "Погода в г. %s:\n" +
                        "Температура: %.1f°C\n" +
                        "Описание: %s\n" +
                        "Влажность: %d%%\n" +
                        "Ветер: %.1f м/с",
                cityName, temp, description, humidity, windSpeed
        );
    }



}
