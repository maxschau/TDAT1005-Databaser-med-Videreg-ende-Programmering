package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;


public class CreatingAlertBoxes extends Application {
    Stage window;
    Button button;

    public static void main(String[]  args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("We want to make alert boxes");

        button = new Button("Click me");
        button.setOnAction(e -> AlertBox.display("VÅLERENGA", "DU ER MIN RELLION"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 200,200);
        window.setScene(scene);
        window.show();



    }


}
