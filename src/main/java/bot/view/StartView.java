package bot.view;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StartView {
    private final ViewManager viewManager;

    private final int BTN_HIGH = 1000;
    private final int BTN_WIDTH = 500;

    public Parent getView () {
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);

        Button startBtn = new Button("START");
        startBtn.setPrefSize(BTN_HIGH, BTN_WIDTH);

        startBtn.setOnAction(e -> viewManager.showChatView());

        layout.getChildren().add(startBtn);
        return layout;
    }

}
