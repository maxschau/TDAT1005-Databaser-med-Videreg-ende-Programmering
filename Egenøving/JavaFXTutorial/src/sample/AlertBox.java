package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL); //Blocks interactions with other windows, until this window is taken care of
        window.setTitle(title);

        Label message1 = new Label();
        message1.setText(message);
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(message1 ,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300,300);
        window.setScene(scene);
        window.showAndWait();
    }
}