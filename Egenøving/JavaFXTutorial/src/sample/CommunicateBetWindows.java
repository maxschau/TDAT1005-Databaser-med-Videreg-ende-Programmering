package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CommunicateBetWindows extends Application {
    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Communcation");
        button = new Button("Click me");

        button.setOnAction(e -> {
           boolean result = ConfirmBox.display("Title", "Send nudes?");
            System.out.println(result);
        });


        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }

}
