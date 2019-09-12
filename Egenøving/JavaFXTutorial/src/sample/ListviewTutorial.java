package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListviewTutorial extends Application {

    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage PrimaryStage) {
        window = PrimaryStage;
        window.setTitle("Checkbox");
        //Button:
        button = new Button("Click me");

        listView = new ListView<>();
        listView.getItems().addAll("Vålerenga", "Rosenborg", "Brann", "Viking", "Molde", "Lyn Oslo", "Oppsal");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(event -> {
            buttonClicked();
        });



        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView, button);

        scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }
    private void buttonClicked() {
        String message = "";
        ObservableList<String> clubs;
        clubs = listView.getSelectionModel().getSelectedItems();
        for (String c: clubs) {
            message += c + "\n";
        }
        System.out.println(message);
    }
}
