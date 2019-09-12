package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxess extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage PrimaryStage) {
        window = PrimaryStage;
        window.setTitle("ComboBox Demo");


        //Button:
        button = new Button("Submit");

        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
          "Good Will Hunting",
                    "St. Vincent",
                    "The 40-year old virgin",
                    "Lord of the Rings"
        );

        comboBox.setPromptText("What is your favorite movie?");
        button.setOnAction(e -> {
            printMovie();
        });

        //User can write by him/herself
        comboBox.setEditable(true);

        //This happens when a change is made -> When the user selects another value
        comboBox.setOnAction(e -> System.out.println("User selected: " + comboBox.getValue()));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox, button);

        scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }
    private void printMovie() {
        System.out.println(comboBox.getValue());
    }
}
