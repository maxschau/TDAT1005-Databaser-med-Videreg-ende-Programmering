package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application  {
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
       // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Title of the window");

        button = new Button("Click me");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        button.setOnAction(e -> {
            System.out.println("Hello");
        }); //Lambda; Basically saying what happens when you press the button

        primaryStage.setScene(new Scene(layout, 300, 275));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
