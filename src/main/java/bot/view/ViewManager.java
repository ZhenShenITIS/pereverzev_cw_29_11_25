package bot.view;

import bot.services.MessageResponser;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ViewManager {
    private final Stage stage;
    private final int HIGH = 800;
    private final int WIDTH = 1600;


    public void showChatView () {
        ChatView chatView = new ChatView(this, new MessageResponser());
        Scene scene = new Scene(chatView.getView(), WIDTH, HIGH);
        stage.setScene(scene);

    }

    public void showStartView () {
        StartView startView = new StartView(this);
        Scene scene = new Scene(startView.getView(), WIDTH, HIGH);
        stage.setScene(scene);
    }
}
