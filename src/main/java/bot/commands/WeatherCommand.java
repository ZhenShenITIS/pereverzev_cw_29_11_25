package bot.commands;

import bot.clients.OpenWeatherClient;

public class WeatherCommand implements Command {
    private final OpenWeatherClient openWeatherClient;

    public WeatherCommand() {
        openWeatherClient = new OpenWeatherClient();
    }

    @Override
    public String handleCommand(String message) {
        try {
            return openWeatherClient.getResponse(message.trim().split(" ")[1]);
        } catch (Exception e) {
            return "Произошла непредвиденная ошибка";
        }
    }
}
