package bot.commands;

import bot.constants.MessageConstants;

public class ListCommand implements Command {
    @Override
    public String handleCommand(String message) {
        return MessageConstants.COMMAND_LIST.getValue();
    }
}
