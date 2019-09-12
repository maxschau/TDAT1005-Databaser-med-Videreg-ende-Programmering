package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class cssThemesAndStyles extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;
        window.setTitle("THEMES!!!");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);

        //Name label - constrains use (child, column, row)
        Label nameLabel = new Label("Username: ");
        GridPane.setConstraints(nameLabel, 0,0);


        //Name input
        TextField nameInput = new TextField("Bucky");
        GridPane.setConstraints(nameInput, 1,0);

        //Password label
        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel, 0,1);

        //Password input
        TextField passInput = new TextField();
        GridPane.setConstraints(passInput, 1,1);

        //Log in button
        Button button = new Button("Log in");
        GridPane.setConstraints(button, 1,2);
        button.setOnAction(event -> {
            grid.setStyle("-fx-background-color: blue");
        });




        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, button);

        Scene scene = new Scene(grid, 300,200);
        scene.getStylesheets().add("Viper.css");
        window.setScene(scene);
        window.show();
    }

}
