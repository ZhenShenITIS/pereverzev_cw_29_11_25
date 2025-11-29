package bot.view;

import bot.constants.CommandName;
import bot.constants.MessageConstants;
import bot.services.MessageResponser;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import lombok.RequiredArgsConstructor;

import javafx.scene.layout.BorderPane;



@RequiredArgsConstructor
public class ChatView {
    private final ViewManager viewManager;
    private final MessageResponser messageResponser;
    private TextArea conversationArea;
    private TextField inputField;

    public Parent getView () {
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));

        conversationArea = new TextArea();
        conversationArea.setEditable(false);
        conversationArea.setWrapText(true);
        conversationArea.appendText(MessageConstants.BOT_PREFIX.getValue() + MessageConstants.HELLO_MESSAGE.getValue() + "\n");


        inputField = new TextField();
        inputField.setPromptText("Введите сообщение...");


        inputField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleSendMessage();
            }
        });

        layout.setCenter(conversationArea);
        layout.setBottom(inputField);

        BorderPane.setMargin(conversationArea, new Insets(0, 0, 10, 0));

        return layout;
    }

    private void handleSendMessage() {
        String userMessage = inputField.getText().trim();
        if (userMessage.isEmpty()) return;

        if (userMessage.equalsIgnoreCase(CommandName.QUIT.getValue())) {
            viewManager.showStartView();
            return;
        }

        conversationArea.appendText(MessageConstants.USER_PREFIX.getValue() + userMessage + "\n");
        inputField.clear();

        String botResponse = messageResponser.getResponse(userMessage);
        conversationArea.appendText(MessageConstants.BOT_PREFIX.getValue() + botResponse + "\n");
    }
}
