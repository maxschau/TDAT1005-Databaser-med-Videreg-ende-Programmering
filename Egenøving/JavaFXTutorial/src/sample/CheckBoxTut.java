package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxTut extends Application {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage PrimaryStage) {
        window = PrimaryStage;
        window.setTitle("Checkbox");

        //Checkbox
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");
        //If you want a box already checked:
        //box2.setSelected(true);

        //Button:
        button = new Button("Click me");
        button.setOnAction(e -> {
            handleOptions(box1, box2);
        });

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(box1, box2, button);

        scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }
    //Handle checkboxes
    private void handleOptions(CheckBox box1, CheckBox box2) {
        String message = "";
        if (box1.isSelected()) {
            message += "Bacon";
        }
        if (box2.isSelected()) {
            message += "\n" + "Tuna";
        }
        System.out.println(message);
    }
}
