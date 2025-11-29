package bot.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class BotApp extends Application {
    private ViewManager viewManager;

    @Override
    public void start(Stage stage) throws Exception {
        viewManager = new ViewManager(stage);
        viewManager.showStartView();

        stage.setTitle("Чат-бот");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
