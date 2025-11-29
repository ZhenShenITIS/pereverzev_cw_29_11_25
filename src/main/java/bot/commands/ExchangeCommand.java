package bot.commands;

import bot.clients.ExchangeClient;

public class ExchangeCommand implements Command{
    private final ExchangeClient exchangeClient;

    public ExchangeCommand() {
        this.exchangeClient = new ExchangeClient();
    }

    @Override
    public String handleCommand(String message) {
        try {
            return exchangeClient.getResponse(message.trim().split(" ")[1]);
        } catch (Exception e) {
            return "Произошла непредвиденная ошибка";
        }
    }
}
