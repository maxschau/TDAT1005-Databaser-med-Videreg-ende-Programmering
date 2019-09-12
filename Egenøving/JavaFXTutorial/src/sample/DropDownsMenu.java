package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DropDownsMenu extends Application {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage PrimaryStage) {
        window = PrimaryStage;
        window.setTitle("Checkbox");

        //DropDown:
        ChoiceBox<String> choiceBox = new ChoiceBox<>(); //Creates a blank dropdown list of (no) strings

        //Default value:
        choiceBox.setValue("Apple"); //Must be value that already exists!

        //You can add one item one by one
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().add("Banana");
        choiceBox.getItems().add("Strawberry");
        choiceBox.getItems().add("Pear");

        //Or add many
        choiceBox.getItems().addAll("Bacon", "Ham", "Pig");


        //Button
        button = new Button("Click me");
        button.setOnAction(e -> {
            getChoices(choiceBox);
        });

        //If you want the change to happen as soon as the change is made; which means when you change the value in the dropdown menu
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue) ); //The listener waits for something top happen
        //v = the property / the list itself    , oldValue = the old value , newValue = the newly selected value


        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox,button);

        scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }

    private void getChoices(ChoiceBox<String> box) {
        String result = box.getValue();
        System.out.println(result);

    }

}
