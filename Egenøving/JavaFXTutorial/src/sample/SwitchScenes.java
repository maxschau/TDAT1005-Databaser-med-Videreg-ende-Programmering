package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchScenes extends Application {
    Stage window;
    Scene scene1;
    Scene scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage; //Better to use the name Window rather than primaryStage

        Label label1 = new Label("Welcome to the first Scene");//Chunck of text
        Button button1 = new Button("Click me to go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2)); //Switches scene when clicked

        //Layout 1 - Children are laid out in a vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(layout1, 200,200);
        window.show();

        //Button2:
        Button button2 = new Button("Click me to go to scene 1");
        button2.setOnAction(e -> window.setScene(scene1)); //Switches scene when clicked

        //Layout 2 -
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600,300);

        window.setScene(scene1);
        window.setTitle("Title yeah");
        window.show();

    }
}
