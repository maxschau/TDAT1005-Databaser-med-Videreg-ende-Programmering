package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ValidateInput extends Application {
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage PrimaryStage) throws Exception {
        window = PrimaryStage;
        window.setTitle("theNewBoss - javafx");

        //Form
        TextField nameInput = new TextField();
        Button confirm = new Button("Confirm");
        confirm.setOnAction(e -> isNotNull(nameInput.getText()));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(nameInput,confirm);

        Scene scene = new Scene(layout,250,300);
        window.setScene(scene);
        window.show();
    }

    private boolean isNotNull(String message) {
        if (message == null || message.equals("")) {
            System.out.println("It was empty");
            return false;
        }
        System.out.println("You wrote: " + message);
        return true;
    }
}
