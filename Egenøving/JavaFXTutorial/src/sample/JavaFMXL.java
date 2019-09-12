package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFMXL extends Application {

    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Java FMXL");

        //Input and labels
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome to the site");
        Label secondLabel = new Label();

        HBox bottomText = new HBox(firstLabel, secondLabel);
        bottomText.setAlignment(Pos.CENTER);
        VBox vBox = new VBox(10, userInput, bottomText);
        vBox.setAlignment(Pos.CENTER);
    }
}
