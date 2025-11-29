package bot.services;

import bot.commands.Command;
import bot.commands.ExchangeCommand;
import bot.commands.ListCommand;
import bot.commands.WeatherCommand;
import bot.constants.CommandName;
import bot.constants.MessageConstants;

import java.util.Map;

public class MessageResponser {

    private final static Map<String, Command> commandMap = Map.of(
            CommandName.LIST.getValue(), new ListCommand(),
            CommandName.WEATHER.getValue(), new WeatherCommand(),
            CommandName.EXCHANGE.getValue(), new ExchangeCommand()
    );

    public String getResponse (String message) {
        if (message.trim().startsWith(MessageConstants.COMMAND_PREFIX.getValue())) {
            String command = message.split(" ")[0];
            return commandMap.get(command).handleCommand(message);
        }
        return "text";
    }



}
