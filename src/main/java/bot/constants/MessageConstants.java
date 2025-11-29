package bot.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MessageConstants {
    COMMAND_PREFIX("/"),
    BOT_PREFIX("Bot: "),
    USER_PREFIX("You: "),
    HELLO_MESSAGE("""
            Привет! Вот список доступных команд:
            %s - узнать список доступных команд
            %s <Название города> - узнать погоду
            %s <Идентификатор валюты> - узнать курс валюты к рублю
            %s - выход""".formatted(
            CommandName.LIST.getValue(),
            CommandName.WEATHER.getValue(),
            CommandName.EXCHANGE.getValue(),
            CommandName.QUIT.getValue())),
    COMMAND_LIST("""
            Вот список доступных команд:
            %s - узнать список доступных команд
            %s <Название города> - узнать погоду
            %s <Идентификатор валюты> - узнать курс валюты к рублю
            %s - выход""".formatted(
            CommandName.LIST.getValue(),
            CommandName.WEATHER.getValue(),
            CommandName.EXCHANGE.getValue(),
            CommandName.QUIT.getValue()));
    private final String value;
}
