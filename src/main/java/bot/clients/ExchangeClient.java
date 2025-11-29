package bot.clients;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ExchangeClient {
    private final String url = "https://open.er-api.com/v6/latest/";

    public String getResponse(String code) {
        HttpClient client = new HttpClientImpl();
        String response = client.get(url + code, new HashMap<>(), new HashMap<>());
        return parseResponse(response);
    }

    private String parseResponse (String response) {
        // Преобразуем строку ответа в JSON-объект
        JSONObject obj = new JSONObject(response);

        // Получаем объект с курсами валют ("rates")
        JSONObject rates = obj.getJSONObject("rates");

        // Извлекаем значение для ключа "RUB" (Российский рубль)
        double rubRate = rates.getDouble("RUB");

        // Возвращаем значение в виде строки
        return String.valueOf("Значение к рублю: " + rubRate);
    }
}
