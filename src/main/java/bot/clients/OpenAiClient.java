package bot.clients;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class OpenAiClient {

    public String getResponse (String prompt) {
        HttpClient client = new HttpClientImpl();
        Map<String, String> headers3 = new HashMap<>();
        headers3.put("Authorization", "Bearer "+getOpenAiToken());
        headers3.put("Content-Type", "application/json");
        Map<String, String> data2 = new HashMap<>();
        data2.put("model", "gpt-5-nano");
        data2.put("input", prompt);
        String response = client.post("https://api.openai.com/v1/responses", headers3, data2);
        return ("AI Response: " + getTextFromJSON(new JSONObject(response)));
    }

    public static String getOpenAiToken(){
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream("openai.properties")){
            properties.load(is);
            return properties.getProperty("open.ai.token");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getTextFromJSON (JSONObject object) {
        JSONArray jsons = object.getJSONArray("output");
        for (int i = 0; i < jsons.length(); i++) {
            JSONObject json = jsons.getJSONObject(i);
            if (json.has("content")) {
                JSONArray content = json.getJSONArray("content");
                for (int j = 0; j < content.length(); j++) {
                    JSONObject contentJson = content.getJSONObject(j);
                    if (contentJson.has("text")) {
                        return contentJson.getString("text");
                    }
                }
            }
        }
        return "Error";
    }
}
