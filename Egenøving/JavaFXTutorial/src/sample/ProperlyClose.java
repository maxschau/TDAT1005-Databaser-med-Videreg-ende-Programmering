package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ProperlyClose extends Application {
    Button button;
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Title");

        window.setOnCloseRequest(e -> {
            e.consume(); //"Takes over" from Java. Which means it will not close the window no matter what, but only run the the lines under
            closeProgram();
        }); //When you are using setOnCloseRequest it will close no matter what. It's important to remember this when coding

        button = new Button("Click me and close program");
        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout,300,300);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("WindowTitle", "Are you sure you want to exit?");
        if (answer) {
            System.out.println("File saved");
            window.close();
        } else {

        }
    }

}
